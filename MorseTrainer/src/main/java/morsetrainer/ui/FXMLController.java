/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.ui;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;  

public class FXMLController {
    
    @FXML
    private Button changeModeButton;
    
    @FXML
    private Button trainButton;
    
    @FXML
    private Label textLabel;
    
    @FXML
    private Label morseLabel;
    
    @FXML
    private TextArea textAreaLeft;
    
    @FXML
    private TextArea textAreaRight;
    
    public void initialize() {
        Image buttonFace = new Image(getClass().getResourceAsStream("Recycle.png"));
        ImageView buttonFaceView = new ImageView(buttonFace);
        //final URL resource = getClass().getResource("resources/b1s.wav");
        changeModeButton.setGraphic(buttonFaceView);
        changeModeButton.setOnAction((event) -> {  
            // Button was clicked, do something...
            System.out.println("Button Action");
            changeModeButton.getTransforms().add(new Rotate(90,100,100,0));
            if(trainButton.getText().equals("Train")) {               
                if(morseLabel.getText().equals("Morse")) {
                    textLabel.setText("Morse");
                    morseLabel.setText("Text");
                    textAreaLeft.setPromptText("Write text here...");
                    textAreaRight.setPromptText("Displays text as Morse code.");
                } else {
                    textLabel.setText("Text");
                    morseLabel.setText("Morse"); 
                    textAreaLeft.setPromptText("Write Morse code here...");
                    textAreaRight.setPromptText("Displays Mode code as text.");
                }
            }
            else {
                if(morseLabel.getText().equals("Morse")) {
                    textLabel.setText("Morse");
                    morseLabel.setText("Text");
                    textAreaLeft.setPromptText("A random text character will appear here...");
                    textAreaRight.setPromptText("Write your answer as a Morse code.");
                } else {
                    textLabel.setText("Text");
                    morseLabel.setText("Morse"); 
                    textAreaLeft.setPromptText("A random Morse code will apper here...");
                    textAreaRight.setPromptText("Write your answer as a text character here.");
                }
            }
        });
        trainButton.setOnAction((event) -> {  
            // Button was clicked, do something...
            System.out.println("Train Button Action");
            if(trainButton.getText().equals("Translate")) {
                trainButton.setText("Train");
                if(morseLabel.getText().equals("Morse")) {
                     textAreaLeft.setPromptText("Write Morse code here...");
                    textAreaRight.setPromptText("Displays Mode code as text.");                  
                } else {                   
                    textAreaLeft.setPromptText("Write text here...");
                    textAreaRight.setPromptText("Displays text as Morse code.");
                }  
            }  
            else {
                trainButton.setText("Translate");
                if(morseLabel.getText().equals("Morse")) {
                    textAreaLeft.setPromptText("A random Morse code will apper here...");
                    textAreaRight.setPromptText("Write your answer as a text character here.");
                } else {
                    textAreaLeft.setPromptText("A random text character will appear here...");
                    textAreaRight.setPromptText("Write your answer as a Morse code."); 
                }
            }
        });
    }
    
    @FXML
    private void switchToTextToMorse() throws IOException {
        
    }
    
//        textAreaLeft.setOnKeyTyped((event) -> {
//            // Key was typed, do something...
//            System.out.println("TextArea Key Typed Action");
//            if(textAreaLeft.getText().endsWith(" ")) {
//                System.out.println("Space Key press observed.");
//            }
//            else if (textAreaLeft.getText().endsWith("-")) {
//                AudioClip beep0408Sound = new AudioClip(getClass().getResource("b1s0408.wav").toString());
//                //beep0408Sound.setPriority(1);
//                //beep0408Sound.setCycleCount(3);
//                beep0408Sound.play();
//            }
//            else if (textAreaLeft.getText().endsWith(".")) {
//                AudioClip beep0208Sound = new AudioClip(getClass().getResource("b1s0208.wav").toString());
//                //beep0208Sound.setPriority(1);
//                //beep0208Sound.setCycleCount(3);
//                beep0208Sound.play();
//            }
//            
//            // Here we just append characters one by one... This is the place to call helper method for Mode code to text conversion and vice versa.
//            // Remember to check the mode first so that we know if we are parsing Morse code to text or text to Morse code.
//            // Its is best to separate Morse codes by Space " " to make them easily recognizeable.
//            textAreaRight.appendText(textAreaLeft.getText().substring(textAreaLeft.getText().length()-1, textAreaLeft.getText().length()));
//            // If we are typing - character we hear a long beep and if . character we hear a short beep.
//            
//        });
    

//    @FXML
//    private void switchToSecondary() throws IOException {
//        MorseTrainerUi.setRoot("secondary");
//    }
    
    
}
