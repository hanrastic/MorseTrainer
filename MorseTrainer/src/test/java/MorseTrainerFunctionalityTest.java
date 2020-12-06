import morsetrainer.domain.MorseAlphabet;
import morsetrainer.domain.TrainerFunctionality;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author joonas
 */
public class MorseTrainerFunctionalityTest {
    
    TrainerFunctionality morse;
    MorseAlphabet tables;
    String input;
    String validOutput;

    @Before
    public void setUp(){
        morse = new TrainerFunctionality();
        tables = new MorseAlphabet();
        input = new String();
        validOutput = new String();
    }
    
//    @Test
//    public void creatingAlphabetsToMorseTableisIsOk(){
//        morse.createAlphabetTable();
//        morse.equals(morse.alphabets);
//    }
    @Test
    public void convertingAlphabetsToMorseIsOk(){
        //Converting alphabets to morse is ok
        
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
    public void convertingMorseToAlphabetIsOkWithInvalidInput(){
        //Converting morse to alphabet returns null if input is invalid. E.G. alphabet, integer or invalid morsecode
        input = "----";
        assertEquals(morse.getAlphabetFromMorse(input), null);
        input = "7";
        assertEquals(morse.getAlphabetFromMorse(input), null);
        input = "k";
        assertEquals(morse.getAlphabetFromMorse(input), null);
    }
    
    @Test
    public void convertingIntegersToMorseIsOk(){
        //All integers Ok (0-9)
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getMorsecodeFromInteger(integer), tables.numbers.get(integer));
        }
    }
    
    @Test
    public void convertingMorseToIntegersIsOk(){
        //Test that converting morse to corresponfing integer (0-9) is ok
        for (int integer = 0; integer < 10 ; integer++){
            assertEquals(morse.getIntegerFromMorse(morse.getMorsecodeFromInteger(integer)), integer);
        }

    }
    
    @Test
    public void testIfInputIsNumeriIsOk(){
        input = "notANumber";
        assertFalse(morse.testIfInputIsNumeric(input));
    }
    
    @Test
    public void testIfInputIsAllowedOrNumericIsOk() {
        
        input = "owekf%&ookkf"; //Not allowed input       
        assertTrue(morse.testIfInputIsAllowedOrNumeric(input));
        
        input = "   43r54rrrtyr 45erfokw !"; //Not allowed input
        assertTrue(morse.testIfInputIsAllowedOrNumeric(input));
    }
    
    @Test
    public void testIfConvertingMultipleLettersToMorseIsOk() {
        //Converts alphabets and integers to morse correctly
        input = "o k k k o y g i i u h i l i u h y i g  9 9 9 9 12123";
        validOutput = "--- -.- -.- -.- --- -.-- --. .. .. ..- .... .. .-.. .. ..- .... -.-- .. --. ----. ----. ----. ----. .---- ..--- .---- ..--- ...-- ";
        assertEquals(morse.convertMultipleLettersToMorse(input), validOutput);
    }
    
    @Test
    public void testThatConvertingMultipleLettersToMorseIsOkWithInvalidInput() {
        //Ignores invalid input and converts all valid input
        input = "( / = ) j q w h f u w h f ( ) = ";
        validOutput = ".--- --.- .-- .... ..-. ..- .-- .... ..-. ";
        assertEquals(morse.convertMultipleLettersToMorse(input), validOutput);
    }
    
    @Test
    public void testThatConvertingMultipleMorseToAlphabetsIsOk() {
        //Converts morsecode to alphabets and integers correctly
        input = "-.- ----- -.-- --- . . ... ..--- - .. .--. .---- .--- .---";
        validOutput = "k 0 y o e e s 2 t i p 1 j j ";
        assertEquals(morse.convertMultipleMorsecodeToAlphabets(input), validOutput);
    }
    
    @Test
    public void testThatConvertingMultipleMorseToAlphabetsIsOkWithInvalidInput() {
        //Ignores invalid input and converts valid input
        input = "... 45678iko9876rd .-. /)(/&%&/( ..... -.-       .-.. .-..";
        validOutput = "s r 5 k l l ";
        assertEquals(morse.convertMultipleMorsecodeToAlphabets(input), validOutput);
    }
}

