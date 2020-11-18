<%@page import="centauri.academy.proxima.cerepro.entity.CandidateStates"%>
<%@page
	import="centauri.academy.proxima.cerepro.repository.CandidateStatesRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate states</title>
</head>
<body>
<%
	String idToUpdate2 = request.getParameter("id");
		System.out.println("This form.jsp has been received an id: " + idToUpdate2);
		CandidateStates csToUpdate = new CandidateStates();
		// If "received" exists, then we take an object User that correspond to this id
		if (idToUpdate2 != null) {
	long idToUpdateLong = Long.parseLong(idToUpdate2);
	CandidateStatesRepository csRep = new CandidateStatesRepository();
	csToUpdate = (CandidateStates) csRep.findById(idToUpdateLong);
		}
		// If there is something in the usrToUpdate we update the user else just insert data
		String formAction = (csToUpdate.getId() != null) ? "../CandidateStatesInsert" : "../CandidateStatesInsert";
%>

	<form action="<%=formAction%>" method="get">
		<%
			if (csToUpdate.getId() != null) {
		%>
		<input type="hidden" name="id" value="<%=csToUpdate.getId()%>">
		<%
			}
		%>
		Role id:<br>
		<input type="number" name="roleid" value="<%out.print(((csToUpdate.getRole_id() != null) ? csToUpdate.getRole_id() : ""));%>" min="1" max="9999999999999999999" value><br><br>
		
		Status code:<br>
		<input type="number" name="statuscode" value="<%out.print((( String.valueOf(csToUpdate.getStatus_code()) != null) ? csToUpdate.getStatus_code(): ""));%>" min="1" max="9999999999"><br><br>
		
		Status label:<br>
		<input type="text" name="statuslabel" value="<%out.print(((csToUpdate.getStatus_label() != null) ? csToUpdate.getStatus_label() : ""));%>"> <br><br>
		
		Status description:<br>
		<input type="text" name="statusdescription" value="<%out.print(((csToUpdate.getStatus_description() != null) ? csToUpdate.getStatus_description() : ""));%>"> <br><br>
		
		Status color:<br>
		<input type="text" name="statuscolor" value="<%out.print(((csToUpdate.getStatus_color() != null) ? csToUpdate.getStatus_color() : ""));%>" maxlength="7"> <br><br>
			
		<input type="submit" value="submit">
		<input type="reset" value="reset">
	</form>
</body>
</html>