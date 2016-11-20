/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Internship;
import insa.db.UserAccount;
import insa.ws.InternshipWS;
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
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {
    
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;
    private static InternshipWS InternshipService = new InternshipWS() ;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        
        request.setAttribute("todo", InternshipService.searchInternship().get(0).getId().toString());
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        
    }
}
