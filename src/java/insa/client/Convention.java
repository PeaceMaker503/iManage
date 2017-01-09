/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Candidature;
import insa.db.UserAccount;
import insa.ws.CandidatureWS;
import insa.ws.UserProfileWS;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

/**
 *
 * @author prmm95
 */
@WebServlet(name = "Convention", urlPatterns = {"/Convention"})
public class Convention extends HttpServlet {

	private static UserProfileWS userProfileService = new insa.ws.UserProfileWS();
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
			out.println("<title>Servlet Convention</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet Convention at " + request.getContextPath() + "</h1>");
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
		
		UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
		String userCategory = ua.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
        else{
            request.setAttribute("student","false");
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Convention.jsp").forward(request, response);
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
		System.out.println("This is a POST");
		String login = request.getParameter("login");
		String cand_id = request.getParameter("cand_id");
		long user_id = userProfileService.getUserAccountByLogin(login).getId();
		request.setAttribute("candidatureList",candidatureService.getCandidaturesByUserID(user_id));		
		
		UserAccount ua = userProfileService.getUserAccountByLogin(request.getParameter("login"));
		String userCategory = ua.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
        else{
            request.setAttribute("student","false");
        }
			
		// Load the pdfTemplate
		File pdfFile = new File("/home/prmm95/Bureau/PdfFormExample.pdf");
		PDDocument pdfTemplate = PDDocument.load(pdfFile);

		PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();

		// Get field names
		List<PDField> fieldList = acroForm.getFields();

		// String the object array
		String[] fieldArray = new String[fieldList.size()];
		int i = 0;
		for (PDField sField : fieldList) {
			fieldArray[i] = sField.getFullyQualifiedName();
			i++;
		}

		// Loop through each field in the array and do something
		for (String f : fieldArray) {
			PDField field = acroForm.getField(f);

			System.out.println("f is: " + f);
			if (f.contains("Family Name Text Box")) {
				String value = login;
				field.setValue(value);
				field.setReadOnly(true);
				System.out.println("printed: " + value + " to: " + f);
			}
		}
		
		// Update the convention path of the candidature on the database:
		String conventionPath = "/home/prmm95/Bureau/Convention_" + cand_id + ".pdf";
		Candidature candidature = candidatureService.getCandidatureById(Long.valueOf(cand_id));
		candidature.setConventionPath(conventionPath);
		candidatureService.updateCandidature(candidature);
				
		// Save the results and ensure that the document is properly closed:
		pdfTemplate.save(conventionPath);
		pdfTemplate.close();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Candidatures.jsp").forward(request, response);
			
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
