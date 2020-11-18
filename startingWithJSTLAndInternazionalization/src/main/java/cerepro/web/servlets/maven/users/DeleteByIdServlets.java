package cerepro.web.servlets.maven.users;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;
import centauri.academy.proxima.cerepro.repository.UserRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/userDeleteById")
public class DeleteByIdServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DeleteByIdServlets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UserRepository uRep = new UserRepository();
		boolean lineDeleted = uRep.delete(Long.parseLong(request.getParameter("usrid")));
		
//		String message = "Lines erased: " + linesDeleted;
		
		response.getWriter().append("Delete succeed!!! ");
//		response.getWriter().append(message);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

