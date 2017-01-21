/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Candidature;
import insa.db.Company;
import insa.db.UserAccount;
import insa.ws.InternshipWS;
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
	private static CandidatureWS candidatureService = new insa.ws.CandidatureWS();
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
		request.setAttribute("offer_name",request.getParameter("offer_name"));
		request.setAttribute("company_name",request.getParameter("company_name"));
		request.setAttribute("login",request.getParameter("login"));
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
		
        UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
        String userCategory = ua.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
		else {
            request.setAttribute("student","false");
        }            
		// Parameters:
		String login = request.getParameter("login");
		long user_id = ua.getId();
		String candTitle = request.getParameter("title");
		String candMessage = request.getParameter("message");
		String offer_name = request.getParameter("offer_name");
		String company_name = request.getParameter("company_name");
		
		// TODO: Verify if a file was sent 
		// TODO: Save the file on the correct path 
		String coverLetterPath = "/Users/jordycabannes/Desktop/iManage/web/Web-content/pdf/internshipOffer/Offre1.pdf"; 
		//		+ login + "/" + offer_id + ".pdf"; 
					
		Candidature candidature = candidatureService.createCandidature(candTitle,candMessage,coverLetterPath);
		
		// Link candidature with the respective user:
		UserAccount userAccount = userProfileService.getUserAccountByLogin(login);
		candidatureService.linkUserToCandidature(candidature.getId(),userAccount);
		
		// Link candidature with the respective company:
		Company company = userProfileService.getCompanyByName(company_name);
		candidatureService.linkCompanyToCandidature(candidature.getId(),company);

		// Redirect to Candidatures view:
		request.setAttribute("login",login);
		request.setAttribute("candidatureList",candidatureService.getCandidaturesByUserID(user_id));		
		request.setAttribute("deletedCand",false);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Candidatures.jsp").forward(request, response);	
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
