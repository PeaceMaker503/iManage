/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.UserAccount;
import insa.db.Message;
import insa.ws.MessageWS;
import insa.ws.UserAccountWS;
import insa.ws.UserProfileWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "WriteMessage", urlPatterns = {"/WriteMessage"})
public class WriteMessage extends HttpServlet {
    
        private static MessageWS messageService = new insa.ws.MessageWS() ;
        private static UserProfileWS userProfileService = new insa.ws.UserProfileWS() ;
        private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
			out.println("<title>Servlet Messages</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Messages at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        
        UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
        String userCategory = ua.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
        else{
            request.setAttribute("student","false");
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/WriteMessage.jsp").forward(request, response);
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
                Collection<UserAccount> listRecipients = new ArrayList<UserAccount>();;
            
                UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
                String userCategory = ua.getUserCategory();
                if(userCategory.compareTo("Student")==0){
                    request.setAttribute("student","true");
                }
                else{
                    request.setAttribute("student","false");
                }
                
                String login=request.getParameter("login");
                String object = request.getParameter("object");
                String content = request.getParameter("message");

                UserAccount sender = userProfileService.getUserAccountByLogin(request.getParameter("login"));
                Boolean read=false;
                Boolean error= false;
                
                String recipients = request.getParameter("recipients");
                String delim = "[,]";
                String[] arrayRecipients = recipients.split(delim);
                
                for (int i = 0; i < arrayRecipients.length; i++){
                    //System.out.println("--------- valeur de l'email : " + arrayRecipients[i]);
                    UserAccount uar= userAccountService.getUserAccountByLogin(arrayRecipients[i]);
                    if(uar==null){
                        request.setAttribute("error", "true" );
                        System.out.println("--------------------"+arrayRecipients[i]);
                        request.setAttribute("wrongLogin", arrayRecipients[i]);
                        error=true;
                        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/WriteMessage.jsp").forward(request, response);
                        break;
                    }
                    //else{System.out.println("//////////// c'est pas nul uar");}
                    boolean r = listRecipients.add(uar);
                    if(r==false){
                        System.out.println("Problèmes liste recipients");
                    }
                    
                }
                
                if(!error){
                    Date date = new Date();
                
                /*if(object==null || content==null || date==null || read==null || sender==null  || listRecipients==null){
                     System.out.println("^^^^^^^^^^^^^^^^^^^^^ Un éléméent est null");
                     
                }*/
                
                /*for(Iterator<UserAccount> i = listRecipients.iterator(); i.hasNext(); ){
                    UserAccount item = i.next();
                    System.out.println("--------------------- Oui"+item.getLogin());
                }*/
                Message message = messageService.addMessage(object, content, date, read);
                message = messageService.linkUserAccountSender(sender, message.getId());
                message = messageService.linkUserAccountListRecipients(listRecipients,message.getId());
                if(message!=null){
                    response.sendRedirect("Messages?login=" + login);                
                }
                else{
                    request.setAttribute("send","false");
                    response.sendRedirect("WriteMessage?login=" + login);                 
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