package OrderClassTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.Client;
import org.fis.student.Order;

import java.lang.reflect.Field;

public class OrderTest extends TestCase {
    public OrderTest(String s) {
        super(s);
    }
    private Cart cart1, cart2;
    private Client client1, client2;
    private Order order1, order2;
    private ObservableList<Book> books= FXCollections.observableArrayList();

    protected void setUp(){
        client1=new Client("Ross", "Geller", "Street1", "123456789", "city1");
        books.add(new Book("Mindset", "Carol S. Dweck", "Curtea Veche", "2017", "26.7", "20"));
        books.add(new Book("Idiotul", "F.M.Dostoievski", "Litera", "1903", "30", "10"));
        cart1=new Cart(books);
        order1=new Order(cart1, client1);

        client2=new Client("Monica", "Geller", "Street2", "987654321", "city1");
        books.add(new Book("Demonii", "F.M.Dostoievski", "Litera", "1871", "35", "15"));
        books.add(new Book("Fight Club", "Chuck Palahniuk", "Polirom", "1996", "25", "5"));
        cart2=new Cart(books);
        order2=new Order(cart2, client2);
    }
    protected void tearDown(){
        client1=null;
        cart1=null;
        order1=null;
        client2=null;
        cart2=null;
        order2=null;
    }

    public void testGetClient() throws NoSuchFieldException, IllegalAccessException{
        final Field field=order1.getClass().getDeclaredField("client");
        field.setAccessible(true);
        field.set(order1, client1);
        final Client result=order1.getClient();
        Assert.assertEquals(result, client1);

        final Field field1=order2.getClass().getDeclaredField("client");
        field1.setAccessible(true);
        field1.set(order2, client2);
        final Client result1=order2.getClient();
        Assert.assertEquals(result1, client2);
    }

    public void testGetCart() throws NoSuchFieldException, IllegalAccessException{
        final Field field=order1.getClass().getDeclaredField("cart");
        field.setAccessible(true);
        field.set(order1, cart1);
        final Cart result=order1.getCart();
        Assert.assertEquals(result, cart1);

        final Field field1=order2.getClass().getDeclaredField("cart");
        field1.setAccessible(true);
        field1.set(order2, cart2);
        final Cart result1=order2.getCart();
        Assert.assertEquals(result1, cart2);
    }

    public void testSetCart() throws NoSuchFieldException, IllegalAccessException{
        ObservableList<Book> b=FXCollections.observableArrayList();
        b.add(new Book("title", "author", "Litera", "2000", "20.5", "15"));
        Cart c=new Cart(b);
        order1.setCart(c);
        final Field field=order1.getClass().getDeclaredField("cart");
        field.setAccessible(true);
        Assert.assertEquals(field.get(order1), c);

        order2.setCart(c);
        final Field field1=order2.getClass().getDeclaredField("cart");
        field1.setAccessible(true);
        Assert.assertEquals(field1.get(order2), c);

        b.add(new Book("title1", "author1", "Litera", "1990", "15", "10"));
        Cart c1=new Cart(b);
        order1.setCart(c1);
        final Field field2=order1.getClass().getDeclaredField("cart");
        field2.setAccessible(true);
        Assert.assertEquals(field2.get(order1), c1);

    }

    public void testSetClient() throws NoSuchFieldException, IllegalAccessException{
        Client c=new Client("Rachel", "Green", "Street10", "10203040", "City2");
        order1.setClient(c);
        final Field field=order1.getClass().getDeclaredField("client");
        field.setAccessible(true);
        Assert.assertEquals(field.get(order1), c);

        order2.setClient(c);
        final Field field2=order2.getClass().getDeclaredField("client");
        field2.setAccessible(true);
        Assert.assertEquals(field2.get(order2), c);

        Client c1=new Client("Rachel", "Green", "Street10", "10203040", "City2");
        order2.setClient(c1);
        final Field field1=order2.getClass().getDeclaredField("client");
        field1.setAccessible(true);
        Assert.assertEquals(field1.get(order2), c1);

        order1.setClient(c1);
        final Field field3=order1.getClass().getDeclaredField("client");
        field3.setAccessible(true);
        Assert.assertEquals(field3.get(order1), c1);

    }
}
