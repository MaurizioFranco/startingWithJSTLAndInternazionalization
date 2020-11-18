package cerepro.web.servlets.maven.surveys;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.repository.SurveysRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/newSurvey")
public class SurveyCreateServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyCreateServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doPost() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		Map<String, String[]> mapParameter = request.getParameterMap();

		Surveys survey = new Surveys();
		survey.setLabel(mapParameter.get("label")[0]);
		survey.setDescription(mapParameter.get("description")[0]);
		survey.setTime(Integer.parseInt(mapParameter.get("time")[0]));
		log.info(survey.toString());
		
		Long id = surveyRepo.create(survey);
		log.info("Survey id: " + id);
		if (id > 0)
			request.setAttribute("surveyCrate", true);
		else
			request.setAttribute("surveyCrate", false);


//		request.getServletContext().getRequestDispatcher("/surveys/show-all-survey.jsp")
//		.forward(request, response);
		request.getServletContext().getRequestDispatcher("/surveys/list.jsp")
		.forward(request, response);
		log.info("method - doPost() - END");
	}
}
