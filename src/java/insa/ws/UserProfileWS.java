/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.metier.IMetier;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zaurelzo
 */
@WebService(serviceName = "UserProfileWS")
public class UserProfileWS 
{
    private IMetier metier;
    
    public UserProfileWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUserProfile")
    public UserProfile addUserProfile(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "phone") String phone, @WebParam(name = "cvPath") String cvPath, @WebParam(name = "mail") String mail) {
        //TODO write your implementation code here:
        return metier.addUserProfile(firstName, lastName, mail, phone, cvPath);
    }
    
        /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUserProfile")
    public UserProfile deleteUserProfile(@WebParam(name = "id") long id) {
        //TODO write your implementation code here:
        return metier.deleteUserProfile(id);
    }


}
