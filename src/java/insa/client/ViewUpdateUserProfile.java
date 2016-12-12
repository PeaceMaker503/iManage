/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.db.UserProfile;
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
@WebServlet(name = "ViewUpdateUserProfile", urlPatterns = {"/ViewUpdateUserProfile"})
public class ViewUpdateUserProfile extends HttpServlet 
{
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS();
	private static UserProfileWS userProfileService = new insa.ws.UserProfileWS(); 
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		long userProfileID = userProfileService.getUserAccountByLogin(request.getParameter("login")).getId_profile().getId();
		UserProfile userProfile = userProfileService.getUserProfileById(userProfileID);
		request.setAttribute("userProfile",userProfile);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateUserProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
		UserAccount userAccount = userProfileService.getUserAccountByLogin(request.getParameter("login")); 
		long userProfileID = userAccount.getId_profile().getId();
		UserProfile userProfile = userProfileService.getUserProfileById(userProfileID);
		userProfile.setFirstName(request.getParameter("firstname"));
		userProfile.setLastName(request.getParameter("lastname"));
		userProfile.setPhone(request.getParameter("phone"));
		userProfile.setMail(request.getParameter("mail"));
		userProfileService.updateUserProfile(userProfile);
		request.setAttribute("userProfile",userProfile);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateUserProfile.jsp").forward(request,response);
    }
}
