package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/surveyQuestionDetail")
public class SurveyQuestionDetailServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyQuestionDetailServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyQuestionsRepository surveyQuestionsRepo = new SurveyQuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Servlet path: " + request.getServletPath());
		String idQueryString = request.getParameter("id");

		if (idQueryString != null) {

			Long idSurveyQuestionRetrieve = Long.valueOf(idQueryString);
			EntityInterface surveyQuestionRetrieved = (SurveysQuestions) surveyQuestionsRepo.findById(idSurveyQuestionRetrieve);
			log.info(surveyQuestionRetrieved.toString());
			if (surveyQuestionRetrieved != null) {
				request.setAttribute("retrieveOK", true);
				request.setAttribute("survQuestRetrieve", surveyQuestionRetrieved);
				
				request.getRequestDispatcher("surveysQuestions/surveyQuestion.jsp").forward(request, response);
			} 
			if(surveyQuestionRetrieved == null){
				request.setAttribute("retrieveOK", false);
				request.getRequestDispatcher("surveysQuestions/errorPage.html").forward(request, response);
			}
		}
		log.info("method - doGet() - END");
	}
}
