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
 * @author paul
 */
@WebServlet(name = "RecoverPassword", urlPatterns = {"/RecoverPassword"})
public class RecoverPassword extends HttpServlet 
{
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/RecoverPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       String userName = request.getParameter("loginCr");
       String mail = request.getParameter("emailAddressCr");
       UserAccount u = userAccountService.linkPassword(userName, mail);
       request.setAttribute("password", u.getPassword());
       //forward
    }

}
