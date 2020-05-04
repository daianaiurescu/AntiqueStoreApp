package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

import Exceptions.WrongPassword;

import Users.User;
import Services.*;

public class LogInController {

    @FXML
    public Text loginMessage;
    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField mailField;
    @FXML
    public ChoiceBox roleField;

    @FXML
    public void handleLogInAction(){
        String mail = mailField.getText();
        roleField.getItems().addAll("Client", "Administrator");
        String password = passwordField.getText();

        try {
            UserService.loadUsersFromFile();

            if (mail == null || mail.isEmpty()) {
                loginMessage.setText("Please type in a username!");
                return;
            }

            if (password == null || password.isEmpty()) {
                loginMessage.setText("Password cannot be empty");
                return;
            }

            if (roleField.getValue().equals("Client")) {
                try {
                    Stage stage = (Stage) loginMessage.getScene().getWindow();
                    Parent viewBooks = FXMLLoader.load(getClass().getResource("../fxml/viewBooks.fxml"));
                    Scene scene = new Scene(viewBooks, 600, 400);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }


            if (roleField.getValue().equals("Administrator")) {
                try {
                    Stage stage = (Stage) loginMessage.getScene().getWindow();
                    Parent AdminView = FXMLLoader.load(getClass().getResource("../fxml/AdminView.fxml"));
                    Scene scene = new Scene(AdminView, 600, 400);
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
        }catch (WrongPassword e){
            loginMessage.setText(e.getMessage());
        }catch(IOException e){

        }

        }


    }