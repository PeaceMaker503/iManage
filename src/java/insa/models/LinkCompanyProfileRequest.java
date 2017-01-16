/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insa.models;

import insa.db.Company;

/**
 *
 * @author Halim
 */
public class LinkCompanyProfileRequest {
    
    private String login;
    private Company company;

    public LinkCompanyProfileRequest()
    {
        this.login = null;
        this.company = null;
    }
    
    public LinkCompanyProfileRequest(String login, Company company) {
        this.login = login;
        this.company = company;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getLogin() {
        return login;
    }

    public Company getCompany() {
        return company;
    }
}
