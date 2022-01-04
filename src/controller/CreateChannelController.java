package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
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
    private TextField userNameFieldChannel;

    @FXML
    private Button searchUser;

    @FXML
    private Button addUser;

    @FXML
    private Label nameUser;

    @FXML
    private Label errorLabel;

    private String name;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        nameUser.setText("");
        closeBTN.setOnAction(event -> Exit());
        createButton.setOnAction(event -> createChannel());
        searchUser.setOnAction(event -> searchUser());
        addUser.setOnAction(event -> addUser() );

    }

    public boolean findUser()
    {
        ArrayList<User> usr = User.getUsers();
        for (User each : usr) {
            if(userNameFieldChannel.getText().equals(each.getUserName())){
                name = each.getName();
                nameUser.setText(name);
                return true;
            }
        }
        return false;
    }

    public void searchUser()
    {
        if(!findUser())
        {
            nameUser.setText("user not found!!");
            nameUser.setAlignment(Pos.CENTER);
            nameUser.setTextFill(Paint.valueOf(("#FF0000")));
        }
        else
        {
            nameUser.setText(name);
            nameUser.setAlignment(Pos.BASELINE_LEFT);
            nameUser.setTextFill(Paint.valueOf(("#2bc22d")));
        }
    }

    public void addUser()
    {
        if(findUser())
        {
            ArrayList<String> users = new ArrayList<>();
            users.add(userNameFieldChannel.getText());
        }
    }

    public void Exit()
    {((Stage)closeBTN.getScene().getWindow()).close();}

    public boolean checkField()
    {
        if(channelName.getText().isEmpty())
        {
            errorLabel.setText("Please fill in all fields !!");
            errorLabel.setAlignment(Pos.CENTER);
            errorLabel.setTextFill(Paint.valueOf(("#FF0000")));
            return false;
        }
        return true;
    }

    public void createChannel()
    {
        if(checkField()) {
            Channel channel = new Channel(channelName.getText());
            channel.getChannelArrayList().add(channel);
        }
    }


}
