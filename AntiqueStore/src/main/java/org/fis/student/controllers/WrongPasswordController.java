package org.fis.student.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WrongPasswordController {
    @FXML
    public Button TryAgain;
    public void TryAgain(){
        try {
            Stage stage = (Stage) TryAgain.getScene().getWindow();
            stage.setTitle("Log in");
            Parent tryAgainRoot= FXMLLoader.load(getClass().getClassLoader().getResource("LogIn.fxml"));
            Scene scene = new Scene(tryAgainRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

