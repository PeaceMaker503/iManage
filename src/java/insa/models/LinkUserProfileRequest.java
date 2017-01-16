/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.models;

import insa.db.Company;
import insa.db.UserProfile;

/**
 *
 * @author Halim
 */
public class LinkUserProfileRequest {
    
    private String login;
    private UserProfile userProfile;

    public LinkUserProfileRequest() {
        this.login = null;
        this.userProfile = null;
    }
    
    public LinkUserProfileRequest(String login, UserProfile userProfile) {
        this.login = login;
        this.userProfile = userProfile;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getLogin() {
        return login;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }
}
