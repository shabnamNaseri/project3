package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Group;
import model.User;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateGroupController implements Initializable {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<User> userList;

    @FXML
    private TableColumn<User, String> list;

    @FXML
    private Button closeBTN;

    @FXML
    private Button createBTN;

    @FXML
    private TextField groupName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeBTN.setOnAction(event -> Exit());
        createBTN.setOnAction(event -> createGroup());

    }
    public void Exit(){
        ((Stage)closeBTN.getScene().getWindow()).close();

    }
    public void createGroup(){
        Group group= new Group(groupName.getText());
        group.getGroupArrayList().add(group);
    }
}
