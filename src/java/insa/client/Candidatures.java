/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.ws.CandidatureWS;
import insa.ws.UserProfileWS;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "Candidatures", urlPatterns = {"/Candidatures"})
public class Candidatures extends HttpServlet {

	private static CandidatureWS candidatureService = new insa.ws.CandidatureWS();
	private static UserProfileWS userProfileService = new insa.ws.UserProfileWS();
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet Candidatures</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Candidatures at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		String login = request.getParameter("login");		
		long user_id = userProfileService.getUserAccountByLogin(login).getId();
		request.setAttribute("candidatureList",candidatureService.getCandidaturesByUserID(user_id));		
		request.setAttribute("deletedCand",false);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Candidatures.jsp").forward(request, response);
    }

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Seach for the Candidature ID to delete:
		long candidatureID = 0;				
				
		// Delete the candidature instance
		Boolean deletedCand = candidatureService.deleteCandidature(candidatureID);
		request.setAttribute("deletedCand",deletedCand);
		
		// TODO: Delete the Cover Letter file 
		
		// Redirect to the Candidatures view 
		
		
		
		
	}

	
	
	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */	
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
