/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.domain;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import static morsetrainer.domain.Morsetrainer.scanner;

/**
 *
 * @author maisajoo
 */
public class MorseAlphabet {

    public HashMap<String, String> alphabets = new HashMap<String,String>();
    
    public MorseAlphabet(){
        createTable();
    }
    public void createTable(){

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
        alphabets.put("o", "---");
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

    public void trainMorse(){
       
        System.out.println("Commands for using MorseTrainer");
        System.out.println("1. See Morse code alphabet table");
        System.out.println("2. Practice by converting letters");
        System.out.println("3. Practice randomly generated letters");
        System.out.println("4. Quit");
                   
        OUTER:
        while (true) {
            System.out.print("What do you want to do ? Type in a command (number): ");
            int command = scanner.nextInt();
            
            switch (command) {
                case 1:
                    printTable();
                    break;
                case 2:
                    convertAlphabetToMorseAndViceVersa();
                    break;
                case 3:
                    trainRandomMorsecode();
                    break;
                case 4:
                    break OUTER;
                default:
                    break;
            }
        }    
    }
    
    public void trainRandomMorsecode(){
        while(true){
            System.out.println("");
            System.out.println("Convert Morse code to corresponding letter or type 'quit' to go back to main menu");
            String morse = randomValue();
            System.out.println(morse);
            
            System.out.print(">");
            String input = scanner.next();
            
            if(input.equals("quit")){
                break;
            }else if (input.equals(morse)){
                System.out.println("Well done!");
            }else{
                System.out.println("Try again");
            }
            
        }
    }
    
    public String randomValue(){
        
        Random generator = new Random();
        Object[] values = alphabets.values().toArray();
        String randomValue = (String)values[generator.nextInt(values.length)];
            return randomValue;
    }
    
    public void convertAlphabetToMorseAndViceVersa(){
        
        while(true){
            System.out.println("");
            System.out.println("Type in alphabets or morsecode to translate it, or type 'quit' to go to main menu");
            System.out.print(">");
            String input = scanner.next();
                        
            if(input.equals("quit")){
                break;
            }else if(input.contains("-") || input.contains(".")){
               
                getAlphabetFromMorse(input);
                
            }else{
                
                getMorsecodeFromAlphabet(input);
                
            }
        }
    }
    
    public void getAlphabetFromMorse(String morseCode){

        for(Entry<String, String> entry : alphabets.entrySet()){
            if(entry.getValue().equals(morseCode)){
                System.out.println("Corresponding Morse code as a alphabet:"
                        + " " + entry.getKey());
            }
        }
    }
    
    public void getMorsecodeFromAlphabet(String alphabetLetter){
        
        System.out.println("Result as Morse code: " + alphabets.get(alphabetLetter));
    }
}
