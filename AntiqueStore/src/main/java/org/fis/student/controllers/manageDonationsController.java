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
            tableView1.setItems(readDonationsFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static ObservableList<Donation> readDonationsFromFile() throws IOException, ParseException {
        ObservableList<Donation> donations = FXCollections.observableArrayList();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("../AntiqueStore/src/main/resources/donations.json");

        Object obj = parser.parse(reader);
        JSONArray donationList = (JSONArray)obj;

        for(Object d : donationList){
            JSONObject o = (JSONObject)d;
            Donation don = new Donation(o.get("bookTitle").toString(), o.get("bookAuthor").toString(), o.get("bookPublishingHouse").toString(),
                    o.get("bookYear").toString(), o.get("donorFirstName").toString(), o.get("donorLastName").toString(),
                    o.get("donorEmail").toString(), o.get("donorPhoneNumber").toString());
            donations.add(don);
            //System.out.println(don.toString());
        }
        return donations;
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
        ObservableList<Donation> donations = readDonationsFromFile();
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



        FileWriter file = new FileWriter("../AntiqueStore/src/main/resources/donations.json");


        JSONArray updatedDonations = new JSONArray();


        for (Donation aux: donations) {
            JSONObject DonationDetails = new JSONObject();

            DonationDetails.put("bookTitle", aux.getBookTitle());
            DonationDetails.put("bookAuthor", aux.getBookAuthor());
            DonationDetails.put("bookPublishingHouse", aux.getBookPublishingHouse());
            DonationDetails.put("bookYear", aux.getBookYear());
            DonationDetails.put("donorFirstName", aux.getDonorFirstName());
            DonationDetails.put("donorLastName", aux.getDonorLastName());
            DonationDetails.put("donorEmail", aux.getDonorEmail());
            DonationDetails.put("donorPhoneNumber", aux.getDonorPhoneNumber());



            updatedDonations.add(DonationDetails);
        }

        file.write(updatedDonations.toJSONString());
        file.flush();

        this.initialize();


    }

}
