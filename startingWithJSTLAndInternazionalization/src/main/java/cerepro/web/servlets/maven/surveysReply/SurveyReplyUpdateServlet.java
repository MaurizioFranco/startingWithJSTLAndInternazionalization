package cerepro.web.servlets.maven.surveysReply;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Questions;
import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.entity.SurveysQuestions;
import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import centauri.academy.proxima.cerepro.repository.QuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;
import cerepro.web.servlets.maven.surveys.SurveyUpdateServlet;

/**
 * Servlet implementation class QuestionUodateServlet
 */
@WebServlet("/surveyReplyUpdate")
public class SurveyReplyUpdateServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(SurveyUpdateServlet.class);
	
	private static final long serialVersionUID = 1L;
    
	private SurveyRepliesRepository surveyReplyRepo = new SurveyRepliesRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("method - doGet() - INIT");
		log.info("Servlet path: " + request.getServletPath());
		Map<String, String[]> mapParameter = request.getParameterMap();
		String parameterId = mapParameter.get("id")[0].trim();

		SurveysReplies retObj = (SurveysReplies) surveyReplyRepo.findById(Long.valueOf(parameterId));
		retObj.setStartTime(fromLocalDateHtml2TimestampJava(mapParameter.get("start_time")[0]));
		retObj.setEndTime(fromLocalDateHtml2TimestampJava(mapParameter.get("end_time")[0]));
		retObj.setAnswer(mapParameter.get("answers")[0]);
		retObj.setPdfFileName(mapParameter.get("pdf_file_name")[0]);
		retObj.setPoints(mapParameter.get("points")[0]);
		
		boolean updated = surveyReplyRepo.update(retObj);
		log.info("updated SurveyReply: " + updated);

		if (updated) {
			request.setAttribute("surveyReplyUpdated", true);
		} else
			request.setAttribute("surveyReplyUpdate", false);

		request.getRequestDispatcher("surveysReplies/show-all-surveyReply.jsp").forward(request, response);
		log.info("method - doGet() - END");
	}
	
	private Timestamp fromLocalDateHtml2TimestampJava(String dd) {
		String splittedSting[] = dd.split("T");
		String date = splittedSting[0];
		String time = splittedSting[1];
		
		String splitDate[] = date.split("-");
		int year = Integer.parseInt(splitDate[0]);
		int month = Integer.parseInt(splitDate[1]);
		int dayOfMonth = Integer.parseInt(splitDate[2]);
		
		String splitTime[] = time.split(":");
		int hour = Integer.parseInt(splitTime[0]);
		int minute = Integer.parseInt(splitTime[1]);
		
		return Timestamp.valueOf(LocalDateTime.of(year, month, dayOfMonth, hour, minute));
	}

}
