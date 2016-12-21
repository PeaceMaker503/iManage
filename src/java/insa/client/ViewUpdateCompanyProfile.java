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
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        long companyProfileID = userProfileService.getUserAccountByLogin(request.getParameter("login")).getId_Company_profile().getId();
	Company company = userProfileService.getCompanyById(companyProfileID);
	request.setAttribute("company",company);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateCompanyProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		UserAccount userAccount = userProfileService.getUserAccountByLogin(request.getParameter("login")); 
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