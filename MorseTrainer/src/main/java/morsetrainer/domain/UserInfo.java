
package morsetrainer.domain;

/**
 * Class contains basic information about the user.
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
    public void setScoreToZero() {
        score = 0;
    }
    
    /**
    * Method for checking if users guess is correct
    * Used in training mode
    * 
    * @param   numberOfLetters number of letters that user is currently training with in training mode
    *
    * @return current score added with points for different difficulties
    */ 
    public int addToCurrentScore(int numberOfLetters) {
        
        if (numberOfLetters == 1) {
            score += 1;
        } else if (numberOfLetters == 2) {
            score += 5;
        } else if (numberOfLetters == 3) {
            score += 10;
        } else if (numberOfLetters == 4) {
            score += 20;
        } else if (numberOfLetters == 5) {
            score += 30;
        }
        return score;
    }
    
    
    
    
    
}
