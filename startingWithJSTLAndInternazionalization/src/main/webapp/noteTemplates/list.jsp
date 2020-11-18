<%@page import="centauri.academy.proxima.cerepro.entity.NoteTemplate"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="java.util.List"%>
<%@page import="centauri.academy.proxima.cerepro.repository.NoteTemplateRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../toolbar.jsp" />
<%
NoteTemplateRepository ntr = new NoteTemplateRepository ();
List<EntityInterface> items = ntr.findAll();
ServletContext sc = request.getServletContext();
Object insertOp = sc.getAttribute("insert");
Object deleteOp = sc.getAttribute("deleteById");
Object deleteAllOp = sc.getAttribute("deleteAll");
Object update = sc.getAttribute("update");


StringBuilder sb = new StringBuilder ();
System.out.println("insert");
//creare metodo 
if (insertOp!=null) {
    boolean insertResult = Boolean.valueOf(insertOp+"") ;
    if (insertResult) {
    	%>
    	<h3 >Inserimento andato a buon fine</h3>
    	<%
    	
    
    } else {
    	%>
    	<h3 >Inserimento NON andato a buon fine</h3>
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
			<th>Content</th>
			<th>Operation</th>
		</tr>
<%
	for ( EntityInterface current : items ) {
	
	NoteTemplate n=(NoteTemplate)current;
	%>
		<tr>
			<td><%=n.getId() %></td>
			<td><%=n.getTitle()%></td>
			<td><%=n.getContent() %></td>
			<td>
				<table>
					<tr>
						<td>
							<form action="/cerepro.web.servlets.maven.jsp/noteTemplateDeleteById" method="get">
								<input type="hidden" name="id" value="<%=n.getId() %>">
								<input type="submit" value="CANCELLA">
							</form>
						</td>
						<td>
							<form action="/cerepro.web.servlets.maven.jsp/noteTemplates/form.jsp" method="get" >
								<input type="hidden" name="id" value="<%=n.getId() %>">
								<input type="submit" value="MODIFICA">
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
				<form action="/cerepro.web.servlets.maven.jsp/deleteAllServlet" method="get" >
					<input type="submit" value="DeleteAll">
				</form>
			</td>
			<td>
				<form>
					<button type="submit" formaction="/cerepro.web.servlets.maven.jsp/noteTemplates/form.jsp">Insert</button>
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