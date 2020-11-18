
<%@page import="centauri.academy.proxima.cerepro.repository.OriginSitesRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.OriginSites"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OriginSites</title>
</head>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<%
String id = request.getParameter("id");
OriginSites currentOriginSitesToUpdate= new OriginSites();

if (id!=null) {
	long idLong = Long.parseLong(id);
	OriginSitesRepository rr = new OriginSitesRepository();
	currentOriginSitesToUpdate = (OriginSites)rr.findById(idLong);
}
String formAction = (currentOriginSitesToUpdate.getId()!=null)?"../originSiteUpdate":"../originSiteInsert" ;

%>
<body>
	<form action="<%=formAction%>" method="post">
	<%
	if(currentOriginSitesToUpdate.getId()!=null){
	%>
		<input type="hidden" name="id" value="<%=currentOriginSitesToUpdate.getId()%>" >
	<%
	}
	%>
	
	<h3>label</h3>
	<input type="text" name="label" value="<%=((currentOriginSitesToUpdate.getLabel()!=null)?currentOriginSitesToUpdate.getLabel():(""))%>"required >
	<h3>description</h3>
	<input type="text" name="description" value="<%=((currentOriginSitesToUpdate.getDescription()!=null)?currentOriginSitesToUpdate.getDescription():"")%>" required>
	<br>
	<h3>imgpath</h3>
	<input type="text" name="imgpath" value="<%=((currentOriginSitesToUpdate.getImgpath()!=null)?currentOriginSitesToUpdate.getImgpath():"")%>" required>
	<br>
	
	<input type="submit" value="Submit">
	</form>
</body>
</html>







