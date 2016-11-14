/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.dao;

import insa.db.Company;
import insa.db.Internship;
import insa.db.UserAccount;
import insa.db.UserProfile;
import insa.utils.HibernateManager;
import java.util.*;
/**
 *
 * @author Halim
 */

public class DaoImpl implements IDao {
    
    private HibernateManager hibernateManager;

    public HibernateManager getHibernateManager() {
        return hibernateManager;
    }

    public void setHibernateManager(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
    }
    
    @Override
    public UserAccount getUserAccountById(Long id)
    {
        return hibernateManager.getObjectFromDatabase(UserAccount.class, id);
    }
    
    @Override
    public UserAccount addUserAccount(UserAccount userAccount)
    {
        Long id = hibernateManager.addObjectToDatabase(userAccount);
        if(id != null)
        {
            userAccount.setId(id);
            return userAccount;
        }
        else
            return null;
    }
    
    @Override
     public UserProfile addUserProfile(UserProfile userProfile)
    {
        Long id = hibernateManager.addObjectToDatabase(userProfile);
        if(id != null)
        {
            userProfile.setId(id);
            return userProfile;
        }
        else
            return null;
    }
     
    @Override
    public Internship addInternship(Internship internship)
    {
        Long id = hibernateManager.addObjectToDatabase(internship);
        if(id != null)
        {
            internship.setId(id);
            return internship;
        }
        else
            return null; 
    }
    
    @Override
    public Company addCompany(Company company)
    {
        Long id = hibernateManager.addObjectToDatabase(company);
        if(id != null)
        {
            company.setId(id);
            return company;
        }
        else
            return null; 
    }

    @Override
    public UserAccount deleteUserAccountById(Long id) {
        UserAccount userAccount = hibernateManager.getObjectFromDatabase(UserAccount.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(userAccount);
        if(res)
            return userAccount;
        else
            return null;
    }

    @Override
    public UserAccount updateUserAccount(UserAccount userAccount) {
        boolean res = hibernateManager.updateObjectInDatabase(userAccount);
        if(res)
            return userAccount;
        else
            return null;
    }

    @Override
    public UserProfile getUserProfileById(Long id) {
        return hibernateManager.getObjectFromDatabase(UserProfile.class, id);
    }

    @Override
    public UserProfile deleteUserProfileById(Long id) {
        UserProfile userProfile = hibernateManager.getObjectFromDatabase(UserProfile.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(userProfile);
        if(res)
            return userProfile;
        else
            return null;
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        boolean res = hibernateManager.updateObjectInDatabase(userProfile);
        if(res)
            return userProfile;
        else
            return null;
    }

    @Override
    public Internship getInternshipById(Long id) {
        return hibernateManager.getObjectFromDatabase(Internship.class, id);
    }

    @Override
    public Internship deleteInternshipById(Long id) {
        Internship internship = hibernateManager.getObjectFromDatabase(Internship.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(internship);
        if(res)
            return internship;
        else
            return null;
    }

    @Override
    public Internship updateInternship(Internship internship) {
        boolean res = hibernateManager.updateObjectInDatabase(internship);
        if(res)
            return internship;
        else
            return null;
    }

    @Override
    public Company getCompanyById(Long id) {
        return hibernateManager.getObjectFromDatabase(Company.class, id);
    }

    @Override
    public Company deleteCompanyById(Long id) {
        Company company = hibernateManager.getObjectFromDatabase(Company.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(company);
        if(res)
            return company;
        else
            return null;
    }

    @Override
    public Company updateCompany(Company company) {
        boolean res = hibernateManager.updateObjectInDatabase(company);
        if(res)
            return company;
        else
            return null;
    }
    
    @Override
    public UserAccount getUserAccountByLogin(String login)
    {
       String query = "from UserAccount as u where u.login= :login";
       HashMap<String, Object> params = new HashMap<>();
       params.put("login", login);
       List<UserAccount> list = hibernateManager.execute(query, params, UserAccount.class);
       if(list != null && list.size() == 1)
           return list.get(0);
       else
           return null;
    }
}
