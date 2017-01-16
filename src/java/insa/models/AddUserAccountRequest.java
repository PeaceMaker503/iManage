/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.models;

/**
 *
 * @author Halim
 */
public class AddUserAccountRequest {
    
    private String login;
    private String mail;
    private String password;
    private String userCategory;

    public AddUserAccountRequest()
    {
        this.login = null;
        this.mail = null;
        this.password = null;
        this.userCategory = null;
    }
    
    public AddUserAccountRequest(String login, String mail, String password, String userCategory) {
        this.login = login;
        this.mail = mail;
        this.password = password;
        this.userCategory = userCategory;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getLogin() {
        return login;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getUserCategory() {
        return userCategory;
    }
}
