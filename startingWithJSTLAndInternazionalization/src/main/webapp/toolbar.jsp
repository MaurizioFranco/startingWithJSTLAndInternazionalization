
<%@page import="centauri.academy.proxima.cerepro.entity.User"%>
<%
    System.out.println("toolbar.jsp - START");
	HttpSession xxx = request.getSession();
	Object ooo=xxx.getAttribute("user");
	System.out.println("toolbar.jsp - DEBUG 1");
	User currenUsers = null ;
	if(ooo!=null){
		System.out.println("toolbar.jsp - DEBUG 2");
		currenUsers= (User)ooo;
		
	}
	else{
		System.out.println("toolbar.jsp - DEBUG 3");
		
		RequestDispatcher rd  = request.getRequestDispatcher("./index.jsp");
		rd.forward(request, response);
// 		response.sendRedirect("./index.jsp");
	}
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/cerepro.web.servlets.maven.jsp/toolbar.css">
</head>
<body>

<ul>
	<li> <a href="/cerepro.web.servlets.maven.jsp/users/list.jsp">Utenti</a> </li>
	<li> <a href="<%=request.getServletContext().getContextPath()%>/surveyList">Surveys</a> </li>
	<li> <a href="<%=request.getServletContext().getContextPath()%>/questionList">Questions</a> </li>
	<li> <a href="<%=request.getServletContext().getContextPath()%>/surveysQuestions/surveyQuestion-control-panel.jsp">SurveysQuestions</a> </li>
	<li> <a href="<%=request.getServletContext().getContextPath()%>/surveysReplies/surveyReply-control-panel.jsp">SurveysReplies</a> </li>
	<li> <a href="/cerepro.web.servlets.maven.jsp/noteTemplates/list.jsp">NoteTemplates</a> </li>
	<li> <a href="./coursePageSelectAll">CoursePage</a> </li>
	<li> <a href="/cerepro.web.servlets.maven.jsp/roles/list.jsp">Roles</a> </li>
	<li> <a href="./CandidateStatesList">Candidate states</a> </li>
	<li> <a href="<%=request.getServletContext().getContextPath()%>/originSites/list.jsp">Origin Sites</a> </li>
	<div  id="log">
		<li > <a href="/cerepro.web.servlets.maven.jsp/main.jsp"><%=currenUsers.getEmail() %></a></li>
		<li > <a href="/cerepro.web.servlets.maven.jsp/logout.jsp">Logout</a></li>
		
	</div>
	
	<!-- id email and logout -->
</ul>

</body>

</html>
