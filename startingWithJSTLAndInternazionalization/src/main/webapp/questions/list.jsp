<%@page import="centauri.academy.proxima.cerepro.repository.QuestionsRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.Questions"%>
<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"
	import="centauri.academy.proxima.cerepro.entity.EntityInterface"
	import="centauri.academy.proxima.cerepro.entity.Surveys"
	import="centauri.academy.proxima.cerepro.repository.SurveysRepository"%>
<html>
<head>
<title>Question control panel</title>
<meta charset="ISO-8859-1">
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	<h1>Question table</h1>
	<%
		Object obj = request.getAttribute("questionCrate");
		if (obj != null) {
			Boolean createOK = (Boolean) obj;
			if (createOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Question create SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Question create FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj1 = request.getAttribute("questionUpdated");
		if (obj1 != null) {
			Boolean updateOK = (Boolean) obj1;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Question updated SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Question updated FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj3 = request.getAttribute("questionDeleted");
		if (obj3 != null) {
			Boolean updateOK = (Boolean) obj3;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Question deleted SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Question deleted FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj4 = request.getAttribute("questionDeletedAll");
		if (obj4 != null) {
			Boolean updateOK = (Boolean) obj4;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("delete all questions SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("delete all questions FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>LABEL</th>
				<th>DESCRIPTION</th>
				<th>FULL ANSWER</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
	<%
		Object obj2 = request.getAttribute("listAllQuestion");
		List<EntityInterface> listSurvey = null;
		if (obj2 != null) {
			try {
				listSurvey = (List<EntityInterface>) obj2;
			} catch (ClassCastException ex) {
				ex.getMessage();
				ex.printStackTrace();
			}
		} else {
			QuestionsRepository questionRepo = new QuestionsRepository();
			listSurvey = questionRepo.findAll();
		}
		out.println(request.getServletPath());
		for (EntityInterface e : listSurvey) {
			Questions q = (Questions) e;
	%>
	<tr>
		<td>
			<%=	q.getId() %>
		</td>
		<td>
			<%= q.getLabel() %>
		</td>
		<td>
			<%= q.getDescription() %>
		</td>		
		<td>
			<%= q.getFullAnswer() %>
		</td>
		
		<td>
			<form
					action="<%= request.getServletContext().getContextPath()%>/questionDetail" 
				method="GET">
				<input type="hidden" name="id" value="<%=q.getId()%>" /> <input
					type="submit" value="update" />
			</form> <br>
			<form action="<%=request.getServletContext().getContextPath()%>/questionDelete" method="GET">
				<input type="hidden" name="id" value="<%=q.getId()%>" /> <input
					type="submit" value="delete" />
			</form>
		</td>
	</tr>
	<%
		}
	%>
		</tbody>
	</table>
	<form action="<%= request.getServletContext().getContextPath()%>/questionDeleteAll">
		<input type="submit" value="reset table"/>
	</form>
	<form action="<%= request.getServletContext().getContextPath()%>/questions/create-question.jsp">
		<input type="submit" value="create question" />
	</form>
</body>
</html>
