/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Internship;
import insa.ws.CandidatureWS;
import insa.ws.InternshipWS;
import insa.ws.UserAccountWS;
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
@WebServlet(name = "Offers", urlPatterns = {"/Offers"})
public class Offers extends HttpServlet {
	
	private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;
    private static UserProfileWS userProfileService = new insa.ws.UserProfileWS() ;
    private static InternshipWS InternshipService = new InternshipWS() ;
	private static CandidatureWS candidatureService = new insa.ws.CandidatureWS();

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
			out.println("<title>Servlet Offers</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Offers at " + request.getContextPath() + "</h1>");
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
				
		String company = new String("Entreprise".getBytes(),"UTF-8"); 
        byte[] bytesComp = company.getBytes(StandardCharsets.ISO_8859_1);
        company = new String(bytesComp, StandardCharsets.UTF_8);
		
		List<Internship> internshipList = InternshipService.getInternshipByCriteria(company,"All","");
		
		if (internshipList.isEmpty()) {
			System.out.println("EMPTY");
			
		}	
		else {
			System.out.println("NOT EMPTY");
		}
		
		request.setAttribute("internshipList",internshipList);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Offers.jsp").forward(request, response);
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Offers.jsp").forward(request, response);
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
