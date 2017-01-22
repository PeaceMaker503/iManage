/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.db.Company;
import insa.ws.UserAccountWS;
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
 * @author zaurelzo
 */
@WebServlet(name = "ViewUpdateCompanyProfile", urlPatterns = {"/ViewUpdateCompanyProfile"})
public class ViewUpdateCompanyProfile extends HttpServlet 
{
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS();
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
			out.println("<title>Servlet EditOffer</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet EditOffer at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}
        
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
                
        UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
		String userCategory = ua.getUserCategory();
		if(userCategory.compareTo("Student")==0){
			request.setAttribute("userType","Student");
		}
		else if (userCategory.compareTo("Company")==0) {
			request.setAttribute("userType","Company");
		}
		else if (userCategory.compareTo("INSA Staff")==0){
			request.setAttribute("userType","INSA Staff");
		}
		
		long companyProfileID = userProfileService.getUserAccountByLogin(request.getParameter("login")).getId_Company_profile().getId();
		Company company = userProfileService.getCompanyById(companyProfileID);
				
		request.setAttribute("company",company);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateCompanyProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		UserAccount userAccount = userProfileService.getUserAccountByLogin(request.getParameter("login")); 
		       
        UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
		String userCategory = ua.getUserCategory();
		if(userCategory.compareTo("Student")==0){
			request.setAttribute("userType","Student");
		}
		else if (userCategory.compareTo("Company")==0) {
			request.setAttribute("userType","Company");
		}
		else if (userCategory.compareTo("INSA Staff")==0){
			request.setAttribute("userType","INSA Staff");
		}
		
		long companyProfileID = userAccount.getId_Company_profile().getId();
		Company company = userProfileService.getCompanyById(companyProfileID);
		company.setName(request.getParameter("name"));
		company.setPhone(request.getParameter("phone"));
		company.setMail(request.getParameter("mail"));
                company.setAddress(request.getParameter("address"));
		userProfileService.updateCompany(company);
		request.setAttribute("company",company);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateCompanyProfile.jsp").forward(request,response);
    }
}
