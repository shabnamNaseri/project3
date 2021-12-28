package controller;

import javafx.application.Platform;
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
        viewProfile.setOnAction(event -> {
            try {
                viewprofile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        exit.setOnAction(event -> Exit());



    }
    public void Exit(){
        ((Stage)exit.getScene().getWindow()).close();

    }
    public void viewprofile() throws IOException {
        AnchorPane root = FXMLLoader.load(getClass().getResource("../view/ViewProfile.fxml"));
        Stage profilestage =new Stage();
        profilestage.setTitle(" Profile");
        profilestage.setScene(new Scene(root));
        profilestage.show();




    }
}
