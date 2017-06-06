package HomeBase.prims;

import HomeBase.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * Created by Mitchell on 4/10/2017.
 */
public class primsMainController {
    private Main Main;
    private static Stage primaryStage;
    private BorderPane mainLayout;

    @FXML
    private MenuItem mainMenu;
    @FXML
    private MenuItem undo;
    @FXML
    private MenuItem close;
    @FXML
    private MenuBar myMenu;
    @FXML
    private Button stepButton;

    private boolean example1;
    private boolean example2;
    private boolean example3;

    public void getUserInput(boolean boolean1,boolean boolean2, boolean boolean3){
        example1 = boolean1;
        example2 = boolean2;
        example3 = boolean3;
        System.out.println(example1+"\n"+example2+"\n"+example3);
    }
    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == mainMenu) {
            stage = (Stage) myMenu.getScene().getWindow();
            stage.close();
        }
        //implement undo here with logic.
        if (event.getSource() == close) {
            Platform.exit();
            System.exit(0);
        }

    }
    @FXML
    private void handleStepAction(ActionEvent event) throws IOException{

    }
}
