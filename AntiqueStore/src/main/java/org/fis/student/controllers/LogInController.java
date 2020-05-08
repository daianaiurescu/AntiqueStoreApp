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
import javafx.fxml.FXML.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;


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
    public void LogIn(){
       /**String mail = mailField.getText();
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

         if(roleField.getValue().equals("Client")){
             try {
                 Stage stage = (Stage) LogIn.getScene().getWindow();
                 Parent viewBooksRoot= FXMLLoader.load(getClass().getClassLoader().getResource("AdminView.fxml"));
                 Scene scene = new Scene(viewBooksRoot);
                 stage.setScene(scene);
                 stage.show();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }**/

             try {
                 Stage stage = (Stage) LogIn.getScene().getWindow();
                 Parent AdminViewRoot= FXMLLoader.load(getClass().getClassLoader().getResource("AdminView.fxml"));
                 Scene scene = new Scene(AdminViewRoot);
                 stage.setScene(scene);
                 stage.show();
             } catch (IOException e) {
                 e.printStackTrace();
             }

    }

    @FXML
    public void Donate() {
        try {
            Stage stage = (Stage) Donate.getScene().getWindow();
            Parent donateFormRoot= FXMLLoader.load(getClass().getClassLoader().getResource("donateForm.fxml"));
            Scene scene = new Scene(donateFormRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
