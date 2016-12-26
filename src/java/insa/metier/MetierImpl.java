/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.DaoImpl;
import insa.dao.IDao;
import insa.db.*;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
	
	public UserProfile getUserProfileById(Long id) 
	{
		return dao.getUserProfileById(id);
	}
	
	public UserAccount getUserAccountByLogin(String login) 
	{
		return dao.getUserAccountByLogin(login);
	}
        
         public UserProfile getUserProfileUsingAccountLogin(String login)
         {
             return dao.getUserProfileUsingAccountLogin(login);
         }
		    
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

    public List<Internship> searchInternship() {
        List<Internship> list = dao.getAllInternships();
        return list;
    }
    
    public List<Category> getCategories() {
        List<Category> list = dao.getAllCategories();
        return list;
    }
    
    public List<Company> getCompanies() {
        List<Company> list = dao.getAllCompanies();
        return list;
    }
    
    public List<Internship> getInternshipByCriteria(String company, String category, String keywords) {
        List<Internship> list = dao.getInternshipByCompanyNameCategoryNameWhereTitleContains(company, category, keywords);
        return list;
    }
	
	public Candidature getCandidatureById(Long id) {
		return dao.getCandidatureById(id);
	}
	
    public Candidature createCandidature(String title, String message, String coverLetterPath) {
		Candidature candidature = new Candidature(title,message,coverLetterPath,null,null,null);
		return dao.addCandidature(candidature);		
	}
	
    public Candidature deleteCandidatureById(Long id) {
		return dao.deleteCandidatureById(id);		
	}
	
    public Candidature updateCandidature(Candidature candidature) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public Internship getInternshipByID(long id) {
		return dao.getInternshipById(id);
	}

    public Company addCompanyProfile(String name, String phone, String mail, String address){
        Company comp = new Company(name, phone, mail, address);
        return dao.addCompany(comp);
    }
    
    public Company getCompanyById(Long id){
            return dao.getCompanyById(id);

    }
    
    public Company updateCompany(Company company){
        return dao.updateCompany(company);
    }

	
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
	
	public List<Company> getCandidaturesByUserID(long user_id) {
		List<Company> list = dao.getCandidaturesByUserID(user_id);
        return list; 
	}
	
}
