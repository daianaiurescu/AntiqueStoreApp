package org.fis.student.controllers;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.fis.student.Book;

import java.io.IOException;

public class cartController {

    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> publishingHouseColumn;

    @FXML
    private TableColumn<Book, String> yearColumn;

    @FXML
    private TableColumn<Book, String> priceColumn;

    @FXML
    private TableColumn<Book, String> quantityColumn;
    @FXML
    private Button goback, order;
    @FXML
    private static Label total;


    @FXML
    private void initialize(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publishingHouseColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("quantity"));
        tableView.setItems(viewBooksController.getSelectedBooks());
        quantityColumn.setCellFactory(TextFieldTableCell.<Book>forTableColumn());
        tableView.setEditable(true);
    }

    public void Goback(ActionEvent event) {
        try {
            Stage stage = (Stage) goback.getScene().getWindow();
            stage.setTitle("Available Books");
            Parent viewBooksRoot= FXMLLoader.load(getClass().getClassLoader().getResource("viewBooks.fxml"));
            Scene scene = new Scene(viewBooksRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Order(ActionEvent event) {
        try {
            Stage stage = (Stage) goback.getScene().getWindow();
            stage.setTitle("Your info");
            Parent orderFormRoot= FXMLLoader.load(getClass().getClassLoader().getResource("PlaceOrderForm.fxml"));
            Scene scene = new Scene(orderFormRoot);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
