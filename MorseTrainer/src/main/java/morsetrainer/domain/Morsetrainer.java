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
        
        TrainerFunctionality f = new TrainerFunctionality();
        
        f.testDB(1, "Hanrastic", "ykskakskol", 0);
    }
   
    
}
