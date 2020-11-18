package cerepro.web.servlets.maven.candidateStates;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CandidateStates;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.repository.CandidateStatesRepository;
import centauri.academy.proxima.cerepro.repository.RolesRepository;

/**
 * Servlet implementation class CandidateStatesInsertServlet
 */
@WebServlet("/CandidateStatesInsert")
public class CandidateStatesInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateStatesInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CandidateStatesRepository cRep = new CandidateStatesRepository();
		CandidateStates cStates = new CandidateStates();
		cStates.setRole_id(Long.parseLong(request.getParameter("roleid")));
		cStates.setStatus_code(Integer.parseInt(request.getParameter("statuscode")));
		cStates.setStatus_label(request.getParameter("statuslabel"));
		cStates.setStatus_description(request.getParameter("statusdescription"));
		cStates.setStatus_color(request.getParameter("statuscolor"));
		// Insert all the data into the database
		Long retValue = cRep.create(cStates);
		ServletContext sc = request.getServletContext();
		if (retValue > 0) {
			sc.setAttribute("insert", "true");
		} else {
			sc.setAttribute("insert", "false");
		}
		try {
			RequestDispatcher rd = request.getRequestDispatcher("./candidateStatesList");
			rd.forward(request, response);
		} catch (ServletException se) {
			se.printStackTrace();
			response.getWriter().append("Qualcosa [ andato storto prova a ricaricare la pagina di lista...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
