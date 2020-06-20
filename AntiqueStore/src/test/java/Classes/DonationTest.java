package Classes;

import javafx.beans.property.SimpleStringProperty;
import org.fis.student.Donation;
import junit.framework.Assert;
import junit.framework.TestCase;
import java.lang.reflect.Field;


public class DonationTest extends TestCase{
    private Donation donation;
    public DonationTest(String s){
        super(s);
    }

    protected void setUp(){
        donation = new Donation("Title1", "Author1", "Publishing House1", "Year1", "First name1", "Last name1", "Email1", "Phone1");
    }
    protected void tearDown(){
        donation = null;
    }

    //Getters

    public void testGetTitle() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("bookTitle");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("Solenoid"));
        final String result1 = donation.getBookTitle();
        Assert.assertEquals(result1, "Solenoid");

        final Field field2 = donation.getClass().getDeclaredField("bookTitle");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("Istanbul"));
        final String result2 = donation.getBookTitle();
        Assert.assertEquals(result2, "Istanbul");

        final Field field3 = donation.getClass().getDeclaredField("bookTitle");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("Padurea norvegiana"));
        final String result3 = donation.getBookTitle();
        Assert.assertEquals(result3, "Padurea norvegiana");
    }

    public void testGetAuthor() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("bookAuthor");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("Mircea Cartarescu"));
        final String result1 = donation.getBookAuthor();
        Assert.assertEquals(result1, "Mircea Cartarescu");

        final Field field2 = donation.getClass().getDeclaredField("bookAuthor");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("Orhan Pamuk"));
        final String result2 = donation.getBookAuthor();
        Assert.assertEquals(result2, "Orhan Pamuk");

        final Field field3 = donation.getClass().getDeclaredField("bookAuthor");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("Haruki Murakami"));
        final String result3 = donation.getBookAuthor();
        Assert.assertEquals(result3, "Haruki Murakami");
    }

    public void testGetPublishingHouse() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("bookPublishingHouse");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("Humanitas"));
        final String result1 = donation.getBookPublishingHouse();
        Assert.assertEquals(result1, "Humanitas");

        final Field field2 = donation.getClass().getDeclaredField("bookPublishingHouse");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("Polirom"));
        final String result2 = donation.getBookPublishingHouse();
        Assert.assertEquals(result2, "Polirom");

        final Field field3 = donation.getClass().getDeclaredField("bookPublishingHouse");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("Polirom"));
        final String result3 = donation.getBookPublishingHouse();
        Assert.assertEquals(result3, "Polirom");
    }

    public void testGetYear() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("bookYear");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("2015"));
        final String result1 = donation.getBookYear();
        Assert.assertEquals(result1, "2015");

        final Field field2 = donation.getClass().getDeclaredField("bookYear");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("2011"));
        final String result2 = donation.getBookYear();
        Assert.assertEquals(result2, "2011");

        final Field field3 = donation.getClass().getDeclaredField("bookYear");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("2011"));
        final String result3 = donation.getBookYear();
        Assert.assertEquals(result3, "2011");
    }

    public void testGetFirstName() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("donorFirstName");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("John"));
        final String result1 = donation.getDonorFirstName();
        Assert.assertEquals(result1, "John");

        final Field field2 = donation.getClass().getDeclaredField("donorFirstName");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("Mary"));
        final String result2 = donation.getDonorFirstName();
        Assert.assertEquals(result2, "Mary");

        final Field field3 = donation.getClass().getDeclaredField("donorFirstName");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("Don"));
        final String result3 = donation.getDonorFirstName();
        Assert.assertEquals(result3, "Don");
    }

    public void testGetLastName() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("donorLastName");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("Doe"));
        final String result1 = donation.getDonorLastName();
        Assert.assertEquals(result1, "Doe");

        final Field field2 = donation.getClass().getDeclaredField("donorLastName");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("Johnson"));
        final String result2 = donation.getDonorLastName();
        Assert.assertEquals(result2, "Johnson");

        final Field field3 = donation.getClass().getDeclaredField("donorLastName");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("Smith"));
        final String result3 = donation.getDonorLastName();
        Assert.assertEquals(result3, "Smith");
    }

    public void testGetEmail() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("donorEmail");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("john.doe@rocketmail.com"));
        final String result1 = donation.getDonorEmail();
        Assert.assertEquals(result1, "john.doe@rocketmail.com");

        final Field field2 = donation.getClass().getDeclaredField("donorEmail");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("mary.johnson@yahoo.com"));
        final String result2 = donation.getDonorEmail();
        Assert.assertEquals(result2, "mary.johnson@yahoo.com");

        final Field field3 = donation.getClass().getDeclaredField("donorEmail");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("don_smith@gmail.com"));
        final String result3 = donation.getDonorEmail();
        Assert.assertEquals(result3, "don_smith@gmail.com");
    }

    public void testGetPhone() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = donation.getClass().getDeclaredField("donorPhoneNumber");
        field1.setAccessible(true);
        field1.set(donation, new SimpleStringProperty("0500-933-650"));
        final String result1 = donation.getDonorPhoneNumber();
        Assert.assertEquals(result1, "0500-933-650");

        final Field field2 = donation.getClass().getDeclaredField("donorPhoneNumber");
        field2.setAccessible(true);
        field2.set(donation, new SimpleStringProperty("0800-455-551"));
        final String result2 = donation.getDonorPhoneNumber();
        Assert.assertEquals(result2, "0800-455-551");

        final Field field3 = donation.getClass().getDeclaredField("donorPhoneNumber");
        field3.setAccessible(true);
        field3.set(donation, new SimpleStringProperty("118-932-0012"));
        final String result3 = donation.getDonorPhoneNumber();
        Assert.assertEquals(result3, "118-932-0012");
    }

    public void testEquals() throws NoSuchFieldException, IllegalAccessException{
        Donation d1 = new Donation("Solenoid", "Mircea Cartarescu", "Humanitas", "2015", "John", "Doe", "john.doe@rocketmail.com", "0500-933-650");
        Donation d2 = new Donation("Solenoid", "Mircea Cartarescu", "Humanitas", "2015", "John", "Doe", "john.doe@rocketmail.com", "0500-933-650");
        Donation d3 = new Donation("Istanbul", "Orhan Pamuk", "Poliron", "2011", "Mary", "Johnson", "mary.johnson@yahoo.com", "0800-455-551");
        Donation d4 = new Donation("Istanbul", "Orhan Pamuk", "Poliron", "2011", "Mary", "Johnson", "mary.johnson@yahoo.com", "0800-455-551");

        assertEquals(true, d1.equals(d2));
        assertEquals(false, d1.equals(d3));
        assertEquals(true, d1.equals(d1));
        assertEquals(true, d3.equals(d4));
        assertEquals(false, d3.equals(d2));
    }
}