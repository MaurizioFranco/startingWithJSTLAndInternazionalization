package cerepro.web.servlets.maven.users;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import centauri.academy.proxima.cerepro.entity.EntityInterface;
import centauri.academy.proxima.cerepro.entity.User;
import centauri.academy.proxima.cerepro.repository.UserRepository;

/**
 * Servlet implementation class InsertServlets
 */
@WebServlet("/userUpdate")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UpdateServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		UserRepository uRep = new UserRepository();
		User usr = new User();
		
		//uRep.delete(Long.parseLong(request.getParameter("id")));
		
		usr.setId(Long.parseLong(request.getParameter("id")));
		System.out.println(request.getParameter("id") + "***********************************************************");
		System.out.println(usr.getId() + "#######################################################################");
		usr.setEmail(request.getParameter("email"));
		usr.setPassword(request.getParameter("password"));
		usr.setFirstname(request.getParameter("firstname"));
		usr.setLastname(request.getParameter("lastname"));
		try {// Set date of birth
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
		
		uRep.update(usr);
		
		String temp="<html>\r\n" + 
				"		<body>\r\n" + 
				"		<a href=\"http://localhost:8080/cerepro.web.servlets.maven.jsp/userList\">List</a>\r\n" + 
				"		</body>\r\n" + 
				"	</html>";
		
		
		response.getWriter().append(temp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

