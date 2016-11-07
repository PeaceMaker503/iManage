/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserProfile;
import insa.ws.accountWS;
import insa.ws.ManageWS;
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
@WebServlet(name = "createProfileServlet", urlPatterns = {"/createProfileServlet"})
public class createProfileServlet extends HttpServlet {

    
        private static ManageWS manageService = new insa.ws.ManageWS() ;
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
            out.println("<title>Servlet createProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet createProfile at " + request.getContextPath() + "</h1>");
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
            //id = Long.parseLong(request.getParameter("id"));
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
            String lastname = request.getParameter("lastname");
            String firstname = request.getParameter("firstname");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            String cvPath = request.getParameter("cvPath");
            System.out.println("LOL");
            UserProfile userPro = manageService.addUserProfile(firstname, lastname, mail, phone, cvPath);
            //Long id = accountService.getUserProfile(login, password);

        
        //manageService.addUserProfileToAccount(userPro, id);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);

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
