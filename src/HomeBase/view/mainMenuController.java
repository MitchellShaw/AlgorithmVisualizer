package HomeBase.view;

import HomeBase.Main;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;

import javafx.event.ActionEvent;

import java.awt.event.MouseEvent;
import java.io.IOException;

/**
 * Created by Mitchell on 4/4/2017.
 */
public class mainMenuController {

    private Main main;
    @FXML
    private Button heapbutton;
    @FXML
    private Button horspoolbutton;
    @FXML
    private Button huffmanbutton;
    @FXML
    private Button primsbutton;
    @FXML
    private MenuItem mainMenu;
    @FXML
    private MenuItem undo;
    @FXML
    private MenuItem close;
    @FXML
    private MenuBar myMenu;
    @FXML
    private ImageView blurbView;

    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if (event.getSource() == close) {
            Platform.exit();
            System.exit(0);
        }
    }
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage;

        if (event.getSource() == heapbutton) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("heap/heapSubmenu.fxml"));
            BorderPane heapSub = loader.load();

            Stage heapStage = new Stage();
            heapStage.setTitle("Heap Submenu");
            heapStage.initModality(Modality.WINDOW_MODAL);
            heapStage.initOwner(heapbutton.getScene().getWindow());

            Scene scene = new Scene(heapSub);
            heapStage.setScene(scene);
            heapStage.showAndWait();
        }
        if(event.getSource() == horspoolbutton) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("horspool/horspoolSubmenu.fxml"));
            BorderPane heapSub = loader.load();

            Stage horspoolStage = new Stage();
            horspoolStage.setTitle("Horspool Submenu");
            horspoolStage.initModality(Modality.WINDOW_MODAL);
            horspoolStage.initOwner(horspoolbutton.getScene().getWindow());

            Scene scene = new Scene(heapSub);
            horspoolStage.setScene(scene);
            horspoolStage.showAndWait();

        }
        if(event.getSource() == huffmanbutton) {
            FXMLLoader loader= new FXMLLoader();
            loader.setLocation(Main.class.getResource("huffman/huffmanSubmenu.fxml"));
            BorderPane heapSub = loader.load();

            Stage huffmanStage = new Stage();
            huffmanStage.setTitle("Huffman Submenu");
            huffmanStage.initModality(Modality.WINDOW_MODAL);
            huffmanStage.initOwner(huffmanbutton.getScene().getWindow());

            Scene scene = new Scene(heapSub);
            huffmanStage.setScene(scene);
            huffmanStage.showAndWait();
        }
        if(event.getSource() == primsbutton) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("prims/primsSubmenu.fxml"));
            BorderPane heapSub = loader.load();

            Stage primsStage = new Stage();
            primsStage.setTitle("Prim's Submenu");
            primsStage.initModality(Modality.WINDOW_MODAL);
            primsStage.initOwner(primsbutton.getScene().getWindow());

            Scene scene = new Scene(heapSub);
            primsStage.setScene(scene);
            primsStage.showAndWait();
        }
    }
    @FXML
    private void handleButtonHover(javafx.scene.input.MouseEvent event) throws IOException{
        Image heapImage = new Image(getClass().getResource("heapImage.png").toExternalForm());
        Image horspoolImage = new Image(getClass().getResource("horspoolImage.png").toExternalForm());
        Image huffmanImage = new Image(getClass().getResource("huffmanImage.png").toExternalForm());
        Image primsImage = new Image(getClass().getResource("primsImage.png").toExternalForm());

        if(event.getSource() == heapbutton){
            blurbView.setImage(heapImage);
        }
        if(event.getSource() == horspoolbutton) {
            blurbView.setImage(horspoolImage);
        }
        if(event.getSource() == huffmanbutton) {
            blurbView.setImage(huffmanImage);
        }
        if(event.getSource() == primsbutton) {
            blurbView.setImage(primsImage);
        }
    }
    @FXML
    private void handleButtonExit(javafx.scene.input.MouseEvent event) throws IOException{
        Image startScreen = new Image(getClass().getResource("startScreen.jpg").toExternalForm());
        if(event.getSource() == heapbutton){
            blurbView.setImage(startScreen);
        }
        if(event.getSource() == horspoolbutton) {
            blurbView.setImage(startScreen);
        }
        if(event.getSource() == huffmanbutton) {
            blurbView.setImage(startScreen);
        }
        if(event.getSource() == primsbutton) {
            blurbView.setImage(startScreen);
        }
    }

}

