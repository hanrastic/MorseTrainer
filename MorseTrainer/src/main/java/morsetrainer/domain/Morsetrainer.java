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
public class Morsetrainer {
    
    static Scanner scanner = new Scanner(System.in);   
           
        
    public static void main(String[] args){  
        MorseAlphabet alphabets = new MorseAlphabet();          
        alphabets.trainMorse();
    }
   
    
}