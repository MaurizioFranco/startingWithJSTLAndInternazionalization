package cerepro.web.servlets.maven.questions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;

/**
 * Servlet implementation class QuestionRetriveByIdServlet
 */
@WebServlet("/questionSelectById")
public class QuestionRetriveByIdServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	private QuestionsRepository questionsRepository = new QuestionsRepository();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> mapParameter = request.getParameterMap();		
		String parameterId = mapParameter.get("id")[0].trim();
		ServletOutputStream out = response.getOutputStream();
		
		boolean paramIdisNumber = true;
		for(int i=0; i<parameterId.length(); i++) {
			if(!Character.isDigit(parameterId.charAt(i))) {
				paramIdisNumber = false;
				break;
			}
		}
		
		String content = "";
		if(!paramIdisNumber) {
			content += "<p><h2>id question specified is not valid number !</h2></p>";
		} 
		else {
			Questions q = (Questions) questionsRepository.findById(Long.parseLong(parameterId));
			content += " <h2>retrieve question with id: " + q.getId() + "</h2>\r\n" +
						"<form action=\"./questionUpdateById?id=" + q.getId() + " \" method=\"GET\" >" +
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
										"<input type=\"text\" name=\"label\" value=\"" + q.getLabel() + " \" /> \r\n" + 
									"</td>\r\n" + 
									"<td>\r\n" +
										"<input type=\"text\" name=\"description\" value=\"" +q.getDescription() + " \" /> \r\n" +
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
						"<title>page response delete all questions</title>\r\n" + 
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
						"<li><a href=\"./questionSelectAll\">click to show Questions table</a></li>\r\n" +
					"</ul>\t\n" +
				"</html>\r\n");
	}
}
