/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.dao.IDao;
import insa.db.Company;
import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.metier.IMetier;
import insa.metier.MetierImpl;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import insa.models.AddUserAccountRequest;
import insa.models.LinkCompanyProfileRequest;
import insa.models.LinkUserProfileRequest;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Halim
 */
@Path("Accounts")
@Produces(MediaType.APPLICATION_JSON)
public class UserAccountWS {

    @Context
    private UriInfo context;
    
    private IMetier metier;
    /**
     * Creates a new instance of AccountsResource
     */
    public UserAccountWS() {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/account")
    public UserAccount addUserAccount(AddUserAccountRequest request) {
        //TODO write your implementation code here:
       return metier.addUserAccount(request.getLogin(), request.getMail(), request.getPassword(), request.getUserCategory());
    }
    
    @GET
    @Path("/login")
    public UserAccount getUserAccountByLogin(@QueryParam("login") String login) {
        return metier.getUserAccountByLogin(login);
    }
    
    @GET
    @Path("/mail")
    public UserAccount getUserAccountByEmail(@QueryParam("mail") String mail) {
        return metier.getUserAccountByEmail(mail);
    }
    
    @GET
    @Path("/verify")
    public UserAccount verifyUserAccount(@QueryParam("login") String login, @QueryParam("password") String password) {
        //TODO write your implementation code here:
        return metier.verifyUserAccount(login, password);
    }
    
    @GET
    @Path("/accounts")
    public List<UserAccount> getAllUserAccount(){
        return metier.getAllUserAccount();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/link/userProfile")
    public UserAccount linkUserProfile(LinkUserProfileRequest request) {
        //TODO write your implementation code here:
        return metier.linkUserProfile(request.getLogin(), request.getUserProfile());
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/link/company")
    public UserAccount linkCompanyProfile(LinkCompanyProfileRequest request) {
        //TODO write your implementation code here:
        return metier.linkCompanyProfile(request.getLogin(), request.getCompany());
    }

    @GET
    @Path("/link/password")
    public UserAccount linkPassword(@QueryParam("login") String login, @QueryParam("mail") String mail) {
        return metier.getUserAccountByLogin(login);
    }
}
