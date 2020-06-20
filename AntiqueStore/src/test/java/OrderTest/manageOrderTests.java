package OrderTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Book;
import org.fis.student.Cart;
import org.fis.student.Client;
import org.fis.student.Order;
import org.fis.student.controllers.PlaceOrderFormController;
import org.fis.student.controllers.manageOrderController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileReader;
import java.io.IOException;

import static org.fis.student.controllers.manageOrderController.ReadOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class manageOrderTests extends ApplicationTest {

    private  manageOrderController controller=new manageOrderController();
    private static ObservableList<Book> books=FXCollections.observableArrayList();
    private static ObservableList<Client> clients=FXCollections.observableArrayList();
    private String file="../AntiqueStore/src/test/resources/finalorders.json";
    private static ObservableList<Order> orders=FXCollections.observableArrayList();

    @Before
    public void setUp(){
        controller.dataTable2=FXCollections.observableArrayList();
        controller.table1=new TableView<>();
        controller.table2=new TableView<>();
        controller.FirstName=new TableColumn<>();
        controller.LastName=new TableColumn<>();
        controller.Address=new TableColumn<>();
        controller.City=new TableColumn<>();
        controller.PhoneNumber=new TableColumn<>();
        controller.Title=new TableColumn<>();
        controller.Author=new TableColumn<>();
        controller.PH=new TableColumn<>();
        controller.Price=new TableColumn<>();
        controller.Quantity=new TableColumn<>();
        controller.Total=new Label();
        controller.File=file;

        books.add(new Book("title", "author", "ph", "1900", "20", "12"));
        clients.add(new Client("name", "name", "street", "1000", "city"));
        controller.table1.setItems(clients);
        controller.table2.setItems(books);
        controller.initialize();

    }


    @Test
    public void testGetTotal() throws IOException, ParseException{
        String total = controller.getTotal(new Client("Ross", "Geller", "Street1", "123456", "City1"), file);
        Assert.assertEquals("85.8", total);
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
        ObservableList<Book> orderedBooks=controller.getOrderedBooks(new Client("Ross", "Geller", "Street1", "123456", "City1"), "../AntiqueStore/src/test/resources/finalorders.json");
        ObservableList<Book> orderedBooksFromFile=FXCollections.observableArrayList();
        ObservableList<Order> Orders=ReadOrder("../AntiqueStore/src/test/resources/finalorders.json");
        Order o=Orders.get(0);
        orderedBooksFromFile=o.getCart().getBooks();

        Assert.assertEquals(orderedBooks, orderedBooksFromFile);

    }

    /**@Test
    public void testAcceptOrder(){
        controller.AcceptOrder();
        Assert.assertEquals("Order accepted! Prepare the Package for delivery!", controller.d.getContentText());
    }**/

    @Test
    public void testInitialize(){
        controller.initialize();
        assertNotNull(controller.table1);
        assertNotNull(controller.table2);
    }

    @Test
    public void testEvents() throws  IOException, ParseException{
        controller.events();
        assertNotNull(controller.table2);
    }

    @Test
    public void testSetTotal() throws IOException, ParseException{
        controller.setTotal();
        Assert.assertEquals("0.0", controller.Total.getText());
    }
    @Test
    public void testDeleteOrder() throws IOException, ParseException{
        /**controller.table1.setItems(clients);
        controller.DeleteOrder();
        assertEquals("3", ReadOrder(file).size());**/
    }

}
