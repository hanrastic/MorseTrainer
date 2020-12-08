
package morsetrainer.domain;

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
    */ 
    public void createAccount(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Not valid for creating account");
        } else {
            dbOperations.insertData(username, password);
        }
    }
    
    /**
    * Method for logging in
    * Method sets users highscore visible from database
    *
    * @param   username   users username
    * @param   password    users password
    */ 
    public void logIn(String username, String password) {
        user.setUsername(username);
        user.setPassword(password);
        user.setScore(getUserHighscoreFromDB(username));
    }
    
    /**
    * Method for updating users highscore to database
    * Method checks if new score is better than previous best and updates is to database if it is
    * 
    * @param   username   users username
    * @param   currentHighscore     users highscore
    */ 
    public void updateUserHighscoreToDB(String username, int currentHighscore) {
        if (currentHighscore > getUserHighscoreFromDB(username)) {
            dbOperations.updateUserHighscore(username, currentHighscore);
        }
    }
    
    
    
    /**
    * Getter method for highscore 
    * 
    * @param   username   users username
    */ 
    public int getUserHighscoreFromDB(String username) {
        return dbOperations.getUserHighscoreFromDB(username);
    }
            
}
