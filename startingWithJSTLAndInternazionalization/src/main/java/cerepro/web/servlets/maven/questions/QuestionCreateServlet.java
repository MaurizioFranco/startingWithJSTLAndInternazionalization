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

import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/newQuestion")
public class QuestionCreateServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(QuestionCreateServlet.class);

	private static final long serialVersionUID = 1L;

	private QuestionsRepository questionsRepo = new QuestionsRepository();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> mapParameter = request.getParameterMap();

		Questions question = new Questions();
		question.setLabel(mapParameter.get("label")[0]);
		question.setDescription(mapParameter.get("description")[0]);
		question.setAnsa(mapParameter.get("ansa")[0].trim());
		question.setAnsb(mapParameter.get("ansb")[0].trim());
		question.setAnsc(mapParameter.get("ansc")[0].trim());
		question.setAnsd(mapParameter.get("ansd")[0].trim());
		question.setAnse(mapParameter.get("anse")[0].trim());
		question.setAnsf(mapParameter.get("ansf")[0].trim());
		question.setAnsg(mapParameter.get("ansg")[0].trim());
		question.setAnsh(mapParameter.get("ansh")[0].trim());
		question.setCansa(mapParameter.get("cansa")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansb(mapParameter.get("cansb")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansc(mapParameter.get("cansc")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansd(mapParameter.get("cansd")[0].equalsIgnoreCase("true") ? true : false);
		question.setCanse(mapParameter.get("canse")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansf(mapParameter.get("cansf")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansg(mapParameter.get("cansg")[0].equalsIgnoreCase("true") ? true : false);
		question.setCansh(mapParameter.get("cansh")[0].equalsIgnoreCase("true") ? true : false);
		question.setFullAnswer(mapParameter.get("full_answer")[0].trim());
		log.info(question.toString());

		Long id = questionsRepo.create(question);
		log.info("question id: " + id);
		if (id > 0)
			request.setAttribute("questionCrate", true);
		else
			request.setAttribute("questionCrate", false);

//		request.getServletContext().getRequestDispatcher("/questions/show-all-question.jsp").forward(request, response);
		request.getServletContext().getRequestDispatcher("/questions/list.jsp").forward(request, response);
		log.info("method - doPost() - END");
	}
}
