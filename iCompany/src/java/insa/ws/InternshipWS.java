/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.Internship;
import insa.metier.IMetier;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

/**
 *
 * @author Halim
 */
@WebService(serviceName = "InternshipWS")
@Stateless()
public class InternshipWS {

    private IMetier metier;
    
    public InternshipWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }

    @WebMethod(operationName = "SearchIntership")
    public List<Internship> searchInternship() {
        return metier.searchInternship();
    }

    @WebMethod(operationName = "getInternshipByCriteria")
    public List<Internship> getInternshipByCriteria(String category, String keywords) {
        return metier.getInternshipByCriteria(category, keywords);
    }
	
    @WebMethod(operationName = "getInternshipByID")
    public Internship getInternshipByID(long id) {
        return metier.getInternshipByID(id);
    }
    
    @WebMethod(operationName = "deleteInternship")
    public Boolean deleteInternshipByID(@WebParam(name = "offer_id") long offer_id) {
        return metier.deleteInternshipById(offer_id);
    }	
	
}
