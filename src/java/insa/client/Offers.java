/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.bus.BusResultTreatment;
import insa.bus.httpWrapper;
import insa.db.Company;
import insa.db.Internship;
import insa.db.UserAccount;
import insa.ws.CandidatureWS;
import insa.ws.InternshipWS;
import insa.ws.UserAccountWS;
import insa.ws.UserProfileWS;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "Offers", urlPatterns = {"/Offers"})
public class Offers extends HttpServlet {
	
	private static UserAccountWS userAccountService = new insa.ws.UserAccountWS() ;
    private static UserProfileWS userProfileService = new insa.ws.UserProfileWS() ;
    private static InternshipWS InternshipService = new InternshipWS() ;
	private static CandidatureWS candidatureService = new insa.ws.CandidatureWS();

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
			out.println("<title>Servlet Offers</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Offers at " + request.getContextPath() + "</h1>");
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
		
		try {
			
			String login = request.getParameter("login");		
			UserAccount companyAccount = userProfileService.getUserAccountByLogin(login);
			Company companyProfile = userProfileService.getCompanyById(companyAccount.getId_Company_profile().getId());
			String company_name = companyProfile.getName();
			
			String url = "http://localhost:11223/getInternship";
            Map<String,String[]> mapRequestParameters = new HashMap<String,String[]>();
            mapRequestParameters.put("selectCompany",new String[]{company_name});
            mapRequestParameters.put("selectCategory",new String[]{"All"});
            mapRequestParameters.put("keywords",new String[]{""});
            
            httpWrapper httpW = new httpWrapper(url, mapRequestParameters);
            
            //received json object with internship information (from zato)
            String httpRes =  httpW.sendRequest() ;
            BusResultTreatment thebusResultTreatment = new BusResultTreatment(httpRes);
            
            response.setContentType("text/html");
						
			String company = new String(companyProfile.getName().getBytes(),"UTF-8"); 
			byte[] bytesComp = company.getBytes(StandardCharsets.ISO_8859_1);
			company = new String(bytesComp, StandardCharsets.UTF_8);

			List<Internship> internshipList = thebusResultTreatment.getListOfInternship();

			request.setAttribute("company_name",company_name);
			request.setAttribute("internshipList",internshipList);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Offers.jsp").forward(request, response);
			
		} catch (JSONException ex) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++ ERROR ");
            //System.out.println("******************************************");
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
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
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Offers.jsp").forward(request, response);
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
