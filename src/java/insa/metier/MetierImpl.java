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

    public IDao getDao() {
        return dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
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
}
