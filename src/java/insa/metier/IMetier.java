/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.IDao;
import insa.db.Category;
import insa.db.Company;
import insa.db.Internship;
import insa.db.UserProfile;
import insa.db.UserAccount;
import java.util.List;
/**
 *
 * @author Halim
 */
public interface IMetier 
{
    public UserAccount getUserAccountByLogin(String login);
    public UserAccount verifyUserAccount(String login, String password);
    public UserProfile getUserProfileById(Long id);
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath);
    public UserAccount addUserAccount(String login , String mail , String password);
    public UserAccount linkUserProfile(String login, UserProfile up);
    public UserProfile deleteUserProfile(Long id);
    public List<Internship> searchInternship();
    public List<Category> getCategories();
    public List<Company> getCompanies();
    public List<Internship> getInternshipByCriteria(String company, String category, String keywords);
}
