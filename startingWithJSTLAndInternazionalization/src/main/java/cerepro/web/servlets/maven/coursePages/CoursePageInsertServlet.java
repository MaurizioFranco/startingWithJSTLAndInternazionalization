package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;

/**
 * Servlet implementation class InsertServlet
 */

@WebServlet("/coursePageInsert")
public class CoursePageInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CoursePageRepository courseRep = new CoursePageRepository();
		CoursePage course = new CoursePage();
		//ServletOutputStream out = response.getOutputStream();
		course.setTitle(request.getParameter("title"));
		course.setCode(request.getParameter("code"));
		course.setBody_text(request.getParameter("body_text"));
		course.setFile_name(request.getParameter("file_name"));
		
		
		Long returnValue = courseRep.create(course);
		System.out.println(returnValue + "create");
//		System.out.println(returnValue.longValue());
		ServletContext sc = request.getServletContext();
		System.out.println(sc + "ServletContext");
		if (returnValue > 0) 
			sc.setAttribute("insert", true);
		 else 
			sc.setAttribute("insert", false);
		RequestDispatcher rd = request.getRequestDispatcher("/coursePage/list.jsp");
		System.out.println("method - doPost() - END");
		}
		

	}
