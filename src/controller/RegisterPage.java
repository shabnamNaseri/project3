package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterPage implements Initializable {

        @FXML
        private TextField name;

        @FXML
        private TextField lastname;

        @FXML
        private TextField username;

        @FXML
        private TextField phonenumber;

        @FXML
        private PasswordField password;

        @FXML
        private PasswordField confirmpassword;
        @FXML
        private Button ExitBTN;

        @FXML
        private Button RegisterBTN;
        @FXML
        private Label errorLBL;

        @FXML
        private Label Labell;

        @Override
        public void initialize(URL location, ResourceBundle resources)
        {
                errorLBL.setText("");
                ExitBTN.setOnAction(e -> exit());
                RegisterBTN.setOnAction(e -> {
                        try {
                                createUser();
                        } catch (Exception ex) {
                                ex.printStackTrace();
                        }
                });

        }

        public boolean checkFields()
        {
                if (name.getText().isEmpty() || lastname.getText().isEmpty()
                        || username.getText().isEmpty() || phonenumber.getText().isEmpty()
                        || password.getText().isEmpty() || confirmpassword.getText().isEmpty()){

                        errorLBL.setText("Please fill in all fields !!");
                        errorLBL.setAlignment(Pos.CENTER);
                        errorLBL.setTextFill(Paint.valueOf(("#FF0000")));
                        return false;
                }
                return true;
        }

        public void exit()
        {
                ((Stage)ExitBTN.getScene().getWindow()).close();
                Loginpagecontroller.registerStage = null;
        }

        public void createUser() throws Exception
        {
                if (checkFields()){
                        if (checkPass()) {
                                User user = new User(name.getText(), lastname.getText(), username.getText()
                                        , password.getText(), phonenumber.getText());
                                user.getUserArrayList().add(user);
                                user.saveuser();
                                clear();
                        }
                }
        }

        public boolean checkPass()
        {
                if (!password.getText().equals(confirmpassword.getText())){
                        errorLBL.setText("Passwords do not match !!");
                        errorLBL.setAlignment(Pos.CENTER);
                        errorLBL.setTextFill(Paint.valueOf(("#FF0000")));
                        return false;
                }
                return true;
        }

        public boolean checkUsername() throws Exception {
                ArrayList<User> users = User.getUsers();
                for (User each : users)
                {
                        if(each.getUserName().equals(username.getText()))
                        {errorLBL.setText("Username Already Entred!!");}
                        return false;
                }
                return true;
        }

        public void clear()
        {
                name.setText("");
                lastname.setText("");
                username.setText("");
                password.setText("");
                confirmpassword.setText("");
                phonenumber.setText("");
                errorLBL.setText("");
                errorLBL.setText("User successfully created ");
                errorLBL.setAlignment(Pos.CENTER);
                errorLBL.setTextFill(Paint.valueOf(("#006600")));



        }
}
