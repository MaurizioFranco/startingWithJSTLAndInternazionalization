package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/newSurveyQuestion")
public class SurveyQuestionCreateServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyQuestionCreateServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyQuestionsRepository surveyQuestionRepo = new SurveyQuestionsRepository();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> mapParameter = request.getParameterMap();

		SurveysQuestions surveyQuestions = new SurveysQuestions();
		surveyQuestions.setSurveyId(Long.valueOf(mapParameter.get("id_survey")[0]));
		surveyQuestions.setQuestionId(Long.valueOf(mapParameter.get("id_question")[0]));
		surveyQuestions.setPosition(Integer.parseInt(mapParameter.get("position")[0]));
		log.info(surveyQuestions.toString());

		Long id = surveyQuestionRepo.create(surveyQuestions);
		log.info("surveyReply id: " + id);
		if (id > 0)
			request.setAttribute("surveyQuestionCrate", true);
		else
			request.setAttribute("surveyQuestionCrate", false);

		request.getServletContext().getRequestDispatcher("/surveysQuestions/show-all-surveyQuestion.jsp").forward(request, response);
		log.info("method - doPost() - END");
	}
}
