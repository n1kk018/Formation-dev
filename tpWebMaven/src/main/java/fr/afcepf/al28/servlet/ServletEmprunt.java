package fr.afcepf.al28.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEmprunt
 */
@WebServlet("/ServletEmprunt") //depuis v3 et tomcat 7 équivalent de <servlet> dans web.xml
public class ServletEmprunt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEmprunt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Double montant = Double.valueOf(request.getParameter ("montant")) ;
		Integer nbAnnees = Integer.valueOf(request.getParameter ("duree"));
		Double tauxMensuel = (Double.valueOf(request.getParameter ("taux"))/100)/12.0;
		int nbMois = nbAnnees*12;
		Double mensualite = montant*tauxMensuel / (1 - Math.pow(1 + tauxMensuel, -nbMois));
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // encodage Unicode  cible (Html).
		DecimalFormat df = new DecimalFormat("0.00");
		out.println("<!DOCTYPE html><html><head><title>résultat</title></head><body><p>Montant mensuel : "+ df.format(mensualite) +" € / Mois</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
