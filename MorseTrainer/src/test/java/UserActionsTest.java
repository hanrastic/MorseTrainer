
import java.sql.SQLException;
import morsetrainer.dao.DBOperations;
import morsetrainer.domain.UserActions;
import morsetrainer.domain.UserInfo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joonas
 */
public class UserActionsTest {
    
    UserActions userA = new UserActions();
    DBOperations dbOp = new DBOperations();
    
    @Test
    public void createAccountOk() throws SQLException {
        userA.createAccount("Jonne", "ykskakskol");
        assertTrue(dbOp.isUser("Jonne"));
    }
    
    @Test
    public void createAccountNotOkWithInvalidParameters() throws SQLException{
        userA.createAccount("", "");
        assertFalse(dbOp.isUser(""));
    }
    
    @Test
    public void createAccountNotOkWithUsedUsername() throws SQLException {
        assertFalse(userA.createAccount("Jonne","ykskakskol"));
    }
    
    @Test
    public void logInOk() throws SQLException {
        assertTrue(userA.logIn("Joonas", "joonas"));       
    }
    
    @Test
    public void logInNotOkWithInvalidParameters() throws SQLException {
        assertFalse(userA.logIn("rftyughujik", "yugiu789"));       
    }
    
    @Test
    public void updateUserHighscoreOk() throws SQLException {
        userA.createAccount("TestiKäyttäjäTestiKäyttäjä", "ÄläMuutaTämänKäyttäjänTietoja");
        userA.updateUserHighscoreToDB("TestiKäyttäjäTestiKäyttäjä", userA.getUserHighscoreFromDB("TestiKäyttäjäTestiKäyttäjä"));
        assertEquals(0, userA.getUserHighscoreFromDB("TestiKäyttäjäTestiKäyttäjä"));
    }
}
