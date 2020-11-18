<%@page import="centauri.academy.proxima.cerepro.entity.SurveysQuestions"%>
<%@page import="centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<title>SurveyQuestion control panel</title>
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
				<h4>SurveyQuestion table</h4>
				<h3>list of all SurveyQuestions</h3>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="<%= request.getServletContext().getContextPath() %>/main.jsp">Home</a></li>
					<li><a href="surveysQuestions/surveyQuestion-control-panel.jsp">SurveyQuestion control panel</a></li>
					<li><a href="<%=request.getServletContext().getContextPath() %>/surveyQuestionDeleteAll">Delete all surveyQuestion</a></li>

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
					Object obj = request.getAttribute("surveyQuestionCrate");
					if (obj != null) {
						Boolean createOK = (Boolean) obj;
						if (createOK) {
							out.println("<div class=\"alert alert-success\">");
							out.println("<h3>");
							out.println("SurveyQuestion create SUCCESFULL !");
							out.println("</h3>");
							out.println("</div>");
						} else {
							out.println("  <div class=\"alert alert-danger\">");
							out.println("<h3>");
							out.println("SurveyQuestion create FAILURE !");
							out.println("</h3>");
							out.println("</div>");
						}
					}
				%>
				<%
					Object obj1 = request.getAttribute("surveyQuestionUpdated");
					if (obj1 != null) {
						Boolean updateOK = (Boolean) obj1;
						if (updateOK) {
							out.println("<div class=\"alert alert-success\">");
							out.println("<h3>");
							out.println("SurveyQuestion updated SUCCESFULL !");
							out.println("</h3>");
							out.println("</div>");
						} else {
							out.println("  <div class=\"alert alert-danger\">");
							out.println("<h3>");
							out.println("SurveyQuestion updated FAILURE !");
							out.println("</h3>");
							out.println("</div>");
						}
					}
				%>
				<%
					Object obj3 = request.getAttribute("surveyQuestionDeleted");
					if (obj3 != null) {
						Boolean updateOK = (Boolean) obj3;
						if (updateOK) {
							out.println("<div class=\"alert alert-success\">");
							out.println("<h3>");
							out.println("SurveyQuestion deleted SUCCESFULL !");
							out.println("</h3>");
							out.println("</div>");
						} else {
							out.println("  <div class=\"alert alert-danger\">");
							out.println("<h3>");
							out.println("SurveyQuestion deleted FAILURE !");
							out.println("</h3>");
							out.println("</div>");
						}
					}
				%>
				<%
					Object obj4 = request.getAttribute("surveyQuestionDeletedAll");
					if (obj4 != null) {
						Boolean updateOK = (Boolean) obj4;
						if (updateOK) {
							out.println("<div class=\"alert alert-success\">");
							out.println("<h3>");
							out.println("delete all surveyQuestion SUCCESFULL !");
							out.println("</h3>");
							out.println("</div>");
						} else {
							out.println("  <div class=\"alert alert-danger\">");
							out.println("<h3>");
							out.println("delete all surveyQuestion FAILURE !");
							out.println("</h3>");
							out.println("</div>");
						}
					}
				%>
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>SURVEY</th>
							<th>QUESTION</th>
							<th>POSITION</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<%
							Object obj2 = request.getAttribute("listAllSurveyQuestion");
							List<EntityInterface> listSurveyQuestion = null;
							if (obj2 != null) {
								try {
									listSurveyQuestion = (List<EntityInterface>) obj2;
								} catch (ClassCastException ex) {
									ex.getMessage();
									ex.printStackTrace();
								}
							} else {
								SurveyQuestionsRepository surveyQuestionRepo = new SurveyQuestionsRepository();
								listSurveyQuestion = surveyQuestionRepo.findAll();
							}
							out.println(request.getServletPath());
							for (EntityInterface e : listSurveyQuestion) {
								SurveysQuestions sq = (SurveysQuestions) e;
						%>
						<tr>
							<td>
								<%=	sq.getId() %>
							</td>
							<td>
								<!-- Deve essere inserita la label di survey -->
								<%= sq.getSurveyId() %>
							</td>
							<td>
								<!-- Deve essere inserita la label di question -->
								<%= sq.getQuestionId() %>
							</td>		
							<td>
								<%= sq.getPosition() %>
							</td>
							
							<td>
								<form
 									action="<%= request.getServletContext().getContextPath()%>/surveyQuestionDetail" 
									method="GET">
									<input type="hidden" name="id" value="<%=sq.getId()%>" /> <input
										type="submit" value="update" />
								</form> <br>
								<form action="<%=request.getServletContext().getContextPath()%>/surveyQuestionDelete" method="GET">
									<input type="hidden" name="id" value="<%=sq.getId()%>" /> <input
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
