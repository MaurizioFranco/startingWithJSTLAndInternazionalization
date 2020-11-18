package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CoursePage;

import centauri.academy.proxima.cerepro.repository.CoursePageRepository;


/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/coursePageUpdateById")
public class CoursePageUpdateById extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CoursePageUpdateById() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CoursePageRepository ntr = new CoursePageRepository ();
		
		long id = Long.parseLong(request.getParameter("id"));
		CoursePage n = (CoursePage) ntr.findById(id);
		System.out.println(id);
		String text="<table>";
		text+="<h1>Update</h1>";
		text+="<form action=\"./coursePagesUpdate\" method=\"get\">\r\n" + 
				"	<h3>Title</h3>\r\n" + 
				"<input type=\"text\" name=\"Title\" value=\"" + n.getTitle()+ " \" /> \r\n" + 
				"</td>\r\n" + 
				"<td>\r\n" +
					"<input type=\"text\" name=\"Code\" value=\"" +n.getCode() + " \" /> \r\n" +
				"</td>\r\n" +
				"<td>\r\n" +
				"<input type=\"text\" name=\"Body_text\" value=\"" +n.getBody_text() + " \" /> \r\n" +
				"</td>\r\n" +
				"<td>\r\n" +
				"<input type=\"text\" name=\"File_name\" value=\"" +n.getFile_name() + " \" /> \r\n" +
				"</td>\r\n" +
				"<td>\r\n" + "<input type=\"hidden\" name=\"id\" value=\""+n.getId() +"\">" + 
				"	<input type=\"submit\" value=\"Submit\">";
		response.getWriter().append(text);


		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
