/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.bus.BusResultTreatment;
import insa.db.Candidature;
import insa.db.Company;
import insa.db.Internship;
import insa.db.UserAccount;
import insa.ws.CandidatureWS;
import insa.ws.InternshipWS;
import insa.ws.UserAccountWS;
import insa.ws.UserProfileWS;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import insa.bus.httpWrapper;
import insa.db.Category;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;
import org.*;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author paul
 */
@WebServlet(name = "Search", urlPatterns = {"/Search"})
public class Search extends HttpServlet {
    
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
			out.println("<title>Servlet EditOffer</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet EditOffer at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}    
            
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try
        {
            String url = "http://localhost:11223/getInternship";
            Map<String,String[]> mapRequestParameters = new HashMap<String,String[]>();
            mapRequestParameters.put("selectCompany",new String[]{"All"});
            mapRequestParameters.put("selectCategory",new String[]{"All"});
            mapRequestParameters.put("keywords",new String[]{""});
            
            httpWrapper httpW = new httpWrapper(url, mapRequestParameters);
            
            //received json object with internship information (from zato)
            String httpRes =  httpW.sendRequest() ;
            BusResultTreatment thebusResultTreatment = new BusResultTreatment(httpRes);
            
            
                response.setContentType("text/html");
                String login = request.getParameter("login");		
		long user_id = userProfileService.getUserAccountByLogin(login).getId();
		List<Internship> internshipList = thebusResultTreatment.getListOfInternship();
		List<Candidature> candidatureList = candidatureService.getCandidaturesByUserID(user_id);
				
		Iterator<Internship> iOffer = internshipList.iterator();
		Iterator<Candidature> iCandidature = candidatureList.iterator();
				 
		// Delete candidatures from the list where there is a Candidature sent
		// from the current student:
		while (iCandidature.hasNext()) {
			
			Candidature currentCandidature = iCandidature.next();
			
			while (iOffer.hasNext()) {
		
				Internship currentOffer = iOffer.next();
			
				if (Objects.equals(currentOffer, currentCandidature.getId_internship())) {
					iOffer.remove();
					iCandidature.remove();
					break;
				}
			
			}
			
		}		
		
            request.setAttribute("internshipList",internshipList);
            request.setAttribute("companyList", InternshipService.getCompanies());
            request.setAttribute("categoryList", InternshipService.getCategories());
        
            UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
            if(ua==null){
                System.out.println("////////////ua est null");
            }
            else{
                System.out.println("////////////ua n'est pas null");
            }
            System.out.println("---------------- valeur du login en haut : "+request.getParameter("login"));
            System.out.println("---------------- valeur du login : " +ua.getLogin());
            System.out.println("---------------- valeur de category : " +ua.getUserCategory());

            String userCategory = ua.getUserCategory();
            if(userCategory.compareTo("Student")==0){
                request.setAttribute("student","true");
            }
            else{
                request.setAttribute("student","false");
            }
        
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
        } catch (JSONException ex) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++ ERROR ");
            //System.out.println("******************************************");
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            
            String url = "http://localhost:11223/getInternship";
        
            httpWrapper httpW = new httpWrapper(url, request.getParameterMap());
            
            //received json object with internship information (from zato)
            String httpRes =  httpW.sendRequest() ;
            BusResultTreatment thebusResultTreatment = new BusResultTreatment(httpRes);
   
            response.setContentType("text/html");
            String login = request.getParameter("login");		
            long user_id = userProfileService.getUserAccountByLogin(login).getId();
        
            UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
            String userCategory = ua.getUserCategory();
            if(userCategory.compareTo("Student")==0)
            {
                request.setAttribute("student","true");
            }
            else
            {
                request.setAttribute("student","false");
            }
        
            request.setAttribute("companyList", InternshipService.getCompanies());
            request.setAttribute("categoryList", InternshipService.getCategories());
        
            String keywords = new String(request.getParameter("keywords").getBytes(),"UTF-8");
            byte[] bytesKeyW = keywords.getBytes(StandardCharsets.ISO_8859_1);
            keywords = new String(bytesKeyW, StandardCharsets.UTF_8);
        
            String company = new String(request.getParameter("selectCompany").getBytes(),"UTF-8"); 
            byte[] bytesComp = company.getBytes(StandardCharsets.ISO_8859_1);
            company = new String(bytesComp, StandardCharsets.UTF_8);
        
        
            String category = new String(request.getParameter("selectCategory").getBytes(),"UTF-8");
            byte[] bytesCat = category.getBytes(StandardCharsets.ISO_8859_1);
            category = new String(bytesCat, StandardCharsets.UTF_8);
            
            //let rebuild the internship list using  the received json object
            //List<Internship> internshipList = InternshipService.getInternshipByCriteria(company, category, keywords);
            
            List<Internship> internshipList=  thebusResultTreatment.getListOfInternship();
            
            List<Candidature> candidatureList = candidatureService.getCandidaturesByUserID(user_id);			
            Iterator<Internship> iOffer = internshipList.iterator();
            Iterator<Candidature> iCandidature = candidatureList.iterator();
				 
            // Delete candidatures from the list where there is a Candidature sent
            // from the current student:
            while (iCandidature.hasNext()) 
            {
			
                Candidature currentCandidature = iCandidature.next();
			
                while (iOffer.hasNext()) 
                {
		
                    Internship currentOffer = iOffer.next();
			
                    if (Objects.equals(currentOffer, currentCandidature.getId_internship())) 
                    {
                        iOffer.remove();
                        iCandidature.remove();
                        break;
                    }
			
                }
			
            }				

            request.setAttribute("keywords", keywords.toUpperCase());
            if (company.equals("All"))
                request.setAttribute("company", "ALL COMPANIES");
            else
                request.setAttribute("company", company.toUpperCase());
            if (category.equals("All"))
                request.setAttribute("category", "ALL CATEGORIES");
            else
                request.setAttribute("category", category.toUpperCase());
       
            request.setAttribute("test", "keywords: " + keywords + "\tcompany: " + company + "\tcategory: " + category);
            //request.setAttribute("internshipList",internshipList);
            request.setAttribute("internshipList", internshipList);
            this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
         
        } catch (JSONException ex) {
            System.out.println("+++++++++++++++++++++++++++++++++++++++ ERROR ");
            //System.out.println("******************************************");
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
