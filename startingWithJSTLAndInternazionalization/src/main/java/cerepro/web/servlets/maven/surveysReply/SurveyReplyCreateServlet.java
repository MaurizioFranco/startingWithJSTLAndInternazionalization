package cerepro.web.servlets.maven.surveysReply;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.SurveysReplies;
import centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/newSurveyReply")
public class SurveyReplyCreateServlet extends HttpServlet {

	private static Logger log = LoggerFactory.getLogger(SurveyReplyCreateServlet.class);

	private static final long serialVersionUID = 1L;

	private SurveyRepliesRepository surveyReplyRepo = new SurveyRepliesRepository();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> mapParameter = request.getParameterMap();

		SurveysReplies surveyReply = new SurveysReplies();
		surveyReply.setSurveyId(Long.valueOf(mapParameter.get("id_survey")[0]));
		log.error(mapParameter.get("start_time")[0]);
		surveyReply.setUserId(Long.valueOf(mapParameter.get("id_user")[0]));
		surveyReply.setStartTime(fromLocalDateHtml2TimestampJava(mapParameter.get("start_time")[0]));
		surveyReply.setEndTime(fromLocalDateHtml2TimestampJava(mapParameter.get("end_time")[0]));
		surveyReply.setAnswer(mapParameter.get("answers")[0].trim());
		surveyReply.setPdfFileName(mapParameter.get("pdf_file_name")[0].trim());
		surveyReply.setPoints(mapParameter.get("points")[0].trim());
		log.info(surveyReply.toString());

		Long id = surveyReplyRepo.create(surveyReply);
		log.info("surveyReply id: " + id);
		if (id > 0)
			request.setAttribute("surveyReplyCrate", true);
		else
			request.setAttribute("surveyReplyCrate", false);

		request.getServletContext().getRequestDispatcher("/surveysReplies/show-all-surveyReply.jsp").forward(request, response);
		log.info("method - doPost() - END");
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
