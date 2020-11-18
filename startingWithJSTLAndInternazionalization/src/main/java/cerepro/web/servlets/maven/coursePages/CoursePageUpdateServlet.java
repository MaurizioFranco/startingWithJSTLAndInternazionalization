package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/coursePageUpdate")
public class CoursePageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CoursePageUpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
//		ServletContext sc = request.getServletContext();
//		Object updateOp = sc.setAttribute("update", object);
		CoursePageRepository ntr = new CoursePageRepository ();
		
		
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();
		ServletOutputStream out = response.getOutputStream();
		
		CoursePage retObj = (CoursePage) ntr.findById(Long.valueOf(parameterId));
		retObj.setTitle(mapParameter.get("Title")[0].trim());
		retObj.setCode(mapParameter.get("code")[0].trim());
		retObj.setBody_text(mapParameter.get("body_text")[0].trim());
		retObj.setFile_name(mapParameter.get("file_name")[0].trim());
		boolean ret = ntr.update(retObj);
		
		

		String content = "";
		try {
			
			long id = Long.parseLong(request.getParameter("id"));
			boolean control= ntr.update(retObj);
			
			if(control == false) {
				content += "<p><h2>id="+ parameterId +" of coursePage not exists !</h2></p>";
				
			}
			else {
				content += "<p><h2>coursePage update succesfully</h2></p>";
			}
		}
		catch(Exception  e){
			response.getWriter().append("Error");
			response.getWriter().append(e.getMessage());
		}out.println("<!DOCTYPE html>\r\n" + 
			"<html>\r\n" +
				"<head>\r\n" +
					"<title>page response update coursePage by id</title>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" +
				"</head>\r\n" +
				"<body>\r\n" +
					 content +
				"<hr>\r\n" +
				"<hr>\r\n" +
				"<ul>\r\n" +
					"<li><a href=\"./coursePageSelectAll\">click to show coursePages table</a></li>\r\n" +
					"</body>\r\n" +
				"</ul>\r\n" +
			"</html>\r\n");
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
