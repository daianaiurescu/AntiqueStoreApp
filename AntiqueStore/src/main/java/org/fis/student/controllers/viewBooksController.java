package org.fis.student.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.fis.student.Book;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class viewBooksController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addBookToCart;

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
    private Button cart;

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        //set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        publishingHouseColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publishingHouse"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("quantity"));
        tableView.setEditable(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        try {
            tableView.setItems(readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*public ObservableList<Book> getBooks(){
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Why am I so clever", "Friedrich Nietzsche", "Penguin Books Ltd", "2016", 12.3, "2"));
        books.add(new Book("Mindset", "Carol S. Dweck", "Curtea Veche", "2017",  11.5,"1"));
        books.add(new Book("The Ultimate Guide to Friends", "Malcolm Mackenzie", "Egmont UK Ltd", "2019", 29.0,"4"));

        return books;
    }*/

    public static ObservableList<Book> readFromFile() throws IOException, ParseException {
        ObservableList<Book> books = FXCollections.observableArrayList();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("../AntiqueStore/src/main/resources/books.json");
        Object obj = jsonParser.parse(reader);

        JSONArray bookList = (JSONArray)obj;

        for (Object book : bookList) {
            JSONObject o = (JSONObject) book;
            Book b = new Book(o.get("title").toString(), o.get("author").toString(), o.get("publishingHouse").toString(), o.get("year").toString(),
                    o.get("price").toString(), o.get("quantity").toString());
            books.add(b);
        }
        return books;

    }


    //For the cart
    public static ObservableList<Book> selectedBooks=FXCollections.observableArrayList();
    @FXML
    public void AddBook(ActionEvent event) {
        ObservableList<Book> books = tableView.getSelectionModel().getSelectedItems();
        setSelectedBooks(books);
        Dialog d;
        d = new Alert(Alert.AlertType.INFORMATION, "Book(s) added to cart");
        d.show();
        return ;
    }
    public void setSelectedBooks(ObservableList<Book> books){
        for(Book b : books){
            selectedBooks.add(b);
        }
    }
    public static ObservableList<Book> getSelectedBooks(){
        for(Book b : selectedBooks){
            b.setQuantity("1");
        }
        return selectedBooks;
    }

   @FXML
    private void openCartView(ActionEvent event) {
       try {
           Stage stage = (Stage) cart.getScene().getWindow();
           stage.setTitle("Shopping Cart");
           Parent CartRoot= FXMLLoader.load(getClass().getClassLoader().getResource("Cart.fxml"));
           Scene scene = new Scene(CartRoot);
           stage.setScene(scene);
           stage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }

    }


}