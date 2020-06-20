package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import org.fis.student.*;
import org.fis.student.controllers.PlaceOrderFormController;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileWriter;
import java.io.IOException;

import static org.fis.student.controllers.manageOrderController.ReadOrder;
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
        private static Dialog d;
        private static String fileName="../AntiqueStore/src/test/resources/orders.json";
        private static ObservableList<Order> orders=FXCollections.observableArrayList();

        @BeforeClass
        public static void setUpClass() throws IOException, ParseException{
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
        public void setUp() throws IOException, ParseException{
            try {
                FileWriter writer = new FileWriter(fileName);
                writer.append("[]");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            orders = ReadOrder(fileName);
            controller=new PlaceOrderFormController();
            controller.firstName=new TextField();
            controller.lastName=new TextField();
            controller.address=new TextField();
            controller.phoneNumber=new TextField();
            controller.city=new TextField();
            //d=new Dialog();
            //controller.d=d;
            controller.firstName.setText(test_firstName);
            controller.lastName.setText(test_lastName);
            controller.address.setText(test_address);
            controller.city.setText(test_city);
            controller.phoneNumber.setText(test_phhoneNumber);
            //controller.d.setContentText("text");

            ObservableList<Book> books= FXCollections.observableArrayList();
            books.add(new Book("title", "author", "ph", "1900", "10", "10"));
            c=new Cart(books);
            c.setTotal("100");
            Client cl=new Client(test_firstName, test_lastName, test_address, test_phhoneNumber, test_city);
            o=new Order(c, cl);
            controller.c=c;
            controller.o=o;

            controller.fileName=fileName;
        }

        @Test
        public void testReadOrder() throws IOException, ParseException{
        orders=ReadOrder(fileName);
        assertEquals(0, orders.size());
       }

        @Test
        public void testGetCartFromController1(){
            ObservableList<Book> books1=FXCollections.observableArrayList();
            books1.add(new Book("title", "author", "ph", "1900", "12", "10"));
            Cart c1=new Cart(books1);
            controller.getCartFromController1(c1);
            Assert.assertEquals(c1.getBooks(), controller.c.getBooks());
        }

        @Test
        public void testPlaceOrder(){
           //controller.PlaceOrder();
            if(test_firstName.isEmpty() || test_lastName.isEmpty() || test_address.isEmpty() || test_phhoneNumber.isEmpty() || test_city.isEmpty()){
                controller.PlaceOrder();
                assertEquals( "Form Error! None of these fields should be empty.", controller.d.getContentText());
            }
           // else
               //assertEquals("Your order was submitted!", controller.d.getContentText());

        }

        @Test
       public void testAddOneOrder() throws Exception{
            orders=ReadOrder(fileName);
            orders.add(o);
            controller.writeNewOrder(o,fileName);
            ObservableList<Order> result=ReadOrder(fileName);
            assertEquals(1, result.size());
        }

        @Test
    public void testAddTwoOrders() throws Exception{
            orders=ReadOrder(fileName);
            orders.add(o);
            orders.add(o);
            controller.writeNewOrder(o, fileName);
            controller.writeNewOrder(o,fileName);
            ObservableList<Order> result=ReadOrder(fileName);
            assertEquals(2, result.size());
        }


}
