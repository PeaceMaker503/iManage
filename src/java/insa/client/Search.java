/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

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
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Map;
import java.util.Map.Entry;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        String login = request.getParameter("login");		
		long user_id = userProfileService.getUserAccountByLogin(login).getId();
		List<Internship> internshipList = InternshipService.searchInternship();
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String url = "http://localhost:11223/getInternship";
        
        httpWrapper httpW = new httpWrapper(url, request.getParameterMap());
        System.out.println("******************************************"+ httpW.sendRequest());
        System.out.println("******************************************");     
    
        response.setContentType("text/html");
	String login = request.getParameter("login");		
	long user_id = userProfileService.getUserAccountByLogin(login).getId();
        
        UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
        String userCategory = ua.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
        else{
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
		
		List<Internship> internshipList = InternshipService.getInternshipByCriteria(company, category, keywords);
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
        request.setAttribute("internshipList", InternshipService.getInternshipByCriteria(company, category, keywords));
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
    }
}
