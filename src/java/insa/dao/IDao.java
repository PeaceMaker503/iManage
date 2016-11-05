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
    
    public UserAccount getUserAccount(Long id);
    public UserAccount addUserAccount(UserAccount userAccount);
    public UserAccount deleteUserAccount(Long id);
    public UserAccount updateUserAccount(UserAccount id);
    
    public UserProfile getUserProfile(Long id);
    public UserProfile addUserProfile(UserProfile userProfile);
    public UserProfile deleteUserProfile(Long id);
    public UserProfile updateUserProfile(UserProfile userProfile);
    
    public Internship getInternship(Long id);
    public Internship addInternship(Internship internship);
    public Internship deleteInternship(Long id);
    public Internship updateInternship(Internship internship);
    
    public Company getCompany(Long id);
    public Company addCompany(Company company);
    public Company deleteCompany(Long id);
    public Company updateCompany(Company company);
    
    /*welcome class functions*/
    public boolean connectToAccount(String login, String password);
    
    
}
