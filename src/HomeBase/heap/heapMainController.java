package HomeBase.heap;

import HomeBase.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mitchell on 4/10/2017.
 */
public class heapMainController {


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
    private Label completed;
    @FXML
    private Label root;
    @FXML
    private Label L;
    @FXML
    private Label R;
    @FXML
    private Label LR;
    @FXML
    private Label RR;
    @FXML
    private Label RL;
    @FXML
    private Label LL;
    @FXML
    private Label LLL;
    @FXML
    private Label LLR;
    @FXML
    private Label LRL;
    @FXML
    private Label LRR;
    @FXML
    private Label RLL;
    @FXML
    private Label RLR;
    @FXML
    private Label RRL;
    @FXML
    private Label RRR;
    @FXML
    private Circle Croot;
    @FXML
    private Circle CL;
    @FXML
    private Circle CR;
    @FXML
    private Circle CLR;
    @FXML
    private Circle CRR;
    @FXML
    private Circle CRL;
    @FXML
    private Circle CLL;
    @FXML
    private Circle CLLL;
    @FXML
    private Circle CLLR;
    @FXML
    private Circle CLRL;
    @FXML
    private Circle CLRR;
    @FXML
    private Circle CRLL;
    @FXML
    private Circle CRLR;
    @FXML
    private Circle CRRL;
    @FXML
    private Circle CRRR;
    @FXML
    private Line XL;
    @FXML
    private Line XR;
    @FXML
    private Line XLR;
    @FXML
    private Line XRR;
    @FXML
    private Line XRL;
    @FXML
    private Line XLL;
    @FXML
    private Line XLLL;
    @FXML
    private Line XLLR;
    @FXML
    private Line XLRL;
    @FXML
    private Line XLRR;
    @FXML
    private Line XRLL;
    @FXML
    private Line XRLR;
    @FXML
    private Line XRRL;
    @FXML
    private Line XRRR;


    private int[] finalArray;
    private boolean bottomUp;
    private boolean theHeap;
    String userInput;

    public void setUserInput(String data) {
        userInput = data;
        String[] inputArray = userInput.replaceAll(" ", "").split(",");
        finalArray = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            try {
                finalArray[i] = Integer.parseInt(inputArray[i]);
            } catch (NumberFormatException ex) {
                System.out.println("Error on capturing input.");
            }
        }
    }

    public void getCheckBox(boolean bottom) {
        bottomUp = bottom;
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
    private void createLevel1() {
        //left
        L.setText(Integer.toString(finalArray[1]));
        CL.setVisible(true);
        XL.setVisible(true);
        //right
        R.setText(Integer.toString(finalArray[2]));
        CR.setVisible(true);
        XR.setVisible(true);
    }

    private void createLevel2Left() {
        createLevel1();
        //LL
        LL.setText(Integer.toString(finalArray[3]));
        CLL.setVisible(true);
        XLL.setVisible(true);
        //LR
        LR.setText(Integer.toString(finalArray[4]));
        CLR.setVisible(true);
        XLR.setVisible(true);
    }

    private void createLevel2Right() {
        createLevel1();
        createLevel2Left();
        //RL
        RL.setText(Integer.toString(finalArray[5]));
        CRL.setVisible(true);
        XRL.setVisible(true);
        //RR
        RR.setText(Integer.toString(finalArray[6]));
        CRR.setVisible(true);
        XRR.setVisible(true);
    }

    private void createLevel3Left() {
        createLevel2Right();
        //LLL
        LLL.setText(Integer.toString(finalArray[7]));
        CLLL.setVisible(true);
        XLLL.setVisible(true);
        ///LLR
        LLR.setText(Integer.toString(finalArray[8]));
        CLLR.setVisible(true);
        XLLR.setVisible(true);
    }

    private void createLevel3LeftRight() {
        createLevel3Left();
        //LRL
        LRL.setText(Integer.toString(finalArray[9]));
        CLRL.setVisible(true);
        XLRL.setVisible(true);
        //LRR
        LRR.setText(Integer.toString(finalArray[10]));
        CLRR.setVisible(true);
        XLRR.setVisible(true);
    }

    private void createLevel3Right() {
        createLevel3LeftRight();
        //RLL
        RLL.setText(Integer.toString(finalArray[11]));
        CRLL.setVisible(true);
        XRLL.setVisible(true);
        //RLR
        RLR.setText(Integer.toString(finalArray[12]));
        CRLR.setVisible(true);
        XRLR.setVisible(true);
    }

    private void createLevel3RightRight() {
        createLevel3Right();
        //RRL
        RRL.setText(Integer.toString(finalArray[13]));
        CRRL.setVisible(true);
        XRRL.setVisible(true);
        //RRR
        RRR.setText(Integer.toString(finalArray[14]));
        CRRR.setVisible(true);
        XRRR.setVisible(true);
    }

    private void createTree(int value) {
        //root
        root.setText(Integer.toString(finalArray[0]));
        Croot.setVisible(true);
        if (value == 3) {
            createLevel1();
        }
        if (value == 5) {
            createLevel2Left();
        }
        if (value == 7) {
            createLevel2Right();
        }
        if (value == 9) {
            createLevel3Left();
        }
        if (value == 11) {
            createLevel3LeftRight();
        }
        if (value == 13) {
            createLevel3Right();
        }
        if (value == 15) {
            createLevel3RightRight();
        }
    }

    boolean created;
    int counter;

    @FXML
    private void handleStepAction(ActionEvent event) throws IOException {
        //handle initialization here

        if (bottomUp) {
            createTree(finalArray.length);

        }
        if (created) {
            heapify();
        }
        created = true;
    }


    //Variables needed for swapping
    private int myI;
    private int myK;
    private int myN;
    private int myV;
    private int myJ;
    private boolean flag;

    private void swap() {
        int temp;
        if(!flag) {
            if (myI >= 1) {
                myK = myI;
                myV = finalArray[myK - 1];
                flag = true;
            }
        }
        if(flag){
            if (!theHeap && ((2 * myK) <= myN))
            {
                myJ = 2 * myK;
                if (myJ < myN)
                {
                    if (finalArray[myJ - 1] < finalArray[myJ])
                    {
                        myJ = myJ + 1;
                    }
                }
                if (myV >= finalArray[myJ - 1])
                {
                    theHeap = true;
                }
                else
                {
                    finalArray[myK - 1] = finalArray[myJ - 1];
                    temp = myK;
                    //create tree for update
                    myK = myJ;
                    finalArray[myJ-1]= temp;
                    finalArray[myK - 1] = myV;
                    createTree(finalArray.length);
                    if((2 * myK) <= myN)
                    {
                        flag = true;
                    }
                    else
                    {
                        flag = false;
                    }
                }
            }
        }
            if(!flag)
            {
                finalArray[myK - 1] = myV;
                //create tree for update
                createTree(finalArray.length);
                myI--;
            }
            if(myI ==0){
                completed.setVisible(true);
            }
        }

    private void heapify() {

        if (counter == 0) {
            myI = finalArray.length / 2;
            myN = finalArray.length;
            flag = false;
            theHeap = false;
            swap();
            counter++;
        } else {
            swap();
        }
    }
}






