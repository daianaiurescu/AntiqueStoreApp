package org.fis.student.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class manageOrderController {
   /** public static ObservableList<Order> readOrdersFromFile() throws IOException, ParseException {
        ObservableList<Order> orders = FXCollections.observableArrayList();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("../AntiqueStore/src/main/resources/orders.json");
        Object obj = jsonParser.parse(reader);

        JSONArray donationList = (JSONArray)obj;

        for (Object order : orders) {
            JSONObject o = (JSONObject)order;
            Client c=new Client(o.get("firstName").toString(), o.get("lastName").toString(), o.get("phoneNumber").toString(), o.get("city").toString(), o.get("address").toString() );

            orders.add(ord);
        }
        return orders;
    }**/
}
