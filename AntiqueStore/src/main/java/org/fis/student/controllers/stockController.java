package org.fis.student.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.HashMap;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;
import java.io.FileWriter;
import java.io.IOException;
import org.fis.student.controllers.viewBooksController;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.*;
import org.fis.student.Book;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import sun.java2d.pipe.SpanShapeRenderer;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

import java.io.*;
import java.util.*;

import java.net.URL;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.String.valueOf;
import static javafx.scene.control.cell.TextFieldTableCell.*;


public class stockController {

    //configure the table
    @FXML private TableView<Book> tableView;

    @FXML private TableColumn<Book, String> titleColumn;
    @FXML private TableColumn<Book, String> authorColumn;
    @FXML private TableColumn<Book, String> publishingHouseColumn;
    @FXML private TableColumn<Book, String> yearColumn;
    @FXML private TableColumn<Book, String> quantityColumn;
    @FXML private TableColumn<Book, String> priceColumn;

    //The following variables will be used in order to create a new book
    @FXML private TextField titleTextField;
    @FXML private TextField authorTextField;
    @FXML private TextField publishingHouseTextField;
    @FXML private Spinner<Integer> yearSpinner;
    @FXML private Spinner<Integer> quantitySpinner;
    @FXML private Spinner<Double> priceSpinner;
    @FXML private Button addBookButton;
    @FXML private Button goback;




   private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        //configuring spinners
        SpinnerValueFactory<Integer> yearValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1700, Year.now().getValue(), 1900);
        this.yearSpinner.setValueFactory(yearValueFactory);
        yearSpinner.setEditable(true);

        SpinnerValueFactory<Integer> quantityValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5000, 1);
        this.quantitySpinner.setValueFactory(quantityValueFactory);
        quantitySpinner.setEditable(true);
        //set up the columns in the table
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        publishingHouseColumn.setCellValueFactory(new PropertyValueFactory<>("publishingHouse"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        try {
            tableView.setItems(viewBooksController.readFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        tableView.setEditable(true);
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //modifying stock
        quantityColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<Book, String>>() {
                    @Override
                    public void handle(CellEditEvent<Book, String> t) {
                        Book actualizedBook = ((Book) t.getTableView().getItems().get(
                                t.getTablePosition().getRow()));
                        actualizedBook.setQuantity((String) t.getNewValue());
                        //System.out.println(actualizedBook.toString());

                        try {
                            updateJSONFile(actualizedBook);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                );
    }



    public void updateJSONFile(Book actualizedBook) throws IOException, ParseException {
        ObservableList<Book> books = viewBooksController.readFromFile();
        Book aux1 = null;

        for(Book b: books){
            if(b.equals(actualizedBook)) {
                aux1 = b;
                //System.out.println(aux1.toString());
            }
        }

        if(aux1 != null) {
            books.remove(aux1); //deleting the same book that has the old quantity
            books.add(actualizedBook); //adding the same book, with the updated quantity

            FileWriter file = new FileWriter("../AntiqueStore/src/main/resources/books.json");


            JSONArray booksJSON = new JSONArray();
            for (Book aux : books) {
                JSONObject bookDetails = new JSONObject();
                bookDetails.put("title", aux.getTitle());
                bookDetails.put("author", aux.getAuthor());
                bookDetails.put("publishingHouse", aux.getPublishingHouse());
                bookDetails.put("price", aux.getPrice());
                bookDetails.put("year", aux.getYear());
                bookDetails.put("quantity", aux.getQuantity());


                booksJSON.add(bookDetails);
            }

            file.write(booksJSON.toJSONString());
            file.flush();
            this.initialize();
        }

    }



    /*This method will retrurn an ObservableList of Books objects */
    /*public ObservableList<Book> getBooks(){
        ObservableList<Book> books = FXCollections.observableArrayList();
        books.add(new Book("Why am I so clever", "Friedrich Nietzsche", "Penguin Books Ltd", "2016", 12.3, "2"));
        books.add(new Book("Mindset", "Carol S. Dweck", "Curtea Veche", "2017",  11.5,"1"));
        books.add(new Book("The Ultimate Guide to Friends", "Malcolm Mackenzie", "Egmont UK Ltd", "2019", 29.0,"4"));

        return books;
    }*/

    /* This method will create a new book and add it to the table*/

    public void newBookButtonPushed(){

       // ObservableList<Book> books = FXCollections.observableArrayList();
        addBookButton.setOnAction(value-> {
            int yearValue = (int) yearSpinner.getValue();
            int quantityValue = (int) quantitySpinner.getValue();
            double priceValue = (double) priceSpinner.getValue();

            Book newBook = new Book(titleTextField.getText(), authorTextField.getText(),
                    publishingHouseTextField.getText(), valueOf(yearValue), valueOf(priceValue), valueOf(quantityValue));

            try {
                writeNewBook(newBook);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

            tableView.getItems().add(newBook);

        });
        }


    public void writeNewBook(Book newBook) throws IOException, ParseException {
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        bookList = viewBooksController.readFromFile();
        bookList.add(newBook);

        FileWriter file = new FileWriter("../AntiqueStore/src/main/resources/books.json");


        JSONArray books = new JSONArray();
        for (Book aux: bookList){
            JSONObject bookDetails = new JSONObject();
            bookDetails.put("title", aux.getTitle());
            bookDetails.put("author", aux.getAuthor());
            bookDetails.put("publishingHouse", aux.getPublishingHouse());
            bookDetails.put("price", aux.getPrice());
            bookDetails.put("year", aux.getYear());
            bookDetails.put("quantity", aux.getQuantity());

            JSONObject obj = new JSONObject();
            books.add(bookDetails);
        }

        file.write(books.toJSONString());
        file.flush();

    }

    public void changeQuantity(CellEditEvent editedCell){
        Book selectedBook = tableView.getSelectionModel().getSelectedItem();
        selectedBook.setQuantity((String) editedCell.getNewValue());
    }

    public void GoBack() {
        try {
            Stage stage = (Stage) goback.getScene().getWindow();
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

}

