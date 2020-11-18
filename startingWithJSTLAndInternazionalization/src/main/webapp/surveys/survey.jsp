<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<html>
<head>
<title>page survey detail</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../toolbar.jsp" />	
	<h1>Survey detail</h1>
	<%
		Object obj = request.getAttribute("retrieveOK");
		if (obj != null) {
			boolean ok = (boolean) obj;

			if (ok) {
				Object obj2 = request.getAttribute("survRetrieve");
				Surveys survey = (Surveys) obj2;
	%>
	<form action="<%=request.getServletContext().getContextPath()%>/surveyUpdate" method="GET">
		<table>
			<tr>
				<th><h1>Survey detail</h1></th>
			</tr>
			<tr>
				<td>label</td>
				<td><input type="text" name="label" value="<%=survey.getLabel()%>" /></td>
			</tr>
			<tr>
				<td>time</td>
				<td><input type="number" name="time" value="<%=survey.getTime()%>" /></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" value="<%=survey.getDescription()%>" /></td>
			</tr>
			<tr>
				<td>
					<input type="hidden" name="id" value="<%=survey.getId()%>" /> 
					<input type="submit" value="update" />
				</td>
			</tr>
		</table>
	</form>
	<%
		}
	}
	%>

</body>
</html>
