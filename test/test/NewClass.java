/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import insa.db.UserAccount;
import insa.metier.MetierImpl;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Halim
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:web/WEB-INF/applicationContext.xml")
public class NewClass {
    
    @Autowired
    private MetierImpl metier;

    public MetierImpl getMetier() {
        return metier;
    }

    public void setMetier(MetierImpl metier) {
        this.metier = metier;
    }
    
    
    @Test
    public void test()
    {
        System.out.println(System.getProperty("user.dir"));
        UserAccount u = metier.addUserAccount("monlogin", "mail@m.fr", "pass");
        assertTrue(u != null);
    }
}
