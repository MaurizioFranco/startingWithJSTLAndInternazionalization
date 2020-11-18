<%@page import="centauri.academy.proxima.cerepro.entity.Surveys"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="centauri.academy.proxima.cerepro.entity.Questions"%>
<html>
<head>
<title>page question detail</title>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	<h1>Question Detail</h1>
	<%
		Object obj = request.getAttribute("retrieveOK");
		if (obj != null) {
			boolean ok = (boolean) obj;

			if (ok) {
				Object obj2 = request.getAttribute("questRetrieve");
				Questions question = (Questions) obj2;
	%>
	<form
		action="<%=request.getServletContext().getContextPath()%>/questionUpdate" method="GET">
		<table borde="2">
			<tr>
				<td><b>label</b></td>
				<td><input type="text" name="label" value="<%=question.getLabel()%>" /></td>
			</tr>
			<tr>
				<td><b>description</b></td>
				<td><input type="text" name="description" value="<%=question.getDescription()%>" /></td>
			</tr>
			<tr>
				<td><b>answer A</b></td>
				<td><input type="text" name="ansa" value="<%=question.getAnsa()%>" /></td>
				<td><input type="text" name="cansa" value="<%if (question.getCansa()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer B</b></td>
				<td><input type="text" name="ansb" value="<%=question.getAnsb()%>" /></td>
				<td><input type="text" name="cansb" value="<%if (question.getCansb()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer C</b></td>
				<td><input type="text" name="ansc" value="<%=question.getAnsc()%>" /></td>
				<td><input type="text" name="cansc" value="<%if (question.getCansc()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer D</b></td>
				<td><input type="text" name="ansd" value="<%=question.getAnsd()%>" /></td>
				<td><input type="text" name="cansd" value="<%if (question.getCansd()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer E</b></td>
				<td><input type="text" name="anse" value="<%=question.getAnse()%>" /></td>
				<td><input type="text" name="canse" value="<%if (question.getCanse()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer F</b></td>
				<td><input type="text" name="ansf" value="<%=question.getAnsf()%>" /></td>
				<td><input type="text" name="cansf" value="<%if (question.getCansf()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer G</b></td>
				<td><input type="text" name="ansg" value="<%=question.getAnsg()%>" /></td>
				<td><input type="text" name="cansg" value="<%if (question.getCansg()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
			<tr>
				<td><b>answer H</b></td>
				<td><input type="text" name="ansh" value="<%=question.getAnsh()%>" /></td>
				<td><input type="text" name="cansh" value="<%if (question.getCansh()) out.println("true"); else out.println("false");%>" /></td>
			</tr>
		</table>
		<input type="hidden" name="id" value="<%=question.getId()%>" /> <input type="submit" value="update" />
	</form>
	<%
		}
	}
	%>
</body>
</html>
