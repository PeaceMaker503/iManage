/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.metier;

import insa.db.UserProfile;

/**
 *
 * @author Halim
 */
public interface IMetier {
    
    public UserProfile addUserProfile(String firstName, String lastName, String mail, String phone, String cvPath);
}
