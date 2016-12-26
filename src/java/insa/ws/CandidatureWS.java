/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.Internship;
import insa.db.Candidature;
import insa.db.Company;
import insa.db.UserAccount;
import insa.metier.IMetier;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author prmm95
 */

@WebService(serviceName = "CandidaturesWS")
public class CandidatureWS {
	
	private IMetier metier;
    
    public CandidatureWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }
	

	/**
	 * This is a sample web service operation
	 */
	@WebMethod(operationName = "hello")
	public String hello(@WebParam(name = "name") String txt) {
		return "Hello " + txt + " !";
	}

	/**
	 * Web service operation
	 * @param title 
	 * @param message
	 * @return 
	 */
	@WebMethod(operationName = "createCandidature")
	public Candidature createCandidature(@WebParam(name="candTitle") String title, @WebParam(name="candMessage") String message, @WebParam(name="coverLetterPath") String coverLetterPath) {
		return metier.createCandidature(title,message,coverLetterPath);
	}
	
	
	@WebMethod(operationName = "linkOfferToCandidature")
	public Candidature linkOfferToCandidature(@WebParam(name="cand_id") long cand_id, @WebParam(name="offer") Internship offer) {
		return metier.linkOfferToCandidature(cand_id,offer);
	}
	
	@WebMethod(operationName = "linkUserToCandidature")
	public Candidature linkUserToCandidature(@WebParam(name="cand_id") long cand_id, @WebParam(name="userAccount") UserAccount userAccount){
		return metier.linkUserToCandidature(cand_id,userAccount);
	}
	
	@WebMethod(operationName = "linkCompanyToCandidature")
	public Candidature linkCompanyToCandidature(@WebParam(name="cand_id") long cand_id, @WebParam(name="company") Company company) {
		return metier.linkCompanyToCandidature(cand_id,company);
	}
		
}
