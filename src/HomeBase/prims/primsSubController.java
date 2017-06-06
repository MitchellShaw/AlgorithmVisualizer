package HomeBase.prims;

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
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by Mitchell on 4/7/2017.
 */
public class primsSubController {

    private Main Main;
    private static Stage primaryStage;
    private BorderPane mainLayout;
    @FXML
    private Button finishButton;
    @FXML
    private Button cancelButton;
    @FXML
    private CheckBox example1;
    @FXML
    private CheckBox example2;
    @FXML
    private CheckBox example3;
    @FXML
    private Label badInput;


    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        Stage stage;
        Parent root;
        if (event.getSource() == finishButton) {

            handleError();
            if (!badInput.isVisible()) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("prims/primsMain.fxml"));
                BorderPane heapSub = loader.load();

                Stage heapStage = new Stage();
                heapStage.setTitle("Prim's Main");
                heapStage.initModality(Modality.WINDOW_MODAL);
                heapStage.initOwner(finishButton.getScene().getWindow());

                Scene scene = new Scene(heapSub, width, height);
                heapStage.setScene(scene);

                primsMainController mainController = loader.<primsMainController>getController();
                mainController.getUserInput(example1.isSelected(),example2.isSelected(),example3.isSelected());

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
    @FXML
    private void handleTopButton(ActionEvent event) throws IOException {
        if (example1.isSelected()) {
            example2.setSelected(false);
            example3.setSelected(false);
        }
    }
    @FXML
    private void handleMiddleButton(ActionEvent event) throws IOException {
        if (example2.isSelected()) {
            example1.setSelected(false);
            example3.setSelected(false);
        }
    }
    @FXML
    private void handleBottomButton(ActionEvent event) throws IOException {
        if (example3.isSelected()) {
            example1.setSelected(false);
            example2.setSelected(false);
        }
    }
    private void handleError(){
        if(!example1.isSelected() && !example2.isSelected() && !example3.isSelected()){
            badInput.setVisible(true);
        }
        else{
            badInput.setVisible(false);
        }
    }
}
