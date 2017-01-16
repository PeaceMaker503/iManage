/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insa.metier;

import insa.db.Category;
import insa.db.Internship;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Halim
 */

public interface IMetier 
{
    public List<Internship> searchInternship();
    public List<Category> getCategories();
    public List<Internship> getInternshipByCriteria(String category, String keywords);
    public Internship getInternshipByID(long id);
    public Boolean deleteInternshipById(long offer_id);
    
}
