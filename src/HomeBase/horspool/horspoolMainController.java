package HomeBase.horspool;

import HomeBase.Main;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import org.apache.commons.lang3.ArrayUtils;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Mitchell on 4/10/2017.
 */
public class horspoolMainController {

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
    @FXML
    private ListView<Character> input;
    @FXML
    private ListView<Integer> values;
    @FXML
    private TextFlow myMainFlow;
    @FXML
    private TextFlow mySubFlow;
    @FXML
    private Text matchString;
    @FXML
    private Text redSub;
    @FXML
    private Text greenSub;

    private String string;
    private String subString;
    private String finalString;
    private String finalSubstring;
    private Integer[] tableValues;
    private final int shiftConstant = 37;

    public void setUserInput(String mainString, String sString) {
        string = mainString;
        subString = sString;

        finalString = string.replaceAll(" ", "").toLowerCase();
        finalSubstring = subString.replaceAll(" ", "").toLowerCase();
        values.setMouseTransparent(true);
        values.setFocusTraversable(false);
        input.setMouseTransparent(true);
        input.setFocusTraversable(false);
        matchString.setText(finalString.toUpperCase());
        greenSub.setText(finalSubstring.toUpperCase());
        redSub.setText("");
        createTable();

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

    private boolean killswitch;
    @FXML
    private void handleStepAction(ActionEvent event) throws IOException {

        if(traverse){
            traverse();
        }else{
            horspool();
        }
    }


    private void findDuplicates() {
        ArrayList<Integer> toDelete = new ArrayList<>();
        int index;

        for (int i = 0; i < myCharArray.length; i++) {
            for (int j = i + 1; j < myCharArray.length; j++) {
                if (myCharArray[i] == myCharArray[j]) {
                    toDelete.add(j);
                }
            }
            index = i;
            if (!toDelete.isEmpty()) {
                swapping(toDelete, index);
                toDelete.clear();
            }

        }

    }

    private void swapping(ArrayList<Integer> cTemp, int index) {
        if (myCharArray[index] == myCharArray[myCharArray.length - 1]) {
            if (cTemp.size() > 2) {
                tableValues[index] = tableValues[cTemp.get(cTemp.size() - 2)];
            }
        }
        else{
            tableValues[index]= tableValues[cTemp.get(cTemp.size() - 1)];
        }
        for (int i = 0; i < cTemp.size(); i++) {
            if (i == 0) {
                myCharArray = ArrayUtils.remove(myCharArray, cTemp.get(i));
                tableValues = ArrayUtils.remove(tableValues, cTemp.get(i));

            } else {
                myCharArray = ArrayUtils.remove(myCharArray, ((cTemp.get(i)) - 1));
                tableValues = ArrayUtils.remove(tableValues, ((cTemp.get(i)) - 1));
                for (int j = 1; j < cTemp.size(); j++) {
                    cTemp.set(j, (cTemp.get(j) - 1));
                }

            }
        }
    }


    private Character[] myCharArray;
    private Character[] splitSubstring;
    private char[] matchMe;

    private void createTable() {

        tableValues = new Integer[finalSubstring.length()];
        for (int i = 0; i < finalSubstring.length(); i++) {
            tableValues[i] = finalSubstring.length() - i - 1;
        }
        tableValues[tableValues.length - 1] = tableValues.length;

        myCharArray = new Character[finalSubstring.length()];
        for (int i = 0; i < finalSubstring.length(); i++) {
            myCharArray[i] = finalSubstring.charAt(i);
        }


        splitSubstring = new Character[myCharArray.length];
        for (int i = 0; i < splitSubstring.length; i++) {
            splitSubstring[i] = finalSubstring.charAt(i);
        }

        findDuplicates();


        ObservableList<Character> myInput = FXCollections.observableArrayList(myCharArray);
        ObservableList<Integer> myValues = FXCollections.observableArrayList(tableValues);

        values.setItems(myValues);
        input.setItems(myInput);


        i = splitSubstring.length - 1;
        k = i;
        n = i;
        m = k;
        matchMe = finalString.toCharArray();
        step = true;
        green = false;
        red = false;


    }

    private String resultRed;
    private String resultGreen;

    private void colorSwap(int point, Color color) {
        StringBuilder green = new StringBuilder(finalSubstring);
        StringBuilder red = new StringBuilder(finalSubstring);
        red.delete(0, point);
        green.delete(point, finalSubstring.length());
        resultRed = red.toString().toUpperCase();
        resultGreen = green.toString().toUpperCase();
        greenSub.setText(resultGreen);
        redSub.setText(resultRed);
        redSub.setFill(color);

    }

    private int k;
    private int i;
    private int n;
    private int y;
    private boolean step;
    private int retainer;
    private boolean red;
    private boolean green;
    private boolean traverse;
    private int m;
    private int shiftValue;
    private int oldValue;

    private void horspool()throws ArrayIndexOutOfBoundsException {
        try {
            if (step) {
                if (splitSubstring[n] != matchMe[k]) {

                    retainer = ArrayUtils.indexOf(myCharArray, matchMe[k], 0);

                    if (retainer == -1) {
                        int temp = ArrayUtils.indexOf(myCharArray, splitSubstring[n], 0);
                        retainer = tableValues[temp];
                        k = m + retainer;
                    } else {
                        retainer = tableValues[retainer];
                        k = m + retainer;
                    }
                    m = k;
                    colorSwap(n, Color.RED);
                    traverse = true;

                } else {
                    green = true;
                    step = false;
                }
            }
            if (green) {
                if (splitSubstring[n] == matchMe[m]) {

                    colorSwap(n, Color.GREEN);
                    m--;
                    n--;
                    if (n < 0) {
                        stepButton.setDisable(true);
                    }
                    step = false;
                } else {
                    green = false;
                    red = true;
                }
            }
            if (red) {
                colorSwap(n, Color.RED);
                m = k;
                red = false;
                step = true;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            if (n >= splitSubstring.length || k >= matchMe.length) {
                greenSub.setFill(Color.RED);
                redSub.setFill(Color.RED);
                stepButton.setDisable(true);
                step = false;
                traverse = false;
            }
        }
    }
    private void traverse(){
        if (traverse) {
            shiftValue = (retainer * shiftConstant) + oldValue;
            mySubFlow.setTranslateX(shiftValue);
            oldValue = shiftValue;
            n = i;
            greenSub.setFill(Color.BLACK);
            redSub.setFill(Color.BLACK);
            traverse = false;
        }
    }

}


