/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.metier.IMetier;
import insa.metier.MetierImpl;
import java.nio.file.Paths;
import javax.annotation.PostConstruct;
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
    /**
     * This is a sample web service operation
     */
    @PostConstruct
    private void init()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }

    /**
     * Web service operation
     */
    public String wsHello() {
        return metier.mHello();
    }
}
