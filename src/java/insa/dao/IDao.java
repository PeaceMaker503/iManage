/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.dao;

import insa.db.*;

/**
 *
 * @author Halim
 */
public interface IDao {
    
    public UserAccount getUserAccountById(Long id);
    public UserAccount addUserAccount(UserAccount userAccount);
    public UserAccount deleteUserAccountById(Long id);
    public UserAccount updateUserAccount(UserAccount id);
    
    public UserProfile getUserProfileById(Long id);
    public UserProfile addUserProfile(UserProfile userProfile);
    public UserProfile deleteUserProfileById(Long id);
    public UserProfile updateUserProfile(UserProfile userProfile);
    
    public Internship getInternshipById(Long id);
    public Internship addInternship(Internship internship);
    public Internship deleteInternshipById(Long id);
    public Internship updateInternship(Internship internship);
    
    public Company getCompanyById(Long id);
    public Company addCompany(Company company);
    public Company deleteCompanyById(Long id);
    public Company updateCompany(Company company);
    
    public UserAccount getUserAccountByLogin(String login);
}
