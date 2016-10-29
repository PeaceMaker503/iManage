/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.*;
import insa.metier.IMetier;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Halim
 */
@WebService(serviceName = "ManageWS")
public class ManageWS {

    private IMetier metier;
    
    public ManageWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }

    /**
     * Web service operation
     * @param firstName
     * @param lastName
     * @param mail
     * @param phone
     * @param cvPath
     * @return UserProfile
     */
    @WebMethod(operationName = "addUserProfile")
    public UserProfile addUserProfile(@WebParam(name = "firstName") String firstName, @WebParam(name = "lastName") String lastName, @WebParam(name = "mail") String mail, @WebParam(name = "phone") String phone, @WebParam(name = "cvPath") String cvPath) 
    {
        return metier.addUserProfile(firstName, lastName, mail, phone, cvPath);
    }
}
