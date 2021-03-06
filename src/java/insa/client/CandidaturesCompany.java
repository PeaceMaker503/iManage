/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Candidature;
import insa.db.Internship;
import insa.ws.CandidatureWS;
import insa.ws.InternshipWS;
import insa.ws.UserProfileWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "CandidaturesCompany", urlPatterns = {"/CandidaturesCompany"})
public class CandidaturesCompany extends HttpServlet {

	private static InternshipWS internshipService = new insa.ws.InternshipWS();
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
			out.println("<title>Servlet CandidaturesCompany</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet CandidaturesCompany at " + request.getContextPath() + "</h1>");
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

		String login = request.getParameter("login");
		String offer_name = request.getParameter("offer_name");
		request.setAttribute("candidatesList",candidatureService.getCandidaturesByOfferName(offer_name));
		request.setAttribute("offer_name",offer_name);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CandidaturesCompany.jsp").forward(request, response);
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
				
		String newStatus = request.getParameter("selectStatus");
		long cand_id = Long.parseLong(request.getParameter("candId"));
		String offer_name = request.getParameter("offer_name");
		
		Candidature candidature = candidatureService.getCandidatureById(cand_id);
		candidature.setStatus(newStatus);
		candidatureService.updateCandidature(candidature);
		
		request.setAttribute("candidatesList",candidatureService.getCandidaturesByOfferName(offer_name));
		request.setAttribute("offer_name",offer_name);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CandidaturesCompany.jsp").forward(request, response);
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
