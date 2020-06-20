package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.fis.student.Book;
import org.fis.student.services.BookService;
import org.json.simple.parser.ParseException;
import org.junit.BeforeClass;
import org.testfx.framework.junit.ApplicationTest;
import org.fis.student.controllers.stockController;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

import static org.fis.student.controllers.stockController.bookList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StockControllerTest extends ApplicationTest {
    private stockController controller;
    private static String fileName = "../AntiqueStore/src/test/resources/books.json";
    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @BeforeClass
    public static void setUpClass(){
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.append("[]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() throws IOException, ParseException {
        controller = new stockController();

        controller.tableView = new TableView<>();
        controller.titleColumn = new TableColumn<>();
        controller.authorColumn = new TableColumn<>();
        controller.publishingHouseColumn = new TableColumn<>();
        controller.yearColumn = new TableColumn<>();
        controller.priceColumn = new TableColumn<>();
        controller.quantityColumn = new TableColumn<>();

        controller.titleTextField = new TextField();
        controller.authorTextField = new TextField();
        controller.publishingHouseTextField = new TextField();
        controller.yearSpinner = new Spinner<Integer>();
        controller.quantitySpinner = new Spinner<Integer>();
        controller.priceSpinner = new Spinner<Double>();


        bookList = BookService.readFromFile(fileName);
       bookList.add(new Book("testTitle", "testAuthor", "testPublishing", "testYear",
                "testPrice", "testQuantity"));
        controller.tableView.setItems(bookList);
        BookService.writeBooks(fileName, bookList);
        controller.fileName = fileName;
    }

    @Test
    public void initializeTest(){
        controller.initialize();
        assertNotNull(controller.tableView);
    }

    @Test
    public void updateJSONFileTestModifyOneBookQuantity() throws IOException, ParseException {
       Book actualizedBook = new Book("testTitle", "testAuthor", "testPublishing", "testYear",
                "testPrice", "testQuantityC");
        controller.updateJSONFile(actualizedBook, fileName);
        ObservableList<Book> booksFromFile = BookService.readFromFile(fileName);
        Book modifiedInFile = booksFromFile.get(booksFromFile.size()-1);

        assertEquals(actualizedBook, modifiedInFile);
    }

    @Test
    public void writeNewBookTest() throws IOException, ParseException {
        Book newBook = new Book("testTitle1", "testAuthor1", "testPublishing1", "testYear1",
                "testPrice1", "testQuantity1");
        bookList.add(newBook);
        controller.writeNewBook(newBook, fileName);
        ObservableList<Book> readBooks = BookService.readFromFile(fileName);

        assertEquals(bookList, readBooks);
    }

    @Test
    public void deleteBookActionTest() throws IOException, ParseException {
        Book deletedBook1 = new Book("deleteTitle1", "deleteAuthor1", "deletePublishing1",
                "deleteYear1", "deletePrice1", "deleteQuantity1");
        ObservableList<Book> aux = FXCollections.observableArrayList();
        aux.add(deletedBook1);
        BookService.writeBooks(fileName, aux);

        controller.bookList = BookService.readFromFile(fileName);

        controller.tableView.getSelectionModel().select(controller.bookList.get(0));
        controller.handleDeleteBookButtonAction();
        aux = BookService.readFromFile(fileName);

        assertEquals(controller.bookList, aux);

    }

}
