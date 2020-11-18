package cerepro.web.servlets.maven.coursePages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.CoursePage;
import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.repository.CoursePageRepository;

/**
 * Servlet implementation class InsertServlet
 */

@WebServlet("/coursePageSelectAll")
public class CoursePageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public CoursePageListServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletContext sc = request.getServletContext();
		Object insertOp = sc.getAttribute("insert");
		StringBuilder sb = new StringBuilder();

		if (insertOp != null) {
			boolean insertResult = Boolean.valueOf(insertOp + "");
			if (insertResult) { // se la condizione risulta veritiera - if condition result true
				sb.append("<h2>il tuo inserimento è stato eseguito con successo, sei fortunato  !!<h2>");
			} else {
				sb.append("<h2>il tuo inserimento NON è stato eseguito con successo, sei sfortunato  !!<h2>");
			}
		}
		CoursePageRepository courseRep = new CoursePageRepository();
		List<EntityInterface> items = courseRep.findAll();
		String tableContent = "<html><body><h3 >List</h3>";
		tableContent += "<table>";
		for (EntityInterface current : items) {
			CoursePage n = (CoursePage) current;
			tableContent += 
							"<tr>"
									+ "<td>" + n.getId() + "</td>"
									+ "<td>" + n.getTitle() +"</td>"
									+ "<td>"+ n.getCode() + "</td>"
									+ "<td>" + n.getBody_text()+"</td>"
									+ "<td>" + n.getFile_name() + "</td>"
									+ "<td>"
										+ "<form action=\"./coursePageDeleteAll\" method=\"get\">"
											+ "<input type=\"submit\" value=\"CANCELLA_TUTTO\">"
										+ "</form>"
										+ "<form action=\"./coursePageDeleteById\" method=\"get\">"
										+ "<input type=\"hidden\" name=\"id\" value=\"" + n.getId() + "\">"
										+ "<input type=\"submit\" value=\"CANCELLA\">"
										+ "</form>" 
										+ "<ul>"
											+ "<li>"
												+ "<a href=\"./coursePage/form.jsp\">click to insert_new CoursePages table</a>"
											+ "</li>"
											+ "<li>"
												+ "<a href=\"./coursePageUpdateById\">click to UpdateById of CoursePages table</a>"
											+ "</li>"
											+ "<li>"
												+ "<a href=\"./coursePageUpdate\">click to Update of CoursePages table</a>"
											+ "</li>"
										+ "</ul>"
									+ "</td>"
							+ "</tr>";

		
		tableContent += "</table></body></html>";
		}
	    int retval = items.size();
	    System.out.println("TOTAL ELEMENT = " + retval);
		response.getWriter().append(tableContent);
		

//		System.out.println(request.getParameter("title"));
//		System.out.println(request.getParameter("code"));
//		System.out.println(request.getParameter("body_text"));
//		System.out.println(request.getParameter("file_name"));
//		
//		CoursePageRepository courseRep = new CoursePageRepository();
//		courseRep.deleteAll();
//		CoursePage course = new CoursePage();
//
//		course.setTitle("power");
//		course.setCode("MMDKDOW");
//		course.setBody_text("power power");
//		course.setFile_name("very power");
//		courseRep.create(course);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
