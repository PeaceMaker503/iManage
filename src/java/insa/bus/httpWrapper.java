/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.bus;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import static javax.ws.rs.core.HttpHeaders.USER_AGENT;

/**
 *
 * @author zaurelzo
 */
public class httpWrapper 
{
    private String url ; 
    private Map<String,String[]> mapRequestParameters;
    
    public httpWrapper(  String url ,Map<String,String[]> mapRequestParameters )
    {
        this.url=url;
        this.mapRequestParameters=mapRequestParameters;
    }
    
    
    public String sendRequest()
    {
        try 
        {
            URL obj = new URL(this.url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");

            //build json paramaters
            // String postJsonData = "{\"id\":5,\"countryName\":\"USA\",\"population\":8000}";
            String postJsonData ="{";
            for (Map.Entry<String, String[]> entry : this.mapRequestParameters.entrySet()) 
            {
                postJsonData += "\""+entry.getKey() + "\"" +  ":";
                for (String value : entry.getValue())
                {
                    if (!value.equals(""))
                        postJsonData += "\""+ value + "\"" +  ",";
                    else
                        postJsonData += "\"\"" +  ",";
                        
                }
            }
            String finalPostJsonData =  postJsonData.substring(0, postJsonData.length()-1)+"}";
            
           // System.out.println("************** ==================" + finalPostJsonData); 
            //System.out.println("******************************************");
            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(finalPostJsonData);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String output;  
            StringBuffer res = new StringBuffer();  
            
            while ((output = in.readLine()) != null) 
            {  
                res.append(output);  
            }  
            in.close();  
             return res.toString();
        } catch (Exception e) 
        {
            return null ;
        }
}
    
}
