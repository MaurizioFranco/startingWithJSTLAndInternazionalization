package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;
import cerepro.web.servlets.maven.surveys.SurveyUpdateServlet;

/**
 * Servlet implementation class QuestionUodateServlet
 */
@WebServlet("/surveyQuestionUpdate")
public class SurveyQuestionUpdateServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyUpdateServlet.class);
	
	private static final long serialVersionUID = 1L;
    
	private SurveyQuestionsRepository surveyQuestionsRepo = new SurveyQuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();


		SurveysQuestions retObj = (SurveysQuestions) surveyQuestionsRepo.findById(Long.valueOf(parameterId));
		retObj.setPosition(Integer.parseInt(mapParameter.get("position")[0]));
		
		boolean updated = surveyQuestionsRepo.update(retObj);
		log.info("updated Question: " + updated);

		if (updated) {
			request.setAttribute("surveyQuestionUpdated", true);
		} else
			request.setAttribute("surveyQuestionUpdate", false);

		request.getRequestDispatcher("surveysQuestions/show-all-surveyQuestion.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}

}
