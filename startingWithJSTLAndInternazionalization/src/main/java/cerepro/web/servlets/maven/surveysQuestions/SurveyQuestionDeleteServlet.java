package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/surveyQuestionDelete")
public class SurveyQuestionDeleteServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyQuestionDeleteServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyQuestionsRepository surveyQuestionsRepo = new SurveyQuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();

		boolean deleted = surveyQuestionsRepo.delete(Integer.parseInt(parameterId));
		log.info("surveyQuestion deleted: " + deleted);
		if (deleted) {
			request.setAttribute("surveyQuestionDeleted", true);
		} else
			request.setAttribute("surveyQuestionDeleted", false);

		request.getRequestDispatcher("surveysQuestions/show-all-surveyQuestion.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}
}