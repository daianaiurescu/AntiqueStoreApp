package controllers;

import Exceptions.WrongPassword;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LogInController {

    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField mailField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Customer", "Administrator");
    }

    @FXML
    public void handleLogInAction() {
        try {

        } catch (WrongPassword e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}