package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.NoteTemplate;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;


/**
 * Servlet implementation class InsertServlet
 */

@WebServlet("/coursePageDeleteAll")
public class CoursePageDeleteAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CoursePageDeleteAllServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CoursePageRepository courseRep = new CoursePageRepository();
		ServletContext sc = request.getServletContext();
		RequestDispatcher rd =request.getRequestDispatcher("/coursePage/list.jsp");
		try {
		int deleteAlls=courseRep.deleteAll();
		sc.setAttribute("deleteAll", "true");
		rd.forward(request, response);
	}
	catch(Exception  e){
		sc.setAttribute("deleteAll", "false");
		rd.forward(request, response);
	}
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
