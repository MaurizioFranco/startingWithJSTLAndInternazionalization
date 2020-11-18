<%@page import="centauri.academy.proxima.cerepro.entity.Roles"%>
<%@page import="centauri.academy.proxima.cerepro.repository.RolesRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String idToUpdate2 = request.getParameter("id");
System.out.println("Sono nella form.jsp ho ricevuto come id: " + idToUpdate2 );
Roles currentRoleToUpdate = new Roles () ;
if (idToUpdate2!=null) {
	long idToUpdateLong = Long.parseLong(idToUpdate2);
	RolesRepository rr = new RolesRepository();
	currentRoleToUpdate = (Roles)rr.findById(idToUpdateLong);
}
String formAction = (currentRoleToUpdate.getId()!=null)?"../roleUpdate":"../roleInsert" ;

%>
    <form action="<%=formAction %>" method="get">
<!-- 					<h3>Label AAA</h3> -->
					<%
					if (currentRoleToUpdate.getId()!=null){
						%>
						<input type="hidden" name="id" value="<%=currentRoleToUpdate.getId()%>">
						<%
					}
					
					%>
					<br> <input type="text" name="label" value="<% out.print(((currentRoleToUpdate.getLabel()!=null)?currentRoleToUpdate.getLabel():"")); %>" size="40"
						maxlength="20"><br>
					<h3>Description</h3>
					<br> <input name="description" type="text" value="<%=((currentRoleToUpdate.getDescription()!=null)?currentRoleToUpdate.getDescription():"")%>"
						size="40" maxlength="200" /><br>
					<h3>Level</h3>
					<br> <input name="level" type="number" value="<%=((currentRoleToUpdate.getLevel()!=null)?currentRoleToUpdate.getLevel():"")%>"
						size="40" /><br> <br> 
					<input
						type="submit" value="Submit">
				</form>

</body>
</html>