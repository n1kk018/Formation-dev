<%@page import="java.util.Map"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Afficher le Panier</title>
<style type="text/css">
	table, td, th{
		border: solid thin black;
	}
	td, th{
		padding: 5px;
	}
</style>
</head>
<body>
	<h1>Afficher le Panier</h1>
	<c:if test="${!empty caddy}">
		<table id="table-1">
			<thead>
				<tr><th>Produit</th><th>Quantité</th></tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${caddy}">
					<tr><td><c:out value="${article.key}" /></td><td><c:out value="${article.value}" /></td></tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<a href="<%=response.encodeURL("index.jsp")%>">Retour à l'accueil</a>
	<a href="<%=response.encodeURL("addInCaddy.jsp")%>">Ajouter au panier</a>
</body>
</html>