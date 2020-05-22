package org.fis.student.controllers;

import com.sun.tools.corba.se.idl.constExpr.Or;
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
    private TextField firstName, lastName, address, phoneNumber, city;


    private Order o;


    public void writeNewOrder(Order newOrder) throws IOException, ParseException {
        ObservableList<Order> OrderList = FXCollections.observableArrayList();
        //OrderList = manageOrderController.readOrdersFromFile();

        OrderList.add(newOrder);
        FileWriter file = new FileWriter("../AntiqueStore/src/main/resources/orders.json");


        JSONArray all_orders = new JSONArray();
        JSONObject OrderDetails = new JSONObject();

        for (Order aux: OrderList) {
            OrderDetails.put("firstName", aux.getClient().getFirstName());
            OrderDetails.put("lastName", aux.getClient().getLastName());
            OrderDetails.put("phoneNumber", aux.getClient().getPhoneNumber());
            OrderDetails.put("City", aux.getClient().getCity());
            OrderDetails.put("Address", aux.getClient().getAddress());

            int no_of_books = aux.getCart().getBooks().size();

            JSONArray books = new JSONArray();

            for (int i = 0; i < no_of_books; i++) {
                JSONObject book_i = new JSONObject();
                book_i.put("Title", aux.getCart().getBooks().get(i).getTitle());
                book_i.put("Author", aux.getCart().getBooks().get(i).getAuthor());
                book_i.put("PublishingHouse", aux.getCart().getBooks().get(i).getPublishingHouse());
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
        Dialog d;
        if(firstName.getText().isEmpty() || lastName.getText().isEmpty() ||
                address.getText().isEmpty() || phoneNumber.getText().isEmpty() ||
                city.getText().isEmpty()) {
            d = new Alert(Alert.AlertType.INFORMATION, "Form Error! None of these fields should be empty.");
            d.show();
            return;
        }
        else{

            Client cl=new Client(firstName.getText(), lastName.getText(), address.getText(), phoneNumber.getText(), city.getText());
            Cart ca=new Cart(cartController.c.getBooks());
            o=new Order(ca,cl);

            try {
                writeNewOrder(o);
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
