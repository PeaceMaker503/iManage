/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.db.Candidature;
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
	// User accounts: 
	public UserAccount getUserAccountByLogin(String login);
    public UserAccount verifyUserAccount(String login, String password);
	public UserAccount addUserAccount(String login , String mail , String password, String userCategory);
    public UserAccount deleteUserAccountById(Long id);
	
	// User profiles:
    public UserProfile getUserProfileById(Long id);
    public UserProfile getUserProfileUsingAccountLogin(String login);
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath);
    public UserAccount linkUserProfile(String login, UserProfile up);
    public UserProfile deleteUserProfile(Long id);
	public UserProfile updateUserProfile(UserProfile userProfile);
        
	// Candidatures:
	public Candidature getCandidatureById(Long id);
    public Candidature createCandidature(String title, String message, String coverLetterPath);
    public Candidature deleteCandidatureById(Long id);
    public Candidature updateCandidature(Candidature candidature);
	public Candidature linkOfferToCandidature(long candID, Internship offer);
	public Candidature linkUserToCandidature(long cand_id,UserAccount userAccount);
	public Candidature linkCompanyToCandidature(long cand_id,Company company);
	public List<Company> getCandidaturesByUserID(long user_id);
	
	
	// Internships:
	public Internship getInternshipByID(long id);
	public List<Internship> searchInternship();
    public List<Internship> getInternshipByCriteria(String company, String category, String keywords);
	
	// Companies and categories:
	public List<Category> getCategories();
    public List<Company> getCompanies();
    public Company addCompanyProfile(String name, String phone, String mail, String address);
	public UserAccount linkCompanyProfile(String login, Company comp);
    public Company deleteCompanyProfile(Long id);
    public Company getCompanyById(Long id);
    public Company updateCompany(Company company);
	
}
