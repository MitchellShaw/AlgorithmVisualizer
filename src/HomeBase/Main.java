package HomeBase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {
   private static Stage primaryStage;
   private static BorderPane mainLayout;
    //private static Button myButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("view/MainMenu.fxml"));
        root.getStylesheets().add(getClass().getResource("myStyle.css").toString());
        primaryStage.setTitle("Algorithm Visualizer");
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        primaryStage.setScene(new Scene(root,width,height));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

