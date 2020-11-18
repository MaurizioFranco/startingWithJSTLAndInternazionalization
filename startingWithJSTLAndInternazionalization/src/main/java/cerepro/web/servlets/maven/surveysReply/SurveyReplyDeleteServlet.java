package cerepro.web.servlets.maven.surveysReply;

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
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/surveyReplyDelete")
public class SurveyReplyDeleteServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyReplyDeleteServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyRepliesRepository surveyReplyRepo = new SurveyRepliesRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();

		boolean deleted = surveyReplyRepo.delete(Integer.parseInt(parameterId));
		log.info("surveyReply deleted: " + deleted);
		if (deleted) {
			request.setAttribute("surveyReplyDeleted", true);
		} else
			request.setAttribute("surveyReplyDeleted", false);

		request.getRequestDispatcher("surveysReplies/show-all-surveyReply.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}
}