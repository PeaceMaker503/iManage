/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

//import insa.db.UserAccount;
import insa.db.*;
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
        UserAccount u = metier.addUserAccount("monlogin", "mail@m.fr", "toto");
        assertTrue(u != null);
    }
    
    @Test
    public void AddUserAccountAlreadyExistTest()
    {
        //compte déjà présent dans la bdd
        UserAccount u = metier.addUserAccount("monlogin", "mail@m.fr", "toto");
        assertTrue(u == null);
    }
    
    @Test
    public void AddNewUserAccountEmptyFieldsTest()
    {
        /* nom vide et regex email non valide*/
        UserAccount u = metier.addUserAccount("", "", "bisounours");
        assertTrue(u == null);
    }
    
    @Test
    public void AddNewUserAccountNullFieldsTest()
    {
        /* champs à null*/
        UserAccount u = metier.addUserAccount(null, null, null);
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
        UserProfile u = metier.addUserProfile("Steve", "Job", "job@vacheALait.com", "0614895030", "home/apple.pdf");
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
}
