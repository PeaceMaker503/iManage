/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.IDao;
import insa.db.*;
import java.util.List;

/**
 *
 * @author Halim
 */

public class MetierImpl implements IMetier {
    
    private IDao dao;
    
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
    public List<Internship> getInternshipByCriteria(String category, String keywords) {
        List<Internship> list = dao.getInternshipByCategoryNameWhereTitleContains(category, keywords);
        return list;
    }
   
    @Override
    public Boolean deleteInternshipById(long offer_id) {
        return dao.deleteInternshipById(offer_id);
    }
		
    @Override
    public Internship getInternshipByID(long id) {
        return dao.getInternshipById(id);
    }
}
