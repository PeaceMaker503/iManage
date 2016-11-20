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
    
    public UserAccount getUserAccountByLogin(String login);
    public UserAccount getUserAccountById(Long id);
    public UserAccount addUserAccount(UserAccount userAccount);
    public UserAccount deleteUserAccountById(Long id);
    public UserAccount updateUserAccount(UserAccount id);
    
    public UserProfile getUserProfileById(Long id);
    public UserProfile addUserProfile(UserProfile userProfile);
    public UserProfile deleteUserProfileById(Long id);
    public UserProfile updateUserProfile(UserProfile userProfile);
    
    public Company getCompanyById(Long id);
    public Company getCompanyByName(String name);
    public Company addCompany(Company company);
    public Company deleteCompanyById(Long id);
    public Company updateCompany(Company company);
    public List<Company> getAllCompanies();
            
    public Internship getInternshipById(Long id);
    public List<Internship> getInternshipByCategory(Category category);
    public List<Internship> getInternshipByCompany(Company company);
    public List<Internship> getInternshipByCategoryName(String name);
    public List<Internship> getInternshipByCompanyName(String name);
    public Internship addInternship(Internship internship);
    public Internship deleteInternshipById(Long id);
    public Internship updateInternship(Internship internship);
    public List<Internship> getAllInternships();
    
    public Category getCategoryById(Long id);
    public Category getCategoryByName(String name);
    public Category addCategory(Category category);
    public Category deleteCategoryById(Long id);
    public Category updateCategory(Category category);
    public List<Category> getAllCategories();
    
}
