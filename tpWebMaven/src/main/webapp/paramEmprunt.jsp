<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ page import="java.text.DecimalFormat"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calcul mensualité</title>
</head>
<%! int compteur = 1; %>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p>Cette page a été globalement appelée <%= compteur %> fois.</p>
	<form name="empruntForm" id="form-1" method="post">
		<br />
		<input id="input-1" name="montant" placeholder="Montant" type="text" value="<%=(request.getParameter ("montant")!=null?request.getParameter ("montant"):"")%>"/>
		<br />
		<input id="input-2" name="duree" placeholder="Durée" type="text" value="<%=(request.getParameter ("duree")!=null?request.getParameter ("duree"):"")%>"/>
		<br />
		<input id="input-3" name="taux" placeholder="Taux" type="text" value="<%=(request.getParameter ("taux")!=null?request.getParameter ("taux"):"")%>"/>
		<br /><br />
		<input type="submit" value="Calculer mensualité" id="button-1"/>
	</form>
	<% 
		synchronized(this){
			compteur++;
		}
		Double mensualite = null;
		DecimalFormat df = new DecimalFormat("0.00");
		String retour = "";
		if((request.getParameter ("montant")!=null & request.getParameter ("montant")!="") 
				&& (request.getParameter ("duree")!=null & request.getParameter ("duree")!="") 
				&& (request.getParameter ("taux")!=null& request.getParameter ("taux")!="") ){
			Double montant = Double.valueOf(request.getParameter("montant")) ;
			Integer nbAnnees = Integer.valueOf(request.getParameter ("duree"));
			Double tauxMensuel = (Double.valueOf(request.getParameter ("taux"))/100)/12.0;
			int nbMois = nbAnnees*12;
			mensualite = montant*tauxMensuel / (1 - Math.pow(1 + tauxMensuel, -nbMois));
			retour = (mensualite!=null?"Montant mensuel : <strong>"+ df.format(mensualite) +"</strong> € / Mois":"");
		}
	%>
	<%=retour%>
</body>
</html>