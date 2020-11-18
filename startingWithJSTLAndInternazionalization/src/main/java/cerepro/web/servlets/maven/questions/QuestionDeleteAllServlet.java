package cerepro.web.servlets.maven.questions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.QuestionsRepository;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/questionDeleteAll")
public class QuestionDeleteAllServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(QuestionDeleteAllServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private QuestionsRepository questionsRepo = new  QuestionsRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		int deleted = questionsRepo.deleteAll();
		log.info("deleted " + deleted + " items questions");
		if(deleted > 0) {
			request.setAttribute("questionDeletedAll", true);
		} else
			request.setAttribute("questionDeletedAll", false);
		
//		request.getRequestDispatcher("questions/show-all-question.jsp").forward(request, response);;
		request.getRequestDispatcher("questions/list.jsp").forward(request, response);;
		log.info("method - doGet() - END");
	}
}
