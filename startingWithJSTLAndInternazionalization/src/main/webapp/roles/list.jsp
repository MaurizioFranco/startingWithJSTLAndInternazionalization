
<%@page import="centauri.academy.proxima.cerepro.entity.Roles"%>
<%@page import="centauri.academy.proxima.cerepro.entity.EntityInterface"%>
<%@page import="java.util.List"%>
<%@page
	import="centauri.academy.proxima.cerepro.repository.RolesRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- 	COMMON JSTL && INTERNAZIONALIZATION CODE - START -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${param.lang==null}">
	<fmt:setLocale value="en" />
</c:if>
<c:if test="${param.lang!=null}">
	<fmt:setLocale value="${param.lang}" />
</c:if>
<fmt:setBundle basename="application" var="lang" scope="session" />
<!-- 	COMMON JSTL && INTERNAZIONALIZATION CODE - END -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../toolbar.jsp" />
	<h3>List di ruoli</h3>
	<table>
		<thead>
			<tr>
				<th><fmt:message key="table.default.th.id" bundle="${lang}" /></th>
				<th><fmt:message key="table.default.th.label" bundle="${lang}" /></th>
				<th><fmt:message key="table.default.th.description" bundle="${lang}" /></th>
				<th><fmt:message key="table.default.th.level" bundle="${lang}" /></th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<tbody>
			<% 
ServletContext sc = request.getServletContext();
		Object insertOp = sc.getAttribute("insert");
		StringBuilder sb = new StringBuilder ();
		
		if (insertOp!=null) {
		    boolean insertResult = Boolean.valueOf(insertOp+"") ;
		    if (insertResult) {
		    	sb.append("<h3 >inserimento andato a buon fine</h3>");
		    } else {
		    	sb.append("<h3 >inserimento NON andato a buon fine</h3>");
		    }
		} 
		
		RolesRepository ntr = new RolesRepository ();
		
		List<EntityInterface> lei = ntr.findAll();

		String tableContent = sb.toString() + "";

		
		for ( EntityInterface current :lei ) {
			
			Roles n=(Roles)current;
			tableContent+="<tr>"
							+ "<td>" 
								+ n.getId()
							+ "</td>"
							+ "<td>"
								+n.getLabel()
							+"</td>"
							+ "<td>"
								+n.getDescription()
							+"</td>"
							+ "<td>"
								+n.getLevel()
							+"</td>"
							+ "<td><form action=\"./roles/form.jsp\" method=\"get\">"+
							"<input type='hidden' name='id' value='" + n.getId()+ "'>"+
							"<input type='submit' value='MODIFICA'/></form>"+
								
							"</td>"
						+ "</tr>";
		}

		out.print(tableContent);
		%>
		</tbody>
	</table>
</body>
</html>