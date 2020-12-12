
package morsetrainer.domain;

import java.sql.SQLException;
import morsetrainer.dao.DBOperations;

/**
 * Class for aiding in merging database functions and user functions.
 * 
 * @author joonas
 */
public class UserActions {
    
    UserInfo user = new UserInfo();
    DBOperations dbOperations = new DBOperations();
    
    /**
    * Method for creating account and adding users info to database
    *
    * @param   username   users username
    * @param   password    users password
    * 
    * @return true if creating new account is okay
    */ 
    public boolean createAccount(String username, String password) throws SQLException {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Not valid for creating account");
            return false;
        } 
        if (dbOperations.isUser(username)) {
            System.out.println("Account for this username already exist");
            return false;            
        } else if (dbOperations.insertData(username, password)) {    
            dbOperations.updateUserHighscore(username, 0);
            System.out.println("Insert ok");
            return true;
        } else {
            System.out.println("Insert failed");
            return false;
        }
    }
    
    /**
    * Method for logging in
    *
    * @param   username   users username
    * @param   password    users password
    */ 
    public boolean logIn(String username, String password) throws SQLException {
        
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Not valid input for logging in");
            return false;
        } else if (dbOperations.validateLogIn(username, password)) {
          
            user.setUsername(username);
            user.setPassword(password);
            user.setScore(getUserHighscoreFromDB(username));
            System.out.println("Juuri kirjautuneen käyttäjän tiedot: " + user.getUsername() + "Salasana: " +  user.getPassword());
            System.out.println("LogIn OK in USERACTIONS -class");
            return true;
        } else {
            System.out.println("log in failed failed");
            return false;
        }     
    }
    
    /**
    * Method for updating users high score to database
    * Method checks if new score is better than previous best and updates is to database if it is
    * 
    * @param   username   users username
    * @param   currentHighscore     users high score
    */ 
    public void updateUserHighscoreToDB(String username, int currentHighscore) {
        if (currentHighscore > getUserHighscoreFromDB(username)) {
            dbOperations.updateUserHighscore(username, currentHighscore);
        }
    }

    /**
    * Getter method for high score 
    * 
    * @param   username   users username
    */ 
    public int getUserHighscoreFromDB(String username) {
        return dbOperations.getUserHighscoreFromDB(username);
    }
            
}
