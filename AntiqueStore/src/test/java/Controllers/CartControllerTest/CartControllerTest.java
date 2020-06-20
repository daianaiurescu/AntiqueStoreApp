package Controllers.CartControllerTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.controllers.cartController;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CartControllerTest extends ApplicationTest {

    private cartController controller;
    private static final ObservableList<Book> books=FXCollections.observableArrayList();
    private static final Cart C=new Cart(books);

    @Before
    public void setUp(){
        controller=new cartController();
        controller.selectedBooks=FXCollections.observableArrayList();
        ObservableList<Book> books=FXCollections.observableArrayList();
        books.add(new Book("t", "a", "p", "1900", "10", "12"));
        controller.c=new Cart(books);

        controller.selectedBooks=C.getBooks();
        controller.c=C;
        C.setTotal("120.0");
        C.setBooks(books);

        controller.tableView=new TableView<>();
        controller.priceColumn=new TableColumn<>();
        controller.yearColumn=new TableColumn<>();
        controller.quantityColumn=new TableColumn<>();
        controller.titleColumn=new TableColumn<>();
        controller.authorColumn=new TableColumn<>();
        controller.publishingHouseColumn=new TableColumn<>();
        controller.total=new Label();

        controller.tableView.setItems(books);

        controller.initialize();
    }

    @Test
    public void testTotal(){
        Double sum=0.0;
            sum+=    controller.total();
       assertEquals("120.0", sum.toString());
    }

    @Test
   public void testGetSelectedBooksFromController1(){
            ObservableList<Book> books1=FXCollections.observableArrayList();
            books1=controller.getSelectedBooksFromController1(books);
            books.add(new Book("t", "a", "p", "1900", "10", "12"));
            assertEquals(books1, books);
    }


    @Test
    public void testInitialize(){
        controller.initialize();
        assertNotNull(controller.tableView);
    }
}
