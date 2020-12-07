package morsetrainer.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
//import javafx.scene.media.AudioClip;
import javafx.scene.transform.Rotate;  
import javafx.stage.Stage;
import morsetrainer.domain.TrainerFunctionality;
import morsetrainer.domain.UserActions;
import morsetrainer.domain.UserInfo;


public class MainViewController {
    
    TrainerFunctionality functionality = new TrainerFunctionality();
    UserInfo userInfo = new UserInfo();
    UserActions userAction = new UserActions();
    
    
    @FXML
    private Button changeModeButton;
    
    @FXML
    private Button trainButton;
    
    @FXML
    private Button logInButton;
    
    @FXML
    private Button createAccountButton;

    @FXML
    private Button highscoreButton; 
    
    @FXML
    private Slider difficultySlider;
    
    @FXML
    private Label textLabel;
    
    @FXML
    private Label morseLabel;
    
    @FXML
    private Label modeLabel;
    
    @FXML
    private Label answerStatus;
       
    @FXML
    private Label scoreLabel;    
    
    @FXML
    private Label scoreValue;
    
    @FXML
    private Text logInStatus;
    
    @FXML
    private TextArea textAreaLeft;
    
    @FXML
    private TextArea textAreaRight;
    
    @FXML
    private TextField usernameTextField;
    
    @FXML
    private TextField passwordTextField;
    
