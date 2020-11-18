package cerepro.web.servlets.maven.surveys;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.repository.SurveysRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/surveyDetail")
public class SurveyDetailServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyDetailServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		String idQueryString = request.getParameter("id");

		if (idQueryString != null) {

			Long idToSurveyRetrieve = Long.valueOf(idQueryString);
			EntityInterface surveyRetrieved = (Surveys) surveyRepo.findById(idToSurveyRetrieve);
			log.info(surveyRetrieved.toString());
			if (surveyRetrieved != null) {
				request.setAttribute("retrieveOK", true);
				request.setAttribute("survRetrieve", surveyRetrieved);
				
				request.getRequestDispatcher("surveys/survey.jsp").forward(request, response);
			} 
			if(surveyRetrieved == null){
				request.setAttribute("retrieveOK", false);
				request.getRequestDispatcher("surveys/errorPage.html").forward(request, response);
			}
		}
		log.info("method - doGet() - END");
	}
}
