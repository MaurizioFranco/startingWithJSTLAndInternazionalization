package cerepro.web.servlets.maven.surveys;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.SurveysRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/surveyDelete")
public class SurveyDeleteServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyDeleteServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();
		
		boolean deleted = surveyRepo.delete(Integer.parseInt(parameterId));
		log.info("survey deleted: " + deleted);
		if(deleted) {
			request.setAttribute("surveyDeleted", true);
		} else
			request.setAttribute("surveyDeleted", false);
		
//		RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
//		resuqsetDispatcher.forward(request, response);
		RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/list.jsp");
		resuqsetDispatcher.forward(request, response);
		log.info("method - doGet() - END");
	}
}
