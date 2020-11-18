package cerepro.web.servlets.maven.questions;

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
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import cerepro.web.servlets.maven.surveys.SurveyRetrieveServlet;

/**
 * Servlet implementation class QuestionRetrieveServlet
 */
@WebServlet("/questionList")
public class QuestionRetrieveServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyRetrieveServlet.class);
	
	private static final long serialVersionUID = 1L;
	
	private QuestionsRepository questionsRepo = new QuestionsRepository();
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		List<EntityInterface> retList = questionsRepo.findAll();
		log.info("retrieved :" + retList.size() + " items question");
		request.setAttribute("listAllQuestion", retList);
//		request.getServletContext().getRequestDispatcher("/questions/show-all-question.jsp")
//													.forward(request, response);
		request.getServletContext().getRequestDispatcher("/questions/list.jsp")
		.forward(request, response);
	}
}