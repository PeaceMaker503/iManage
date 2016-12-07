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
		String lastname = request.getParameter("lastname");
        String firstname = request.getParameter("firstname");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        String cvPath = request.getParameter("cvPath");
		String login = request.getParameter("login");
		
		UserAccount userAccount = userProfileService.getUserAccountByLogin(request.getParameter("login")); 
		long oldProfileID = userAccount.getId_profile().getId();
		
		// Create new profile and link it 
		UserProfile userPro = userProfileService.addUserProfile(firstname, lastname, phone, cvPath, mail);
        UserAccount ua = userAccountService.linkUserProfile(login, userPro);
		long userProfileID2 = userProfileService.getUserAccountByLogin(request.getParameter("login")).getId_profile().getId();
        request.setAttribute("userProfile",userProfileService.getUserProfileById(userProfileID2));
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateUserProfile.jsp").forward(request, response);
		userProfileService.deleteUserProfile(oldProfileID);
    }
}
