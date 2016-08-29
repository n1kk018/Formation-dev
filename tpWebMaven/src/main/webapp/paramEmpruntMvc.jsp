<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Calcul mensualité avec Mvc</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="main.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	${objCalcul.msgHtml} <!--  eventuel msg d'erreur -->
	<form name="empruntForm" id="form-1" method="post" action="MyMvcServlet">
		<input name="task" type="hidden" value="calcul_mensuailte" />
		<br />
		<input id="input-1" name="montant" placeholder="Montant" type="text" value="${objCalcul.montant}" />
		<br />
		<input id="input-2" name="duree" placeholder="Durée" type="text" value="${objCalcul.duree}" />
		<br />
		<input id="input-3" name="taux" placeholder="Taux" type="text" value="${objCalcul.taux}" />
		<br /><br />
		<input type="submit" value="Calculer mensualité - MVC" id="button-1" />
	</form>
</body>
</html>