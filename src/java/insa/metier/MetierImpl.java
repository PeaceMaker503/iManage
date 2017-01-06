/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.IDao;
import insa.db.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Halim
 */

public class MetierImpl implements IMetier {
    
    private IDao dao;
    
    @Override
    public UserAccount verifyUserAccount(String login, String password)
    {
        UserAccount ua = dao.getUserAccountByLogin(login);
        if(ua != null && ua.getPassword().equals(password))
            return ua;
        else
            return null;
    }

    @Override
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath)
    {
        UserProfile up = new UserProfile(lastName, firstName, phone, mail, cvPath);
        return dao.addUserProfile(up);
    }
	
	@Override
    public UserProfile getUserProfileById(Long id) 
    {
	return dao.getUserProfileById(id);
    }
        
	@Override
    public UserAccount getUserAccountByEmail(String mail){
        return dao.getUserAccountByEmail(mail); 
    }

	
    @Override
	public UserAccount getUserAccountByLogin(String login) 
	{
		return dao.getUserAccountByLogin(login);
	}
        
	@Override
    public UserProfile getUserProfileUsingAccountLogin(String login)
    {
        return dao.getUserProfileUsingAccountLogin(login);
    }
		    
	@Override
    public UserAccount addUserAccount(String login , String mail, String password, String userCategory)
    {
        UserAccount ua = new UserAccount(login, mail, password, userCategory);
        return dao.addUserAccount(ua);
    }
	
	@Override 
	public UserAccount deleteUserAccountById(Long id) {
		return dao.deleteUserAccountById(id);
	}
	    
    @Override
    public UserProfile deleteUserProfile(Long id)
    {
        return dao.deleteUserProfileById(id);
    }
	
    @Override
    public Company deleteCompanyProfile(Long id)
    {
        return dao.deleteCompanyById(id);
    }
	@Override 
	public UserProfile updateUserProfile(UserProfile userProfile) 
	{
		return dao.updateUserProfile(userProfile);
	}
	    
    @Override
    public UserAccount linkUserProfile(String login, UserProfile up)
    {
        UserAccount res = null;
        UserAccount ua = dao.getUserAccountByLogin(login);
        if(ua != null)
        {
            ua.setId_profile(up);
            ua = dao.updateUserAccount(ua);
            res = ua;
        }
        else
            res = null;
        
        return res;
    }

    @Override
    public UserAccount linkCompanyProfile(String login, Company comp)
    {
        UserAccount res = null;
        UserAccount ua = dao.getUserAccountByLogin(login);
        if(ua != null)
        {
            ua.setId_Company_profile(comp);
            ua = dao.updateUserAccount(ua);
            res = ua;
        }
        else
            res = null;
        
        return res;
    }
    
    public IDao getDao() 
    {
        return dao;
    }

    public void setDao(IDao dao) 
    {
        this.dao = dao;
    }

	@Override
    public List<Internship> searchInternship() {
        List<Internship> list = dao.getAllInternships();
        return list;
    }
    
	@Override
    public List<Category> getCategories() {
        List<Category> list = dao.getAllCategories();
        return list;
    }
    
	@Override
    public List<Company> getCompanies() {
        List<Company> list = dao.getAllCompanies();
        return list;
    }
    
	@Override
    public List<Internship> getInternshipByCriteria(String company, String category, String keywords) {
        List<Internship> list = dao.getInternshipByCompanyNameCategoryNameWhereTitleContains(company, category, keywords);
        return list;
    }
	
	@Override
	public Boolean deleteInternshipById(long offer_id) {
		return dao.deleteInternshipById(offer_id);
	}
		
	
	@Override
	public Candidature getCandidatureById(Long id) {
		return dao.getCandidatureById(id);
	}
	
	@Override
    public Candidature createCandidature(String title, String message, String coverLetterPath) {
		Candidature candidature = new Candidature(title,message,coverLetterPath,null,null,null);
		return dao.addCandidature(candidature);		
	}
	
	@Override
    public Boolean deleteCandidatureById(Long id) {
		return dao.deleteCandidatureById(id);		
	}
	
	@Override
    public Candidature updateCandidature(Candidature candidature) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	@Override
	public Internship getInternshipByID(long id) {
		return dao.getInternshipById(id);
	}

	@Override
    public Company addCompanyProfile(String name, String phone, String mail, String address){
        Company comp = new Company(name, phone, mail, address);
        return dao.addCompany(comp);
    }
    
	@Override
    public Company getCompanyById(Long id){
            return dao.getCompanyById(id);

    }
    
	@Override
    public Company updateCompany(Company company){
        return dao.updateCompany(company);
    }
    
	@Override
    public Message getMessageById(Long id){
        return dao.getMessageById(id);
    }
    
	@Override
    public Message addMessage(String object, String content, Date date, Boolean read){
        Message message = new Message(object, content, date, read); 
        return dao.addMessage(message);
    }
	@Override
    public Message deleteMessageById(Long id){
        return dao.deleteMessageById(id);
    }
    
	@Override
    public Message updateMessage(String object, String content, Date date, Boolean read){
        Message message = new Message(object, content, date, read); 
        return dao.updateMessage(message);
    }
    
	@Override
    public List<Message> searchMessage(UserAccount ua){
        List<Message> list = dao.getAllMessages(ua);
        return list;
    }
    
    @Override
    public Message linkUserAccountSender(UserAccount ua, Long id)
    {
        Message res = null;
        Message message = dao.getMessageById(id);
        if(message != null)
        {
            message.setSender(ua);
            message = dao.updateMessage(message);
            res = message;
            }
        else
            res = null;
        return res;
    }
	
	@Override
	public Candidature linkOfferToCandidature(long candID, Internship offer) {
		Candidature res = null;
        Candidature ua = dao.getCandidatureById(candID);
        if(ua != null)
        {
            ua.setId_internship(offer);
            ua = dao.updateCandidature(ua);
            res = ua;
         }
        else
            res = null;
        return res;
    }
        
        
    
    @Override
    public Message linkUserAccountListRecipients(Collection<UserAccount> list, Long id){
        Message res = null;
        Message message = dao.getMessageById(id);
        if(message != null)
        {
            message.setReceiver(list);
            for(Iterator<UserAccount> i = list.iterator(); i.hasNext(); ){
                    UserAccount item = i.next();
                    ArrayList<Message> messagesUA = new ArrayList<Message>();
                    for(Iterator<Message> it =dao.getAllMessages(item).iterator(); it.hasNext(); ){
                        Message itemMsg = it.next();
                        messagesUA.add(itemMsg);
                    }
                    messagesUA.add(message);
                    item.setMessages(messagesUA);
                    dao.updateUserAccount(item);
            }
            message = dao.updateMessage(message);
            res = message;
        }
        else{
            res = null;
        }
        return res;
    }
    
	@Override
    public List<Message> searchSentMessages(Long id){
        List<Message> list = dao.getAllSentMessages(id);
        return list;      
    }
    
	@Override
    public List<UserAccount> getAllUserAccount(){
        List<UserAccount> list = dao.getAllUserAccount();
        return list;      
    }
    
	@Override
    public List<UserAccount> getAllReceiverAccount(Message message){
        List<UserAccount> list = dao.getAllReceiverAccount(message);
        return list;
    }



    

	
	@Override
	public Candidature linkUserToCandidature(long cand_id,UserAccount userAccount) {
		Candidature res = null;
        Candidature ua = dao.getCandidatureById(cand_id);
        if(ua != null)
        {
            ua.setId_userAccount(userAccount);
            ua = dao.updateCandidature(ua);
            res = ua;
        }
        else
            res = null;
        return res;	
	}
	
	@Override
	public Candidature linkCompanyToCandidature(long cand_id,Company company) {
		Candidature res = null;
        Candidature ua = dao.getCandidatureById(cand_id);
        if(ua != null)
        {
            ua.setId_company(company);
            ua = dao.updateCandidature(ua);
            res = ua;
        }
        else
            res = null;
        
        return res;	
	}
	
	@Override
	public List<Candidature> getCandidaturesByUserID(long user_id) {
		List<Candidature> list = dao.getCandidaturesByUserID(user_id);
        return list; 
	}
	
	@Override
        public Message updateReadMessage(Long id){
            Message message = dao.getMessageById(id);
            message.setRead(true);
            message = dao.updateMessage(message);
            if (message != null)
                return message;
            else
                return null;
            
        }

}
