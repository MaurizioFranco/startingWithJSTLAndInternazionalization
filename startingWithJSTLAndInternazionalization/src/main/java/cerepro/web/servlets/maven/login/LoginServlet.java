package cerepro.web.servlets.maven.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;
import centauri.academy.proxima.cerepro.repository.UserRepository;
import cerepro.web.servlets.maven.surveys.SurveyCreateServlet;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(LoginServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("loginSevlet start");
		RequestDispatcher rd ;
		
		if(checkAccount(request.getParameter("email"),request.getParameter("psw"),request.getSession())) {
			rd =request.getRequestDispatcher("./main.jsp");
		}
		else {
			 rd =request.getRequestDispatcher("./index.jsp");
//			 ServletContext sc = request.getServletContext();
			 
			 request.setAttribute("loginFailed", true);
		}
		 rd.forward(request, response);
	}
	
	private boolean checkAccount(String email, String password , HttpSession session) {
		log.info("checkAccount start");
		UserRepository uRep = new UserRepository();
		
		EntityInterface use = uRep.findByEmail(email);
		if(use != null) {
			User usr = (User)use;
			if(usr.getPassword().equals(password)) {
				session.setAttribute("user", usr);
				log.info("checkAccount debug settato utente in sessione: "+usr);
				return true;
			}
		}
		
		return false;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
