package cerepro.web.servlets.maven.roles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.repository.RolesRepository;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/roleList")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext sc = request.getServletContext();
		Object insertOp = sc.getAttribute("insert");
		StringBuilder sb = new StringBuilder ();
		
		if (insertOp!=null) {
		    boolean insertResult = Boolean.valueOf(insertOp+"") ;
		    if (insertResult) {
		    	sb.append("<h3 >inserimento andato a buon fine</h3>");
		    } else {
		    	sb.append("<h3 >inserimento NON andato a buon fine</h3>");
		    }
		} 
		
		RolesRepository ntr = new RolesRepository ();
		
		List<EntityInterface> lei = ntr.findAll();

		String tableContent = "<html><body>" + sb.toString() + "<h3 >List di ruoli</h3>";
		tableContent += "<table border='1'>";
		tableContent+="<tr><th>Id</th><th>Label</th><th>Description</th><th>Level</th></tr>";
		for ( EntityInterface current :lei ) {
			
			Roles n=(Roles)current;
			tableContent+="<tr>"
							+ "<td>" 
								+ n.getId()
							+ "</td>"
							+ "<td>"
								+n.getLabel()
							+"</td>"
							+ "<td>"
								+n.getDescription()
							+"</td>"
							+ "<td>"
								+n.getLevel()
							+"</td>"
							+ "<td><form action=\"./roles/form.jsp\" method=\"get\">"+
							"<input type='hidden' name='id' value='" + n.getId()+ "'>"+
							"<input type='submit' value='MODIFICA'/></form>"+
								
							"</td>"
						+ "</tr>";
		}

		response.getWriter().append(tableContent);

//		
//		
	}
	
}
