
package morsetrainer.domain;

import java.util.HashMap;

/**
 * Class contains functionality for creating tables for morse code and alphabets
 * 
 * @author joonas
 */
public class MorseAlphabet {
    
    public HashMap<String, String> alphabets = new HashMap<String, String>();
    public HashMap<Integer, String> numbers = new HashMap<Integer, String>();
    
    public MorseAlphabet() {
        createAlphabetTable();
        createNumericTable();
    }
    /**
    * 
    * Method for creating HashMap for alphabets and morse code.
    * Key = alphabet
    * Value = morse code
    *
    */ 
    public void createAlphabetTable() {
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
    
    /**
    * 
    * Method for creating HashMap for numbers and morse code.
    * Key = integer
    * Value = morse code
    *
    */ 
    public void createNumericTable() {               
        numbers.put(1, ".----");
        numbers.put(2, "..---");
        numbers.put(3, "...--");
        numbers.put(4, "....-");
        numbers.put(5, ".....");
        numbers.put(6, "-....");
        numbers.put(7, "--...");
        numbers.put(8, "---..");
        numbers.put(9, "----.");
        numbers.put(0, "-----");
    }
}
