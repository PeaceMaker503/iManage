/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.dao.IDao;
import insa.db.Category;
import insa.db.Company;
import insa.db.Internship;
import insa.metier.IMetier;
import insa.metier.MetierImpl;
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
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "debug_initDb")
    public Internship debug_initDb() {
        
        IDao dao = ((MetierImpl)metier).getDao();
        Company co = new Company("WaterTech Corporation", "0494424242", "recruit@wtc.com", "allée des chameaux");
        Category ca = new Category("Informatique");
        co = dao.addCompany(co);
        ca = dao.addCategory(ca);
        Internship i = new Internship("Solution informatique pour entreprise à taille humaine", "/humain/suicide.pdf", co, ca);
        i = dao.addInternship(i);
        return i;
    }
    
    @WebMethod(operationName = "debug_searchByCompany")
    public List<Internship> debug_searchByCompany() {
        IDao dao = ((MetierImpl)metier).getDao();
        Company co = dao.getCompanyById(new Long(1));
        List<Internship> list = dao.getInternshipByCompanyName("WaterTech Corporation");
        return list;
    }
    
    @WebMethod(operationName = "debug_searchByCategory")
    public List<Internship> debug_searchByCategory() {
        IDao dao = ((MetierImpl)metier).getDao();
        Category ca = dao.getCategoryById(new Long(1));
        List<Internship> list = dao.getInternshipByCategoryName("Informatique");
        return list;
    }
    
    @WebMethod(operationName = "debug_getInternships")
    public List<Internship> debug_getInternships() {
        IDao dao = ((MetierImpl)metier).getDao();
        List<Internship> list = dao.getAllInternships();
        return list;
    }
    
    @WebMethod(operationName = "debug_getCategories")
    public List<Category> debug_getCategories() {
        IDao dao = ((MetierImpl)metier).getDao();
        List<Category> list = dao.getAllCategories();
        return list;
    }
    
    @WebMethod(operationName = "debug_getCompanies")
    public List<Company> debug_getCompanies() {
        IDao dao = ((MetierImpl)metier).getDao();
        List<Company> list = dao.getAllCompanies();
        return list;
    }
    //
}
