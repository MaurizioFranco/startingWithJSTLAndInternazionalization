package cerepro.web.servlets.maven.questions;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import cerepro.web.servlets.maven.surveys.SurveyUpdateServlet;

/**
 * Servlet implementation class QuestionUodateServlet
 */
@WebServlet("/questionUpdate")
public class QuestionUpdateServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyUpdateServlet.class);
	
	private static final long serialVersionUID = 1L;
    
	private QuestionsRepository questionsRepo = new QuestionsRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();


		Questions retObj = (Questions) questionsRepo.findById(Long.valueOf(parameterId));
		retObj.setLabel(mapParameter.get("label")[0].trim());
		retObj.setDescription(mapParameter.get("description")[0].trim());
		retObj.setAnsa(mapParameter.get("ansa")[0].trim());
		retObj.setCansa(mapParameter.get("cansa")[0].trim().equals("true")?true:false);
		retObj.setAnsb(mapParameter.get("ansb")[0].trim());
		retObj.setCansb(mapParameter.get("cansb")[0].trim().equals("true")?true:false);
		retObj.setAnsc(mapParameter.get("ansc")[0].trim());
		retObj.setCansc(mapParameter.get("cansc")[0].trim().equals("true")?true:false);
		retObj.setAnsd(mapParameter.get("ansd")[0].trim());
		retObj.setCansd(mapParameter.get("cansd")[0].trim().equals("true")?true:false);
		retObj.setAnse(mapParameter.get("anse")[0].trim());
		retObj.setCanse(mapParameter.get("canse")[0].trim().equals("true")?true:false);
		retObj.setAnsf(mapParameter.get("ansf")[0].trim());
		retObj.setCansf(mapParameter.get("cansf")[0].trim().equals("true")?true:false);
		retObj.setAnsg(mapParameter.get("ansg")[0].trim());
		retObj.setCansg(mapParameter.get("cansg")[0].trim().equals("true")?true:false);
		retObj.setAnsh(mapParameter.get("ansh")[0].trim());
		retObj.setCansh(mapParameter.get("cansh")[0].trim().equals("true")?true:false);
		
		boolean updated = questionsRepo.update(retObj);
		log.info("updated Question: " + updated);

		if (updated) {
			request.setAttribute("questionUpdated", true);
		} else
			request.setAttribute("questionUpdate", false);

		request.getRequestDispatcher("questions/show-all-question.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}

}
