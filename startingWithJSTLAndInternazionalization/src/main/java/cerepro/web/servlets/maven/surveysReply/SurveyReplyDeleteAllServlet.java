package cerepro.web.servlets.maven.surveysReply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/surveyReplyDeleteAll")
public class SurveyReplyDeleteAllServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyReplyDeleteAllServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private SurveyRepliesRepository surveyQuestionsRepo = new SurveyRepliesRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		int deleted = surveyQuestionsRepo.deleteAll();
		log.info("deleted " + deleted + " items surveyReply");
		if(deleted > 0) {
			request.setAttribute("surveyReplyDeletedAll", true);
		} else
			request.setAttribute("surveyReplyDeletedAll", false);
		
		request.getRequestDispatcher("surveysReplies/show-all-surveyReply.jsp").forward(request, response);;
		log.info("method - doGet() - END");
	}
}
