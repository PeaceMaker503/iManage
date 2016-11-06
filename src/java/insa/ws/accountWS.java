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
@WebService(serviceName = "accountWS")
public class accountWS 
{
    
    private IMetier metier;
    
    public accountWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }
    
    
    @WebMethod(operationName = "addUserAccount")
    public UserAccount addUserAccount(@WebParam(name = "login") String login, @WebParam(name = "mail") String mail, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
       return metier.addUserAccount(login, mail, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "connectUser")
    public boolean connectUser(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return metier.connectUser(login, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserProfile")
    public Long getUserProfile(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return metier.getUserProfile(login, password);
    }


    
}
