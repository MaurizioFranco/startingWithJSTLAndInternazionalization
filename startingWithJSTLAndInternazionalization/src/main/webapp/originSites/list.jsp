<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="cerepro.web.servlets.maven.originSites.Methods"%>
<%@page import="centauri.academy.proxima.cerepro.entity.OriginSites"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="java.util.List"%>
<%@page
	import="centauri.academy.proxima.cerepro.repository.OriginSitesRepository"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	
	<c:if test="${param.lang==null}">
		<fmt:setLocale value="en" />
	</c:if>
	<c:if test="${param.lang!=null}">

		<fmt:setLocale value="${param.lang}" />
	</c:if>
	<fmt:setBundle basename="application" var="lang" scope="session" />
	<fmt:message key="message.first" bundle="${lang}" />
	<br />
	<%
		OriginSitesRepository ntr = new OriginSitesRepository();
		Methods m = new Methods();
		List<EntityInterface> items = ntr.findAll();
		// ServletContext sc = request.getServletContext();

		//Object insertOp = request.getAttribute("insert");
		Object deleteOp = request.getAttribute("deleteById");
		Object deleteAllOp = request.getAttribute("deleteAll");
		Object update = request.getAttribute("update");
		
	%>

	<p>
		<c:out value="${insert}"></c:out>
		<c:if test="${insert != null}">
			<c:if test="${insert == true}">
				<p>inserimento andato a buon fine!!
				<p>
			</c:if>
			<c:if test="${insert == false}">
				<p>inserimento non andato a buon fine!!
				<p>
			</c:if>
		</c:if>

		result:

		<%=m.ObjectInsert(deleteOp)%><br> <br>
		<%=m.ObjectInsert(deleteAllOp)%><br> <br>
		<%=m.ObjectInsert(update)%>
	</p>
	<h3>List</h3>
	<table border='1'>
		<tr>
			<th>Id</th>
			<th>label</th>
			<th>description</th>
			<th>imgpath</th>
			<th>Button</th>
		</tr>
		<%
			for (EntityInterface current : items) {

				OriginSites os = (OriginSites) current;
		%>
		<tr>
			<td><%=os.getId()%></td>
			<td><%=os.getLabel()%></td>
			<td><%=os.getDescription()%></td>
			<td><%=os.getImgpath()%></td>
			<td>
				<table>
					<tr>
						<td>
							<!-- 			cancella -->
							<form action="/cerepro.web.servlets.maven.jsp/DeleteByIdServlet"
								method="get">
								<input type="hidden" name="id" value="<%=os.getId()%>">
								<input type="submit" value="CANCELLA">
							</form>
						</td>
						<!-- 			modifica -->
						<td>
							<form
								action="/cerepro.web.servlets.maven.jsp/originSites/form.jsp"
								method="get">
								<input type="hidden" name="id" value="<%=os.getId()%>">
								<input type="submit" value="MODIFICA">
							</form>
						</td>
					</tr>
				</table> <%
			}
		%>
			
	</table>
	<table>
		<tr>
			<td>
				<!-- 			deleteall -->
				<form action="/cerepro.web.servlets.maven.jsp/DeleteAll"
					method="get">
					<input type="submit" value="DeleteAll">
				</form>
			</td>
			<td>
				<form>
					<button type="submit"
						formaction="/cerepro.web.servlets.maven.jsp/originSites/form.jsp">Insert</button>
				</form>
			</td>
		</tr>
	</table>
	<!--  ALLUCINAZIONE!!!!!!!!!!! -->
	<table>
		<c:forEach items="${originSitesList}" var="current">
			<tr>
				<td><c:out value="${current.label}"></c:out></td>
			</tr>
		</c:forEach>

	</table>
</body>

</html>