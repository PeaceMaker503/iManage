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
import insa.db.Message;
import insa.db.UserProfile;
import insa.db.UserAccount;
import java.util.Collection;
import java.util.Date;
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
    public UserAccount getUserAccountByEmail(String mail);
    public List<UserAccount> getAllUserAccount();
	
	// User profiles:
    public UserProfile getUserProfileById(Long id);
    public UserProfile getUserProfileUsingAccountLogin(String login);
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath);

    public UserAccount linkUserProfile(String login, UserProfile up);
    public UserProfile deleteUserProfile(Long id);
    public UserProfile updateUserProfile(UserProfile userProfile);
    public List<Internship> searchInternship();
    public List<Category> getCategories();
    public List<Company> getCompanies();
    public List<Internship> getInternshipByCriteria(String company, String category, String keywords);

        
	// Candidatures:
	public Candidature getCandidatureById(Long id);
    public Candidature createCandidature(String title, String message, String coverLetterPath, String offer_name);
    public Boolean deleteCandidatureById(Long id);
    public Candidature updateCandidature(Candidature candidature);
	//public Candidature linkOfferToCandidature(long candID, Internship offer);
	public Candidature linkUserToCandidature(long cand_id,UserAccount userAccount);
	public Candidature linkCompanyToCandidature(long cand_id,Company company);
	public List<Candidature> getCandidaturesByUserID(long user_id);
		
	// Internships:
	public Internship getInternshipByID(long id);
    //	public Boolean deleteInternshipByID(Long id);
	public Boolean deleteInternshipById(long offer_id);
	
    // Messages:
    public Message getMessageById(Long id);
    public Message addMessage(String object, String content, Date date, Boolean read);
    public Message deleteMessageById(Long id);
    public Message updateMessage(String object, String content, Date date, Boolean read);
    public List<Message> searchMessage(UserAccount ua);
    public Message linkUserAccountSender(UserAccount ua, Long id);
    public Message linkUserAccountListRecipients(Collection<UserAccount> list, Long id);
    public List<Message> searchSentMessages(Long id);
    public List<UserAccount> getAllReceiverAccount(Message message);
    public Message updateReadMessage(Long id);
		
	// Companies and categories:
    public Company addCompanyProfile(String name, String phone, String mail, String address);
	public UserAccount linkCompanyProfile(String login, Company comp);
    public Company deleteCompanyProfile(Long id);
    public Company getCompanyById(Long id);
    public Company updateCompany(Company company);
	public Company getCompanyByName(String company_name);
	
	// Candidatures:
    //public Candidature getCandidatureById(Long id);
    //public Candidature addCandidature(Candidature candidature);
    //public Candidature deleteCandidatureById(Long id);
    //public Candidature updateCandidature(Candidature candidature);
	
	// Companies and categories:
	//public UserAccount linkCompanyProfile(String login, Company comp);
    //public Company deleteCompanyProfile(Long id);
    //public Company getCompanyById(Long id);
    //public Company updateCompany(Company company);

	
	
}
