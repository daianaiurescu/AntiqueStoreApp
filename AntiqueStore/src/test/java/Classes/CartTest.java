package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;
import org.fis.student.Cart;

import java.lang.reflect.Field;

public class CartTest extends TestCase{
    public CartTest(String s) {
        super(s);
    }

    private ObservableList<Book> books=FXCollections.observableArrayList();
    private final Cart c=new Cart(books);

    private ObservableList<Book> books1=FXCollections.observableArrayList();


    protected void setUp(){
        books.add((new Book("title", "author", "publishingHouse", "1900", "10.0", "1")));
        books1.add((new Book("title1", "author1", "publishingHouse1", "1900", "10.0", "1")));
    }
    protected void tearDown(){
        books=null;
        books1=null;
    }

    public void testSetBooks() throws NoSuchFieldException, IllegalAccessException{
        books.add((new Book("title2", "author2", "publishingHouse2", "1900", "10.0", "1")));
        c.setBooks(books);
        final Field field=c.getClass().getDeclaredField("books");
        field.setAccessible(true);
        Assert.assertEquals(field.get(c), books);


        books1.add((new Book("title3", "author3", "publishingHouse3", "1900", "10.0", "1")));
        c.setBooks(books1);
        final Field field1=c.getClass().getDeclaredField("books");
        field1.setAccessible(true);
        Assert.assertEquals(field1.get(c), books1);
    }

    public void testSetTotal() throws NoSuchFieldException, IllegalAccessException{
        c.setTotal("100");
        final Field field=c.getClass().getDeclaredField("total");
        field.setAccessible(true);
        Assert.assertEquals(field.get(c), "100");


        c.setTotal("10000");
        final Field field1=c.getClass().getDeclaredField("total");
        field1.setAccessible(true);
        Assert.assertEquals(field1.get(c), "10000");
    }

    public void testGetBooks() throws NoSuchFieldException, IllegalAccessException{
        final Field field=c.getClass().getDeclaredField("books");
        field.setAccessible(true);
        field.set(c, books);
        final ObservableList<Book> result=c.getBooks();
        Assert.assertEquals(result, books);

        final Field field1=c.getClass().getDeclaredField("books");
        field1.setAccessible(true);
        field1.set(c, books1);
        final ObservableList<Book> result1=c.getBooks();
        Assert.assertEquals(result1, books1);

    }

    public void testGetTotal() throws NoSuchFieldException, IllegalAccessException{
        final Field field=c.getClass().getDeclaredField("total");
        field.setAccessible(true);
        field.set(c, "100");
        final String result=c.getTotal();
        Assert.assertEquals(result, "100");

        final Field field1=c.getClass().getDeclaredField("total");
        field1.setAccessible(true);
        field1.set(c, "10000");
        final String result1=c.getTotal();
        Assert.assertEquals(result1, "10000");

    }
}
