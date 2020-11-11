/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import morsetrainer.domain.MorseAlphabet;
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
        MorseAlphabet morse = new MorseAlphabet();
        morse.createTables();
        morse.equals(morse.alphabets);
    }
    @Test
    public void convertingAlphabetsToMorseIsOk(){
        //Converting alphabets to morse is ok
        MorseAlphabet morse = new MorseAlphabet();
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
        MorseAlphabet morse = new MorseAlphabet();
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
        MorseAlphabet morse = new MorseAlphabet();
        
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getMorsecodeFromInteger(integer), morse.numbers.get(integer));
        }
    }
    
    @Test
    public void convertingMorseToIntegersIsOk(){
        //Test that converting morse to corresponfing integer (0-9) is ok
        MorseAlphabet morse = new MorseAlphabet();
        
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getIntegerFromMorse(morse.getMorsecodeFromInteger(integer)), integer);
        }

    }
    // Check that input 4 quits program
    // Check that command back brings back to main menu
    //Test that check if input is not allowed for conversion
    //Komentojen toimiviuus
}
