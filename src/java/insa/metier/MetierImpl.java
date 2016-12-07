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
		    
    public UserAccount addUserAccount(String login , String password, String mail)
    {
        UserAccount ua = new UserAccount(login, password, mail);
        return dao.addUserAccount(ua);
    }
	    
    @Override
    public UserProfile deleteUserProfile(Long id)
    {
        return dao.deleteUserProfileById(id);
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
}
