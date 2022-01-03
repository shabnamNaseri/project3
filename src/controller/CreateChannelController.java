package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Channel;
import model.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateChannelController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField channelName;

    @FXML
    private Button createButton;

    @FXML
    private Button closeBTN;

    @FXML
    private TextField userNameField;

    @FXML
    private Button searchUser;

    @FXML
    private Button addUser;

    @FXML
    private Label nameUser;

    private String name;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameUser.setText("");

        closeBTN.setOnAction(event -> Exit());
        createButton.setOnAction(event -> createChannel());
        searchUser.setOnAction(event -> findUser());
      //  addUser.setOnAction(event -> );

    }

    public boolean findUser()
    {
        ArrayList<User> usr = User.getUsers();
        for (User each : usr) {
            if(userNameField.getText().equals(each.getUserName())){
                name = each.getName();
                nameUser.setText(name);
                return true;
            }
        }
        return false;
    }

    public void Exit()
    {((Stage)closeBTN.getScene().getWindow()).close();}



    public void createChannel()
    {
        Channel channel = new Channel(channelName.getText());
        channel.getChannelArrayList().add(channel);
    }


}
