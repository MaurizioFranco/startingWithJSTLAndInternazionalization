<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@page import="centauri.academy.proxima.cerepro.repository.SurveysRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="java.util.List"%>
<%@page import="centauri.academy.proxima.cerepro.entity.User"%>
<%@page import="centauri.academy.proxima.cerepro.repository.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Survey</title>
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	<h1>Survey Table</h1>
	<%
		Object obj = request.getAttribute("surveyCrate");
		if (obj != null) {
			Boolean createOK = (Boolean) obj;
			if (createOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Survey create SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Survey create FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj1 = request.getAttribute("surveyUpdated");
		if (obj1 != null) {
			Boolean updateOK = (Boolean) obj1;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Survey updated SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Survey updated FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj3 = request.getAttribute("surveyDeleted");
		if (obj3 != null) {
			Boolean updateOK = (Boolean) obj3;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("Survey deleted SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("<div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("Survey deleted FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
	<%
		Object obj4 = request.getAttribute("surveyDeletedAll");
		if (obj4 != null) {
			Boolean updateOK = (Boolean) obj4;
			if (updateOK) {
				out.println("<div class=\"alert alert-success\">");
				out.println("<h3>");
				out.println("delete all surveys SUCCESFULL !");
				out.println("</h3>");
				out.println("</div>");
			} else {
				out.println("  <div class=\"alert alert-danger\">");
				out.println("<h3>");
				out.println("delete all surveys FAILURE !");
				out.println("</h3>");
				out.println("</div>");
			}
		}
	%>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>LABEL</th>
					<th>TIME</th>
					<th>DESCRIPTION</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<%
					Object obj2 = request.getAttribute("listAllSurvey");
					List<EntityInterface> listSurvey = null;
					if (obj2 != null) {
						try {
							listSurvey = (List<EntityInterface>) obj2;
						} catch (ClassCastException ex) {
							ex.getMessage();
							ex.printStackTrace();
						}
					} else {
						SurveysRepository surveyRepo = new SurveysRepository();
						listSurvey = surveyRepo.findAll();
					}
					out.println(request.getServletPath());
					for (EntityInterface e : listSurvey) {
						Surveys s = (Surveys) e;
				%>
				<tr>
					<td>
						<%=	s.getId() %>
					</td>
					<td>
						<%= s.getLabel() %>
					</td>
					<td>
						<%= s.getTime() %>
					</td>
					<td>
						<%= s.getDescription() %>
					</td>
					<td>
						<form action="<%= request.getServletContext().getContextPath()%>/surveyDetail" method="GET">
							<input type="hidden" name="id" value="<%=s.getId()%>" /> 
							<input type="submit" value="update" />
						</form>
						<form action="<%=request.getServletContext().getContextPath()%>/surveyDelete" method="GET">
							<input type="hidden" name="id" value="<%=s.getId()%>" /> 
							<input type="submit" value="delete" />
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<form action="<%= request.getServletContext().getContextPath()%>/surveyDeleteAll">
			<input type="submit" value="reset table"/>
		</form>
		<form action="<%= request.getServletContext().getContextPath()%>/surveys/create-survey.jsp">
			<input type="submit" value="create survey" />
		</form>
</body>
</html>