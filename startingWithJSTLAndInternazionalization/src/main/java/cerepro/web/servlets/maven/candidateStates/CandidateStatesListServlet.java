package cerepro.web.servlets.maven.candidateStates;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CandidateStates;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.repository.CandidateStatesRepository;
import centauri.academy.proxima.cerepro.repository.RolesRepository;

/**
 * Servlet implementation class CandidateStateListServlet
 */
@WebServlet("/candidateStatesList")
public class CandidateStatesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateStatesListServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext sc = request.getServletContext();
		Object insertOp = sc.getAttribute("insert");
		StringBuilder sb = new StringBuilder ();
		
		if (insertOp!=null) {
		    boolean insertResult = Boolean.valueOf(insertOp+"") ;
		    if (insertResult) {
		    	sb.append("<h3 >Insert succeed!</h3>");
		    } else {
		    	sb.append("<h3 >Insert failed!</h3>");
		    }
		} 
		
		CandidateStatesRepository csRep = new CandidateStatesRepository ();
		List<EntityInterface> lei = csRep.findAll();
		String tableContent = "<html><body>" + sb.toString() + "<h3 >Candidate states list</h3>";

		tableContent += "<table border='1'>";
		tableContent+="<tr><th>Id</th><th>Role Id</th><th>Status Code</th><th>Status label</th><th>Status description</th><th>Status color</th></tr>";
		for ( EntityInterface current :lei ) {
			
			CandidateStates n=(CandidateStates)current;
			tableContent+="<tr>"
							+ "<td>" 
								+ n.getId()
							+ "</td>"
							+ "<td>"
								+n.getRole_id()
							+"</td>"
							+ "<td>"
								+n.getStatus_code()
							+"</td>"
							+ "<td>"
								+n.getStatus_label()
							+"</td>"
							+ "<td>"
								+n.getStatus_description()
							+"</td>"
							+ "<td>"
								+n.getStatus_color()
							+"</td>"
							+ "<td><form action=\"./roles/form.jsp\" method=\"get\">"+
							"<input type='hidden' name='id' value='" + n.getId()+ "'>"+
							"<input type='submit' value='MODIFICA'/></form>"+
								
							"</td>"
						+ "</tr>";
		}

		response.getWriter().append(tableContent);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
