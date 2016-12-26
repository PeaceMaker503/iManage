/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.dao.IDao;
import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.db.Company;
import insa.metier.IMetier;
import insa.metier.MetierImpl;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author zaurelzo
 */
@WebService(serviceName = "UserAccountWS")
public class UserAccountWS 
{
    private IMetier metier;
    
    public UserAccountWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }

    @WebMethod(operationName = "addUserAccount")
    public UserAccount addUserAccount(@WebParam(name = "login") String login, @WebParam(name = "mail") String mail, @WebParam(name = "password") String password, @WebParam(name = "selectUserCategory") String userCategory) {
        //TODO write your implementation code here:
       return metier.addUserAccount(login, mail, password, userCategory);
    }

    @WebMethod(operationName = "verifyUserAccount")
    public UserAccount verifyUserAccount(@WebParam(name = "login") String login, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return metier.verifyUserAccount(login, password);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "linkUserProfile")
    public UserAccount linkUserProfile(@WebParam(name = "login") String login, @WebParam(name = "profile") UserProfile profile) {
        //TODO write your implementation code here:
        return metier.linkUserProfile(login, profile);
    }
    
    @WebMethod(operationName = "linkCompanyProfile")
    public UserAccount linkCompanyProfile(@WebParam(name = "login") String login, @WebParam(name = "company") Company comp) {
        //TODO write your implementation code here:
        return metier.linkCompanyProfile(login, comp);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "linkPassword")
    public UserAccount linkPassword(@WebParam(name = "login") String login, @WebParam(name = "mail") String mail) {
        IDao dao = ((MetierImpl)metier).getDao();
        return dao.getUserAccountByLogin(login);
    }

    
    @WebMethod(operationName = "getUserAccountByEmail")
    public UserAccount getUserAccountByEmail(@WebParam(name = "mail") String mail) {
        return metier.getUserAccountByEmail(mail);
    }
    
    @WebMethod(operationName = "getAllUserAccount")
    public List<UserAccount> getAllUserAccount(){
        return metier.getAllUserAccount();
    }

}
