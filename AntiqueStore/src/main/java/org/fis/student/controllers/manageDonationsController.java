package org.fis.student.controllers;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.Book;
import org.fis.student.Donation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class manageDonationsController {

    public static ObservableList<Donation> readDonationsFromFile() throws IOException, ParseException {
        ObservableList<Donation> donations = FXCollections.observableArrayList();
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("../AntiqueStore/src/main/resources/donations.json");
        Object obj = jsonParser.parse(reader);

        JSONArray donationList = (JSONArray)obj;

        for (Object donation : donationList) {
            JSONObject o = (JSONObject)donation;
            Donation d = new Donation(o.get("donorFirstName").toString(), o.get("donorLastName").toString(), o.get("donorEmail").toString(),
                    o.get("donorPhoneNumber").toString(), o.get("bookTitle").toString(), o.get("bookAuthor").toString(),
                    o.get("bookPublishingHouse").toString(), o.get("bookYearOfPublishing").toString());
            donations.add(d);
        }
        return donations;
    }
}
