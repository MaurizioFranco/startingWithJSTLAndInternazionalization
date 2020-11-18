package cerepro.web.servlets.maven.users;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.Roles;
import centauri.academy.proxima.cerepro.entity.User;
import centauri.academy.proxima.cerepro.repository.RolesRepository;
import centauri.academy.proxima.cerepro.repository.UserRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/userInsert")// webServlet is mapped from the folder WebContent
public class InsertServlets extends HttpServlet  {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertServlets() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(request.getParameter("id")); // request.getParameter(<argument>) returns an String

//		
		UserRepository uRep = new UserRepository();
//		RolesRepository rRep = new RolesRepository();
		
//		uRep.deleteAll();
//		rRep.deleteAll();
		
//		Roles roles = new Roles();
//		roles = rRep.getEntityForTest();
//		rRep.create(roles);
		
		User usr = new User();
		usr.setEmail(request.getParameter("email"));
		usr.setPassword(request.getParameter("password"));
		usr.setFirstname(request.getParameter("firstname"));
		usr.setLastname(request.getParameter("lastname"));
//		System.out.println(request.getParameter(name));
		try {
			String dt = request.getParameter("dateofbirth");
			System.out.println("dt: " + dt);
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
			Date date = sDateFormat.parse(dt);
			usr.setDateofbirth(new java.sql.Date(date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usr.setRegdate(new Timestamp(System.currentTimeMillis()));
		usr.setRole(2);
		usr.setImgpath(request.getParameter("imgpath"));
		usr.setNote(request.getParameter("note"));
		usr.setenabled(Integer.parseInt(request.getParameter("enabled")));
		Long retValue = uRep.create(usr);
		
		ServletContext sc = request.getServletContext();
		if(retValue > 0) {
			sc.setAttribute("insert", "true");
		} else {
			sc.setAttribute("insert","false");
		}
		try {
			RequestDispatcher rd = request.getRequestDispatcher("./userList");
			rd.forward(request, response);
		} catch (ServletException se) {
			se.printStackTrace();
			response.getWriter().append("Something went wrong... try to reload the list page");
		}
		
//		if(flag > 0L) {
////			response.getWriter().append("Insert succeed!!! ");
//			RequestDispatcher rd = request.getRequestDispatcher("./userList");
//			rd.forward(request, response);
//		} else {
//			response.getWriter().append("Insert failed: ");
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
