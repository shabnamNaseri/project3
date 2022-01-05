package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;

public class LoginPageController implements Initializable {
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
    private Label errorLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        errorLabel.setText("");
        RegisterBTN.setOnAction(e -> {
            try {
                openRegisterPage();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        LoginBTN.setOnAction(event -> {
            try {
                openMainPage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

    public void openRegisterPage() throws Exception
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
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            errorLabel.setText("Please fill in all fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    public void openMainPage() throws Exception
    {
        if (checkLogin()) {
            AnchorPane root1 = FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Messenger");
            stage.setScene(new Scene(root1));
            stage.show();
        }
    }

    public boolean checkLogin()
    {
        if (checkFields()) {
            ArrayList<User> users = User.getUsers();
            for (User each : users) {
                if (username.getText().equals(each.getUserName())
                        && each.getHashPassword() == (password.getText().hashCode())) {
                    errorLabel.setText("");
                    MainPageController.usernameChannel = each.getUserName();
                    MainPageController.saveName = each.getName();
                    return true;
                }
            }
        }
        errorLabel.setText("Username or password is incorrect!");
        errorLabel.setAlignment(Pos.CENTER);
        errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
        return false;
    }
}
