package HomeBase.horspool;

import HomeBase.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;




public class horspoolSubController {

    private Main Main;
    private static Stage primaryStage;
    private BorderPane mainLayout;
    @FXML
    private Button finishButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label badInput;
    @FXML
    private TextField stringInput;
    @FXML
    private TextField subStringInput;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        Stage stage;
        Parent root;

        String userStringInput = stringInput.getText();
        String userSubStringInput= subStringInput.getText();

        sanitizeInput(userStringInput,userSubStringInput);

        if (event.getSource() == finishButton) {
            if(!badInput.isVisible()) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("horspool/horspoolMain.fxml"));
                BorderPane heapSub = loader.load();

                Stage heapStage = new Stage();
                heapStage.setTitle("Horspool Main");
                heapStage.initModality(Modality.WINDOW_MODAL);
                heapStage.initOwner(finishButton.getScene().getWindow());

                Scene scene = new Scene(heapSub, width, height);
                heapStage.setScene(scene);

                horspoolMainController mainController = loader.<horspoolMainController>getController();
                mainController.setUserInput(stringInput.getText(),subStringInput.getText());

                heapStage.showAndWait();

                stage = (Stage) finishButton.getScene().getWindow();
                stage.close();
            }
        }
        if (event.getSource() ==cancelButton)
        {
            stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }
    private void sanitizeInput(String string, String subString){
        if(subString.length() >string.length()) {
            badInput.setText("Substring longer than string.");
            badInput.setVisible(true);
            stringInput.clear();
            subStringInput.clear();
        }
        else{
            badInput.setVisible(false);
        }

    }
}
