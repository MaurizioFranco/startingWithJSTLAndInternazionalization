package cerepro.web.servlets.maven.roles;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.repository.RolesRepository;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/roleInsert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RolesRepository rr = new RolesRepository();
		Roles role = new Roles();
		role.setLabel(request.getParameter("label"));
		role.setDescription(request.getParameter("description"));
		role.setLevel(Integer.parseInt(request.getParameter("level")));
		Long retValue = rr.create(role);
		ServletContext sc = request.getServletContext();
		if (retValue > 0) {
			sc.setAttribute("insert", "true");
		} else {
			sc.setAttribute("insert", "false");
		}
		try {
			RequestDispatcher rd = request.getRequestDispatcher("./roleList");
			rd.forward(request, response);
		} catch (ServletException se) {
			se.printStackTrace();
			response.getWriter().append("Qualcosa [ andato storto prova a ricaricare la pagina di lista...");
		}
	}

}