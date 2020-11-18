package cerepro.web.servlets.maven.surveysQuestions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

@WebServlet("/surveyQuestionList")
public class SurveyQuestionRetrieveServlet extends HttpServlet{

	private static Logger log = LoggerFactory.getLogger(SurveyQuestionRetrieveServlet.class);
	
	private static final long serialVersionUID = -8152973301955771222L;
	
	private SurveyQuestionsRepository surveyQuestionRepo = new SurveyQuestionsRepository();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		List<EntityInterface> retList = surveyQuestionRepo.findAll();
		log.info("retrieved :" + retList.size() + " items surveyQuestion");
		request.setAttribute("listAllSurveyQuestion", retList);
		request.getServletContext().getRequestDispatcher("/surveysQuestions/show-all-surveyQuestion.jsp")
													.forward(request, response);
	}

}
