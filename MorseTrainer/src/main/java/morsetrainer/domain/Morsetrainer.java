/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

import java.util.Scanner;

/**
 *
 * @author maisajoo
 */


/**This class is used only for testing during program development
 *
 * 
 */
public class Morsetrainer {
    
    static Scanner scanner = new Scanner(System.in);   
          
    public static void main(String[] args) {          
        UserActions ua = new UserActions();
        UserInfo ui = new UserInfo();
//       ua.createAccount("Leevi", "1234");
        //ua.logIn("Leevi", "1234");
        System.out.println("Tässä ois!  " + ua.getUserHighscoreFromDB("Leevi"));
       // ua.updateUserHighscoreToDB("Leevi", 1005);
        System.out.println("Leevis highscore is: " + ua.getUserHighscoreFromDB("Leevi"));
    }
   
    
}
