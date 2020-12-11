package morsetrainer.ui;

import java.io.IOException;
import java.sql.SQLException;
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

//    @FXML
//    private Button highscoreButton; 
    
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
    private Label highscoreLabel;
    
    @FXML
    private Label highscoreValue;
    
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
        double sliderValue = difficultySlider.getValue();
        //final URL resource = getClass().getResource("resources/b1s.wav");
        changeModeButton.setGraphic(buttonFaceView);
        highscoreLabel.setDisable(true);
        
        changeModeButton.setOnAction((event) -> {  
            System.out.println("Change mode button action Action");
            changeModeButton.getTransforms().add(new Rotate(90,100,100,0));
            textAreaLeft.setText("");
            textAreaRight.setText("");
            
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
                scoreLabel.setText("Score:");
                scoreValue.setText(Integer.toString(0));
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
        });
        
        textAreaRight.setOnKeyPressed(event -> {           
            if(trainButton.getText().equals("Translate") && event.getCode() == KeyCode.ENTER){
                System.out.println("Enter pressed");
                String convertableMorse = textAreaLeft.getText().replaceAll("\\s+", " ");
                String inputLetters = textAreaRight.getText().toLowerCase().trim();
                scoreLabel.setText("Score: ");

                
                if(functionality.checkIfMorseIsCorrect(convertableMorse, inputLetters)){                    
                    answerStatus.setText("Correct answer!");
                    scoreValue.setText(Integer.toString(userInfo.addToCurrentScore((int)difficultySlider.getValue())));
                    textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                    textAreaRight.clear();
                }else{
                    System.out.println("Nykyisen käyttäjän username: " + userInfo.getUsername());
                    if(userInfo.getUsername() != null){
                        System.out.println(Integer.parseInt(scoreValue.getText()));
                        userAction.updateUserHighscoreToDB(userInfo.getUsername(), Integer.parseInt(scoreValue.getText()));
                        highscoreValue.setText(Integer.toString(userAction.getUserHighscoreFromDB(userInfo.getUsername())));
                    }else 
                    answerStatus.setText("Wrong answer, better luck next time");
                    scoreValue.setText(Integer.toString(0));
                    userInfo.setScoreToZero();
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
            }
        });
        
        createAccountButton.setOnAction((event) -> {
            System.out.println("Create account Button action");
            try {
                if(userAction.createAccount(usernameTextField.getText(), passwordTextField.getText())) {
                    System.out.println("Account created.");
                } else
                {
                    System.out.println("Account creation failed.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }   
            usernameTextField.clear();
            passwordTextField.clear();               
        });
        
        logInButton.setOnAction((event) -> {
            System.out.println("Log in Button action");
            try {
                if(userAction.logIn(usernameTextField.getText().trim(), passwordTextField.getText().trim())){
                    userInfo.setUsername(usernameTextField.getText().trim());
                    logInStatus.setText("Logged In as: " + usernameTextField.getText());
                    highscoreLabel.setDisable(false);
                    highscoreValue.setText(Integer.toString(userAction.getUserHighscoreFromDB(usernameTextField.getText())));
                    System.out.println("Log In Ok in Controller");
                } else {
                    System.out.println("Log in failed");
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
            }   
            usernameTextField.clear();
            passwordTextField.clear();  
        });
    }
    
    @FXML
    private void convertTextToMorse() throws IOException {
        textAreaRight.setText(functionality.convertMultipleLettersToMorse(textAreaLeft.getText().toLowerCase()));
    }
    
    @FXML
    private void convertMorseToText() throws IOException {
        textAreaRight.setText(functionality.convertMultipleMorsecodeToAlphabets(textAreaLeft.getText().toLowerCase()));
    }
    
    /**
    * Changes the view to infoView
    */
    @FXML
    public void changeViewToInfo(ActionEvent event) throws IOException {
        Parent infoViewParent = FXMLLoader.load(getClass().getResource("InfoView.fxml"));
        Scene infoViewScene = new Scene(infoViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(infoViewScene);
        window.show();
    }
    
    /**
    * Changes the view to alphabetTableView
    */
    @FXML
    public void changeViewToAlphabetTableInfo(ActionEvent event) throws IOException {
        Parent infoViewParent = FXMLLoader.load(getClass().getResource("AlphabetTableView.fxml"));
        Scene infoViewScene = new Scene(infoViewParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(infoViewScene);
        window.show();
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
}
