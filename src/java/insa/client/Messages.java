/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Message;
import insa.db.UserAccount;
import insa.ws.MessageWS;
import insa.ws.UserAccountWS;
import insa.ws.UserProfileWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "Messages", urlPatterns = {"/Messages"})
public class Messages extends HttpServlet {
    
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
        Collection<UserAccount> uaReceiver = new ArrayList<UserAccount>();
        List<Collection<UserAccount>> uaReceiverList= new ArrayList<Collection<UserAccount>>();
        
		UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
        String userCategory = ua.getUserCategory();
		
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("userType","Student");
        }
		else if (userCategory.compareTo("Company")==0) {
            request.setAttribute("userType","Company");
        }
		else if (userCategory.compareTo("INSA Staff")==0){
			request.setAttribute("userType","INSA Staff");
		}
        
        request.setAttribute("messagesList", messageService.searchMessage(ua));
        request.setAttribute("SentMessagesList", messageService.searchSentMessages(ua.getId()));
        //request.setAttribute("usersList", userAccountService.getAllUserAccount());
        for(Iterator<Message> i = messageService.searchSentMessages(ua.getId()).iterator(); i.hasNext(); ){
                    Message item = i.next();
                    uaReceiver = messageService.getAllReceiverAccount(item);
                    uaReceiverList.add(uaReceiver);
        }
        
        /*for(Iterator<Collection<UserAccount>> i = uaReceiverList.iterator(); i.hasNext(); ){
                    Collection<UserAccount> item = i.next();
                    for(Iterator<UserAccount> it = item.iterator(); it.hasNext(); ){
                        UserAccount iti = it.next();
                        System.out.println("------------ valeur du loooogggg : "+iti.getLogin());
                    }
                    
        }*/
        request.setAttribute("receiverList", uaReceiverList);
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Messages.jsp").forward(request, response);
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
                String idS = request.getParameter("idm");
                Long id = Long.parseLong(idS);
                Message message = messageService.updateReadMessage(id);
                if (message!=null)
                        System.out.println("---------- Tout est OK!");
                else
                    System.out.println("---------- Rien est OK!");

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
