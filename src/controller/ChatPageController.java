package controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.User;

public class ChatPageController implements Initializable {
    @FXML
    private VBox chatVbox;

    @FXML
    private HBox profileHbox;

    @FXML
    private Circle profileIcon;

    @FXML
    private ImageView profile;

    @FXML
    private Label nameLBL;

    @FXML
    private HBox HboxMessage;

    @FXML
    private Label PmLBL;

    @FXML
    private HBox sendHbox;

    @FXML
    private TextField messageText;

    @FXML
    private Button sendBTN;

    @FXML
    private Button closeBTN;

    @FXML
    private Label OnlineBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameLBL.setText("");
        showUserNameInChat();
        PmLBL.setText("");
        OnlineBTN.setText("");
        closeBTN.setOnAction(event -> closePage());
        sendBTN.setOnAction(event -> sendMessage());

    }
    public void closePage()
    {((Stage)closeBTN.getScene().getWindow()).close();}

    public void sendMessage()
    {
        OnlineBTN.setText("Online");
        PmLBL.setText(messageText.getText());
    }

    public void showUserNameInChat()
    {nameLBL.setText(MainPageController.nameUser);}
}
