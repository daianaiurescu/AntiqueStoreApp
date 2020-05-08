package org.fis.student.controllers;

import java.io.IOException;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.Node;

import static javafx.fxml.FXMLLoader.load;


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
    private Button LogIn, Donate;

    @FXML
    public void LogIn(ActionEvent Event) throws Exception {
       /** String mail = mailField.getText();
        String password = passwordField.getText();
        roleField.getItems().addAll("Client", "Administrator");
        if (mail == null || mail.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }**/
        /**
         if(roleField.getValue().equals("Client")){
         Parent root = FXMLLoader.load(getClass().getResource("viewBooks.fxml"));
         stage.setTitle("Log In");
         stage.setScene(new Scene(root));
         stage.show();
         }
         if(roleField.getValue().equals("Administrator")){
         Parent root = FXMLLoader.load(getClass().getResource("AdminView.fxml"));
         stage.setTitle("Log In");
         stage.setScene(new Scene(root));
         stage.show();
         }**/
    }

    @FXML
    public void Donate() {
        /**try {
            Parent donate = load(getClass().getResource("donateForm.fxml"));
            Scene donateScene = new Scene(donate);
            Stage window = (Stage) (Donate).getScene().getWindow();
            window.setScene(donateScene);
            window.show();
        }catch(IOException e){
            e.printStackTrace();
        }**/

        try {
            Stage stage = (Stage) Donate.getScene().getWindow();
            Parent donateFormRoot = load(getClass().getResource("donateForm.fxml"));
            Scene scene = new Scene(donateFormRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
