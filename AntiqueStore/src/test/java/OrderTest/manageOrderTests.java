package OrderTest;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class manageOrderTests extends TestCase {

    public manageOrderTests(String s){
        super(s);
    }

    private JSONArray orderList;
    private JSONArray booklist;

    protected void setUp() throws IOException, ParseException{
        JSONParser jsonParser = new JSONParser();
        FileReader reader=new FileReader("../AntiqueStore/src/test/resources/orders.json");
        Object obj=jsonParser.parse(reader);
        orderList = (JSONArray)obj;
    }

    protected void tearDown(){
        orderList=null;
    }

    public void testRossOrder(){
        Object Order=orderList.get(0);
        JSONObject o=(JSONObject) Order;
        String firstName=o.get("firstName").toString();
        String lastName=o.get("lastName").toString();
        String phoneNumber=o.get("phoneNumber").toString();
        String address=o.get("Address").toString();
        String total=o.get("Total").toString();
        String city=o.get("City").toString();

        Assert.assertEquals("Ross", firstName);
        Assert.assertEquals("Geller", lastName);
        Assert.assertEquals("1829402", phoneNumber);
        Assert.assertEquals("Street1", address);
        Assert.assertEquals("City1", city);
        Assert.assertEquals("53.4", total);

        booklist=(JSONArray) o.get("Books");
        Object book=booklist.get(0);


        JSONObject b=(JSONObject) book;
        String title=b.get("Title").toString();
        String author=b.get("Author").toString();
        String ph=b.get("PublishingHouse").toString();
        String price=b.get("Price").toString();
        String qty=b.get("Quantity").toString();
        String year=b.get("Year").toString();
        Assert.assertEquals("Mindset", title);
        Assert.assertEquals("Carol S. Dweck", author);
        Assert.assertEquals("Curtea Veche", ph);
        Assert.assertEquals("26.7", price);
        Assert.assertEquals("2", qty);
        Assert.assertEquals("2017", year);

    }

    public void testMonicaOrder(){
     Object Order=orderList.get(1);
     JSONObject o=(JSONObject) Order;
     String firstName=o.get("firstName").toString();
     String lastName=o.get("lastName").toString();
     String phoneNumber=o.get("phoneNumber").toString();
     String address=o.get("Address").toString();
     String total=o.get("Total").toString();
     String city=o.get("City").toString();

     Assert.assertEquals("Monica", firstName);
     Assert.assertEquals("Geller", lastName);
     Assert.assertEquals("1839402", phoneNumber);
     Assert.assertEquals("Street2", address);
     Assert.assertEquals("City5", city);
     Assert.assertEquals("58.599999999999994", total);

     booklist=(JSONArray) o.get("Books");
     Object book;
     String title, author, ph, price, qty, year;
     JSONObject b;

     book=booklist.get(0);

     b=(JSONObject) book;
     title=b.get("Title").toString();
     author=b.get("Author").toString();
     ph=b.get("PublishingHouse").toString();
     price=b.get("Price").toString();
     qty=b.get("Quantity").toString();
     year=b.get("Year").toString();
     Assert.assertEquals("Mindset", title);
     Assert.assertEquals("Carol S. Dweck", author);
     Assert.assertEquals("Curtea Veche", ph);
     Assert.assertEquals("26.7", price);
     Assert.assertEquals("1", qty);
     Assert.assertEquals("2017", year);

     book=booklist.get(1);


     b=(JSONObject) book;
     title=b.get("Title").toString();
     author=b.get("Author").toString();
     ph=b.get("PublishingHouse").toString();
     price=b.get("Price").toString();
     qty=b.get("Quantity").toString();
     year=b.get("Year").toString();
     Assert.assertEquals("Idiotul", title);
     Assert.assertEquals("F.M. Dostoievski", author);
     Assert.assertEquals("Litera", ph);
     Assert.assertEquals("31.9", price);
     Assert.assertEquals("1", qty);
     Assert.assertEquals("1903", year);

     }

     public void testRachelOrder(){
     Object Order=orderList.get(2);
     JSONObject o=(JSONObject) Order;
     String firstName=o.get("firstName").toString();
     String lastName=o.get("lastName").toString();
     String phoneNumber=o.get("phoneNumber").toString();
     String address=o.get("Address").toString();
     String total=o.get("Total").toString();
     String city=o.get("City").toString();

     Assert.assertEquals("Rachel", firstName);
     Assert.assertEquals("Green", lastName);
     Assert.assertEquals("1932013", phoneNumber);
     Assert.assertEquals("Street56", address);
     Assert.assertEquals("City10", city);
     Assert.assertEquals("100.0", total);

     booklist=(JSONArray) o.get("Books");
     Object book=booklist.get(0);


     JSONObject b=(JSONObject) book;
     String title=b.get("Title").toString();
     String author=b.get("Author").toString();
     String ph=b.get("PublishingHouse").toString();
     String price=b.get("Price").toString();
     String qty=b.get("Quantity").toString();
     String year=b.get("Year").toString();
     Assert.assertEquals("ABC", title);
     Assert.assertEquals("DEF", author);
     Assert.assertEquals("GHI", ph);
     Assert.assertEquals("20.0", price);
     Assert.assertEquals("5", qty);
     Assert.assertEquals("1900", year);

     }

    Object Order;
    JSONObject o;
    String firstName, lastName, phoneNumber, address, total, city;

    public void testClientRossgetter() {
        Order = orderList.get(0);
        o = (JSONObject) Order;
        firstName = o.get("firstName").toString();
        lastName = o.get("lastName").toString();
        phoneNumber = o.get("phoneNumber").toString();
        address = o.get("Address").toString();
        total = o.get("Total").toString();
        city = o.get("City").toString();
        Assert.assertEquals("Ross", firstName);
        Assert.assertEquals("Geller", lastName);
        Assert.assertEquals("1829402", phoneNumber);
        Assert.assertEquals("Street1", address);
        Assert.assertEquals("City1", city);
        Assert.assertEquals("53.4", total);
    }

    public void testClientMonicagetter() {

        Order = orderList.get(1);
        o = (JSONObject) Order;
        firstName = o.get("firstName").toString();
        lastName = o.get("lastName").toString();
        phoneNumber = o.get("phoneNumber").toString();
        address = o.get("Address").toString();
        total = o.get("Total").toString();
        city = o.get("City").toString();

        Assert.assertEquals("Monica", firstName);
        Assert.assertEquals("Geller", lastName);
        Assert.assertEquals("1839402", phoneNumber);
        Assert.assertEquals("Street2", address);
        Assert.assertEquals("City5", city);
        Assert.assertEquals("58.599999999999994", total);
    }

    public void testClientRachelgetter() {
        Order = orderList.get(2);
        o = (JSONObject) Order;
        firstName = o.get("firstName").toString();
        lastName = o.get("lastName").toString();
        phoneNumber = o.get("phoneNumber").toString();
        address = o.get("Address").toString();
        total = o.get("Total").toString();
        city = o.get("City").toString();

        Assert.assertEquals("Rachel", firstName);
        Assert.assertEquals("Green", lastName);
        Assert.assertEquals("1932013", phoneNumber);
        Assert.assertEquals("Street56", address);
        Assert.assertEquals("City10", city);
        Assert.assertEquals("100.0", total);
    }

    public void testTotalRoss(){
        Order=orderList.get(0);
        String total=o.get("Total").toString();
        Assert.assertEquals("53.4", total);
    }

    public void testTotalMonica(){
        Order=orderList.get(1);
        String total=o.get("Total").toString();
        Assert.assertEquals("58.599999999999994", total);
    }

    public void testTotalRachel(){
        Order=orderList.get(2);
        String total=o.get("Total").toString();
        Assert.assertEquals("100.0", total);

    }

    public void testOrderedBooksRoss(){
        Object Order=orderList.get(0);
        JSONObject o=(JSONObject) Order;

        booklist=(JSONArray) o.get("Books");
        Object book=booklist.get(0);
        JSONObject b=(JSONObject) book;
        String title=b.get("Title").toString();
        String author=b.get("Author").toString();
        String ph=b.get("PublishingHouse").toString();
        String price=b.get("Price").toString();
        String qty=b.get("Quantity").toString();
        String year=b.get("Year").toString();
        Assert.assertEquals("Mindset", title);
        Assert.assertEquals("Carol S. Dweck", author);
        Assert.assertEquals("Curtea Veche", ph);
        Assert.assertEquals("26.7", price);
        Assert.assertEquals("2", qty);
        Assert.assertEquals("2017", year);

    }

    public void testOrderedBooksMonica(){
        Object Order=orderList.get(1);
        JSONObject o=(JSONObject) Order;
        booklist=(JSONArray) o.get("Books");
        Object book;
        String title, author, ph, price, qty, year;
        JSONObject b;
        book=booklist.get(0);

        b=(JSONObject) book;
        title=b.get("Title").toString();
        author=b.get("Author").toString();
        ph=b.get("PublishingHouse").toString();
        price=b.get("Price").toString();
        qty=b.get("Quantity").toString();
        year=b.get("Year").toString();
        Assert.assertEquals("Mindset", title);
        Assert.assertEquals("Carol S. Dweck", author);
        Assert.assertEquals("Curtea Veche", ph);
        Assert.assertEquals("26.7", price);
        Assert.assertEquals("1", qty);
        Assert.assertEquals("2017", year);

        book=booklist.get(1);


        b=(JSONObject) book;
        title=b.get("Title").toString();
        author=b.get("Author").toString();
        ph=b.get("PublishingHouse").toString();
        price=b.get("Price").toString();
        qty=b.get("Quantity").toString();
        year=b.get("Year").toString();
        Assert.assertEquals("Idiotul", title);
        Assert.assertEquals("F.M. Dostoievski", author);
        Assert.assertEquals("Litera", ph);
        Assert.assertEquals("31.9", price);
        Assert.assertEquals("1", qty);
        Assert.assertEquals("1903", year);


    }

    public void testOrderedBooksRachel(){
        Object Order=orderList.get(2);
        JSONObject o=(JSONObject) Order;
        booklist=(JSONArray) o.get("Books");
        Object book=booklist.get(0);


        JSONObject b=(JSONObject) book;
        String title=b.get("Title").toString();
        String author=b.get("Author").toString();
        String ph=b.get("PublishingHouse").toString();
        String price=b.get("Price").toString();
        String qty=b.get("Quantity").toString();
        String year=b.get("Year").toString();
        Assert.assertEquals("ABC", title);
        Assert.assertEquals("DEF", author);
        Assert.assertEquals("GHI", ph);
        Assert.assertEquals("20.0", price);
        Assert.assertEquals("5", qty);
        Assert.assertEquals("1900", year);

    }
}
