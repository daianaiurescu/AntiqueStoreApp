import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Services.UserService;
import Users.User;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Services.UserService.loadUsersFromFile();

        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LogIn.fxml"));
        primaryStage.setTitle("Log In");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
}
