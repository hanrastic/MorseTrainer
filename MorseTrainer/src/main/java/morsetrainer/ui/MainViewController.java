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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;  
import javafx.stage.Stage;
import morsetrainer.domain.TrainerFunctionality;
import morsetrainer.domain.UserActions;
import morsetrainer.domain.UserInfo;


public class MainViewController {
    
    TrainerFunctionality functionality = new TrainerFunctionality();
    UserInfo userInfo = new UserInfo();
    UserActions userAction = new UserActions();
    private static String username;
    private static String password;
    private static int highscore;
    
    
    @FXML
    private Button changeModeButton;
    
    @FXML
    private Button trainButton;
    
    @FXML
    private Button logInButton;
    
    @FXML
    private Button createAccountButton;
    
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
        Alert alert = new Alert(AlertType.INFORMATION);

        changeModeButton.setGraphic(buttonFaceView);
        highscoreLabel.setDisable(true);
        setSavedUI();

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
                    if (trainButton.getText().equals("Translate")) {
                        textAreaLeft.setText(functionality.randomValue(difficultySlider.getValue()));
                        textAreaRight.setPromptText("Write your answer as a text character here and press 'enter'.");
                    }
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
                    answerStatus.setText("Wrong answer, better luck next time");
                    System.out.println("Nykyisen käyttäjän username: " + userInfo.getUsername());
                    if(userInfo.getUsername() != null){
                        System.out.println(Integer.parseInt(scoreValue.getText()));
                        userAction.updateUserHighscoreToDB(username, Integer.parseInt(scoreValue.getText()));
                        highscoreValue.setText(Integer.toString(userAction.getUserHighscoreFromDB(username)));
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
                    alert.setTitle("Account created!");
                    String s = "Account has been created! \nYou can now log in.";
                    alert.setContentText(s);
                    alert.showAndWait();
                } else
                {
                    System.out.println("Account creation failed.");
                    alert.setTitle("Creating account failed");
                    String s = "Make sure that either of the fields are not empty \nor consider trying different username.";
                    alert.setContentText(s);
                    alert.showAndWait();
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
                    userInfo.setPassword(passwordTextField.getText().trim());
                    saveUiInfo();
                    logInStatus.setText("Logged In as: " + usernameTextField.getText());
                    highscoreLabel.setDisable(false);
                    highscoreValue.setText(Integer.toString(userAction.getUserHighscoreFromDB(usernameTextField.getText())));
                } else {
                    System.out.println("Log in failed");
                    alert.setTitle("Login failed");
                    String alertString = "Please log in with a valid user name and password !";
                    alert.setContentText(alertString);
                    alert.showAndWait();
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
    *  Method for saving user info to static variables.
    *  Necessary for changing view to E.G info and back to main.
    */
    @FXML
    private void saveUiInfo() {        
        username = userInfo.getUsername();
        password = userInfo.getPassword();
        highscore = userAction.getUserHighscoreFromDB(username);      
    }
    
    /**
    *  Method for setting user info to original when coming back from different view
    */
    @FXML
    public void setSavedUI() {       
        if (username != null) {
            logInStatus.setText("Logged In as: " + username);
            highscoreLabel.setDisable(false);
            highscoreValue.setText(Integer.toString(userAction.getUserHighscoreFromDB(username)));
        }
    }
    
    /**
    * Changes the view to infoView
    */
    @FXML
    public void changeViewToInfo(ActionEvent event) throws IOException, SQLException {
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
}
