package cerepro.web.servlets.maven.questions;

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
@WebServlet("/questionDetail")
public class QuestionDetailServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(QuestionDetailServlet.class);

	private static final long serialVersionUID = 1L;

	private QuestionsRepository questionsRepo = new QuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Servlet path: " + request.getServletPath());
		String idQueryString = request.getParameter("id");

		if (idQueryString != null) {

			Long idQuestionToRetrieve = Long.valueOf(idQueryString);
			EntityInterface questionRetrieved = (Questions) questionsRepo.findById(idQuestionToRetrieve);
			log.info(questionRetrieved.toString());
			if (questionRetrieved != null) {
				request.setAttribute("retrieveOK", true);
				request.setAttribute("questRetrieve", questionRetrieved);
				
				request.getRequestDispatcher("questions/question.jsp").forward(request, response);
			} 
			if(questionRetrieved == null){
				request.setAttribute("retrieveOK", false);
				request.getRequestDispatcher("questions/errorPage.html").forward(request, response);
			}
		}
		log.info("method - doGet() - END");
	}
}
