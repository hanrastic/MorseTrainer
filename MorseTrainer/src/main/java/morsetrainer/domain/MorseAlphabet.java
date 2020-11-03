/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

import java.util.HashMap;
import java.util.Random;
import static morsetrainer.domain.Morsetrainer.scanner;

/**
 *
 * @author maisajoo
 */
public class MorseAlphabet {

    public HashMap<String, String> alphabets = new HashMap<String,String>();
    
    public void createTable(){
        //HashMap<String, String> alphabets = new HashMap<String,String>();
        
        alphabets.put("a", ".-");
        alphabets.put("b", "-...");
        alphabets.put("c", "-.-.");
        alphabets.put("d", "-..");
        alphabets.put("e", ".");
        alphabets.put("f", "..-.");
        alphabets.put("g", "--.");
        alphabets.put("h", "....");
        alphabets.put("i", "..");
        alphabets.put("j", ".---");
        alphabets.put("k", "-.-");      
        alphabets.put("l", ".-..");
        alphabets.put("m", "--");
        alphabets.put("n", "-.");
        alphabets.put("o", "--");
        alphabets.put("p", ".--.");
        alphabets.put("q", "--.-");
        alphabets.put("r", ".-.");
        alphabets.put("s", "...");
        alphabets.put("t", "-");
        alphabets.put("u", "..-");
        alphabets.put("v", "...-");
        alphabets.put("w", ".--");
        alphabets.put("x", "-..-");
        alphabets.put("y", "-.--");
        alphabets.put("z", "--..");
    }
    
    public void printTable(){
        System.out.println(alphabets);
    }
    
    public String getLetterMorse(String letter){
        return alphabets.get(letter);
    }
    
    public String getLetterAlphabet(String letter){
        return "w";
    }
    public void trainMorse(){
       
        System.out.println("Commands for using MorseTrainer");
        System.out.println("1. See morse code alphabet table");
        System.out.println("2. Practice by converting letters");
        System.out.println("3. Practice randomly generated letters");
        System.out.print("What do you want to do ? Type in a command (number): ");
        
            
        while(true){
            System.out.print("What do you want to do ? Type in a command (number): ");
            int command = scanner.nextInt();
            
            if(command == 1){
                printTable();
            }else if(command == 2){
                
            }else if(command == 3){
                
            }else if (command == 4){
                break;
            }
        }    
        
        
        
    }
    
    public String randomValue(){
        
        Random generator = new Random();
        Object[] values = alphabets.values().toArray();
        String randomValue = (String)values[generator.nextInt(values.length)];
            return randomValue;
    }
}
