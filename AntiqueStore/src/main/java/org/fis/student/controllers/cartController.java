package org.fis.student.controllers;

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
import org.fis.student.Book;
import org.fis.student.Cart;

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
    private Label total;



    private ObservableList<Book> selectedBooks=FXCollections.observableArrayList();
    private Cart c=new Cart(selectedBooks);


    @FXML
    private void initialize(){
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publishingHouseColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("quantity"));

        tableView.setItems(c.getBooks());

        quantityColumn.setCellFactory(TextFieldTableCell.<Book>forTableColumn());

        tableView.setEditable(true);

    }


    public ObservableList<Book> getSelectedBooksFromController1(ObservableList<Book> books){
        for(Book b : books) {
            c.getBooks().add(b);
        }
        total.setText(total().toString());
        return c.getBooks();
    }


    public void ChangeBookQuantity(){
        int nr_elem=c.getBooks().size();
        for(int i=0;i<nr_elem;i++) {
            String newquantity=tableView.getColumns().get(5).getCellObservableValue(i).getValue().toString();
            c.getBooks().get(i).setQuantity(newquantity);
        }
    }

    public  Double total(){
        Double sum=0.0;
        for(Book b : c.getBooks())
            sum += Double.parseDouble(b.getPrice()) * Double.parseDouble(b.getQuantity());
        return sum;
    }

    @FXML
    public void ModifyQty(TableColumn.CellEditEvent<Book, String> event){
        Book b=tableView.getSelectionModel().getSelectedItem();
        b.setQuantity(event.getNewValue());
        ChangeBookQuantity();
        c.setTotal(total().toString());
        total.setText(c.getTotal());
    }


    @FXML
    public void Order(ActionEvent event) {
        try {
            Stage stage=(Stage) order.getScene().getWindow();
            stage.setTitle("Your info");

            FXMLLoader loader=new FXMLLoader(getClass().getClassLoader().getResource("PlaceOrderForm.fxml"));
            Parent root=loader.load();

            c.setTotal(total.getText());
            PlaceOrderFormController controller2=loader.getController();
            controller2.getCartFromController1(c);


            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
