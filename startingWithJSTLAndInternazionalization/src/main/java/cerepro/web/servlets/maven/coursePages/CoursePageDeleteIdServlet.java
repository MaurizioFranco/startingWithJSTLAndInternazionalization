package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/coursePageDeleteById")
public class CoursePageDeleteIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CoursePageDeleteIdServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		CoursePageRepository ntr = new CoursePageRepository ();
//		Map<String, String[]> mapParameter = request.getParameterMap();	
//		String parameterId = mapParameter.get("id")[0].trim();
//		ServletOutputStream out = response.getOutputStream();
		
		

		String content = "";
			
			long id = Long.parseLong(request.getParameter("id"));
			boolean control=ntr.delete(id);
			
			if(control == false) {
				content += "<p><h2>CoursePage non cancellato </h2></p>";
				
			}
			else {
				content += "<p><h2>CoursePage cancellato succesfully</h2></p>";
			}
		
//		out.println("<!DOCTYPE html>\r\n" + 
//			"<html>\r\n" +
//				"<head>\r\n" +
//					"<title>page response delete coursePage by id</title>\r\n" + 
//					"<meta charset=\"utf-8\">\r\n" +
//				"</head>\r\n" +
//				"<body>\r\n" +
//					 content +
//				"<hr>\r\n" +
//				"<hr>\r\n" +
//				"<ul>\r\n" +
//					"<li><a href=\"./questionSelectAll\">click to show coursePages table</a></li>\r\n" +
//					"</body>\r\n" +
//				"</ul>\r\n" +
//			"</html>\r\n");
			response.getWriter().append(content);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
