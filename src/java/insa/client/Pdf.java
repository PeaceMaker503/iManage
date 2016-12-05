package insa.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author paul
 */
@WebServlet(name = "Pdf", urlPatterns = {"/Pdf"})
public class Pdf extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        ServletOutputStream  outs =  response.getOutputStream ();
        response.setContentType( "application/pdf" ); 

        File file=new File(request.getParameter("path"));
        
        String[] bits = request.getParameter("path").split("/");
        String filename = bits[bits.length-1];
        
        response.setHeader("Content-disposition","inline; filename=" + filename);

        BufferedInputStream  bis = null; 
        BufferedOutputStream bos = null;
        try {

            InputStream isr=new FileInputStream(file);
            bis = new BufferedInputStream(isr);
            bos = new BufferedOutputStream(outs);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while(-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } 
        catch(Exception e)
        {
            System.out.println("Exception ----- Message ---"+e);
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
       
    }

}
