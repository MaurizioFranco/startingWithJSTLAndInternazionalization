package cerepro.web.servlets.maven.surveysReply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/surveyReplyDetail")
public class SurveyReplyDetailServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyReplyDetailServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyRepliesRepository surveyReplyRepo = new SurveyRepliesRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("Servlet path: " + request.getServletPath());
		String idQueryString = request.getParameter("id");

		if (idQueryString != null) {

			Long idSurveyReplyRetrieve = Long.valueOf(idQueryString);
			EntityInterface surveyReplyRetrieved = (SurveysReplies) surveyReplyRepo.findById(idSurveyReplyRetrieve);
			log.info(surveyReplyRetrieved.toString());
			if (surveyReplyRetrieved != null) {
				request.setAttribute("retrieveOK", true);
				request.setAttribute("survReplRetrieve", surveyReplyRetrieved);
				
				request.getRequestDispatcher("surveysReplies/surveyReply.jsp").forward(request, response);
			} 
			if(surveyReplyRetrieved == null){
				request.setAttribute("retrieveOK", false);
				request.getRequestDispatcher("surveysReplies/errorPage.html").forward(request, response);
			}
		}
		log.info("method - doGet() - END");
	}
}
