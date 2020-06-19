
package org.fis.student.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import org.fis.student.Book;
import org.fis.student.Donation;
import org.fis.student.controllers.manageDonationsController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ResourceBundle;

import static org.fis.student.services.DonationService.readDonationsFromFile;
import static org.fis.student.services.DonationService.writeDonation;

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
    private Button submitButton;

    public String fileName = "../AntiqueStore/src/main/resources/donations.json";


    @FXML
    void initialize() {
    }

    @FXML private Text actiontarget;

    public void handleSubmitButtonAction(ActionEvent event) throws IOException {
        Dialog d;
        if(userFirstNameField.getText().isEmpty() || userLastNameField.getText().isEmpty() ||
                userEmailField.getText().isEmpty() || userNumberField.getText().isEmpty() ||
        bookTitleField.getText().isEmpty() ||  authorNameField.getText().isEmpty() ||
                publishingHouseField.getText().isEmpty() ||  publishingYearField.getText().isEmpty()){
            d = new Alert(Alert.AlertType.INFORMATION, "Form Error! None of these fields should be empty.");
            d.show();
            return;
        }

        else{
            d = new Alert(Alert.AlertType.INFORMATION, "Donation submitted.");
            d.show();
            Donation newDonation = new Donation(bookTitleField.getText(), authorNameField.getText(),
                    publishingHouseField.getText(), publishingYearField.getText(),
                    userFirstNameField.getText(), userLastNameField.getText(),
                    userEmailField.getText(), userNumberField.getText());

            try {
                writeNewDonation(newDonation, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }


    }

    public void writeNewDonation(Donation newDonation, String fileName) throws IOException, ParseException {
        ObservableList<Donation> donationList = FXCollections.observableArrayList();
        donationList = readDonationsFromFile(fileName);

        donationList.add(newDonation);
        writeDonation(fileName, donationList);

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
