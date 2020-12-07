/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

import morsetrainer.dao.DBOperations;

/**
 *
 * @author joonas
 */
public class UserActions {
    UserInfo User = new UserInfo();
    
    public void createAccount(String username, String password) {
        if(username.isEmpty() || password.isEmpty()){
            System.out.println("Not valid for creating account");
        }else{
            DBOperations.insertData(username, password);
        }
    }
    
    public void logIn(String username, String password) {
        User.setUsername(username);
        User.setPassword(password);
        User.setScore(getUserHighscoreFromDB(username));
    }
    
    
    public void updateUserHighscoreToDB(String username, int currentHighscore) {
        if(currentHighscore > getUserHighscoreFromDB(username)) {
            DBOperations.updateUserHighscore(username, currentHighscore);
        }

    }
    
    public int getUserHighscoreFromDB(String username){
        return DBOperations.getUserHighscoreFromDB(username);
    }
            
}
