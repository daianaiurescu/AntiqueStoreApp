package BookClassTest;

import javafx.beans.property.SimpleStringProperty;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;

import java.lang.reflect.Field;

public class BookTest extends TestCase{
    private Book book;

    public BookTest(String s){
        super(s);
    }

    protected void setUp(){
        book = new Book("Title1", "Author1", "Publishing House1", "Year1", "Price1", "Quantity1");
    }

    protected void tearDown(){
        book = null;
    }


    public void testGetTitle() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("title");
        field1.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Solenoid"));
        final String result1 = book.getTitle();
        Assert.assertEquals(result1, "Solenoid");

        final Field field2 = book.getClass().getDeclaredField("title");
        field2.setAccessible(true);
        field2.set(book, new SimpleStringProperty("Istanbul"));
        final String result2 = book.getTitle();
        Assert.assertEquals(result2, "Istanbul");

        final Field field3 = book.getClass().getDeclaredField("title");
        field3.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Padurea norvegiana"));
        final String result3 = book.getTitle();
        Assert.assertEquals(result3, "Padurea norvegiana");

    }

    public void testGetAuthor() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("author");
        field1.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Mircea Cartarescu"));
        final String result1 = book.getAuthor();
        Assert.assertEquals(result1, "Mircea Cartarescu");

        final Field field2 = book.getClass().getDeclaredField("author");
        field2.setAccessible(true);
        field2.set(book, new SimpleStringProperty("Orhan Pamuk"));
        final String result2 = book.getAuthor();
        Assert.assertEquals(result2, "Orhan Pamuk");

        final Field field3 = book.getClass().getDeclaredField("author");
        field3.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Haruki Murakami"));
        final String result3 = book.getAuthor();
        Assert.assertEquals(result3, "Haruki Murakami");
    }

    public void testGetPublishingHouse() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("publishingHouse");
        field1.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Humanitas"));
        final String result1 = book.getPublishingHouse();
        Assert.assertEquals(result1, "Humanitas");

        final Field field2 = book.getClass().getDeclaredField("publishingHouse");
        field2.setAccessible(true);
        field2.set(book, new SimpleStringProperty("Polirom"));
        final String result2 = book.getPublishingHouse();
        Assert.assertEquals(result2, "Polirom");

        final Field field3 = book.getClass().getDeclaredField("publishingHouse");
        field3.setAccessible(true);
        field1.set(book, new SimpleStringProperty("Polirom"));
        final String result3 = book.getPublishingHouse();
        Assert.assertEquals(result3, "Polirom");
    }

    public void testGetYear() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("year");
        field1.setAccessible(true);
        field1.set(book, new SimpleStringProperty("2015"));
        final String result1 = book.getYear();
        Assert.assertEquals(result1, "2015");

        final Field field2 = book.getClass().getDeclaredField("year");
        field2.setAccessible(true);
        field2.set(book, new SimpleStringProperty("2011"));
        final String result2 = book.getYear();
        Assert.assertEquals(result2, "2011");

        final Field field3 = book.getClass().getDeclaredField("year");
        field3.setAccessible(true);
        field1.set(book, new SimpleStringProperty("2011"));
        final String result3 = book.getYear();
        Assert.assertEquals(result3, "2011");
    }

    public void testGetQuantity() throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("quantity");
        field1.setAccessible(true);
        field1.set(book, "30");
        final String result1 = book.getQuantity();
        Assert.assertEquals(result1, "30");

        final Field field2 = book.getClass().getDeclaredField("quantity");
        field2.setAccessible(true);
        field2.set(book, "8");
        final String result2 = book.getQuantity();
        Assert.assertEquals(result2, "8");

        final Field field3 = book.getClass().getDeclaredField("quantity");
        field3.setAccessible(true);
        field1.set(book, "33");
        final String result3 = book.getQuantity();
        Assert.assertEquals(result3, "33");
    }


    public void testGetPrice()  throws NoSuchFieldException, IllegalAccessException{
        final Field field1 = book.getClass().getDeclaredField("price");
        field1.setAccessible(true);
        field1.set(book, new SimpleStringProperty("20.0"));
        final String result1 = book.getPrice();
        Assert.assertEquals(result1, "20.0");

        final Field field2 = book.getClass().getDeclaredField("price");
        field2.setAccessible(true);
        field2.set(book, new SimpleStringProperty("8.0"));
        final String result2 = book.getPrice();
        Assert.assertEquals(result2, "8.0");

        final Field field3 = book.getClass().getDeclaredField("price");
        field3.setAccessible(true);
        field1.set(book, new SimpleStringProperty("33.0"));
        final String result3 = book.getPrice();
        Assert.assertEquals(result3, "33.0");
    }

   public void testSetQuantity() throws NoSuchFieldException, IllegalAccessException{
        book.setQuantity("20");
        final Field field1 = book.getClass().getDeclaredField("quantity");
        field1.setAccessible(true);
        Assert.assertEquals(field1.get(book),"20");
    }

    public void testEquals() {
        Book b1 = new Book ("Padurea norvegiana", "Haruki Murakami", "Polirom", "2011", "30.0", "15");
        Book b2 = new Book ("Padurea norvegiana", "Haruki Murakami", "Polirom", "2011", "30.0", "40");
        Book b3 = new Book("Istanbul", "Orhan Pamuk", "Polirom", "2011", "28.0", "10");

        assertEquals(true, b1.equals(b2));
        assertEquals(false, b1.equals(b3));
    }

    public void testToString() {
        Book b1 = new Book ("Padurea norvegiana", "Haruki Murakami", "Polirom", "2011", "30.0", "15");
        final String actual = "Padurea norvegiana, Haruki Murakami, Polirom, 2011, 30.0, q:15";
        final String result = b1.toString();
        Assert.assertEquals(result, actual);

        Book b2 = new Book ("Solenoid", "Mircea Cartarescu", "Humanitas", "2015", "48.7", "20");
        final String actual1 = "Solenoid, Mircea Cartarescu, Humanitas, 2015, 48.7, q:20";
        final String result1 = b2.toString();
        Assert.assertEquals(result1, actual1);
    }
}
