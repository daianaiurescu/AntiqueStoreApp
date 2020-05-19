package org.fis.student.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.fis.student.exception.WrongPasswordException;
import org.fis.student.user.ReadJsonFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


public class LogInController {

    @FXML
    public PasswordField passwordField;
    @FXML
    public TextField mailField;
    @FXML
    private Button LogIn, Donate;

    @FXML
    public void LogIn() {
        String password=passwordField.getText();

        byte[] passBytes=password.getBytes(StandardCharsets.UTF_8);
        String encodedPassword = Base64.getEncoder().encodeToString(passBytes);

        String mail=mailField.getText();


        try{
            ReadJsonFile.Read(encodedPassword, mail);

            if(ReadJsonFile.getRole().equals("Administrator")){
                try {
                    Stage stage = (Stage) LogIn.getScene().getWindow();
                    stage.setTitle("Admin's Page");
                    Parent adminViewRoot = FXMLLoader.load(getClass().getClassLoader().getResource("AdminView.fxml"));
                    Scene scene = new Scene(adminViewRoot);
                    stage.setScene(scene);
                    stage.show();
                }catch(IOException e1){
                    e1.printStackTrace();
                }
            }
            else{//for client view
                try {
                    Stage stage = (Stage) LogIn.getScene().getWindow();
                    stage.setTitle("Available Books");
                    Parent clientViewRoot = FXMLLoader.load(getClass().getClassLoader().getResource("viewBooks.fxml"));
                    Scene scene = new Scene(clientViewRoot);
                    stage.setScene(scene);
                    stage.show();
                }catch(IOException e2){
                    e2.printStackTrace();
                }
            }

        }catch(WrongPasswordException e){
                try {
                    Stage stage = (Stage) LogIn.getScene().getWindow();
                    stage.setTitle("WRONG PASSWORD!");
                    Parent wrongpassRoot = FXMLLoader.load(getClass().getClassLoader().getResource("WrongPassword.fxml"));
                    Scene scene = new Scene(wrongpassRoot);
                    stage.setScene(scene);
                    stage.show();
                }catch(IOException e3){
                    e3.printStackTrace();
                }
        }catch(Exception E){
            E.printStackTrace();
        }
    }


    @FXML
    public void Donate() {
        try {
            Stage stage = (Stage) Donate.getScene().getWindow();
            stage.setTitle("Donation Form");
            Parent donateFormRoot= FXMLLoader.load(getClass().getClassLoader().getResource("donateForm.fxml"));
            Scene scene = new Scene(donateFormRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
