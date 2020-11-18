package cerepro.web.servlets.maven.originSites;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import centauri.academy.proxima.cerepro.entity.OriginSites;
import centauri.academy.proxima.cerepro.repository.OriginSitesRepository;

/**
 * Servlet implementation class update
 */
@WebServlet("/originSiteUpdate")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OriginSitesRepository ntr = new OriginSitesRepository ();
		OriginSites nt = new OriginSites();
		nt.setId(Long.parseLong(request.getParameter("id")));
		nt.setLabel(request.getParameter("label"));
		nt.setDescription(request.getParameter("description"));
		nt.setImgpath(request.getParameter("imgpath"));
		ServletContext sc = request.getServletContext();
		try {
			boolean control = ntr.update(nt);
			System.out.println(ntr.update(nt));	
			if(control) {
				System.out.println(control+" update true ");
				sc.setAttribute("update", "true");
			}
			else {
				
				System.out.println(control+" update false");
				sc.setAttribute("update", "false");		
			}
			
			RequestDispatcher rd =request.getRequestDispatcher("/originSites/list.jsp");
			rd.forward(request, response);
			
			}
		catch(Exception  e) {
			System.out.println("error update");
			response.getWriter().append(e.getMessage());
		}
	}
}
