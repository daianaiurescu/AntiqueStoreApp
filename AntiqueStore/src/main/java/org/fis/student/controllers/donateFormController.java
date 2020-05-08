
package org.fis.student.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;

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
    void initialize() {
        assert userLastNameField != null : "fx:id=\"userLastNameField\" was not injected: check your FXML file 'Untitled'.";
        assert userFirstNameField != null : "fx:id=\"userFirstNameField\" was not injected: check your FXML file 'Untitled'.";
        assert userEmailField != null : "fx:id=\"userEmailField\" was not injected: check your FXML file 'Untitled'.";
        assert userNumberField != null : "fx:id=\"userNumberField\" was not injected: check your FXML file 'Untitled'.";
        assert bookTitleField != null : "fx:id=\"bookTitleField\" was not injected: check your FXML file 'Untitled'.";
        assert authorNameField != null : "fx:id=\"authorNameField\" was not injected: check your FXML file 'Untitled'.";
        assert publishingHouseField != null : "fx:id=\"publishingHouseField\" was not injected: check your FXML file 'Untitled'.";
        assert publishingYearField != null : "fx:id=\"publishingYearField\" was not injected: check your FXML file 'Untitled'.";

    }

    /**String userFirstName = userFirstNameField.getText();

    @FXML private Text actiontarget;

    public void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Donation submitted. ");
        ////////////to be linked w manage donations
    }**/


}
