package cerepro.web.servlets.maven.surveys;

import java.io.IOException;

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
@WebServlet("/surveyDeleteAll")
public class SurveyDeleteAllServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyDeleteAllServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		int deleted = surveyRepo.deleteAll();
		log.info("deleted " + deleted + " items survey");
		if(deleted > 0) {
			request.setAttribute("surveyDeletedAll", true);
		} else
			request.setAttribute("surveyDeletedAll", false);
		
//		request.getRequestDispatcher("surveys/show-all-survey.jsp").forward(request, response);
		request.getRequestDispatcher("surveys/list.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}
}
