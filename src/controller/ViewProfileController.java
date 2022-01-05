package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.User;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ViewProfileController<Lable> implements Initializable {
    @FXML
    private Group group;

    @FXML
    private Label nameLBL;

    @FXML
    private Label BioLBL;

    @FXML
    private TextArea nameText;

    @FXML
    private TextArea bioText;

    @FXML
    private Button exitBTN;

    @FXML
    private Label editLBL;

    @FXML
    private Button EditBTN;

    @FXML
    private Label  usernameViewProfile;



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        usernameViewProfile.setText("");
        showUsername();
        nameText.setText(MainPageController.saveName);
        bioText.setText(MainPageController.saveBio);
        editLBL.setText("");
        exitBTN.setOnAction(event -> exit());

        EditBTN.setOnAction(event -> {
            try {
                EditProfile();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void exit()
    {((Stage)exitBTN.getScene().getWindow()).close();}

    public void EditProfile() throws SQLException {
        if(setNameUser()) {
            nameText.setText(MainPageController.saveName);
            ArrayList<User> users = User.getUsers();
            for (User each : users ) {
                if (each.getUserName().equals(usernameViewProfile.getText())) {
                    User user = new User(each.getId(),nameText.getText(),each.getLastName(),each.getUserName()
                            ,each.getPassword(), each.getHashPassword(),each.getPhoneNumber());
                    DataBase.updateProfile(user);
                }
            }
            bioText.setText(bioText.getText());
            editLBL.setText("Profile edited successfully");
            editLBL.setTextFill(Paint.valueOf(("#208a27")));
        }
    }

    public boolean setNameUser()
    {
        ArrayList<User> users = User.getUsers();
        for (User each : users ) {
            if (each.getUserName().equals(usernameViewProfile.getText())) {
                MainPageController.nameUser = each.getName();
                nameText.setText(MainPageController.nameUser);
                each.setName(nameText.getText());
                return true;
            }
        }
        return false;
    }

    public void showUsername()
    {usernameViewProfile.setText(MainPageController.usernameChannel);}
}
