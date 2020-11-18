<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List"
	import="java.util.ArrayList"
	import="centauri.academy.proxima.cerepro.entity.EntityInterface"
	import="centauri.academy.proxima.cerepro.entity.Surveys"
	import="centauri.academy.proxima.cerepro.repository.SurveysRepository"%>
<html>
<head>
<title>Survey control panel</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
<% 	
// 		Object ooobj = request.getSession().getAttribute("userLogged");
// 		if (ooobj != null) {
// 			boolean isLogged = (boolean) ooobj;
// 			if (isLogged) {
%>	
	<div class="container-fluid">
		<div class="row content">
		<jsp:include page="../toolbar.jsp" />
			<div class="col-sm-3 sidenav">
				<h4>Survey table</h4>
				<h3>list of all survey</h3>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="<%=request.getServletContext().getContextPath()%>/main.jsp">Home</a></li>
					<li><a href="surveys/survey-control-panel.jsp">survey control panel</a></li>
					<li><a href="<%=request.getServletContext().getContextPath() %>/surveyDeleteAll">Delete all surveys</a></li>

				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
			<div class="col-sm-9">
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
							out.println("  <div class=\"alert alert-danger\">");
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
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>LABEL</th>
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
								<%= s.getDescription() %>
							</td>
							<td>
								<form
<%-- 									action="<%= request.getServletContext().getContextPath()%>/idsurvey" --%>
 									action="<%= request.getServletContext().getContextPath()%>/surveyDetail" 
									method="GET">
									<input type="hidden" name="id" value="<%=s.getId()%>" /> <input
										type="submit" value="update" />
								</form> <br>
<%-- 								<form action="<%=request.getServletContext().getContextPath()%>/delete" method="GET"> --%>
								<form action="<%=request.getServletContext().getContextPath()%>/surveyDelete" method="GET">
									<input type="hidden" name="id" value="<%=s.getId()%>" /> <input
										type="submit" value="delete" />
								</form>
							</td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
<%
// 			}
//			
// 			if(!isLogged){
// 				response.sendRedirect(request.getServletContext().getContextPath() + "/surveys/AnauthorizedPage.html");
// 			}
// 		}
// 		else {
// 			response.sendRedirect(request.getServletContext().getContextPath() + "/surveys/AnauthorizedPage.html");
// 		}
%>
</body>
</html>
