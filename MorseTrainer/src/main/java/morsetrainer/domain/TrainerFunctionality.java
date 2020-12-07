package morsetrainer.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import morsetrainer.dao.DBOperations;
//import static morsetrainer.domain.Morsetrainer.scanner;

/**
 *
 * @author maisajoo
 */
public class TrainerFunctionality {

    MorseAlphabet tables = new MorseAlphabet();
    int inputIsNumeric = 0;
    int currentScore = 0;
    
    /**
    * Method for checking if input is numeric or a letter
    *
    * @param   input   Input by from user 
    *
    * @return true if numeric
    */
    public boolean testIfInputIsNumeric(String input) {
        try {
            inputIsNumeric = Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
   
    /**
    * Method for generating random letters from alphabets
    *
    * @param   numberOfLetters   random morse code to be generated 
    *
    * @return set of random letters as a string
    */
    public String randomValue(double numberOfLetters) {   
        
        Random generator = new Random();
        Object[] values = this.tables.alphabets.values().toArray();
        String randomValues = "";
         
        for(int i = 0; i < numberOfLetters ; i++){
           randomValues += values[generator.nextInt(values.length)].toString();
           randomValues += "   ";
        }
            return randomValues;
    }
    
    /**
    * Method for converting alphabet to morse code
    *
    * @param   alphabetLetter   single letter
    *
    * @return corresponding morse code
    */    
    public String getMorsecodeFromAlphabet(String alphabetLetter) {
        //Toimii
        return this.tables.alphabets.get(alphabetLetter.toLowerCase());
    }

    /**
    * Method for converting integer to morse code
    *
    * @param   inputNumber   single integer
    *
    * @return corresponding morse code
    */      
    public String getMorsecodeFromInteger(int inputNumber) {
        //Toimii
        return this.tables.numbers.get(inputNumber);
    }

    /**
    * Method for converting morse code to alphabet
    *
    * @param   morseCode   single morse code
    *
    * @return corresponding letter
    */      
    public String getAlphabetFromMorse(String morseCode) {
        //Toimii
        for (Entry<String, String> entry : this.tables.alphabets.entrySet()) {
            if (entry.getValue().equals(morseCode.toLowerCase())) {
                return entry.getKey();
            }
        }
        return "Not morse code. ";
    }
    
     /**
    * Method for converting morse code to integer
    *
    * @param   morse   single morse code
    *
    * @return corresponding Integer
    */  
    public int getIntegerFromMorse(String morse) {
       //Toimii
       for (Entry<Integer, String> entry : this.tables.numbers.entrySet()) {
            if (entry.getValue().equals(morse)) {
                return entry.getKey();
            }
        }
        return 9999;
    }
    
    /**
    * Method for converting multiple letters to morse code
    *
    * @param   input   set of letters to be converted
    *
    * @return corresponding set of morse code as a String
    */  
    public String convertMultipleLettersToMorse(String input) {

        ArrayList<String> morseCode = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            
            if (String.valueOf(input.charAt(i)).equals(" ")) {
                i = i; //Do nothing
            } else if (testIfInputIsAllowedOrNumeric(String.valueOf(input.charAt(i))) == false) {
                morseCode.add(getMorsecodeFromAlphabet(String.valueOf(input.charAt(i))));   
            } else if (testIfInputIsNumeric(String.valueOf(input.charAt(i))) == true) {
                morseCode.add(getMorsecodeFromInteger(Integer.parseInt(String.valueOf(input.charAt(i)))));
            }
            
        }       
        String output = appendToString(sb, morseCode);
        return output;
        //System.out.println(output);
    }
    
    /**
    * Method for converting multiple morse code to alphabets
    *
    * @param   input   set of morse code to be converted
    *
    * @return corresponding set of alphabets as a String
    */  
    public String convertMultipleMorsecodeToAlphabets(String input) {
        
        List<String> morse = Arrays.asList(input.split(" "));
        StringBuilder sb = new StringBuilder();
        ArrayList<String> letters = new ArrayList<>();
         
        for (int i = 0; i < morse.size(); i++) {
            
            if (morse.get(i).isEmpty()) {
                i = i; //Do nothing
            } else if (morse.get(i).length() <= 4) {
                letters.add(getAlphabetFromMorse(morse.get(i)));
            } else if (morse.get(i).length() == 5) {   
                if (getIntegerFromMorse(morse.get(i)) == 9999) {
                    letters.add("Not morse code. ");
                } else {
                    letters.add(Integer.toString(getIntegerFromMorse(morse.get(i))));      
                }          
            } else if (morse.get(i).length() > 5) {
                letters.add("Not morse code. ");
            }
        }
        String output = appendToString(sb, letters);
        return output;
    }
    
    /**
    * Method for appending list to a String
    *
    * @param   stringBuilder   StringBuilder
    * @param   list   list that need to be appended to a String
    *
    * @return list as a single String
    */  
    public String appendToString(StringBuilder stringBuilder, List list) {
        for (Object letter : list) {
            stringBuilder.append(letter);
            stringBuilder.append(" ");
        }
        String output = stringBuilder.toString();
        return output;
         
    }
        
    
    /**
    * Method for testing if input is allowed.
    * Accepts only letters from (a-Z) and numbers (0-9)
    *
    * @param   input   input to be checked
    *
    * @return true if input is allowed
    */  
    public boolean testIfInputIsAllowedOrNumeric(String input) {
        Pattern special = Pattern.compile("[^A-Za-z]");
        Matcher matcherS = special.matcher(input);

        return matcherS.find();
    }   
    
    
    /**
    * Method for checking if users guess is correct
    * Used in training mode
    * 
    * @param   convertableMorse   morse code that was generated by the program
    * @param   inputLetters   users guess as what convertableMorse is as a letter
    *
    * @return true if users guessed correctly
    */ 
    public boolean checkIfMorseIsCorrect(String convertableMorse, String inputLetters) {
        
        if (inputLetters.equals(convertMultipleMorsecodeToAlphabets(convertableMorse).trim())){
            return true;
        } else return false;
    }
    
    public void testDB(String username, String password) {
        DBOperations.insertData(username, password);
        
    }
    
    public void testHighscoreUpdateDB(String username, int currentHighscore) {
        DBOperations.updateUserHighscore(username, currentHighscore);
    }
}
