package insa.client;

import insa.db.UserProfile;
import insa.ws.UserAccountWS;
import insa.ws.UserProfileWS;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "FileUploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
		
	private Boolean uploadFile(HttpServletRequest request, HttpServletResponse response, String path, String fileName, Part filePart, UserProfile userProfile) throws IOException, ServletException {
		
		OutputStream out = null;
        InputStream filecontent = null;
        final PrintWriter writer = response.getWriter();

        try {
            out = new FileOutputStream(new File(path + File.separator
                    + fileName));
            filecontent = filePart.getInputStream();
			
			int read = 0;
			final byte[] bytes = new byte[1024];
	
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
			
			request.setAttribute("login",request.getParameter("login"));
			request.setAttribute("userProfile",userProfile);
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ViewUpdateUserProfile.jsp").forward(request, response);
			return true;
			
        } catch (FileNotFoundException fne) {
            writer.println("You either did not specify a file to upload or are "
                    + "trying to upload a file to a protected or nonexistent "
                    + "location.");
            writer.println("<br/> ERROR: " + fne.getMessage());

            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
                    new Object[]{fne.getMessage()});
        } finally {
            if (out != null) {
                out.close();
            }
            if (filecontent != null) {
                filecontent.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
		
		return false;

	}
	
	private static UserAccountWS userAccountService = new insa.ws.UserAccountWS();
	private static UserProfileWS userProfileService = new insa.ws.UserProfileWS();
    private final static Logger LOGGER = Logger.getLogger(FileUploadServlet.class.getCanonicalName());

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
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// Parameters definition:
		response.setContentType("text/html;charset=UTF-8");
		String login = request.getParameter("login");
		long userProfileID = userProfileService.getUserAccountByLogin(login).getId_profile().getId();
		UserProfile userProfile = userProfileService.getUserProfileById(userProfileID);
		Boolean fileUploaded = false;
		
		// TODO: Parameter
		String uploadType = "userCV";
		//String uploadType = "coverLetter";
		//String uploadType = "messageFile";
		
		switch (uploadType) {
			
			case "coverLetter":
				System.out.println("Not implemented");
				break;
				
			case "userCV":				
				final String path = "/home/prmm95/NetBeansProjects/iManage/static/pdf";
				final Part filePart = request.getPart("file");
				final String fileName = "cv_" + request.getParameter("login") + ".pdf";
				userProfile.setCvPath(path + "/" + fileName);		
				userProfileService.updateUserProfile(userProfile);				
				fileUploaded = uploadFile(request, response, path, fileName, filePart, userProfile);				
				break;
			
			case "messageFile":
				System.out.println("Not implemented");
				break;	
				
			default:
				System.out.println("Error");
			
		}
		
    }
}
