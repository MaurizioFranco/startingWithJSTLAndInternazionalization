<%@page import="centauri.academy.proxima.cerepro.entity.SurveysReplies"%>
<%@page import="centauri.academy.proxima.cerepro.entity.SurveysQuestions"%>
<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="centauri.academy.proxima.cerepro.entity.Questions"%>
<html>
<head>
<title>page SurveyReply detail</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
				<h4>SurveyReply detail</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a
						href="<%=request.getServletContext().getContextPath()%>/main.jsp">Home</a></li>
					<li><a href="surveysReplies/surveyReply-control-panel.jsp">SurveyReply
							control panel</a></li>

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
					Object obj = request.getAttribute("retrieveOK");
					if (obj != null) {
						boolean ok = (boolean) obj;

						if (ok) {
							Object obj2 = request.getAttribute("survReplRetrieve");
							SurveysReplies surveyReply = (SurveysReplies) obj2;
				%>
				<form
					action="<%=request.getServletContext().getContextPath()%>/surveyReplyUpdate"
					method="GET">
					<table class="table">
						<tr>
							<th><h1>SurveyQuestion Detail</h1></th>
						</tr>
						<tr>
							<td><b>SURVEY_LABEL</b></td>
							<!-- value dovra' avere la label di survey e non l'id. SurveyQuestion Fara' una join con Survey -->
							<td><input type="text" value="<%=surveyReply.getSurveyId()%>" readonly="true" /></td>

						</tr>
						<tr>
							<td><b>USER_EMAIL</b></td>
							<!-- value dovra' avere la label di question e non l'id. SurveyQuestion Fara' una join con Question -->
							<td><input type="text" value="<%=surveyReply.getUserId()%>" readonly="true" /></td>
						</tr>
						<tr>
							<td><b>START TIME</b></td>
							<td><input type="datetime-local" name="start_time" value="<%=surveyReply.getStartTime()%>" /></td>
						</tr>
						<tr>
							<td><b>END TIME</b></td>
							<td><input type="datetime-local" name="end_time" value="<%=surveyReply.getEndTime()%>" /></td>
						</tr>
						<tr>
							<td><b>ANSWERS</b></td>
							<td><input type="text" name="answers" value="<%=surveyReply.getAnswer()%>" /></td>
						</tr>
						<tr>
							<td><b>PDF FILE NAME</b></td>
							<td><input type="text" name="pdf_file_name" value="<%=surveyReply.getPdfFileName()%>" /></td>
						</tr>
						<tr>
							<td><b>POINTS</b></td>
							<td><input type="text" name="points" value="<%=surveyReply.getPoints()%>" /></td>
						</tr>
						
						<tr>
							<td><input type="hidden" name="id" value="<%=surveyReply.getId()%>" /> <input type="submit" value="update" /></td>
						</tr>
					</table>
				</form>
				<%
					}
					}
				%>
				<hr>
				<hr>
			</div>
		</div>
	</div>

	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
	<%
		// 			}

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
