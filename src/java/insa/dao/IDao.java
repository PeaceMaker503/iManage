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
    
    public UserAccount addUserAccount(UserAccount userAccount);
    public UserProfile addUserProfile(UserProfile userProfile);
}
