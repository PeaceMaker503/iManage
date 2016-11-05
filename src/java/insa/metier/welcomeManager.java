/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.IDao;
import java.util.*;
import insa.dao.DaoImpl;
/**
 *
 * @author zaurelzo
 */
public class welcomeManager 
{
    private IDao dao;
    
   
    
    
    public boolean  connectUser(String login, String password)
    {
        return dao.connectToAccount(login, password);
    }
    
    public void forgotPassword(String UserMail)
    { 
        System.out.println("hfee");
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
