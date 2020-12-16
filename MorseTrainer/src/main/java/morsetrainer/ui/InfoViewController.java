package morsetrainer.ui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author joonas
 */
public class InfoViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Changes the view to mainView
     */
    @FXML
    public void changeViewToMain(ActionEvent event) throws IOException, SQLException {

        Parent infoViewParent = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        Scene infoViewScene = new Scene(infoViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(infoViewScene);
        window.show();
    }
    
}
