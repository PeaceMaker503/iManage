/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.ws.UserAccountWS;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    
    private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;

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
        
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);

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
       UserAccount userAccount = userAccountService.verifyUserAccount(login, password);

       //System.out.println("------------- User category" + userCategory);
       if(userAccount == null){
            request.setAttribute("exists", "false" );
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
       }
       else
       {
		   String userCategory = userAccount.getUserCategory();
           if(userAccount.getId_profile() == null && userCategory.compareTo("Student")==0){
                    response.sendRedirect("CreateUserProfile?login=" + login);
            }
            else if(userAccount.getId_Company_profile() == null && userCategory.compareTo("Company")==0){
                    response.sendRedirect("CreateCompanyProfile?login=" + login);    
            }
            else{
                if(userCategory.compareTo("Student")==0){
                   response.sendRedirect("Home?login=" + login);
                }
                else if(userCategory.compareTo("Company")==0){
                   response.sendRedirect("HomeCompany?login=" + login);
                }
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
