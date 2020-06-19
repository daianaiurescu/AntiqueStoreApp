package CartControllerTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.controllers.cartController;

import java.lang.reflect.Field;

public class CartControllerTest extends TestCase {

    public CartControllerTest(String s){super(s);}

    private ObservableList<Book> books= FXCollections.observableArrayList();
    private ObservableList<Book> books1= FXCollections.observableArrayList();
    private final Cart c=new Cart(books);
    private final Cart c1=new Cart(books1);
    private final cartController cc=new cartController();

    protected void setUp(){
        books.add(new Book("title1", "author1", "ph1", "2000", "10.5", "10"));
        books1.add(new Book("title2", "author2", "ph2", "1989", "12", "15"));

    }

    protected void tearDown(){
        books=null;
    }

   public void testGetSelectedBooks() throws NoSuchFieldException, IllegalAccessException{
       final Field field=cc.getClass().getDeclaredField("c");
       field.setAccessible(true);
       field.set(cc, c);
       final ObservableList<Book> result=c.getBooks();
       Assert.assertEquals(result, books);

       Book B=new Book("title", "author", "ph", "1900", "30", "2");
       c1.getBooks().add(B);

       final Field field1=cc.getClass().getDeclaredField("c");
       field1.setAccessible(true);
       field1.set(cc, c1);
       final ObservableList<Book> result1=c1.getBooks();
       Assert.assertEquals(result1, books1);


    }
}
