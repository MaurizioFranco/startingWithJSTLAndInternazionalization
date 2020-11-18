package cerepro.web.servlets.maven.surveys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.Surveys;
import centauri.academy.proxima.cerepro.repository.SurveysRepository;

/**
 * Servlet implementation class ManageSurveyServlet
 */
@WebServlet(urlPatterns = { "/survey", "/createsurvey", "/delete", "/idsurvey", "/update", "/deleteall" })
public class ManageSurveyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SurveysRepository surveyRepo = new SurveysRepository();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getServletPath());
		if (request.getServletPath().equals("/survey")) {
			List<EntityInterface> retList = surveyRepo.findAll();
			System.out.println("sono in /survey");
			request.setAttribute("listAllSurvey", retList);
			RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
			resuqsetDispatcher.forward(request, response);
		}

		if (request.getServletPath().equals("/idsurvey")) {
			String idQueryString = request.getParameter("id");

			if (idQueryString != null) {

				Long idToSurveyRetrieve = Long.valueOf(idQueryString);
				EntityInterface surveyRetrieved = (Surveys) surveyRepo.findById(idToSurveyRetrieve);
				if (surveyRetrieved != null) {
					request.setAttribute("retrieveOK", true);
					request.setAttribute("survRetrieve", surveyRetrieved);
				} else {
					request.setAttribute("retrieveOK", false);
					RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/errorPage.html");
					resuqsetDispatcher.forward(request, response);
				}
				RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/survey.jsp");
				resuqsetDispatcher.forward(request, response);
			}
		}

		if (request.getServletPath().equals("/update")) {
			Map<String, String[]> mapParameter = request.getParameterMap();
			System.out.println("sonon in /update");
			String parameterId = mapParameter.get("id")[0].trim();

			Surveys survey = new Surveys();
			survey.setLabel(mapParameter.get("label")[0]);
			survey.setDescription(mapParameter.get("description")[0]);
			survey.setTime(Integer.parseInt(mapParameter.get("time")[0]));

			System.out.println("CI PASSO");
			Surveys retObj = (Surveys) surveyRepo.findById(Long.valueOf(parameterId));
			retObj.setLabel(mapParameter.get("label")[0].trim());
			retObj.setDescription(mapParameter.get("description")[0].trim());
			retObj.setTime(Integer.parseInt(mapParameter.get("time")[0].trim()));
			boolean updated = surveyRepo.update(retObj);

			if (updated) {
				request.setAttribute("surveyUpdated", true);
			} else
				request.setAttribute("surveyUpdate", false);

			RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
			resuqsetDispatcher.forward(request, response);
		}
		
		if (request.getServletPath().equals("/delete")) {
			Map<String, String[]> mapParameter = request.getParameterMap();
			System.out.println("sonon in /delete");
			String parameterId = mapParameter.get("id")[0].trim();
			
			boolean deleted = surveyRepo.delete(Integer.parseInt(parameterId));
			if(deleted) {
				request.setAttribute("surveyDeleted", true);
			} else
				request.setAttribute("surveyDeleted", false);
			
			RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
			resuqsetDispatcher.forward(request, response);
		}
		
		if (request.getServletPath().equals("/deleteall")) {
			int deleted = surveyRepo.deleteAll();
			if(deleted >= 0) {
				request.setAttribute("surveyDeletedAll", true);
			} else
				request.setAttribute("surveyDeletedAll", false);
			
			RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
			resuqsetDispatcher.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String[]> mapParameter = request.getParameterMap();

		Surveys survey = new Surveys();
		survey.setLabel(mapParameter.get("label")[0]);
		survey.setDescription(mapParameter.get("description")[0]);
		survey.setTime(Integer.parseInt(mapParameter.get("time")[0]));

		Long id = surveyRepo.create(survey);
		if (id > 0)
			request.setAttribute("surveyCrate", true);
		else
			request.setAttribute("surveyCrate", false);

		RequestDispatcher resuqsetDispatcher = request.getRequestDispatcher("surveys/show-all-survey.jsp");
		resuqsetDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}