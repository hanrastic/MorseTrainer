/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import morsetrainer.domain.MorseAlphabet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    public void creatingAlphabetsToMorseTableisOk(){
        MorseAlphabet morse = new MorseAlphabet();
        morse.createTables();
        morse.equals(morse.alphabets);
    }
    @Test
    public void convertingAlphabetsToMorseOk(){
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
    public void convertingMorseToAlphabets(){
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
    
    //Test that check if input is not allowed for conversion
}
