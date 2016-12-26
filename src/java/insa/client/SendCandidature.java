/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Company;
import insa.db.Internship;
import insa.db.Message;
import insa.db.UserAccount;
import insa.ws.InternshipWS;
import insa.ws.MessageWS;
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
@WebServlet(name = "SendCandidature", urlPatterns = {"/SendCandidature"})
public class SendCandidature extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	
	private static InternshipWS internshipService = new insa.ws.InternshipWS();
	private static MessageWS messageService = new insa.ws.MessageWS();
	private static UserProfileWS userProfileService = new insa.ws.UserProfileWS();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet SendCandidature</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet SendCandidature at " + request.getContextPath() + "</h1>");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		long offer_id = Long.valueOf(request.getParameter("offer_id"));
		Internship internshipOffer = internshipService.getInternshipByID(offer_id);
		request.setAttribute("internshipOffer",internshipOffer);
		request.setAttribute("login",request.getParameter("login"));
		System.out.println(request.getParameter("login"));
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/SendCandidature.jsp").forward(request, response);
		
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
		
		String login = request.getParameter("login");
		String candTitle = request.getParameter("title");
		String candMessage = request.getParameter("message");
		String coverLetterPath = "/home/prmm95/NetBeansProjects/iManage/static/coverLetters/" 
				+ login + "/" + "offre_id" + ".pdf"; 
					
		Message candidature = messageService.createCandidature(candTitle,candMessage,coverLetterPath);
		
		// Link candidature with the respective internship offer:
		long offer_id = Long.parseLong(request.getParameter("offer_id"));
		Internship offer = internshipService.getInternshipByID(offer_id);
		messageService.linkOfferToCandidature(candidature.getId(),offer);
		
		// Link candidature with the respective user:
		UserAccount userAccount = userProfileService.getUserAccountByLogin(login);
		messageService.linkUserToCandidature(candidature.getId(),userAccount);
		
		// Link candidature with the respective company:
		//Company company = 
		
				
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Candidatures.jsp").forward(request, response);
		
		
		// Verify if a file was sent 
		// Save the file on the correct path 
		
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
