package HomeBase.heap;

import HomeBase.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Mitchell on 4/7/2017.
 */
public class heapSubController{

    private int[] inputArray;

    @FXML
    private Button finishButton;
    @FXML
    private Button cancelButton;
    @FXML
    private CheckBox topDown;
    @FXML
    private CheckBox bottomUp;
    @FXML
    private TextField inputField;
    @FXML
    private Label badInput;



    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        if (event.getSource() == finishButton) {

            sanitizeInput(inputField.getText());

            if (!badInput.isVisible()) {

                GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                int width = gd.getDisplayMode().getWidth();
                int height = gd.getDisplayMode().getHeight();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("heap/heapMain.fxml"));
                BorderPane heapSub = loader.load();


                Stage heapStage = new Stage();
                heapStage.setTitle("Heap Main");

                heapStage.initModality(Modality.WINDOW_MODAL);
                heapStage.initOwner(finishButton.getScene().getWindow());

                Scene scene = new Scene(heapSub, width, height);
                heapStage.setScene(scene);

                heapMainController mainController = loader.<heapMainController>getController();
                mainController.setUserInput(inputField.getText());
                mainController.getCheckBox(bottomUp.isSelected());

                heapStage.showAndWait();

                stage = (Stage) finishButton.getScene().getWindow();
                stage.close();


            }
        }
        if (event.getSource() == cancelButton) {
            stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }
    @FXML
    private void handleTopButton(ActionEvent event) throws IOException {
        if (topDown.isSelected()) {
            bottomUp.setSelected(false);
        }
    }
    @FXML
    private void handleBottomButton(ActionEvent event) throws IOException{
        if (bottomUp.isSelected()) {
            topDown.setSelected(false);
        }
    }
    private void sanitizeInput(String string) {
        String[] inputArray = string.replaceAll(" ","").split(",");
        int[] sanitizedArray = new int[inputArray.length];

        for(int i=0;i<inputArray.length; i++)
        {
            try{
                sanitizedArray[i]= Integer.parseInt(inputArray[i]);
                badInput.setVisible(false);
            }
            catch(NumberFormatException ex){

                badInput.setText("Please use integers.");
                badInput.setVisible(true);
                inputField.clear();
                break;
            }
        }
        if(!topDown.isSelected() && !bottomUp.isSelected()){
            badInput.setText("Please choose check box.");
            inputField.clear();
            badInput.setVisible(true);
        }
        if(inputArray.length % 2 == 0){
            badInput.setText("Heap is not balanced.");
            inputField.clear();
            badInput.setVisible(true);

        }
        if(inputArray.length > 15){
            badInput.setText("Input more than 15 integers.");
            inputField.clear();
            badInput.setVisible(true);
        }
    }
}
