/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morsetrainer.ui;

import javafx.geometry.Insets; 
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author joonas
 */
public class MorseTrainerUi extends Application {
    //Stage = ikkuna kokonaisuudessaan
    //Scene = näkymä ikkunassa
    @Override
    public void start(Stage primaryStage) {
        //starting scene
        primaryStage.setTitle("MorseTrainer");
            //SceneTitle Gridpane (1,0)
            Text introTextField = new Text("MorseTrainer 2.0");
            introTextField.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
            
                //Train button Gridpane(2,1)
                Button trainButton = new Button("Train");
                trainButton.setPadding(new Insets(23,30,23,30));
                    //Info pop-up button Gridpane (2,2)
                    Button infoButton = new Button ("Info");
                    infoButton.setPadding(new Insets (20,32,20,32));
                            
                        //vBox for buttons
                        VBox buttonColumn = new VBox();
                        buttonColumn.setSpacing(10);
                        buttonColumn.setPadding(new Insets(20,30,20,30));
                        buttonColumn.getChildren().add(infoButton);
                        buttonColumn.getChildren().add(trainButton);
                            //VBox for logging in and create new account Gridpane (0,1)
                            TextField username = new TextField();
                            username.setPromptText("username");
                            PasswordField password = new PasswordField();
                            password.setPromptText("password");
                            Button logIn = new Button("log In");
                            Button createAccount = new Button ("create account");

                            VBox signInColumn = new VBox();
                            signInColumn.setSpacing(10);
                            signInColumn.setPadding(new Insets(20,30,20,30));
                            signInColumn.getChildren().add(username);
                            signInColumn.getChildren().add(password);
                            signInColumn.getChildren().add(logIn);
                            signInColumn.getChildren().add(createAccount);                   
                     
        GridPane layout = new GridPane();
        
       
                                    //Top, Right, Bottom, Left
        layout.setPadding(new Insets(5,30,30,30));
        layout.setAlignment(Pos.CENTER);
        GridPane.setMargin(introTextField, new Insets(0,0,0,32));
        layout.add(introTextField,0,0);
        layout.add(buttonColumn,0,1);
        layout.add(signInColumn, 1, 1);
        
        Scene mainScene = new Scene(layout);
        
        
        
        //Info Scene
        String text = "Welcome to Morsetrainer! \n "
                    + "\nThis application is for learning Morse code. Application offers an training mode where you can get to know morse as well as practice converting letters. \n"
                    + "\nYou can also log in or create account in the main menu. Do this to keep track of your progress. ";
        Text infoText = new Text(text);
        Button backToPrimaryButton = new Button("Back to main menu");
        
        GridPane infoLayout = new GridPane();
        infoLayout.setPadding(new Insets(20,20,20,20));
        infoLayout.setVgap(30);
        infoLayout.add(infoText, 0, 0);
        infoLayout.add(backToPrimaryButton, 0, 2);
        Scene infoScene = new Scene(infoLayout);       
        infoButton.setOnAction(e -> primaryStage.setScene(infoScene));
        backToPrimaryButton.setOnAction(e -> primaryStage.setScene(mainScene));
        
        
        
        
        primaryStage.setScene(mainScene);
        primaryStage.show();   
    }

    

    public static void main(String[] args) {
        launch(args);
    }
    
}
