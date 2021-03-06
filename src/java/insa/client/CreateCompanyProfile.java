/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.db.Company;
import insa.models.LinkCompanyProfileRequest;
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
 * @author jordycabannes
 */
@WebServlet(name = "CreateCompanyProfile", urlPatterns = {"/CreateCompanyProfile"})
public class CreateCompanyProfile extends HttpServlet {

    private static UserAccountWS userAccountService = new UserAccountWS() ;
    private static UserProfileWS userProfileService = new UserProfileWS() ;
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
            out.println("<title>Servlet CreateCompanyProfile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCompanyProfile at " + request.getContextPath() + "</h1>");
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
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CreateCompanyProfile.jsp").forward(request, response);
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
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            String mail = request.getParameter("mail");
            
            Company company = userProfileService.addCompanyProfile(name, phone, mail, address);
            if(company == null)
            {
                //System.out.println("--------------////// c'est null");
                this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/CreateCompanyProfile.jsp").forward(request, response);
            }
            else
            {
                //System.out.println("--------------////// c'est pas null");
                String login = request.getParameter("login");
                System.out.println(login + " " + company.getId());
                LinkCompanyProfileRequest req = new LinkCompanyProfileRequest(login, company);
                UserAccount ua = userAccountService.linkCompanyProfile(req);
                if(ua == null)
                    userProfileService.deleteCompanyProfile(company.getId());
                else
                    response.sendRedirect("HomeCompany?login=" + login);
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
