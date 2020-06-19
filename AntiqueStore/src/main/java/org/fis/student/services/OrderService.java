package org.fis.student.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.Client;
import org.fis.student.Order;
import org.fis.student.controllers.manageOrderController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OrderService {
    public static void writeNewOrder(Order newOrder, String file1) throws IOException, ParseException {

        ObservableList<Order> OrderList = FXCollections.observableArrayList();
        OrderList =ReadOrder(file1);

        OrderList.add(newOrder);

        FileWriter file = new FileWriter(file1);


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

    public static ObservableList<Order> ReadOrder(String file) throws IOException, ParseException {
        ObservableList<Order> orders=FXCollections.observableArrayList();
        JSONParser jsonParser=new JSONParser();
        FileReader reader=new FileReader(file);
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
}
