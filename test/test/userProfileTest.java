/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import insa.db.UserAccount;
import insa.db.*;
import java.util.List;
import insa.metier.MetierImpl;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author zaurelzo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class userProfileTest {
    
    @Autowired
    private MetierImpl metier;

    public MetierImpl getMetier() {
        return metier;
    }

    public void setMetier(MetierImpl metier) {
        this.metier = metier;
    }
    
    
    @Test
    public void AddNewUserAccountTest()
    {
        //compte qui n'existe pas
        UserAccount u = metier.addUserAccount("monlogin", "mail@m.fr", "toto","Student");
        assertTrue(u != null);
    }
    
    @Test
    public void AddUserAccountAlreadyExistTest()
    {
        //compte déjà présent dans la bdd
        UserAccount u = metier.addUserAccount("user", "user@mail.com", "passwd","Student");
        assertTrue(u == null);
    }
    
    @Test
    public void AddNewUserAccountEmptyFieldsTest()
    {
        /* nom vide et regex email non valide*/
        UserAccount u = metier.addUserAccount("", "", "bisounours","Student");
        assertTrue(u == null);
    }
    
    @Test
    public void AddNewUserAccountNullFieldsTest()
    {
        /* champs à null*/
        UserAccount u = metier.addUserAccount(null, null, null,null);
        assertTrue(u == null);
    }
    
    @Test
    public void AddUserProfileTest()
    {
        /* Nouveau profile*/
        UserProfile u = metier.addUserProfile("Steve", "Job", "job@vacheALait.com", "0614895030", "home/apple.pdf");
        assertTrue(u != null);
    }
    
    @Test
    public void AddUserProfileAlreadyExistTest()
    {
        /*profile déja existant*/
        UserProfile u = metier.addUserProfile("fname", "fname", "job@vacheALait.com", "0614895030", "/home/file.pdf");
        assertTrue(u == null);
    }
    
    @Test
    public void AddUserProfileEmptyFieldTest()
    {
        /*champs vides*/
        UserProfile u = metier.addUserProfile("", "", "", "", "");
        assertTrue(u == null);
    }
    
    @Test
    public void AddUserProfileNullFieldTest()
    {
        /*champs vides*/
        UserProfile u = metier.addUserProfile(null, null, null, null, null);
        assertTrue(u == null);
    }
    
    @Test
    public void deleteUserAccountByIdNotExistTest()
    {
        /*compte non existant d'id 1000*/
        long id = 1000;
        UserAccount ua = metier.deleteUserAccountById(id);
        assertTrue(ua == null);
    }
    
    @Test
    public void deleteUserAccountByIdAlreadyExistTest()
    {
        /*compte  existant dont le login est ichigo*/
        UserAccount uaTest = metier.getUserAccountByLogin("ichigo");
        UserAccount ua = metier.deleteUserAccountById(uaTest.getId());
        assertTrue(ua != null);
    }
    
    @Test
    public void deleteUserProfileNotExistTest()
    {
        /*profil non existant d'id 1000*/
        long id = 1000;
        UserProfile up = metier.deleteUserProfile(id);
        assertTrue(up == null);
    }
    
    @Test
    public void deleteUserProfileAlreadyExistTest()
    {
        /*profil déjà existant*/
        UserProfile up = metier.getUserProfileUsingAccountLogin("BelleFontaine");
        assertTrue(up != null);
    }
    
    @Test
    public void searchInternshipTest()
    {
        /*recherche l'ensemble des stages*/
        List<Internship> listInternship = metier.searchInternship();
        //System.out.println("************* size internship list :" + listInternship.size());
        assertTrue(listInternship.size() == 4);
    }
    
    @Test
    public void getInternshipByCriteriaTest()
    {
        /*recherche stage dans la catégorie biologie*/
        List<Internship> listInternship = metier.getInternshipByCriteria("All", "biologie", "");
        //System.out.println("************* size internship list :" + listInternship.size());
        assertTrue(listInternship.get(0).getName().equals( "amelioration nouvelle enzyme"));
    }
    
    @Test
    public void getInternshipByCriteriaCategoryNotExistTest()
    {
        /*recherche stage dans la catégorie biologie*/
        List<Internship> listInternship = metier.getInternshipByCriteria("All", "math", "");
        //System.out.println("************* size internship list :" + listInternship.size());
        assertTrue(listInternship.size()==0);;
    }
}
