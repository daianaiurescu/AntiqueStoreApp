package org.fis.student.controllers;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.fis.student.Book;
import org.fis.student.Cart;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

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
    private TableView<Double> totalTable;

    @FXML
    private TableColumn<Double,String> totalColumn;

    @FXML
    private Label total;

    public static Cart c=new Cart(viewBooksController.selectedBooks);

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

        total.setText(total().toString());
    }

    public void ChangeBookQuantity(){
        int nr_elem=viewBooksController.selectedBooks.size();
        for(int i=0;i<nr_elem;i++) {
            String newquantity=tableView.getColumns().get(5).getCellObservableValue(i).getValue().toString();
            viewBooksController.selectedBooks.get(i).setQuantity(newquantity);
        }
    }

    public Double total(){
        Double sum=0.0;
        for(Book b : viewBooksController.selectedBooks)
            sum += Double.parseDouble(b.getPrice()) * Double.parseDouble(b.getQuantity());
        return sum;
    }

    @FXML
    public void ModifyQty(TableColumn.CellEditEvent<Book, String> event){
        Book b=tableView.getSelectionModel().getSelectedItem();
        b.setQuantity(event.getNewValue());
        ChangeBookQuantity();
        c.setTotal(total());
        total.setText(c.getTotal().toString());
    }

    @FXML
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

    @FXML
    public void Order(ActionEvent event) {
        try {
            Stage stage = (Stage) order.getScene().getWindow();
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
