
package org.fis.student.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class donateFormController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userLastNameField;

    @FXML
    private TextField userFirstNameField;

    @FXML
    private TextField userEmailField;

    @FXML
    private TextField userNumberField;

    @FXML
    private TextField bookTitleField;

    @FXML
    private TextField authorNameField;

    @FXML
    private TextField publishingHouseField;

    @FXML
    private TextField publishingYearField;
    @FXML
    private Button goback;


    @FXML
    void initialize() {
        /*assert userLastNameField != null : "fx:id=\"userLastNameField\" was not injected: check your FXML file 'Untitled'.";
        assert userFirstNameField != null : "fx:id=\"userFirstNameField\" was not injected: check your FXML file 'Untitled'.";
        assert userEmailField != null : "fx:id=\"userEmailField\" was not injected: check your FXML file 'Untitled'.";
        assert userNumberField != null : "fx:id=\"userNumberField\" was not injected: check your FXML file 'Untitled'.";
        assert bookTitleField != null : "fx:id=\"bookTitleField\" was not injected: check your FXML file 'Untitled'.";
        assert authorNameField != null : "fx:id=\"authorNameField\" was not injected: check your FXML file 'Untitled'.";
        assert publishingHouseField != null : "fx:id=\"publishingHouseField\" was not injected: check your FXML file 'Untitled'.";
        assert publishingYearField != null : "fx:id=\"publishingYearField\" was not injected: check your FXML file 'Untitled'.";*/

    }

    @FXML private Text actiontarget;

    public void handleSubmitButtonAction(ActionEvent event) {
        //// "Donation submitted" message////
        Dialog d = new Alert(Alert.AlertType.INFORMATION, "Donation submitted.");
        d.show();
        ////////////////////////////////////


        ////////////to be linked w manage donations
    }
    public void GoBack(){
        try {
            Stage stage = (Stage) goback.getScene().getWindow();
            stage.setTitle("Log in");
            Parent gobackRoot= FXMLLoader.load(getClass().getClassLoader().getResource("LogIn.fxml"));
            Scene scene = new Scene(gobackRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
