/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Halim
 */
public class HibernateManager {
    
    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public Long addObjectToDatabase(Object o)
    {
        Long res = null;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                res = (Long)s.save(o);
                tx.commit();
            } 
            catch(Exception e)
            {
                res = null;
            }
            finally
            {
               s.close();
            }
        }
        catch(HibernateException e)
        {
            res = null;
        }
        finally
        {
            
        }
        
        return res;
    }
    
    public boolean updateObjectInDatabase(Object o)
    {
        boolean res = true;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                s.update(o);
                tx.commit();
            } 
            catch(Exception e)
            {
                res = false;
            }
            finally
            {
               s.close();
            }
        }
        catch(HibernateException e)
        {
            res = false;
        }
        finally
        {

        }

        return res;
    }
    
    public <T> T getObjectFromDatabase(Class<T> type, Long id)
    {
        Object res = null;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                res = s.get(type, id);
                tx.commit();
            } 
            catch(Exception e)
            {
                res = null;
            }
            finally
            {
               s.close();
            }
        }
        catch(HibernateException e)
        {
            res = null;
        }
        finally
        {

        }

        return (T)res;
    }
    
    public boolean deleteObjectFromDatabase(Object o)
    {
        boolean res = true;
        try
        {
            Session s = sessionFactory.openSession();
            try
            {
                Transaction tx = s.beginTransaction();
                s.delete(o);
                tx.commit();
            } 
            catch(Exception e)
            {
                res = false;
            }
            finally
            {
               s.close();
            }
        }
        catch(HibernateException e)
        {
            res = false;
        }
        finally
        {

        }
        return res;
    }
}
