/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.ws;

import insa.db.Internship;
import insa.db.Message;
import insa.db.UserAccount;
import insa.db.UserProfile;

import insa.metier.IMetier;
import insa.metier.MetierImpl;
import java.util.Collection;
import java.util.Date;
import java.util.List;
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
public class MessageWS {

    private IMetier metier;
    
    public MessageWS()
    {
        ApplicationContext ap = new ClassPathXmlApplicationContext("../../WEB-INF/applicationContext.xml");
        metier = (IMetier)ap.getBean("metier");
    }
    
    @WebMethod(operationName = "addMessage")
    public Message addMessage(@WebParam(name = "object") String object, @WebParam(name = "content") String content, Date date, Boolean read) {
        //TODO write your implementation code here:
       return metier.addMessage(object, content, date, read);
    }
    
    
    @WebMethod(operationName = "linkUserAccountSender")
    public Message linkUserAccountSender(@WebParam(name = "userAccountSender") UserAccount ua, @WebParam(name = "id") Long id) {
        //TODO write your implementation code here:
        return metier.linkUserAccountSender(ua, id);
    }
    
    @WebMethod(operationName = "linkUserAccountListRecipients")
    public Message linkUserAccountListRecipients(@WebParam(name = "listUserAccountRecipients") Collection<UserAccount> listUA, @WebParam(name = "id") Long id) {
        //TODO write your implementation code here:
        return metier.linkUserAccountListRecipients(listUA, id);
    }
    
    @WebMethod(operationName = "searchMessage")
    public List<Message> searchMessage(UserAccount ua) {
        return ((MetierImpl)metier).searchMessage(ua);
    }
    
    @WebMethod(operationName = "searchSentMessages")
    public List<Message> searchSentMessages(@WebParam(name = "login") Long id) {
        //TODO write your implementation code here:
        return metier.searchSentMessages(id);
    }
    
    @WebMethod(operationName = "getAllReceiverAccount")
    public List<UserAccount> getAllReceiverAccount(@WebParam(name = "message") Message message) {
        //TODO write your implementation code here:
        return metier.getAllReceiverAccount(message);
    }
}
