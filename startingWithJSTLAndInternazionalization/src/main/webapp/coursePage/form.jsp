<%@page import="centauri.academy.proxima.cerepro.entity.CoursePage"%>
<%@page import="centauri.academy.proxima.cerepro.repository.CoursePageRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
       pageEncoding="ISO-8859-1"%> 
<%--        <%@ =open declaration import.  IMPORT  %> = close declaration  import.                --%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<jsp:include page="../toolbar.jsp" />
<%

String cpIdUpt = request.getParameter("id");
System.out.println("id in esecuzione:"+ cpIdUpt);

CoursePage cp = new CoursePage();

if(cpIdUpt != null){
		
	long idToUpdateLong = Long.parseLong(cpIdUpt);
	CoursePageRepository ntr = new CoursePageRepository ();
	cp = (CoursePage) ntr.findById(Long.valueOf(idToUpdateLong));

}

String formAction = (cp.getId()!=null)?"/cerepro.web.servlets.maven.jsp/coursePageUpdate":"/cerepro.web.servlets.maven.jsp/coursePageInsert" ;
%>
<body>
	<form action="<%=formAction %>" method = "get">

                    <% 
					if (cp.getId()!=null){
						%>
						<input type="hidden" name="id" value="<%=cp.getId()%>">
					    <%
					}
						%>
						 <br> Title:<br>
						  <input type="text" name="title" value="<% out.print(((cp.getTitle()!=null)?cp.getTitle():"")); %>" required size="40"
						maxlength="20"><br>
							
							 <br> code:<br> 
							
							<input type="text" name="code" value="<% out.print(((cp.getCode()!=null)?cp.getCode():"")); %>" required size="40"
						maxlength="20"><br>
							
							<br> body text:<br>
						
						<input type="text" name="body_text" value="<% out.print(((cp.getBody_text()!=null)?cp.getBody_text():"")); %>" required size="40"
						maxlength="200"><br>
						
						<br> file name:<br>
						
						<input type="text" name="file_name" value="<% out.print(((cp.getFile_name()!=null)?cp.getFile_name():"")); %>" required size="40"
						maxlength="20"><br>
						 <br> 
						 	<br>
						<input type="submit" value="insert" />
		<br>
		<a href="../coursePageSelectAll">click here to show CoursePage table</a>
	</form>
</body>
</html>


