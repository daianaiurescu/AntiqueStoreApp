package ViewBooksControllerTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.fis.student.Book;
import org.fis.student.controllers.viewBooksController;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ViewBooksControllerTest extends ApplicationTest {
    private viewBooksController controller;
    private static String fileName = "../AntiqueStore/src/test/resources/books.json";
    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @Before
    public void setUp(){
        controller = new viewBooksController();

        controller.tableView = new TableView<>();
        controller.titleColumn = new TableColumn<>();
        controller.authorColumn = new TableColumn<>();
        controller.publishingHouseColumn = new TableColumn<>();
        controller.yearColumn = new TableColumn<>();
        controller.priceColumn = new TableColumn<>();
        controller.quantityColumn = new TableColumn<>();

        bookList.add(new Book("testTitle", "testAuthor", "testPublishing", "testYear",
                "testPrice", "testQuantity"));
        controller.tableView.setItems(bookList);
        controller.initialize();

    }

    @Test
    public void initializeTest(){
        controller.initialize();
        assertNotNull(controller.tableView);
    }

    @Test
    public void setGetSelectedBooks(){
        ObservableList<Book> newBooks = FXCollections.observableArrayList();
        /*newBooks.add(new Book("testTitle1","testAuthor1", "testPublishing1", "testYear1",
               "testPrice", "testQuantity"));*/
        controller.setSelectedBooks(bookList);
        newBooks = controller.getSelectedBooks();
        assertEquals(bookList, newBooks);
    }
}
