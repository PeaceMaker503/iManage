/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
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
 * @author jordycabannes
 */
@WebServlet(name = "connectionServlet", urlPatterns = {"/connectionServlet"})
public class connectionServlet extends HttpServlet {

    
    private static accountWS accountService = new insa.ws.accountWS() ;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            out.println("<title>Servlet connexionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet connexionServlet at " + request.getContextPath() + "</h1>");
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
                    //request.setAttribute( "exists", true );
                    //this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);

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
        {
       String login = request.getParameter("login");
       String password = request.getParameter("motDePasse");
       boolean exists = accountService.connectUser(login, password);
       
       if(exists==false){
            request.setAttribute( "exists", false );
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
       }
       else
       {
           Long id_profile = accountService.getUserProfile(login, password);
           //request.setAttribute( "id", id_profile );
           if(id_profile!=null){
               this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
           }
           else{
               this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/createProfile.jsp").forward(request, response);
           }
       }
    }
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
