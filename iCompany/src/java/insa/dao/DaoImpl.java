/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.dao;

import insa.db.Category;
import insa.db.Internship;
import insa.utils.HibernateManager;
import java.util.*;

public class DaoImpl implements IDao {
    
    private HibernateManager hibernateManager;

    public HibernateManager getHibernateManager() {
        return hibernateManager;
    }

    public void setHibernateManager(HibernateManager hibernateManager) {
        this.hibernateManager = hibernateManager;
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
    public Internship getInternshipById(Long id) {
        return hibernateManager.getObjectFromDatabase(Internship.class, id);
    }

    @Override
    public Boolean deleteInternshipById(Long id) {
        Internship internship = hibernateManager.getObjectFromDatabase(Internship.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(internship);
		return res;
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
    public List<Internship> getInternshipByCategory(Category category)
    {
        String query = "from Internship as i where i.id_category = :category";
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", category);
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        return list;
    }

    @Override
    public Category getCategoryById(Long id) {
        return hibernateManager.getObjectFromDatabase(Category.class, id);
    }

    @Override
    public Category addCategory(Category category) 
    {
        
        Long id = hibernateManager.addObjectToDatabase(category);
        if(id != null)
        {
            category.setId(id);
            return category;
        }
        else
            return null; 
    }

    @Override
    public Category deleteCategoryById(Long id) {
        Category category = hibernateManager.getObjectFromDatabase(Category.class, id);
        boolean res = hibernateManager.deleteObjectFromDatabase(category);
        if(res)
            return category;
        else
            return null;
    }

    @Override
    public Category updateCategory(Category category) {
        boolean res = hibernateManager.updateObjectInDatabase(category);
        if(res)
            return category;
        else
            return null;
    }
	
    @Override
    public List<Internship> getInternshipByCategoryName(String name)
    {
        Category ca = this.getCategoryByName(name);
        if(ca != null)
            return this.getInternshipByCategory(ca);
        else
            return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        String query = "from Category as ca where ca.name = :category";
        HashMap<String, Object> params = new HashMap<>();
        params.put("category", name);
        List<Category> list = hibernateManager.execute(query, params, Category.class);
        if(list != null && list.size() > 0)
            return list.get(0);
        else
            return null;
    }

    @Override
    public List<Internship> getAllInternships() {
        
        String query = "from Internship";
        List<Internship> list = hibernateManager.execute(query, Internship.class);
        if(list != null)
            return list;
        else
            return null;
    }

    @Override
    public List<Category> getAllCategories() {
        
        String query = "from Category";
        List<Category> list = hibernateManager.execute(query, Category.class);
        if(list != null)
            return list;
        else
            return null;
    }
    
    @Override
    public List<Internship> getInternshipByCategoryNameWhereTitleContains(String categoryName, String keywords) 
    {
        String query = "from Internship as i";
        
        System.out.println("QUERY : " + query);
        HashMap<String, Object> params = new HashMap<>();
        if (!(categoryName.equals("All")) || !(keywords.equals(""))) {
            query += " where ";
            if (!(keywords.equals(""))) {
                query += "i.name like :condition";
                params.put("condition", "%" + keywords + "%");
            }
           
            if (!categoryName.equals("All")) {
                if (!(keywords.equals(""))) {
                    query += " and i.id_category = :category";
                } else {
                    query += "i.id_category = :category";
                }
                params.put("category", this.getCategoryByName(categoryName));
            }
        }
        
        List<Internship> list = hibernateManager.execute(query, params, Internship.class);
        if(list != null)
            return list;
        else
            return null;
    }
}
