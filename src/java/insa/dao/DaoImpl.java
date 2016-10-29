/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.dao;

import insa.db.UserAccount;
import insa.db.UserProfile;
import java.util.concurrent.Callable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTransactionManager;

/**
 *
 * @author Halim
 */

public class DaoImpl implements IDao {
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    

    public UserAccount addUserAccount(UserAccount userAccount)
    {
        boolean result = true;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                s.save(userAccount);
                tx.commit();
            } 
            catch(Exception e)
            {
                result = false;
            }
            finally
            {
               s.close();
            }
        }
        catch(Exception e)
        {
            result = false;
        }

        if(result)
            return userAccount;
        else
            return null;
    }
    
     public UserProfile addUserProfile(UserProfile userProfile)
    {
        boolean result = true;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                s.save(userProfile);
                tx.commit();
            } 
            catch(Exception e)
            {
                 result = false;
            }
            finally
            {
               s.close();
            }
        }
        catch(Exception e)
        {
             result = false;
        }

        if(result)
            return userProfile;
        else
            return null;
    }
}
