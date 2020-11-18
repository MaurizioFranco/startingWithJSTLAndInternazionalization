package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/surveyQuestionDeleteAll")
public class SurveyQuestionDeleteAllServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyQuestionDeleteAllServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveyQuestionsRepository surveyQuestionsRepo = new SurveyQuestionsRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		int deleted = surveyQuestionsRepo.deleteAll();
		log.info("deleted " + deleted + " items surveyQuestion");
		if(deleted > 0) {
			request.setAttribute("surveyQuestionDeletedAll", true);
		} else
			request.setAttribute("surveyQuestionDeletedAll", false);
		
		request.getRequestDispatcher("surveysQuestions/show-all-surveyQuestion.jsp").forward(request, response);;
		log.info("method - doGet() - END");
	}
}
