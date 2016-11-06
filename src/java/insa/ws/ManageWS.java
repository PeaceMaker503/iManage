/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.dao.DaoImpl;
import insa.dao.IDao;
import insa.db.*;
import insa.metier.IMetier;
import insa.metier.MetierImpl;
import javax.jws.Oneway;
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
    
    

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "debugInitDatabase")
    public String debugInitDatabase() {
        IDao dao = ((MetierImpl)metier).getDao();
        
        UserAccount ua = new UserAccount();
        ua.setLogin("Halim");
        ua.setPassword("I<3DannyMare");
        ua = dao.addUserAccount(ua);
        UserProfile up = new UserProfile();
        up.setFirstName("Halim");
        up.setLastName("Chellal");
        up.setMail("chellal@guermouche.fr");
        up.setPhone("0645259233");
        up.setCvPath("C:/chellal.pdf");
        up = dao.addUserProfile(up);
        ua.setId_profile(up);
        dao.updateUserAccount(ua);
        return "OK";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addUserProfileToAccount")
    public int addUserProfileToAccount(@WebParam(name = "userProfile") UserProfile userProfile, @WebParam(name = "id") Long id) {
        //TODO write your implementation code here:
        return metier.addUserProfileToAcccount(userProfile, id);
    }

}
