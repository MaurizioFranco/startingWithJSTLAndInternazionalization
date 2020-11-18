package cerepro.web.servlets.maven.surveys;

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
import centauri.academy.proxima.cerepro.repository.SurveysRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/surveyList")
public class SurveyRetrieveServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyRetrieveServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveysRepository surveyRepo = new SurveysRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		List<EntityInterface> retList = surveyRepo.findAll();
		log.info("retrieved :" + retList.size() + " items survey");
		request.setAttribute("listAllSurvey", retList);
		
//		request.getServletContext().getRequestDispatcher("/surveys/show-all-survey.jsp")
//													.forward(request, response);
		request.getServletContext().getRequestDispatcher("/surveys/list.jsp")
		.forward(request, response);
		log.info("method - doGet() - END");
	}
}
