package cerepro.web.servlets.maven.originSites;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.OriginSites;
import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.repository.OriginSitesRepository;
import centauri.academy.proxima.cerepro.repository.RolesRepository;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/originSiteInsert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static final ArrayList<OriginSites> los = new ArrayList<OriginSites>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		OriginSitesRepository osr = new OriginSitesRepository();
		OriginSites os = new OriginSites();
		os.setLabel(request.getParameter("label"));
		os.setDescription(request.getParameter("description"));
		os.setImgpath(request.getParameter("imgpath"));
		Long retValue = osr.create(os);
		System.out.println(retValue);
		if (retValue > 0) {
			request.setAttribute("insert", "true");
			System.out.println("true");
		} else {
			System.out.println("fasle");
			request.setAttribute("insert", "false");
		}
		try {
			RequestDispatcher rd = request.getRequestDispatcher("./originSites/list.jsp");
			OriginSitesRepository ntr = new OriginSitesRepository();
			List<EntityInterface> items = ntr.findAll();
			request.setAttribute("originSitesList", items);
			rd.forward(request, response);
		} catch (ServletException se) {
			se.printStackTrace();
			response.getWriter().append("Qualcosa [ andato storto prova a ricaricare la pagina di lista...");
		}
	}
}