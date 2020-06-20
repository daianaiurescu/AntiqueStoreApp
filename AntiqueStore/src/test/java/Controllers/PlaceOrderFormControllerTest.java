package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.fis.student.*;
import org.fis.student.controllers.PlaceOrderFormController;
import org.fis.student.services.OrderService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static org.fis.student.services.OrderService.ReadOrder;
import static org.fis.student.services.OrderService.writeNewOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlaceOrderFormControllerTest extends ApplicationTest {
        public static final String test_firstName="firstName";
        public static final String test_lastName="lastName";
        public static final String test_address="address";
        public static final String test_phhoneNumber="phoneNumber";
        public static final String test_city="city";
        private Order o;
        private Cart c;
        private PlaceOrderFormController controller;
        private JSONArray orderList;

        /** @BeforeClass
        public static void setUpClass() throws IOException, ParseException{
        OrderService.ReadOrder("../AntiqueStore/src/test/resources/orders.json");
        FileWriter writer=new FileWriter("../AntiqueStore/src/test/resources/orders.json");
        writer.append("[]");
        writer.flush();
        writer.close();
        }**/

        public void setUp() throws IOException, ParseException{
            controller=new PlaceOrderFormController();
            controller.firstName=new TextField();
            controller.lastName=new TextField();
            controller.address=new TextField();
            controller.phoneNumber=new TextField();
            controller.city=new TextField();
            controller.firstName.setText(test_firstName);
            controller.lastName.setText(test_lastName);
            controller.address.setText(test_address);
            controller.city.setText(test_city);
            controller.phoneNumber.setText(test_phhoneNumber);

            ObservableList<Book> books= FXCollections.observableArrayList();
            books.add(new Book("title", "author", "ph", "1900", "10", "10"));
            c=new Cart(books);
            Client cl=new Client(test_firstName, test_lastName, test_address, test_phhoneNumber, test_city);
            o=new Order(c, cl);
            controller.c=c;
            controller.o=o;
        }

        @Test
        public void testPlaceOrder(){
            if(test_firstName.isEmpty() || test_lastName.isEmpty() || test_address.isEmpty() || test_phhoneNumber.isEmpty() || test_city.isEmpty()){
                controller.PlaceOrder();
                assertEquals(controller.d.getContentText(), "Form Error! None of these fields should be empty.");
            }
        }

        @Test
        public void testWriteNewOrder() throws IOException, ParseException {
            String file="../AntiqueStore/src/test/resources/orders.json";
            //writeNewOrder(o, file);
            //assertEquals(6, ReadOrder(file).size());
            assertEquals(6, ReadOrder(file).size());
        }
        @Test
        public void testReadNewOrder() throws IOException, ParseException{
            String file="../AntiqueStore/src/test/resources/orders.json";
            ObservableList<Order> orders=ReadOrder(file);

            JSONParser jsonParser = new JSONParser();
            FileReader reader=new FileReader("../AntiqueStore/src/test/resources/orders.json");
            Object obj=jsonParser.parse(reader);
            orderList = (JSONArray)obj;
            Object Order=orderList.get(0);
            JSONObject o=(JSONObject)Order;

            Assert.assertEquals(o.get("firstName").toString(), orders.get(0).getClient().getFirstName());
            Assert.assertEquals(o.get("lastName").toString(), orders.get(0).getClient().getLastName());
            Assert.assertEquals(o.get("City").toString(), orders.get(0).getClient().getCity());
            Assert.assertEquals(o.get("Address").toString(), orders.get(0).getClient().getAddress());
            Assert.assertEquals(o.get("phoneNumber").toString(), orders.get(0).getClient().getPhoneNumber());

            JSONArray booklist=(JSONArray) o.get("Books");
            Object book=booklist.get(0);

            JSONObject b=(JSONObject) book;
            String title=b.get("Title").toString();
            String author=b.get("Author").toString();
            String ph=b.get("PublishingHouse").toString();
            String price=b.get("Price").toString();
            String qty=b.get("Quantity").toString();
            String year=b.get("Year").toString();
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getTitle(), title);
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getAuthor(), author);
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getPrice(), price);
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getPublishingHouse(), ph);
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getQuantity(), qty);
            Assert.assertEquals(orders.get(0).getCart().getBooks().get(0).getYear(), year);
        }


    }
