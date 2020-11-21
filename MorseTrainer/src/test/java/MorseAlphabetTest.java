/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import morsetrainer.domain.MorseTrainerFuntionality;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joonas
 */
public class MorseAlphabetTest {
    
    public MorseAlphabetTest() {
    }
    @Test
    public void creatingAlphabetsToMorseTableisIsOk(){
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        morse.createTables();
        morse.equals(morse.alphabets);
    }
    @Test
    public void convertingAlphabetsToMorseIsOk(){
        //Converting alphabets to morse is ok
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        String letterA = "a";
        String letterO = "O";
        String letterJ = "J";
        String letterE = "e";
        
        assertEquals(morse.getMorsecodeFromAlphabet(letterA), ".-");
        assertEquals(morse.getMorsecodeFromAlphabet(letterO), "---");
        assertEquals(morse.getMorsecodeFromAlphabet(letterJ), ".---");
        assertEquals(morse.getMorsecodeFromAlphabet(letterE), ".");      
    }
    
    @Test
    public void convertingMorseToAlphabetsIsOk(){
        //Converting morse to alphabet is ok
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        String morseQ = "--.-";
        String morseT = "-";
        String morseN = "-.";
        String morseH = "....";
        
        assertEquals(morse.getAlphabetFromMorse(morseQ), "q");
        assertEquals(morse.getAlphabetFromMorse(morseT), "t");
        assertEquals(morse.getAlphabetFromMorse(morseN), "n");
        assertEquals(morse.getAlphabetFromMorse(morseH), "h");       
    }
    
    @Test
    public void convertingIntegersToMorseIsOk(){
        //All integers Ok (0-9)
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getMorsecodeFromInteger(integer), morse.numbers.get(integer));
        }
    }
    
    @Test
    public void convertingMorseToIntegersIsOk(){
        //Test that converting morse to corresponfing integer (0-9) is ok
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getIntegerFromMorse(morse.getMorsecodeFromInteger(integer)), integer);
        }

    }
    
    @Test
    public void testIfInputIsNumeriIsOk(){
        MorseTrainerFuntionality morse = new MorseTrainerFuntionality();
        
        String input = "notANumber";
        assertFalse(morse.testIfInputIsNumeric(input));
    }
}
