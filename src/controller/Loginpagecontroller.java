package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;

public class Loginpagecontroller implements Initializable {
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Label Text;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button LoginBTN;

    @FXML
    private Button RegisterBTN;

    @FXML
    private Label passLBL;

    @FXML
    private Label userLBL;
    @FXML
    private Label iconLabel;

    static Stage registerStage = null;
    @FXML
    private Label errorlabel;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        errorlabel.setText("");
        RegisterBTN.setOnAction(e -> {
            try {
                openregisterpage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        LoginBTN.setOnAction(event -> {
            try {
                openMainPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void openregisterpage() throws Exception
    {
        if (registerStage == null) {
            AnchorPane root = FXMLLoader.load(getClass().getResource("../view/RegisterPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.setTitle("Register Page");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }
    }

    public boolean checkFields()
    {
        if (username.getText().isEmpty() || password.getText().isEmpty()){
            errorlabel.setText("Please fill in all fields !!");
            errorlabel.setAlignment(Pos.CENTER);
            errorlabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true ;
    }

    public void openMainPage() throws IOException
    {
        if (checkLogin()){
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("  Messenger");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    public boolean checkLogin()
    {
        if (checkFields()) {
            User user1 = new User();
            for (int i = 0; i < user1.getUserArrayList().size(); i++) {
                if (username.getText().equals(user1.getUserArrayList().get(i).getUserName())
                        && password.getText().equals(user1.getUserArrayList().get(i).getPassword())){
                    return true;
                }
                else{
                    errorlabel.setText("Username or password is incorrect !");
                    errorlabel.setAlignment(Pos.CENTER);
                    errorlabel.setTextFill(Paint.valueOf(("#FF0000")));
                }
            }
        }
        return false;
    }


}
