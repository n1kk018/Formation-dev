<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<a href="paramEmprunt.html">paramEmprunt(servlet)</a><br />
	<a href="paramEmprunt.jsp">paramEmprunt(jsp)</a><br />
	<a href="paramEmpruntMvc.jsp">paramEmprunt(mvc)</a><br />
	<a href="<%=response.encodeURL("addInCaddy.jsp")%>">Ajouter au panier</a><br />
	<a href="<%=response.encodeURL("displayCaddy.jsp")%>">Afficher le panier</a><br />
	<a href="regions.jsp">Liste des régions</a><br />
</body>
</html>