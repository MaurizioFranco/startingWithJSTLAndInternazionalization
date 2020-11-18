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

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/CoursePageSelectById")
public class CoursePageSelectIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CoursePageSelectIdServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		
		CoursePageRepository ntr = new CoursePageRepository ();
		Map<String, String[]> mapParameter = request.getParameterMap();	
		String parameterId = mapParameter.get("id")[0].trim();
		ServletOutputStream out = response.getOutputStream();
		
		
		long id = Long.parseLong(request.getParameter("id"));
		
		String content = "";
			
			
			boolean paramIdisNumber = true;
			for(int i=0; i<parameterId.length(); i++) {
				if(!Character.isDigit(parameterId.charAt(i))) {
					paramIdisNumber = false;
					break;
				}
			}
			
			if(!paramIdisNumber) {
				content += "<p><h2>id="+ parameterId +" of coursePage not exists !</h2></p>";
				
			}
			else {
				CoursePage q=(CoursePage)ntr.findById(id);
				content += "<p><h2>Select coursePage:" + q.getId() + " with success</h2></p>" +
				"<form action=\"./CoursePageUpdateById?id=" + q.getId() + " \" method=\"GET\" >" +
				"<input type=\"hidden\" name=\"id\" value=\"" + q.getId() + "\"/> \r\n" + 
				 "<table style=\"width:100%\">\r\n" +
					"<tr>\r\n" +
						"<th>ID</th>\r\n" +
						"<th>LABEL</th>\r\n" + 
						"<th>DESCRIPTION</th>\r\n" +
						"<th></th>" +
					"</tr>\r\n" +
					"<tr>\r\n" + 
						"<td>\r\n" +
							q.getId() + "\r\n" + 
						"</td>" + 
						"<td>" +
							"<input type=\"text\" name=\"Title\" value=\"" + q.getTitle()+ " \" /> \r\n" + 
						"</td>\r\n" + 
						"<td>\r\n" +
							"<input type=\"text\" name=\"Code\" value=\"" +q.getCode() + " \" /> \r\n" +
						"</td>\r\n" +
						"<td>\r\n" +
						"<input type=\"text\" name=\"Body_text\" value=\"" +q.getBody_text() + " \" /> \r\n" +
						"</td>\r\n" +
						"<td>\r\n" +
						"<input type=\"text\" name=\"File_name\" value=\"" +q.getFile_name() + " \" /> \r\n" +
						"</td>\r\n" +
						"<td>\r\n" +
							"<input type=\"submit\" value=\"update\" />" +
						"</td>\r\n" +
					"</tr>\r\n" + 
				"</table>\r\n" +
			"</form>";
}		   

			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" +
						"<head>\r\n" +
							"<title>page response delete all coursePage</title>\r\n" + 
							"<meta charset=\"utf-8\">\r\n" +
							"<style>\r\n" + 
							"table, th, td {\r\n" + 
							"  border: 1px solid black;\r\n" + 
							"  border-collapse: collapse;\r\n" + 
							"}\r\n" + 
							"th, td {\r\n" + 
							"  padding: 15px;\r\n" + 
							"}\r\n" + 
							"</style>" +
						"</head>\r\n" +
						"<body>\r\n" +
							 content +
						"</body>\r\n" +
						"<hr>\r\n" +
						"<hr>\r\n" +
						"<ul>\r\n" +
							"<li><a href=\"./coursePageSelectAll\">click to show CoursePage table</a></li>\r\n" +
						"</ul>\t\n" +
					"</html>\r\n");
		}
	}

