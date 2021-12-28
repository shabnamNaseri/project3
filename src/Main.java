import controller.DataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("view/loginpage.fxml"));
        loader.load();
        primaryStage.setTitle("LoginPage");
        primaryStage.setScene(new Scene(loader.getRoot()));
        primaryStage.show();

    }
}
