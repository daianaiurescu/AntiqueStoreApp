package org.fis.student.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.fis.student.Donation;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DonationService {
    public static ObservableList<Donation> donations;

    public static ObservableList<Donation> readDonationsFromFile(String fileName) throws IOException, ParseException {
        donations = FXCollections.observableArrayList();

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(fileName);

        Object obj = parser.parse(reader);
        JSONArray donationList = (JSONArray)obj;

        for(Object d : donationList){
            JSONObject o = (JSONObject)d;
            Donation don = new Donation(o.get("bookTitle").toString(), o.get("bookAuthor").toString(), o.get("bookPublishingHouse").toString(),
                    o.get("bookYear").toString(),
                    o.get("donorFirstName").toString(),
                    o.get("donorLastName").toString(),
                    o.get("donorEmail").toString(),
                    o.get("donorPhoneNumber").toString());
            donations.add(don);
            //System.out.println(don.toString());
        }
        return donations;
    }

    public static void writeDonation(String fileName, ObservableList<Donation> donationList) throws IOException {
        FileWriter file = new FileWriter(fileName);


        JSONArray updatedDonations = new JSONArray();


        for (Donation aux: donationList) {
            JSONObject DonationDetails = new JSONObject();

            DonationDetails.put("bookTitle", aux.getBookTitle());
            DonationDetails.put("bookAuthor", aux.getBookAuthor());
            DonationDetails.put("bookPublishingHouse", aux.getBookPublishingHouse());
            DonationDetails.put("bookYear", aux.getBookYear());
            DonationDetails.put("donorFirstName", aux.getDonorFirstName());
            DonationDetails.put("donorLastName", aux.getDonorLastName());
            DonationDetails.put("donorEmail", aux.getDonorEmail());
            DonationDetails.put("donorPhoneNumber", aux.getDonorPhoneNumber());


            updatedDonations.add(DonationDetails);
        }

        file.write(updatedDonations.toJSONString());
        file.flush();
    }
}
