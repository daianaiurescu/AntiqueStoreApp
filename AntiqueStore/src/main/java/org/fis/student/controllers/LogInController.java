package org.fis.student.controllers;

import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

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
    public void LogIn(ActionEvent Event) throws Exception{
        String mail = mailField.getText();
        String password = passwordField.getText();
        roleField.getItems().addAll("Client", "Administrator");
        if (mail == null || mail.isEmpty()) {
            loginMessage.setText("Please type in a username!");
            return;
        }

        if (password == null || password.isEmpty()) {
            loginMessage.setText("Password cannot be empty");
            return;
        }
        Stage stage=new Stage();
        if(roleField.getValue().equals("Client")){
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("viewBooks.fxml"));
            stage.setTitle("Log In");
            stage.setScene(new Scene(root));
            stage.show();
        }
        if(roleField.getValue().equals("Administrator")){
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("AdminView.fxml"));
            stage.setTitle("Log In");
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

}
