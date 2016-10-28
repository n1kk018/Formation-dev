package com.formation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.dto.Message;
import com.formation.model.InverseBean;

/**
 * Servlet implementation class AlphaServlet
 */
@WebServlet("/alpha")
public class AlphaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Nom: "+name);
*/	    
	    Message m = new Message();
	    m.setNom((new InverseBean()).execute(request.getParameter("name")));
        request.setAttribute("message", m);
	    RequestDispatcher disp = request.getRequestDispatcher("reponse.jsp");
	    disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
