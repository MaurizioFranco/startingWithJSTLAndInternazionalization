package cerepro.web.servlets.maven.users;

import java.io.IOException;
import java.sql.Timestamp;
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
@WebServlet("/userUpdateById")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public UserUpdateServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		UserRepository uRep = new UserRepository();
		
		long id = Long.parseLong(request.getParameter("usrid"));
		User usr = (User)uRep.findById(id);
		
		String text="<table>";
		text+="<h1>Update</h1>";
		text+="<form action=\"./userUpdate\" method=\"get\">\r\n" + 
				"	<h3>Email</h3>\r\n" + 
				"	<input type=\"email\" name=\"email\" value=\"\">\r\n" + 
				"	<h3>Password</h3>\r\n" + 
				"	<input type=\"password\" name=\"password\" value=\"\">\r\n" + 
				"	<h3>First Name</h3>\r\n" + 
				"	<input type=\"text\" name=\"firstname\" value=\"\">\r\n" + 
				"	<h3>Last name</h3>\r\n" + 
				"	<input type=\"text\" name=\"lastname\" value=\"\">\r\n" + 
				"	<h3>Date of birth</h3>\r\n" + 
				"	<input type=\"date\" name=\"dateofbirth\" value=\"\">\r\n" + 
				"	<h3>Role</h3>\r\n" + 
				"	<select name=\"role\">\r\n" + 
				"	<option value=\"1\">Role 1</option>\r\n" +
				"	<option value=\"2\">Role 2</option>\r\n" +
				"	<option value=\"3\">Role 3</option>\r\n" +
				"	<option value=\"4\">Role 4</option>\r\n" +
				"	<option value=\"5\">Role 5</option>\r\n" +
				"	<option value=\"6\">Role 6</option>\r\n" +
				"	<option value=\"7\">Role 8</option>\r\n" +
				"	<option value=\"8\">Role 8</option>\r\n" +
				"	<option value=\"9\">Role 9</option>\r\n" +
				"	</select>\r\n" + 
				"	<h3>Image path</h3>\r\n" + 
				"	<input type=\"text\" name=\"imgpath\" value=\"\">\r\n" + 
				"	<h3>Note</h3>\r\n" + 
				"	<textarea type=\"text\" name=\"note\" value=\"\" rows=\"3\" cols=\"30\">\r\n" + 
				"	</textarea>\r\n" + 
				"	<h3>Enabled: </h3>\r\n" + 
				"	<select name=\"enabled\">\r\n" + 
				"	<option value=\"1\">Yes</option>\r\n" + 
				"	<option value=\"0\">No</option>\r\n" + 
				"	</select> \r\n" + 
				"	<br>\r\n" + 
				"	<h3>User Id: \"" + usr.getId() + "\"</h3>\r\n" + 
				"   <input type=\"hidden\" name=\"id\" value=\""+usr.getId() +"\">" + 
				"	<input type=\"submit\" value=\"Submit\">"+
		       "</form>\r\n";
		response.getWriter().append(text);
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


