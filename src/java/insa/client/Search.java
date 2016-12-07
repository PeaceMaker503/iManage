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
import java.nio.charset.StandardCharsets;

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
        
        request.setAttribute("internshipList", InternshipService.searchInternship());
        request.setAttribute("companyList", InternshipService.getCompanies());
        request.setAttribute("categoryList", InternshipService.getCategories());
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html");
        
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
        
        request.setAttribute("test", "keywords: " + keywords + "\tcompany: " + company + "\tcategory: " + category);
        request.setAttribute("internshipList", InternshipService.getInternshipByCriteria(company, category, keywords));
        this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
    }
}
