<%@page import="centauri.academy.proxima.cerepro.entity.User"%>
<%@page
	import="centauri.academy.proxima.cerepro.repository.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<%
		String idToUpdate2 = request.getParameter("id");
		System.out.println("This form.jsp has been received an id: " + idToUpdate2);
		User usrToUpdate = new User();
		// If "received" exists, then we take an object User that correspond to this id
		if (idToUpdate2 != null) {
			long idToUpdateLong = Long.parseLong(idToUpdate2);
			UserRepository uRep = new UserRepository();
			usrToUpdate = (User) uRep.findById(idToUpdateLong);
		}
		// If there is something in the usrToUpdate we update the user else just insert data
		String formAction = (usrToUpdate.getId() != null) ? "../userUpdate" : "../userInsert";
	%>

	<form action="<%=formAction%>" method="get">
		<%
			if (usrToUpdate.getId() != null) {
		%>
		<input type="hidden" name="id" value="<%=usrToUpdate.getId()%>">
		<%
			}
		%>
		
		Email:<br> <input type="email" name="email"
			value="<% out.print(((usrToUpdate.getEmail()!=null)?usrToUpdate.getEmail():"")); %>"><br><br>
		
		password:<br> <input type="password"
			name="password" value="<%out.print(((usrToUpdate.getPassword() != null) ? usrToUpdate.getPassword() : ""));%>"> <br><br>
		
		First name:<br>
		<input type="text" name="firstname" value="<%out.print(((usrToUpdate.getFirstname() != null) ? usrToUpdate.getFirstname() : ""));%>"> <br><br>
		
		Last name:<br> <input type="text" name="lastname" value="">
		<br><br>
		
		Date of birth:<br> 
		<input type="date"
			name="dateofbirth" value="<%out.print(((usrToUpdate.getDateofbirth() != null) ? usrToUpdate.getDateofbirth() : ""));%>"><br> <br>
		
		Role:<br>
		<select name="role">
			<option value="1">Role 1</option>
			<option value="2">Role 2</option>
			<option value="3">Role 3</option>
			<option value="4">Role 4</option>
			<option value="5">Role 5</option>
			<option value="6">Role 6</option>
			<option value="7">Role 7</option>
			<option value="8">Role 8</option>
			<option value="9">Role 9</option>
		</select> <br>	<br>
		
		Image path:<br>
 			 <input type="text" name="imgpath" value="<%out.print(((usrToUpdate.getImgpath() != null) ? usrToUpdate.getImgpath() : ""));%>"><br><br>
		
		Note:<br>
   		<textarea type="text" name="note" value="<%out.print(((usrToUpdate.getNote() != null) ? usrToUpdate.getNote() : ""));%>" rows="3" cols="30"><br>
		</textarea> <br><br>
		
		Enabled:<br>
 			<select name="enabled">
  			<option value="1">Yes</option>
  			<option value="0">No</option>
			</select> <br><br>
			
		<input type="submit" value="submit">
	</form>


</body>
</html>