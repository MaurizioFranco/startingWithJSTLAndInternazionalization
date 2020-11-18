package cerepro.web.servlets.maven.roles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.repository.OriginSitesRepository;

/**
 * Servlet implementation class deleteAll
 */
@WebServlet("/roleDeleteAll")
public class DeleteAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OriginSitesRepository osr = new OriginSitesRepository();
		int x = osr.deleteAll();
		ServletOutputStream out = response.getOutputStream();
		out.println(String.valueOf(x) + "  deleted!");
		
	}
		
	

	

}
