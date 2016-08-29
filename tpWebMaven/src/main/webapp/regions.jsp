<%@page import="fr.afcepf.al28.dao.GeoDao"%>
<%@page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Regions</title>
</head>
<body>
<% List<String> regions = (new GeoDao()).rechercherRegions(); %>
<c:set var="regions" value="<%=regions%>" scope="page" />
<c:if test="${!empty regions}">
	<table id="table-1">
			<tbody>
				<c:forEach var="region" items="${regions}">
					<tr><td><c:out value="${region}" /></td></tr>
				</c:forEach>
			</tbody>
		</table>
</c:if>
</body>
</html>