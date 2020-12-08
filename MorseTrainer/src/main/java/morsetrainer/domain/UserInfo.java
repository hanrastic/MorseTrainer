/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

/**
 *
 * @author joonas
 */
public class UserInfo {
    String username;
    String password;
    int score;
    
    public UserInfo() {
        this.username = username;
        this.password = password;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int highscore) {
        this.score = highscore;
    }
    
    /**
    * Method for setting score to zero
    */ 
    public void setScoreToZero(){
        score = 0;
    }
    
        /**
    * Method for checking if users guess is correct
    * Used in training mode
    * 
    * @param   NumberOfLetters number of letters that user is currently training with in training mode
    *
    * @return current score added with points for different difficulties
    */ 
    public int addToCurrentScore(int NumberOfLetters){
        
        if(NumberOfLetters == 1){
            score += 1;
        } else if (NumberOfLetters == 2) {
            score += 5;
        } else if (NumberOfLetters == 3) {
            score += 10;
        } else if (NumberOfLetters == 4) {
            score += 20;
        } else if (NumberOfLetters == 5) {
            score += 30;
        }
        return score;
    }
    
    
    
    
    
}
