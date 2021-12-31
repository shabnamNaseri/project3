package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private Button createBTN;

    @FXML
    private TextField groupName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
