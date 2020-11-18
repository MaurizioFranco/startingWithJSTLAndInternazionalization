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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../toolbar.jsp" />
<%
	UserRepository uRep = new UserRepository();

	ServletContext sc = request.getServletContext();
	Object insertOp = sc.getAttribute("insert");// get the value of the "insert" key
	StringBuilder sb = new StringBuilder();

	if (insertOp != null) {
		boolean insertResult = Boolean.valueOf(insertOp + "");
		if (insertResult) {
			sb.append("<h3>Insert succeed!!</h3>");
		} else {
			sb.append("<h3>Insert failed!!</h3>");
		}
	}

	List<EntityInterface> items = uRep.findAll();
	int itemsSize = items.size();
	String tableContent = "<html><body>" + sb.toString() + "<h3 >User's List</h3>" + "<table border = '1'>";

	tableContent += "<tr><th>Id</th><th>Email</th><th>Password</th><th>First name</th><th>Last name</th><th>Date of birth</th><th>Register date</th><th>Role</th><th>Image path</th><th>Note</th><th>Enabled</th></tr>";
	for (EntityInterface current : items) {

		User n = (User) current;
		tableContent += "<tr><td>" + n.getId() + "</td><td>" + n.getEmail() + "</td><td>" + n.getPassword()
				+ "</td><td>" + n.getFirstname() + "</td><td>" + n.getLastname() + "</td><td>"
				+ n.getDateofbirth() + "</td><td>" + n.getRegdate() + "</td><td>" + n.getRole() + "</td><td>"
				+ n.getImgpath() + "</td><td>" + n.getNote() + "</td><td>" + n.getenabled() + "</td>";
		tableContent += "<td>"
				+ "<form action=\"./userDeleteById\"><input type=\"hidden\" id=\"custId\" name=\"usrid\" value=\""
				+ n.getId() + "\"><input type=\"submit\" value=\"Delete\"></form>" + "</td>";
		tableContent += "<td>"
				+ "<form action=\"./userUpdateById\"><input type=\"hidden\" id=\"custId\" name=\"usrid\" value=\""
				+ n.getId() + "\"><input type=\"submit\" value=\"Update\"></form>" + "</td></tr>";

	}

	tableContent += "</table>";
	response.getWriter().append(tableContent);

	String buttom = "<form action=\"./userDeleteAll\" method=\"POST\"><input type=\"submit\" value=\"Clean Table\"></form></body><html>";
	response.getWriter().append(buttom);
	String buttom2 = "<form action=\"/cerepro.web.servlets.maven.jsp/users/form.jsp\" method=\"POST\"><input type=\"submit\" value=\"New user\"></form></body><html>";
	response.getWriter().append(buttom2);
%>
</body>
</html>