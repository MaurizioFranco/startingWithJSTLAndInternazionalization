package cerepro.web.servlets.maven.questions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.repository.QuestionsRepository;

/**
 * Servlet implementation class QuestionDeleteServlet
 */
@WebServlet("/questionDelete")
public class QuestionDeleteServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(QuestionDeleteServlet.class);

	private static final long serialVersionUID = 1L;

	private QuestionsRepository questionsRepo = new QuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();

		boolean deleted = questionsRepo.delete(Integer.parseInt(parameterId));
		log.info("question deleted: " + deleted);
		if (deleted) {
			request.setAttribute("questionDeleted", true);
		} else
			request.setAttribute("questionDeleted", false);

//		request.getRequestDispatcher("questions/show-all-question.jsp").forward(request, response);
		request.getRequestDispatcher("questions/list.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}
}