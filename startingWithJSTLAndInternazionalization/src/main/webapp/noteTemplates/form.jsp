
<%@page import="centauri.academy.proxima.cerepro.repository.NoteTemplateRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.NoteTemplate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Note Template</title>
</head>

<jsp:include page="../toolbar.jsp" />
<%

String id = request.getParameter("id");
NoteTemplate currentNoteTemplateToUpdate= new NoteTemplate();

if (id!=null) {
	long idLong = Long.parseLong(id);
	NoteTemplateRepository rr = new NoteTemplateRepository();
	currentNoteTemplateToUpdate = (NoteTemplate)rr.findById(idLong);
}
String formAction = (currentNoteTemplateToUpdate.getId()!=null)?"/cerepro.web.servlets.maven.jsp/noteTemplatesUpdate":"/cerepro.web.servlets.maven.jsp/noteTemplatesInsert" ;

%>
<body>
	<form action="<%=formAction%>" method="get">
	<%
	if(currentNoteTemplateToUpdate.getId()!=null){
	%>
		<input type="hidden" name="id" value="<%=currentNoteTemplateToUpdate.getId()%>" >
	<%
	}
	%>
	
	<h3>Title</h3>
	<input type="text" name="title" value="<%=((currentNoteTemplateToUpdate.getTitle()!=null)?currentNoteTemplateToUpdate.getTitle():(""))%>"required >
	<h3>Content</h3>
	<input type="text" name="content" value="<%=((currentNoteTemplateToUpdate.getContent()!=null)?currentNoteTemplateToUpdate.getContent():"")%>" required>
	<br>
	
	<input type="submit" value="Submit">
	</form>
</body>
</html>