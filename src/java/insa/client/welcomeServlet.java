/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.ws.ManageWS;
import insa.ws.accountWS;
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
@WebServlet(name = "welcomeServlet", urlPatterns = {"/welcomeServlet"})
public class welcomeServlet extends HttpServlet 
{
    private static accountWS accountService = new insa.ws.accountWS() ;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       String userName = request.getParameter("loginCr");
       String password = request.getParameter("motDePasseCr");
       String mail = request.getParameter("emailAddressCr");
       UserAccount u = accountService.addUserAccount(userName, mail, password);
      /* if (u==null)
       {
           //todo 
       }else 
       {
            this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
       }*/
       
    }

}
