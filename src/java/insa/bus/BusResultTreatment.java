/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.bus;

import insa.client.Search;
import insa.db.Category;
import insa.db.Internship;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author zaurelzo
 */
public class BusResultTreatment 
{
    
    private String busResult;
    
    
    public BusResultTreatment(String busResult)
    {
        this.busResult=busResult;
    }
    
    public List<Internship> getListOfInternship() throws JSONException 
    {
        try
        {            
            List<Internship> internshipList = new ArrayList<Internship>();
            JSONObject jObjectWithInternshipResult  = new JSONObject(this.busResult.substring(1, this.busResult.length()-1)); // json
            //System.out.println("////////////// 1st conversion worked ");
            for (int a= 0 ; a < jObjectWithInternshipResult.length();a++)
            {
                Integer ind = new Integer(a);
                String oneInternship = jObjectWithInternshipResult.getString(ind.toString());
                //System.out.println("***********************" + oneInternship);
                //System.out.println("**********************************************");
                //convert current intership to  json 
                JSONObject AnInternshipJsonObject =  new JSONObject(oneInternship);
                String name = AnInternshipJsonObject.getString("name");
                String pdfPath= AnInternshipJsonObject.getString("pdfPath");
                String description= AnInternshipJsonObject.getString("description");
                Long  category_id = new Long (AnInternshipJsonObject.getString("category_id"));
                String category_name = AnInternshipJsonObject.getString("category_name");
                Category  cat = new Category(category_name);
                cat.setId(category_id);
                        
                // also get company information (not pass a null object to the function)
                Internship internshipToAdd =  new Internship(name, pdfPath, description, null, cat);
                internshipList.add(internshipToAdd);
                //System.out.println("***************** THE CONVERSION WORKED" );
             }
            return internshipList;
            
        }  catch (JSONException ex) 
        {
           throw ex;
        }
       
    }
    
}
