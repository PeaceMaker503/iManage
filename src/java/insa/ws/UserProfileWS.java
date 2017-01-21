/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.db.Company;
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
    
    @WebMethod(operationName = "addCompanyProfile")
    public Company addCompanyProfile(@WebParam(name = "name") String name, @WebParam(name = "phone") String phone, @WebParam(name = "mail") String mail, @WebParam(name = "address") String address) {
        //TODO write your implementation code here:
        return metier.addCompanyProfile(name, phone, mail, address);
    }
    
        /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteUserProfile")
    public UserProfile deleteUserProfile(@WebParam(name = "id") long id) {
        //TODO write your implementation code here:
        return metier.deleteUserProfile(id);
    }
    
    public Company deleteCompanyProfile(@WebParam(name = "id") long id) {
         return metier.deleteCompanyProfile(id);
    }
	
	@WebMethod(operationName = "updateUserProfile")
	public UserProfile updateUserProfile(UserProfile userProfile) 
	{
		return metier.updateUserProfile(userProfile);
	}
	
	@WebMethod(operationName = "deleteUserAccount")
	public UserAccount deleteUserAccountById(Long id) {
		return metier.deleteUserAccountById(id);
	}
	
	/**
	 * Web service operation
	 */
	@WebMethod(operationName = "getUserProfile")
	public UserProfile getUserProfileById(@WebParam(name = "id") long id) {
		return metier.getUserProfileById(id);
	}

	@WebMethod(operationName = "getUserAccountByLogin")
	public UserAccount getUserAccountByLogin(@WebParam(name = "login") String login) {
		return metier.getUserAccountByLogin(login);
	}
        
	@WebMethod(operationName = "getCompanyById")
	public Company getCompanyById(@WebParam(name = "id") long id) {
		return metier.getCompanyById(id);
	}
        
        @WebMethod(operationName = "updateCompany")
	public Company updateCompany(Company company) 
	{
		return metier.updateCompany(company);
        }

	public Company getCompanyByName(String company_name) {
		return metier.getCompanyByName(company_name);
	}
		

}
