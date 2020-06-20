package org.fis.student.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.fis.student.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileWriter;
import java.io.IOException;

public class PlaceOrderFormController {
    @FXML
    public TextField firstName, lastName, address, phoneNumber, city;


    public Order o;
    public  Cart c;

    public Dialog d;

    public String fileName="../AntiqueStore/src/main/resources/orders.json";

    public void getCartFromController1(Cart cart){
        c=new Cart(cart.getBooks());
        c.setTotal(cart.getTotal());
    }


    public void writeNewOrder(Order newOrder, String fileName) throws IOException, ParseException {

        ObservableList<Order> OrderList = FXCollections.observableArrayList();
        OrderList = manageOrderController.ReadOrder(fileName);

        OrderList.add(newOrder);

        FileWriter file = new FileWriter(fileName);


        JSONArray all_orders = new JSONArray();


        for (Order aux: OrderList) {
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

            file.write(all_orders.toJSONString());
            file.flush();


    }


    @FXML
    public void PlaceOrder(){
        if(firstName.getText().isEmpty() || lastName.getText().isEmpty() ||
                address.getText().isEmpty() || phoneNumber.getText().isEmpty() ||
                city.getText().isEmpty()) {
            d = new Alert(Alert.AlertType.INFORMATION, "Form Error! None of these fields should be empty.");
            d.show();
            return;
        }

        else{
            Client cl=new Client(firstName.getText(), lastName.getText(), address.getText(), phoneNumber.getText(), city.getText());
            o=new Order(c, cl);
            try {
                writeNewOrder(o, fileName);
            }catch(IOException e){
                e.printStackTrace();
            }catch(ParseException e1){
                e1.printStackTrace();
            }

            d= new Alert(Alert.AlertType.INFORMATION, "Your order was submitted!");
            d.show();
            return ;
        }
    }
}
