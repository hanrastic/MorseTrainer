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
    
    @Before
    public void setUp(){
        userinfo = new UserInfo(username, password);
    }
}
