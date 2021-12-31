package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {
    @FXML
    private AnchorPane anchorpane;

    @FXML
    private HBox hbox;

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, String> list;

    @FXML
    private VBox vbox;

    @FXML
    private ImageView image;

    @FXML
    private Button viewProfile;

    @FXML
    private Button createGroup;

    @FXML
    private Button createChannel;

    @FXML
    private Button exit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        User user = new User(this);
        ArrayList<User> users = User.getUsers();
        user.addUserTable();

        viewProfile.setOnAction(event -> {
            try {
                viewProfile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exit.setOnAction(event -> Exit());
        createChannel.setOnAction(event -> {
            try {
                openCreateChannelPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        createGroup.setOnAction(event -> {
            try {
                openCreateGroupPage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void Exit(){
        ((Stage)exit.getScene().getWindow()).close();

    }

    public void viewProfile() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ViewProfile.fxml"));
        Stage profilestage =new Stage();
        profilestage.setTitle(" Profile");
        profilestage.setScene(new Scene(root));
        profilestage.show();

    }

    public void openCreateChannelPage() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/CreateChannel.fxml"));
        Stage channel = new Stage();
        channel.setTitle("Create channel");
        channel.setScene(new Scene(root));
        channel.show();
    }

    public void openCreateGroupPage() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/CreateGroup.fxml"));
        Stage group = new Stage();
        group.setTitle("Create group");
        group.setScene(new Scene(root));
        group.show();
    }

    public TableView<User> getTableview()
    {return tableview;}

    public void showUsers()
    {

    }


}