    public void initialize() {
        Image buttonFace = new Image(getClass().getResourceAsStream("Recycle.png"));
        ImageView buttonFaceView = new ImageView(buttonFace);
        double value = difficultySlider.getValue();
        //final URL resource = getClass().getResource("resources/b1s.wav");
        changeModeButton.setGraphic(buttonFaceView);
        
        changeModeButton.setOnAction((event) -> {  
            // Button was clicked, do something...
            System.out.println("Button Action");
            changeModeButton.getTransforms().add(new Rotate(90,100,100,0));
            //Empty fields from letters and morse
            textAreaLeft.setText("");
            textAreaRight.setText("");
            //Set textfield text according to translate mode            
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
                    textAreaLeft.setPromptText("Training not available for text to morse conversion.");
                    textAreaRight.setPromptText("");
                } else {
                    textLabel.setText("Text");
                    morseLabel.setText("Morse"); 
                    textAreaLeft.setPromptText("A random Morse code will apper here...");
                    textAreaRight.setPromptText("Write your answer as a text character here ans press 'enter'.");
                }
            }
        });
        trainButton.setOnAction((event) -> {  
            System.out.println("Train Button Action");
            if(trainButton.getText().equals("Translate")) {
                textAreaLeft.setDisable(false);
                textAreaLeft.clear();
                trainButton.setText("Train");
                modeLabel.setText("Translate mode");
                if(morseLabel.getText().equals("Morse")) {
                     textAreaLeft.setPromptText("Write Morse code here...");
                    textAreaRight.setPromptText("Displays Mode code as text.");                  
                } else {                   
                    textAreaLeft.setPromptText("Write text here...");
                    textAreaRight.setPromptText("Displays text as Morse code.");
                }  
            }  
            else {
                textAreaLeft.setDisable(true);
                textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                trainButton.setText("Translate");
                modeLabel.setText("Training mode");
                if(morseLabel.getText().equals("Morse")) {
                    textAreaLeft.setPromptText("A random Morse code will apper here...");
                    textAreaRight.setPromptText("Write your answer as a text character here.");
                } else {
                    textAreaLeft.setPromptText("A random text character will appear here...");
                    textAreaRight.setPromptText("Write your answer as a Morse code here"); 
                }
            }
            //Set random character as text to the left field
            //textAreaLeft.setText(arg0);
            //User types in answer to the right textfield
            //Create method that checks if answer is correct. If it empty both fields and generate new random letter to the left text field.
            //
            
            
        });
        textAreaLeft.setOnKeyTyped((event) -> {
            if(morseLabel.getText().equals("Morse")) {
                try {
                    convertMorseToText();
                } catch (IOException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(morseLabel.getText().equals("Text")) {
                try {
                    convertTextToMorse();
                } catch (IOException ex) {
                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(textAreaLeft.getText().isEmpty()){
                textAreaLeft.setText("");
            }
//            // Key was typed, do something...
//            System.out.println("TextArea Key Typed Action");
//            if(textAreaLeft.getText().charAt(textAreaLeft.getText().length()-2)) {
//                System.out.println("Space Key press observed.");
//                try {
//                    convertTextToMorse();
//                } catch (IOException ex) {
//                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            else if (textAreaLeft.getText().endsWith("-") || textAreaLeft.getText().endsWith(".")) {
//                try {
//                    convertMorseToText();
//                } catch (IOException ex) {
//                    Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                    //AudioClip beep0408Sound = new AudioClip(getClass().getResource("b1s0408.wav").toString());
//                    //beep0408Sound.setPriority(1);
//                    //beep0408Sound.setCycleCount(3);
//                    //beep0408Sound.play();
//            }
////            else if (textAreaLeft.getText().endsWith(".")) {
////                //AudioClip beep0208Sound = new AudioClip(getClass().getResource("b1s0208.wav").toString());
////                //beep0208Sound.setPriority(1);
////                //beep0208Sound.setCycleCount(3);
////                //beep0208Sound.play();
////            }
////            
////            // Here we just append characters one by one... This is the place to call helper method for Mode code to text conversion and vice versa.
////            // Remember to check the mode first so that we know if we are parsing Morse code to text or text to Morse code.
////            // Its is best to separate Morse codes by Space " " to make them easily recognizeable.
////                textAreaRight.appendText(textAreaLeft.getText().substring(textAreaLeft.getText().length()-1, textAreaLeft.getText().length()));
////            // If we are typing - character we hear a long beep and if . character we hear a short beep.
////            
        });
        textAreaRight.setOnKeyPressed(event -> {
            
            if(trainButton.getText().equals("Translate") && event.getCode() == KeyCode.ENTER){
                System.out.println("Enter pressed");
                String convertableMorse = textAreaLeft.getText().replaceAll("\\s+", " ");
                String inputLetters = textAreaRight.getText().trim();
                scoreLabel.setText("Score: ");

                
                if(functionality.checkIfMorseIsCorrect(convertableMorse, inputLetters)){                    
                    answerStatus.setText("Correct answer!");
                    scoreValue.setText(Integer.toString(userInfo.addToCurrentScore((int)difficultySlider.getValue())));
                    textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                    textAreaRight.clear();
                }else{
                    answerStatus.setText("Wrong answer, better luck next time");
                    userInfo.setScoreToZero();
                    scoreValue.setText(Integer.toString(userInfo.getScore()));
                    textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                    textAreaRight.clear();                    
                }
            }
        });
        
        difficultySlider.setOnMouseReleased((event) -> {
            System.out.println("Difficulty Slider action");
            if(trainButton.getText().equals("Translate")){
                textAreaLeft.setDisable(true);
                textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                System.out.println(value);
            }
        });
        
        createAccountButton.setOnAction((event) -> {
                System.out.println("Create account Button action");
                userAction.createAccount(usernameTextField.getText(), passwordTextField.getText());
        });
    }
    
    @FXML
    private void switchToTextToMorse() throws IOException {
        
    }
    
    @FXML
    private void convertTextToMorse() throws IOException {
        textAreaRight.setText(functionality.convertMultipleLettersToMorse(textAreaLeft.getText()));
    }
    
    @FXML
    private void convertMorseToText() throws IOException {
        textAreaRight.setText(functionality.convertMultipleMorsecodeToAlphabets(textAreaLeft.getText()));
    }
    
    //When this method is called it changes the scene to infoView
    @FXML
    public void changeViewToInfo(ActionEvent event) throws IOException {
        Parent infoViewParent = FXMLLoader.load(getClass().getResource("InfoView.fxml"));
        Scene infoViewScene = new Scene(infoViewParent);
        
        //this line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(infoViewScene);
        window.show();
    }
    
    @FXML
    public void changeViewToAlphabetTableInfo(ActionEvent event) throws IOException {
        Parent infoViewParent = FXMLLoader.load(getClass().getResource("AlphabetTableView.fxml"));
        Scene infoViewScene = new Scene(infoViewParent);
        
        //this line gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(infoViewScene);
        window.show();
    }
    
    

//    @FXML
//    private void switchToSecondary() throws IOException {
//        MorseTrainerUi.setRoot("secondary");
//    }
    
    
}
