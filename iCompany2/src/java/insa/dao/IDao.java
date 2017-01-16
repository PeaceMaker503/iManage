/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insa.dao;

import insa.db.*;
import java.util.List;

/**
 *
 * @author Halim
 */

public interface IDao {
   

    // Internships:
    public Internship getInternshipById(Long id);
    public List<Internship> getInternshipByCategory(Category category);
    public List<Internship> getInternshipByCategoryName(String name);
    public List<Internship> getInternshipByCategoryNameWhereTitleContains(String categoryName, String keywords);
    public Internship addInternship(Internship internship);
    public Boolean deleteInternshipById(Long id);
    public Internship updateInternship(Internship internship);
    public List<Internship> getAllInternships();
    
    //Categories :
    public Category getCategoryById(Long id);
    public Category getCategoryByName(String name);
    public Category addCategory(Category category);
    public Category deleteCategoryById(Long id);
    public Category updateCategory(Category category);
    public List<Category> getAllCategories();

}
