/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.client;

import insa.db.Candidature;
import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.ws.CandidatureWS;
import insa.ws.UserProfileWS;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
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
		
		// Parameters definition:
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String login = request.getParameter("login");
		String cand_id = request.getParameter("cand_id");
		long user_id = userProfileService.getUserAccountByLogin(login).getId();
		UserAccount userAccount = userProfileService.getUserAccountByLogin(request.getParameter("login"));
		UserProfile userProfile = userAccount.getId_profile();
		String userCategory = userAccount.getUserCategory();
        if(userCategory.compareTo("Student")==0){
            request.setAttribute("student","true");
        }
        else{
            request.setAttribute("student","false");
        }
		
		// Create the array with the variables:
		Map<String, String> parametersDict = new HashMap<>();
		parametersDict.put("nom_stagiaire",userProfile.getLastName());
		parametersDict.put("prenom_stagiaire",userProfile.getFirstName());
		// TODO: Add to the user profile creation?
		parametersDict.put("sec_social_stagiaire","Sec. social");
		// TODO: Add to the user profile creation?
		parametersDict.put("adresse_stagiaire","Adresse");
		parametersDict.put("tel_stagiaire",userProfile.getPhone());
		parametersDict.put("mail_stagiaire",userProfile.getMail());
		// TODO: This will be on the request.
		parametersDict.put("sujet_stage","Sujet du stage");
		// TODO: This will be on the request.
		parametersDict.put("activites_stage","Activites du stage");
		// TODO: This will be on the request.
		//parametersDict.put("dates_stage","Dates du stage");
		// TODO: This will be on the request.
		//parametersDict.put("heures_stage","Nombre d'heures du stage");
		// TODO: This will be on the request.
		parametersDict.put("jours_stage","Nombre de jours du stage");
		// TODO: This will be on the request. This corresponds
		// To jours feries etc.
		parametersDict.put("commentaire_stage","Commentaires du stage");
		// TODO: This will be on the request.
		parametersDict.put("conges_stage","#");
		//parametersDict.put("date_convention",dateFormat.format(date));
		
		// Load the internship convention template:
		File pdfFile = new File("/home/prmm95/Bureau/Internship_Convention.pdf");
		PDDocument pdfTemplate = PDDocument.load(pdfFile);
		PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
		PDAcroForm acroForm = docCatalog.getAcroForm();

		// Loop through each field in the dictionary and update the values of the template:
		parametersDict.entrySet().forEach((Map.Entry<String, String> entry) -> {
			PDField field = acroForm.getField(entry.getKey());
			try {
				field.setValue(entry.getValue());
			} catch (IOException ex) {
				Logger.getLogger(Convention.class.getName()).log(Level.SEVERE, null, ex);
			}
			field.setReadOnly(true);
			System.out.println(entry.getKey() + " / " + entry.getValue());
		});
			
		// Update the convention path of the candidature on the database:
		String conventionPath = "/home/prmm95/NetBeansProjects/iManage/static/pdf/Convention_" + cand_id + ".pdf";
		Candidature candidature = candidatureService.getCandidatureById(Long.valueOf(cand_id));
		candidature.setConventionPath(conventionPath);
		candidatureService.updateCandidature(candidature);
		
		// Save the results and ensure that the document is properly closed:
		pdfTemplate.save(conventionPath);
		pdfTemplate.close();
		
		// Update the candidatures list and redirect to the candidatures view:		
		request.setAttribute("candidatureList",candidatureService.getCandidaturesByUserID(user_id));
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
