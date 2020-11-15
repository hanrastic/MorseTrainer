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
            introTextField.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
                //Train button Gridpane(2,1)
                Button trainButton = new Button("Train");
                trainButton.setPadding(new Insets(20,30,20,30));
                    //VBox for logging in and create new account Gridpane (0,1)
                    TextField username = new TextField("username");
                    TextField password = new TextField("password");
                    Button logIn = new Button("logIn");
                    Button createAccount = new Button ("create account");

                    VBox signInColumn = new VBox();
                    signInColumn.setSpacing(10);
                    signInColumn.setPadding(new Insets(20,30,20,30));
                    signInColumn.getChildren().add(username);
                    signInColumn.getChildren().add(password);
                    signInColumn.getChildren().add(logIn);
                    signInColumn.getChildren().add(createAccount);                   
                        //Info pop-up button Gridpane (2,2)
                        Button popupButton = new Button ("info");
                        popupButton.setPadding(new Insets (5,30,5,30));
          
                       
        GridPane layout = new GridPane();
        
        //layout.setSize(600, 300);
                                    //Top, Right, Bottom, Left
        layout.setPadding(new Insets(5,30,30,30));
        layout.setAlignment(Pos.CENTER);
        
        layout.add(introTextField,0,0);
        layout.add(trainButton,0,1);
        layout.add(signInColumn, 1, 1);
        layout.add(popupButton, 0, 2);
        
        Scene mainScene = new Scene(layout);
        
        
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        //login/signup scene
//        
//        GridPane grid = new GridPane();
//        grid.setAlignment(Pos.CENTER);
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(25, 25, 25, 25));
//
//        Scene login_createAccountScene = new Scene(grid, 300, 275);
//        primaryStage.setScene(scene);
//
//        Text sceneTitle = new Text("Here you can log in or create a new account!");
//        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
//        grid.add(sceneTitle, 0, 1);
        
        
        
    }

    

    public static void main(String[] args) {
        launch(args);
    }
    
}
