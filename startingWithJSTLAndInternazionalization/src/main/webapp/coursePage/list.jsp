
<%@page import="java.util.List"%>
<%@page import="centauri.academy.proxima.cerepro.entity.CoursePage"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="centauri.academy.proxima.cerepro.repository.CoursePageRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
</head>
<body>
<jsp:include page="../toolbar.jsp" />
<%
		// TODO Auto-generated method stub
// 		response.getWriter().append("arriva");
		CoursePageRepository courseRep = new CoursePageRepository();
		List<EntityInterface> items = courseRep.findAll();
		ServletContext sc = request.getServletContext();
		Object insertOp = sc.getAttribute("insert");
		Object deleteOp = sc.getAttribute("deleteById");
		Object deleteAllOp = sc.getAttribute("deleteAll");
		Object update = sc.getAttribute("update");
		StringBuilder sb = new StringBuilder();
		System.out.println("insert");

		if (insertOp != null) {
			boolean insertResult = Boolean.valueOf(insertOp + "");
			if (insertResult) { // se la condizione risulta veritiera - if condition result true
			%>
			<h2>il tuo inserimento stato eseguito con successo, sei fortunato  !!<h2>
			<% 
			} else {
				%> 
			<h2>il tuo inserimento NON e' stato eseguito con successo, sei sfortunato  !!<h2>
				<% 
			}
		}
		%>
		<% 
		if (update!=null) {
		    boolean updateResult = Boolean.valueOf(update+"") ;
		    if (updateResult) {
		    	%>
		    	<h3 >Update andata a buon fine</h3>
		    	<%
		    	
		    } else {
		    	%>
		    	<h3 >Update andata male</h3>
		    	<%
		    }
		}
		if (deleteOp!=null) {
		    boolean deleteResult = Boolean.valueOf(deleteOp+"") ;
		    if (deleteResult) {
		    	%>
		    	<h3 >Eliminazione andata a buon fine</h3>
		    	<%
		    } else {
		    	%>
		    	<h3 >Eliminazione andata male</h3>
		    	<%
		    }
		}
		if (deleteAllOp!=null) {
		    boolean deleteAllResult = Boolean.valueOf(deleteAllOp+"") ;
		    if (deleteAllResult) {
		    	%>
		    	<h3 >Eliminazione di tutta la tabella andata a buon fine</h3>
		    	<%
		    } else {
		  		 %>
		    	<h3 >Eliminazione di tutta la tabella NON andata a buon fine</h3>
		    	<%
		    }
		    
		}
		%>
	

	<h3 >List</h3>
	<table border='1'>
		<tr> 
			<th>Id</th>
			<th>Title</th>
			<th>Code</th>
			<th>Body_text</th>
			<th>File_name</th>
		</tr>
<%
		for (EntityInterface current : items) {
			CoursePage n = (CoursePage) current;
			%>
				<tr>
									<td><%= n.getId() %></td>
									<td><%= n.getTitle() %></td>
									<td><%= n.getCode() %></td>
									<td><%= n.getBody_text() %></td>
									<td><%= n.getFile_name() %></td>
									<td>
										
										<form action="/cerepro.web.servlets.maven.jsp/coursePageDeleteById" method="get">
										<input type="hidden" name="id" value="<%=n.getId() %>">
										<input type="submit" value="click to delete of CoursePages table">
										</form>" 
										<td>
							<form action="/cerepro.web.servlets.maven.jsp/coursePage/form.jsp" method="get" >
								<input type="hidden" name="id" value="<%=n.getId() %>">
								<input type="submit" value="click to insert_new CoursePages table">
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	<%
	}
	%>

	</table>
	<table>
		<tr>
			<td>
				<form action="/cerepro.web.servlets.maven.jsp/coursePageDeleteAll" method="get" >
					<input type="submit" value="DeleteAll">
				</form>
			</td>
			<td>
				<form>
					<button type="submit" formaction="/cerepro.web.servlets.maven.jsp/coursePage/form.jsp">Insert</button>
				</form>
			</td>
		</tr>
	</table>



<h2><%=sb.toString() %></h2>
<%
sb.setLength(0);

sc.removeAttribute("deleteAll");
sc.removeAttribute("deleteById");
sc.removeAttribute("insert");
sc.removeAttribute("update");

%>

</body>
</html>