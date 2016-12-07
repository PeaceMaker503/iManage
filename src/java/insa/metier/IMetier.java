/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.dao.IDao;
import insa.db.UserProfile;
import insa.db.UserAccount;
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
	public UserAccount deleteUserAccountById(Long id);
    public UserAccount linkUserProfile(String login, UserProfile up);
    public UserProfile deleteUserProfile(Long id);
}
