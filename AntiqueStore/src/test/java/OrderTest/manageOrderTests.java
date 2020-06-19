package OrderTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;
import org.fis.student.Client;
import org.fis.student.Order;
import org.fis.student.controllers.manageOrderController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileReader;
import java.io.IOException;

import static org.fis.student.services.OrderService.ReadOrder;

public class manageOrderTests extends ApplicationTest {

    private  manageOrderController controller=new manageOrderController();
    private ObservableList<Book> dataTable2;
    private TableView<Client> table1;
    private TableView<Book> table2;
    private TableColumn<Client,String> FirstName, LastName, PhoneNumber, City, Address;
    private TableColumn<Book,String> Title, Author, PH, Quantity, Price;

    public void setUp(){
        controller.initialize();
    }

    @Test
    public void testGetTotal() throws IOException, ParseException{
        String total = controller.getTotal(new Client("Ross", "Geller", "Street1", "1829402", "City1"), "../AntiqueStore/src/test/resources/orders.json");
        Assert.assertEquals("53.4", total);
    }

    @Test
    public void testGetClients() throws IOException, ParseException{
        ObservableList<Client> clients=controller.getClients("../AntiqueStore/src/test/resources/orders.json");
        ObservableList<Order> Orders=ReadOrder("../AntiqueStore/src/test/resources/orders.json");
        ObservableList<Client> ClientsFromFile= FXCollections.observableArrayList();
        for(Order o : Orders){
            ClientsFromFile.add(o.getClient());
        }

        Assert.assertEquals(ClientsFromFile, clients);
    }

    @Test
    public void testGetOrderedBooks() throws IOException, ParseException{
        ObservableList<Book> orderedBooks=controller.getOrderedBooks(new Client("Ross", "Geller", "Street1", "1829402", "City1"), "../AntiqueStore/src/test/resources/orders.json");
        ObservableList<Book> orderedBooksFromFile=FXCollections.observableArrayList();
        ObservableList<Order> Orders=ReadOrder("../AntiqueStore/src/test/resources/orders.json");
        Order o=Orders.get(0);
        orderedBooksFromFile=o.getCart().getBooks();

        Assert.assertEquals(orderedBooks, orderedBooksFromFile);

    }

    /**@Test
    public void testAcceptOrder(){
        controller.AcceptOrder();
        Assert.assertEquals("Order accepted! Prepare the Package for delivery!", controller.d.getContentText());
    }**/





}
