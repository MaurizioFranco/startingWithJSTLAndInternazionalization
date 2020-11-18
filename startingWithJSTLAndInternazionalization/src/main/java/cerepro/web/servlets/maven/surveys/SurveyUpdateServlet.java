package cerepro.web.servlets.maven.surveys;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/surveyUpdate")
public class SurveyUpdateServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyUpdateServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();

//		Surveys survey = new Surveys();
//		survey.setLabel(mapParameter.get("label")[0]);
//		survey.setDescription(mapParameter.get("description")[0]);
//		survey.setTime(Integer.parseInt(mapParameter.get("time")[0]));
//		log.info(survey.toString());

		Surveys retObj = (Surveys) surveyRepo.findById(Long.valueOf(parameterId));
		retObj.setLabel(mapParameter.get("label")[0].trim());
		retObj.setDescription(mapParameter.get("description")[0].trim());
		retObj.setTime(Integer.parseInt(mapParameter.get("time")[0].trim()));
		boolean updated = surveyRepo.update(retObj);
		log.info("updated Survey: " + updated);

		if (updated) {
			request.setAttribute("surveyUpdated", true);
		} else
			request.setAttribute("surveyUpdate", false);

//		RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
//		resuqsetDispatcher.forward(request, response);
		RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/list.jsp");
		resuqsetDispatcher.forward(request, response);
		log.info("method - doGet() - END");
	}
}
