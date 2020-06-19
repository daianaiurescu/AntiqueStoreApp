package Services;

import javafx.collections.ObservableList;
import org.fis.student.Book;
import org.fis.student.Donation;
import org.fis.student.services.BookService;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.fis.student.services.BookService.readFromFile;
import static org.fis.student.services.BookService.writeBooks;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BookServiceTest {
    private ObservableList<Book> bookList;
    private static String fileName = "../AntiqueStore/src/test/resources/books.json";

    @BeforeClass
    public static void setUpClass() {
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
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.append("[]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        bookList = readFromFile(fileName);
    }

    @Test
    public void testLoadBooksFromFile() throws IOException, ParseException {
        bookList = readFromFile(fileName);
        assertNotNull(BookService.books);
        assertEquals(0, BookService.books.size());
    }

    @Test
    public void testAddOneBook() throws Exception{
        bookList = readFromFile(fileName);
        bookList.add(new Book("testTitle1", "testAuthor1", "testPublishingHouse1",
                "testYear1", "testPrice1", "testQuantity1"));
        BookService.writeBooks(fileName, bookList);
        assertNotNull(BookService.books);
        assertEquals(1, BookService.books.size());
    }

    @Test
    public void testAddTwoBooks() throws Exception{
        bookList = BookService.readFromFile(fileName);
        bookList.add(new Book("testTitle1", "testAuthor1", "testPublishingHouse1",
                "testYear1", "testPrice1", "testQuantity1"));
        bookList.add(new Book("testTitle2", "testAuthor2", "testPublishingHouse2",
                "testYear2", "testPrice2", "testQuantity2"));
        BookService.writeBooks(fileName, bookList);
        assertNotNull(BookService.books);
        assertEquals(2, BookService.books.size());
    }
}
