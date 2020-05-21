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
    private TextField firstName, lastName, address, phoneNumber, city;

    @FXML
    private Button orderButton;

    private Order o;


    public void writeNewOrder(Order newOrder) throws IOException, ParseException {
        ObservableList<Order> OrderList = FXCollections.observableArrayList();
        //OrderList = manageOrderController.readOrdersFromFile();

        OrderList.add(newOrder);
        FileWriter file = new FileWriter("../AntiqueStore/src/main/resources/orders.json");


        JSONArray orders = new JSONArray();

        for (Order aux: OrderList){
            JSONObject OrderDetails = new JSONObject();
            OrderDetails.put("firstName", aux.getClient().getFirstName());
            OrderDetails.put("lastName", aux.getClient().getLastName());
            OrderDetails.put("phoneNumber", aux.getClient().getPhoneNumber());
            OrderDetails.put("City", aux.getClient().getCity());
            OrderDetails.put("Address", aux.getClient().getAddress());

            int no_of_books=aux.getCart().getBooks().size();

            JSONArray titleArray=(JSONArray)OrderDetails.get("selectedTitles");
            JSONArray authorArray=(JSONArray)OrderDetails.get("selectedAuthors");
            JSONArray qtiesArray=(JSONArray)OrderDetails.get("selectedQuantities");
            for(int i=0;i<no_of_books;i++){

                //OrderDetails.get("selectedTitles").put( ((JSONArray) OrderDetails.get("selectedTitles")), aux.getCart().getBooks().get(i).getTitle());
               // OrderDetails.put(((JSONArray) OrderDetails.get("selectedAuthors")), aux.getCart().getBooks().get(i).getAuthor());
                //OrderDetails.put(((JSONArray) OrderDetails.get("selectedQuantities")), aux.getCart().getBooks().get(i).getQuantity());

                //OrderDetails.get("selectedTitles");
                /**titleArray.add(aux.getCart().getBooks().get(i).getTitle());
                authorArray.add(aux.getCart().getBooks().get(i).getAuthor());
                qtiesArray.add(aux.getCart().getBooks().get(i).getQuantity());**/
            }

            JSONObject obj = new JSONObject();

            orders.add(OrderDetails);
        }

        file.write(orders.toJSONString());
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
