package org.fis.student.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import static javafx.fxml.FXMLLoader.load;

public class AdminViewController {
    @FXML
    private Button modifyStockButton;

    @FXML
    private Button manageOrder;

    @FXML
    private Button manageDonationButton;

    @FXML
    public void modifyStock(){
        try {
            Stage stage = (Stage) modifyStockButton.getScene().getWindow();
            stage.setTitle("Modify Stock");
            Parent managestockRoot= load(getClass().getClassLoader().getResource("manageStock.fxml"));
            Scene scene = new Scene(managestockRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void ManageOrder(){
        try {
            Stage stage = (Stage) manageOrder.getScene().getWindow();
            stage.setTitle("Manage Order");
            Parent managestockRoot= load(getClass().getClassLoader().getResource("manageOrders.fxml"));
            Scene scene = new Scene(managestockRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void manageDonation(){
        try {
            Stage stage = (Stage) manageDonationButton.getScene().getWindow();
            stage.setTitle("Manage Donations");
            Parent manageDonationRoot= load(getClass().getClassLoader().getResource("manageDonations.fxml"));
            Scene scene = new Scene(manageDonationRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
