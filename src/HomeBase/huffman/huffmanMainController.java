package HomeBase.huffman;

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
public class huffmanMainController {
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

    private String charInput;
    private String freqInput;
    private int[] finalArray;

    public void setUserInput(String mainString, String sString){
        charInput = mainString;
        freqInput = sString;

        String[] inputArray = charInput.replaceAll(" ","").split(",");
        String[] freqInputArray = freqInput.replaceAll(" ","").split(",");
        finalArray = new int[freqInputArray.length];
        for(int i=0;i<inputArray.length; i++)
        {
            try{
                finalArray[i]= Integer.parseInt(freqInputArray[i]);
            }
            catch(NumberFormatException ex){
                System.out.println("Error on capturing input.");
            }
        }
        for(int i=0;i<inputArray.length;i++){
            System.out.println(inputArray[i]);
            System.out.println(finalArray[i]);
        }
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