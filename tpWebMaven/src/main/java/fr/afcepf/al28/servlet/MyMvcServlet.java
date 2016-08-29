package fr.afcepf.al28.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afcepf.al28.model.CalculEmprunt;

/**
 * Servlet implementation class MyMvcServlet
 */
@WebServlet("/MyMvcServlet")
public class MyMvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMvcServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		switch (task) {
		case "calcul_mensuailte":
			doCalculMensualite(request, response);
		default:
			break;
		}
		//doGet(request, response);
	}
	
	protected void doCalculMensualite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sUrl = "/mensualiteMvcRes.jsp";
		CalculEmprunt objCalcul = new CalculEmprunt();
		try{
			objCalcul.setMontant(Double.parseDouble(request.getParameter("montant")));
		}catch (Exception e) {
			objCalcul.setMsg(e.getMessage());
			sUrl="/paramEmpruntMvc.jsp";
		}
		try{
			objCalcul.setDuree(Integer.parseInt(request.getParameter("duree")));
		}catch (Exception e) {
			objCalcul.setMsg(e.getMessage());
			sUrl="/paramEmpruntMvc.jsp";
		}
		try{
			objCalcul.setTaux(Double.parseDouble(request.getParameter("taux")));
		}catch (Exception e) {
			objCalcul.setMsg(e.getMessage());
			sUrl="/paramEmpruntMvc.jsp";
		}
		
		objCalcul.calculerMensualite();
		
		//request.setAttribute("objCalcul",objCalcul);
		request.getSession().setAttribute("objCalcul",objCalcul);
		this.getServletContext().getRequestDispatcher(sUrl).forward(request, response);
	}

}
