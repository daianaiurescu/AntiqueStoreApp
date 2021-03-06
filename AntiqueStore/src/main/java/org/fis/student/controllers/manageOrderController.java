package org.fis.student.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.Client;
import org.fis.student.Order;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;


public class manageOrderController {

   public ObservableList<Book> dataTable2;

    @FXML
    public TableView<Client> table1;
    @FXML
    public TableView<Book> table2;
    @FXML
    public TableColumn<Client,String> FirstName, LastName, PhoneNumber, City, Address;
    @FXML
    public TableColumn<Book,String> Title, Author, PH, Quantity, Price;
    @FXML
    public Button Accept, Decline, GoBack;
    @FXML
    public Label Total;

    public Dialog d;

    public String File="../AntiqueStore/src/main/resources/orders.json";

    @FXML
   public void initialize(){
        dataTable2=FXCollections.observableArrayList();
        FirstName.setCellValueFactory(new PropertyValueFactory<Client, String>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<Client, String>("LastName"));
        PhoneNumber.setCellValueFactory(new PropertyValueFactory<Client, String>("PhoneNumber"));
        City.setCellValueFactory(new PropertyValueFactory<Client, String>("City"));
        Address.setCellValueFactory(new PropertyValueFactory<Client, String>("Address"));

        try {
            table1.setItems(getClients(File));
        }catch(IOException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }
        Title.setCellValueFactory(new PropertyValueFactory<Book, String>("Title"));
        Author.setCellValueFactory(new PropertyValueFactory<Book, String>("Author"));
        PH.setCellValueFactory(new PropertyValueFactory<Book, String>("PublishingHouse"));
        Quantity.setCellValueFactory(new PropertyValueFactory<Book, String>("Quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<Book, String>("Price"));
        table1.setOnMouseClicked(e -> {
            try {
                events();
                setTotal();
            }catch(IOException e1){
                e1.printStackTrace();

            }catch(ParseException e2){
                e2.printStackTrace();
            }
        });

   }
   public void events() throws IOException, ParseException {

       for(Client client : table1.getSelectionModel().getSelectedItems()){
           dataTable2.clear();
           dataTable2=getOrderedBooks(client, File);
       }
       table2.setItems(dataTable2);
    }

    public void setTotal() throws IOException, ParseException{
        Total.setText("0.0");
        String total="0.0";
        for(Client client:table1.getSelectionModel().getSelectedItems()){
            total=getTotal(client, File);
        }
        Total.setText(total);
    }


  public static ObservableList<Order> ReadOrder(String fileName) throws IOException, ParseException {
      ObservableList<Order> orders=FXCollections.observableArrayList();
      JSONParser jsonParser=new JSONParser();
      FileReader reader=new FileReader(fileName);
      Object obj=jsonParser.parse(reader);
      JSONArray orderList = (JSONArray)obj;

      for(Object order : orderList){
          JSONObject o = (JSONObject)order;
          Client c=new Client(o.get("firstName").toString(), o.get("lastName").toString(),o.get("Address").toString(), o.get("phoneNumber").toString(), o.get("City").toString());
          JSONArray Books=(JSONArray)o.get("Books");
          ObservableList<Book> bookList=FXCollections.observableArrayList();
          for(Object book : Books){
              JSONObject b = (JSONObject)book;
              Book B=new Book(b.get("Title").toString(), b.get("Author").toString(), b.get("PublishingHouse").toString(), b.get("Year").toString(), b.get("Price").toString(), b.get("Quantity").toString());
              bookList.add(B);
          }
          Order O=new Order(new Cart(bookList), c);
          O.getCart().setTotal(o.get("Total").toString());
          orders.add(O);
      }
      return orders;
  }


   public ObservableList<Client> getClients(String file) throws IOException, ParseException{
        ObservableList<Client> clients=FXCollections.observableArrayList();
        ObservableList<Order> Orders=ReadOrder(file);
            for(Order o : Orders){
                clients.add(o.getClient());
            }
        return clients;
   }

   public static ObservableList<Book> getOrderedBooks(Client c, String file) throws IOException, ParseException{

        ObservableList<Book> orderedBooks=FXCollections.observableArrayList();
        orderedBooks.clear();
       JSONParser jsonParser=new JSONParser();
       FileReader reader=new FileReader(file);
       Object obj=jsonParser.parse(reader);

       JSONArray orderList=(JSONArray)obj;
        for(Object aux : orderList){
            JSONObject o=(JSONObject)aux;
            Client cl=new Client(o.get("firstName").toString(), o.get("lastName").toString(), o.get("Address").toString(), o.get("phoneNumber").toString(), o.get("City").toString());
            if(cl.equals(c)){
                JSONArray books=(JSONArray)o.get("Books");
                for(Object b : books){
                    JSONObject o1= (JSONObject)b;
                    Book B=new Book(o1.get("Title").toString(), o1.get("Author").toString(), o1.get("PublishingHouse").toString(),o1.get("Year").toString(), o1.get("Price").toString(),o1.get("Quantity").toString());
                    orderedBooks.add(B);
                }
            }

        }

        return orderedBooks;
   }
  public String getTotal(Client c, String file) throws  IOException, ParseException{
       JSONParser jsonParser=new JSONParser();
       FileReader reader=new FileReader(file);
       Object obj=jsonParser.parse(reader);
       JSONArray orderList=(JSONArray)obj;
       String total="0.0";
       for(Object aux : orderList) {
           JSONObject o=(JSONObject)aux;
           Client cl = new Client(o.get("firstName").toString(), o.get("lastName").toString(), o.get("Address").toString(), o.get("phoneNumber").toString(), o.get("City").toString());
           if(cl.equals(c))
               total=o.get("Total").toString();
       }
       return total;
   }

   @FXML
    public void GoBack(){
       try {
           Stage stage = (Stage) GoBack.getScene().getWindow();
           stage.setTitle("Admin's View");
           Parent managestockRoot= load(getClass().getClassLoader().getResource("AdminView.fxml"));
           Scene scene = new Scene(managestockRoot);
           stage.setScene(scene);
           stage.show();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   @FXML
    public void AcceptOrder(){
       d = new Alert(Alert.AlertType.INFORMATION, "Order accepted! Prepare the Package for delivery!");
       d.setContentText("Order accepted! Prepare the Package for delivery!");
       d.show();
       return;
   }



   @FXML
    public void DeleteOrder() throws IOException, ParseException{
            ObservableList<Order> orders=ReadOrder("../AntiqueStore/src/main/resources/orders.json");
            Client c=table1.getSelectionModel().getSelectedItem();
            Order aux1 = null;
            for(Order o : orders){
                if(o.getClient().equals(c)){
                    aux1=o;
                }
            }
            orders.remove(aux1);

            FileWriter file1 = new FileWriter("../AntiqueStore/src/main/resources/orders.json");


       JSONArray all_orders = new JSONArray();


       for (Order aux: orders) {
           JSONObject OrderDetails = new JSONObject();
           OrderDetails.put("firstName", aux.getClient().getFirstName());
           OrderDetails.put("lastName", aux.getClient().getLastName());
           OrderDetails.put("phoneNumber", aux.getClient().getPhoneNumber());
           OrderDetails.put("City", aux.getClient().getCity());
           OrderDetails.put("Address", aux.getClient().getAddress());
           OrderDetails.put("Total", aux.getCart().getTotal());

           int no_of_books = aux.getCart().getBooks().size();

           JSONArray books = new JSONArray();
           books.clear();

           for (int i = 0; i < no_of_books; i++) {
               JSONObject book_i = new JSONObject();
               book_i.put("Title", aux.getCart().getBooks().get(i).getTitle());
               book_i.put("Author", aux.getCart().getBooks().get(i).getAuthor());
               book_i.put("PublishingHouse", aux.getCart().getBooks().get(i).getPublishingHouse());
               book_i.put("Year", aux.getCart().getBooks().get(i).getYear());
               book_i.put("Price", aux.getCart().getBooks().get(i).getPrice());
               book_i.put("Quantity", aux.getCart().getBooks().get(i).getQuantity());
               books.add(book_i);
           }
           OrderDetails.put("Books", books);
           all_orders.add(OrderDetails);
       }

       file1.write(all_orders.toJSONString());
       file1.flush();

       Dialog d;
       d = new Alert(Alert.AlertType.INFORMATION, "Order deleted!");
       d.show();

       this.initialize();
   }
}
