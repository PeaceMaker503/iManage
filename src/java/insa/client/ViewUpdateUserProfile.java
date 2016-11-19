/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.ws.UserAccountWS;
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
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateUserProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

}
