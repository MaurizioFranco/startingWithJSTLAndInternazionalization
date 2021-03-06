package cerepro.web.servlets.maven.roles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.repository.OriginSitesRepository;

/**
 * Servlet implementation class deleteByIdServlet
 */
@WebServlet("/roleDeleteById")
public class DeleteByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OriginSitesRepository osr = new OriginSitesRepository();
		String id = request.getParameter("id");
		if(osr.delete(Long.valueOf(id).longValue())== true) {
			response.getWriter().append("operazione eseguita con successo  il contenuto di id  :"+(Long.valueOf(id).longValue()+"è stato cancellato"));
		}
		response.getWriter().append("errore");
	}

}
