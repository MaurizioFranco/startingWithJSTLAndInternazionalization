<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="centauri.academy.proxima.cerepro.entity.EntityInterface"
	import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<!DOCTYPE html>
<html>
<head>
<title>page create survey</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	<h1>Insert data of new Survey</h1>
	<form action="<%=request.getServletContext().getContextPath()%>/newSurvey" method="POST"> 
		<table>
			
			<tr>
				<td><b>label</b></td>
				<td><input type="text" name="label" /></td>
			</tr>
			<tr>
				<td><b>time</b></td>
				<td><input type="number" name="time" /></td>
			</tr>
			<tr>
				<td><b>description</b></td>
				<td><input type="text" name="description" /></td>
			</tr>
		</table>
		<input type="submit" value="insert" />
	</form>
</body>
</html>
