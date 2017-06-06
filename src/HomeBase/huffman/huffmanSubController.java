package HomeBase.huffman;

import HomeBase.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


/**
 * Created by Mitchell on 4/7/2017.
 */
public class huffmanSubController {

    private Main Main;
    private static Stage primaryStage;
    private BorderPane mainLayout;
    @FXML
    private Button finishButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField charInput;
    @FXML
    private TextField freqInput;
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

            String userCharInput = charInput.getText();
            String userFreqInput = freqInput.getText();

            sanitizeInput(userCharInput,userFreqInput);

            if(!badInput.isVisible()) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(Main.class.getResource("huffman/huffmanMain.fxml"));
                BorderPane heapSub = loader.load();

                Stage heapStage = new Stage();
                heapStage.setTitle("Huffman Main");
                heapStage.initModality(Modality.WINDOW_MODAL);
                heapStage.initOwner(finishButton.getScene().getWindow());

                Scene scene = new Scene(heapSub, width, height);
                heapStage.setScene(scene);

                huffmanMainController mainController = loader.<huffmanMainController>getController();
                mainController.setUserInput(charInput.getText(),freqInput.getText());

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
    private void sanitizeInput(String charString, String freqString) {
        String[] charInputArray = charString.replaceAll(" ","").split(",");
        String[] freqInputArray = freqString.replaceAll(" ","").split(",");

        char[] sanitizedCharArray = new char [charInputArray.length];
        int[] sanitizedFreqArray = new int[freqInputArray.length];

        for(int i=0;i<freqInputArray.length; i++)
        {
            try{
                badInput.setVisible(false);
                sanitizedFreqArray[i]= Integer.parseInt(freqInputArray[i]);
            }
            catch(NumberFormatException ex){
                freqInput.clear();
                badInput.setText("Use integers for frequency.");
                badInput.setVisible(true);
            }
        }
        if(charInputArray.length != freqInputArray.length){
            badInput.setVisible(true);
            badInput.setText("Input length mismatch.");
            charInput.clear();
            freqInput.clear();
        }
    }
}
