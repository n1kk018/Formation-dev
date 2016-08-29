<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter au Panier</title>
</head>
<body>
	<h1>Ajouter au Panier</h1>
	<form name="caddy_form" id="form-1">
		<label for="product">produit:</label>
		<input id="product" name="product" placeholder="Nom du produit" type="text"/><br />
		<label for="quantity">qte:</label>
		<select id="quantity" name="quantity">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
		</select><br />
		<input type="submit" value="ajouter au panier" id="button-1"/>
	</form>
	<%
	String msg =  "Il n'y a aucune ligne dans le panier.";
	String produit = request.getParameter("product");
	Map<String,Integer> panier = (Map)session.getAttribute("caddy");
	
	if(panier == null){
		panier = new HashMap<String,Integer>(); 
		session.setAttribute("caddy",panier);
	} 
	if (produit!=null){
		panier.put(produit, Integer.parseInt(request.getParameter("quantity")));
	}
	if(panier.size()>0) {
		msg = "Il y a "+panier.size()+ " ligne(s) dans le panier.";
	}
	%>
	<p><%=msg %></p>
	<a href="<%=response.encodeURL("index.jsp")%>">Retour à l'accueil</a>
	<a href="<%=response.encodeURL("displayCaddy.jsp")%>">Afficher le panier</a>
</body>
</html>