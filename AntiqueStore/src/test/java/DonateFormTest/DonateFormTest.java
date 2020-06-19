package DonateFormTest;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DonateFormTest extends TestCase{
    private JSONArray donationList;
    public DonateFormTest(String s){
        super(s);
    }

    protected void setUp() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("../AntiqueStore/src/test/resources/donations.json");
        Object obj = parser.parse(reader);
        donationList = (JSONArray)obj;
    }

    protected void tearDown(){
        donationList = null;
    }

    public void testJohn(){
        Object donation = donationList.get(0);
        JSONObject obj = (JSONObject)donation;
        String donorFirstName = obj.get("donorFirstName").toString();
        String donorLastName = obj.get("donorLastName").toString();
        String donorEmail = obj.get("donorEmail").toString();
        String donorPhoneNumber = obj.get("donorPhoneNumber").toString();

        String bookTitle = obj.get("bookTitle").toString();
        String bookAuthor = obj.get("bookAuthor").toString();
        String bookPublishingHouse = obj.get("bookPublishingHouse").toString();
        String bookYear = obj.get("bookYear").toString();

        Assert.assertEquals("John", donorFirstName);
        Assert.assertEquals("Travolta", donorLastName);
        Assert.assertEquals("john.travolta@rocketmail.com", donorEmail);
        Assert.assertEquals("681-499-4723", donorPhoneNumber);
        Assert.assertEquals("Fratii Karamazov", bookTitle);
        Assert.assertEquals("FEODOR MIHAILOVICI DOSTOIEVSKI", bookAuthor);
        Assert.assertEquals("Polirom", bookPublishingHouse);
        Assert.assertEquals("2011", bookYear);
    }

    public void testWalter(){
        Object donation = donationList.get(1);
        JSONObject obj = (JSONObject)donation;
        String donorFirstName = obj.get("donorFirstName").toString();
        String donorLastName = obj.get("donorLastName").toString();
        String donorEmail = obj.get("donorEmail").toString();
        String donorPhoneNumber = obj.get("donorPhoneNumber").toString();

        String bookTitle = obj.get("bookTitle").toString();
        String bookAuthor = obj.get("bookAuthor").toString();
        String bookPublishingHouse = obj.get("bookPublishingHouse").toString();
        String bookYear = obj.get("bookYear").toString();

        Assert.assertEquals("Walter", donorFirstName);
        Assert.assertEquals("Walter", donorLastName);
        Assert.assertEquals("walter_white2000@yahoo.com", donorEmail);
        Assert.assertEquals("+40769112553", donorPhoneNumber);
        Assert.assertEquals("Why am I so Clever", bookTitle);
        Assert.assertEquals("Friedrich Nietzsche", bookAuthor);
        Assert.assertEquals("Penguin Books Ltd", bookPublishingHouse);
        Assert.assertEquals("2014", bookYear);
    }

    public void testMary(){
        Object donation = donationList.get(2);
        JSONObject obj = (JSONObject)donation;
        String donorFirstName = obj.get("donorFirstName").toString();
        String donorLastName = obj.get("donorLastName").toString();
        String donorEmail = obj.get("donorEmail").toString();
        String donorPhoneNumber = obj.get("donorPhoneNumber").toString();

        String bookTitle = obj.get("bookTitle").toString();
        String bookAuthor = obj.get("bookAuthor").toString();
        String bookPublishingHouse = obj.get("bookPublishingHouse").toString();
        String bookYear = obj.get("bookYear").toString();

        Assert.assertEquals("Mary", donorFirstName);
        Assert.assertEquals("Johnson", donorLastName);
        Assert.assertEquals("mary.johnson1982@gmail.com", donorEmail);
        Assert.assertEquals("+4077881723", donorPhoneNumber);
        Assert.assertEquals("Solenoid", bookTitle);
        Assert.assertEquals("Mircea Cartarescu", bookAuthor);
        Assert.assertEquals("Humanitas", bookPublishingHouse);
        Assert.assertEquals("2015", bookYear);
    }


}
