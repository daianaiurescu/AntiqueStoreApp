package org.fis.student.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.Client;
import org.fis.student.Order;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


public class manageOrderController {
   public static ObservableList<Order> ReadOrder() throws IOException, ParseException {
       ObservableList<Order> orders =  FXCollections.observableArrayList();
       JSONParser jsonParser=new JSONParser();
       FileReader reader=new FileReader("../AntiqueStore/src/main/resources/orders.json");
       Object obj=jsonParser.parse(reader);

       JSONArray orderList=(JSONArray)obj;
       JSONArray books=new JSONArray();
       ObservableList<Book> orderedBooks = FXCollections.observableArrayList();

       for(Object ord: orderList){
           JSONObject o= (JSONObject)ord;
           Client c=new Client(o.get("firstName").toString(), o.get("lastName").toString(), o.get("Address").toString(), o.get("phoneNumber").toString(), o.get("City").toString());
           for(Object b : books){
               JSONObject o1= (JSONObject)b;
               Book B=new Book(o1.get("Title").toString(), o1.get("Author").toString(), o1.get("PublishingHouse").toString(),o1.get("Year").toString(), o1.get("Price").toString(),o1.get("Quantity").toString());
               orderedBooks.add(B);
           }
           Cart ca=new Cart(orderedBooks);
           ca.setTotal(Double.parseDouble(o.get("Total").toString()));
           Order O=new Order(ca, c);
           orders.add(O);
       }
       return orders;
   }
}
