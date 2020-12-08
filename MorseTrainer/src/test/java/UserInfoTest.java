import morsetrainer.domain.UserInfo;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author joonas
 */
public class UserInfoTest {
    UserInfo userinfo;
    String username;
    String password;
    int score;
    
    @Before
    public void setUp(){
        userinfo = new UserInfo();
        userinfo.setUsername("Jussi");
        userinfo.setPassword("JussinKissa");
        userinfo.setScore(100);
    }
    
    @Test
    public void getUsernameOk(){
        assertEquals(userinfo.getUsername(), "Jussi");
    }
    
    @Test
    public void getpasswordOk(){
        assertEquals(userinfo.getPassword(), "JussinKissa");
    }
    
    @Test
    public void getScoreOk(){
        assertEquals(userinfo.getScore(),100);
    }
    
    @Test
    public void settingScoreToZeroOk(){
        userinfo.setScoreToZero();
        assertEquals(userinfo.getScore(),0);
    }
    
    @Test
    public void addingToScoreOk() {
        userinfo.setScoreToZero();
        
        userinfo.addToCurrentScore(1);
        assertEquals(userinfo.getScore(),1);  
        
        userinfo.addToCurrentScore(2);
        assertEquals(userinfo.getScore(),6); 
         
        userinfo.addToCurrentScore(3);
        assertEquals(userinfo.getScore(),16); 
         
        userinfo.addToCurrentScore(4);
        assertEquals(userinfo.getScore(),36);
         
        userinfo.addToCurrentScore(5);
        assertEquals(userinfo.getScore(),66);      
    }
    

    
    
}
