<%@page import="centauri.academy.proxima.cerepro.entity.User"%>
<%@page import="centauri.academy.proxima.cerepro.repository.UserRepository"%>
<%@page import="centauri.academy.proxima.cerepro.repository.SurveyRepliesRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.SurveysReplies"%>
<%@page import="centauri.academy.proxima.cerepro.entity.Questions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="centauri.academy.proxima.cerepro.repository.QuestionsRepository"%>
<%@page import="centauri.academy.proxima.cerepro.repository.SurveysRepository"%>
<%@page import="centauri.academy.proxima.cerepro.repository.SurveyQuestionsRepository"%>
<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="centauri.academy.proxima.cerepro.entity.EntityInterface"
	import="centauri.academy.proxima.cerepro.entity.User"
	import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<!DOCTYPE html>
<html>
<head>
<title>page create surveyQuestion</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
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
// 		Object obj = request.getSession().getAttribute("userLogged");
// 		if (obj != null) {
// 			boolean isLogged = (boolean) obj;
// 			if (isLogged) {
	%>
	<div class="container-fluid">
		<div class="row content">
		<jsp:include page="../toolbar.jsp" />
			<div class="col-sm-3 sidenav">
				<h4>Create a new SurveyReply</h4>
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a href="<%=request.getServletContext().getContextPath()%>/main.jsp">Home</a></li>
					<li><a href="./surveyReply-control-panel.jsp">SurveyReply control panel</a></li>

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
			<%				
				SurveysRepository surveyRepo = new SurveysRepository();
				UserRepository userRepo = new UserRepository();
				
				List<Surveys> listSurvey = new ArrayList<>();
				surveyRepo.findAll().forEach( (entityInterf) -> {
							Surveys surv = (Surveys) entityInterf;
							listSurvey.add(surv);
				});

				List<User> listUser = new ArrayList<>();
				userRepo.findAll().forEach( (entityInterf) -> {
							User user = (User) entityInterf;
							listUser.add(user);
				});
				
			%>
			<div class="col-sm-9">
				<form action="../newSurveyReply" method="POST">
					<table class="table">
						<tr>
							<th><h1>Insert data of new SurveyReplie</h1></th>
						</tr>
						<tr>
							<td><b>SURVEY</b></td>
							<td>
								<select name="id_survey">
									<option value=""></option>
							<% if(!listSurvey.isEmpty()){
							  	  for(Surveys s : listSurvey){
							  			%>	
									<option value="<%=s.getId()%>"><%=s.getLabel()%></option>
							  		<%}
							  }%>
							 	</select>
							 </td>
						</tr>
						<tr>
							<td><b>USER</b></td>
							<td>
								<select name="id_user">
									<option value=""></option>
								
							<% if(!listUser.isEmpty()){
							  	  for(User u : listUser){
							  			%>	
									<option value="<%=u.getId()%>"><%=u.getEmail()%></option>
							  		<%}
							  }%>
								  </select>
							 </td>
						</tr>
						<tr>
							<td><b>START TIME</b></td>
							<td><input type="datetime-local" name="start_time" /></td>
						</tr>
						<tr>
							<td><b>END TIME</b></td>
							<td><input type="datetime-local" name="end_time" /></td>
						</tr>
						<tr>
							<td><b>ANSWERS</b></td>
							<td><input type="text" name="answers" /></td>
						</tr>
						<tr>
							<td><b>PDF FILE NAME</b></td>
							<td><input type="text" name="pdf_file_name" /></td>
						</tr>
						<tr>
							<td><b>POINTS</b></td>
							<td><input type="text" name="points" /></td>
						</tr>
						<tr>
							<td><input type="submit" value="insert" /></td>
						</tr>
					</table>
				</form>
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
