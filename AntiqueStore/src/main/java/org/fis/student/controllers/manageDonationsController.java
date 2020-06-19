package org.fis.student.controllers;

import com.sun.org.apache.xml.internal.security.Init;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;
import org.fis.student.Book;
import org.fis.student.Donation;
import org.fis.student.services.DonationService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static org.fis.student.services.DonationService.readDonationsFromFile;
import static org.fis.student.services.DonationService.writeDonation;

public class manageDonationsController {

    @FXML
    private TableView<Donation> tableView1;

    @FXML
    private TableColumn<Donation, String> titleColumn1;

    @FXML
    private TableColumn<Donation, String> authorColumn1;

    @FXML
    private TableColumn<Donation, String>publishingHouseColumn1;

    @FXML
    private TableColumn<Donation, String> yearColumn1;

    @FXML
    private TableColumn<Donation, String> firstNameColumn1;

    @FXML
    private TableColumn<Donation, String> lastNameColumn1;

    @FXML
    private TableColumn<Donation, String> emailColumn1;

    @FXML
    private TableColumn<Donation, String> phoneColumn1;

    @FXML
    private Button resolvedButton;

    @FXML
    private Button goBackButton;

    public static ObservableList<Donation> donations;

    public String fileName = "../AntiqueStore/src/main/resources/donations.json";

    @FXML
    public void initialize(){
        titleColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("bookTitle"));
        authorColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("bookAuthor"));
        publishingHouseColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("bookPublishingHouse"));
        yearColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("bookYear"));

        firstNameColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("donorFirstName"));
        lastNameColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("donorLastName"));
        emailColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("donorEmail"));
        phoneColumn1.setCellValueFactory(new PropertyValueFactory<Donation, String>("donorPhoneNumber"));

        try {
            tableView1.setItems(readDonationsFromFile(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }




    public void goBack() {
        try {
            Stage stage = (Stage) goBackButton.getScene().getWindow();
            stage.setTitle("Admin's view");
            Parent gobackRoot = FXMLLoader.load(getClass().getClassLoader().getResource("AdminView.fxml"));
            Scene scene = new Scene(gobackRoot);
            stage.setScene(scene);
            stage.show();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleResolvedButtonAction() throws IOException, ParseException{
        ObservableList<Donation> donations = readDonationsFromFile(fileName);
        Donation d = tableView1.getSelectionModel().getSelectedItem();
        Donation aux1 = null;
        for(Donation o: donations){
            if(o.equals(d))
                aux1 = o;
        }

        donations.remove(aux1);

       /* for(Donation o : donations){
            System.out.println(o.getBookTitle());
        }*/
        writeDonation(fileName, donations);

        this.initialize();


    }

}
