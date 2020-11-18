<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
// ServletContext sc = request.getServletContext();
Object lf = request.getAttribute("loginFailed");
if (lf!=null) {
	boolean loginFailed = Boolean.valueOf(""+lf);
	if (loginFailed) {
		out.print("Username o password non corretti!!!");
	}
}

%>
<h1>Welcome to cerepro back office!</h1>
<form action="./LoginServlet" method="get">

  <div class="container">
    <label for="email"><b>email</b></label>
    <input type="email" placeholder="Enter email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <input type="submit" value="login"/>
  </div>

</form>
</body>
</html>