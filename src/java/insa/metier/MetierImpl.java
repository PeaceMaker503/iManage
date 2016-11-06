/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.DaoImpl;
import insa.dao.IDao;
import insa.db.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author Halim
 */

public class MetierImpl implements IMetier {
    
    private IDao dao;
    private welcomeManager welcomeM;
    
   
    
    @Override
    public boolean connectUser(String login, String password)
    {
        return welcomeM.connectUser(login, password);
    }
    
    
    @Override
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath)
    {
        UserProfile u = new UserProfile();
        u.setFirstName(firstName);
        u.setLastName(lastName);
        u.setMail(mail);
        u.setPhone(phone);
        u.setCvPath(cvPath);
        return dao.addUserProfile(u);
    }
    
    public UserAccount addUserAccount(String login , String mail , String password)
    {
        UserAccount a = new UserAccount();
        a.setLogin(login);
        a.setPassword(password);
        a.setMail(mail);
        return dao.addUserAccount(a);
    }
    
    public Long getUserProfile(String login, String password){
        return dao.getProfileConnection(login, password);
    }

    public int addUserProfileToAcccount(UserProfile userProfile, Long id){
        UserAccount user = dao.getUserAccount(id);
        user.setId_profile(userProfile);
        dao.updateUserAccount(user);
        return 0;
    }
    
    public welcomeManager getWelcomeM() 
    {
        return welcomeM;
    }

    
    public void setWelcomeM(welcomeManager welcomeM) {
        this.welcomeM = welcomeM;
    }
    
    public IDao getDao() 
    {
        return dao;
    }

    public void setDao(IDao dao) 
    {
        this.dao = dao;
    }
    
}
