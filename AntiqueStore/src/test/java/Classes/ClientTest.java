package Classes;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.fis.student.Client;
import java.lang.reflect.Field;

public class ClientTest extends TestCase{
    public ClientTest(String s) {
        super(s);
    }
    private Client client;

    protected void setUp(){
        client=new Client("firstName1", "lastName1", "Street1", "123456789", "city1");
    }
    protected void tearDown(){
        client=null;
    }

    public void testGetFirstName() throws NoSuchFieldException, IllegalAccessException{
        final Field field=client.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        field.set(client, "Ross");
        final String result=client.getFirstName();
        Assert.assertEquals(result, "Ross");

        final Field field1=client.getClass().getDeclaredField("firstName");
        field1.setAccessible(true);
        field1.set(client, "Monica");
        final String result1=client.getFirstName();
        Assert.assertEquals(result1, "Monica");

        final Field field2=client.getClass().getDeclaredField("firstName");
        field2.setAccessible(true);
        field2.set(client, "Chandler");
        final String result2=client.getFirstName();
        Assert.assertEquals(result2, "Chandler");
    }

    public void testGetLastName() throws NoSuchFieldException, IllegalAccessException{
        final Field field=client.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        field.set(client, "Geller");
        final String result=client.getLastName();
        Assert.assertEquals(result, "Geller");

        final Field field1=client.getClass().getDeclaredField("lastName");
        field1.setAccessible(true);
        field1.set(client, "Bing");
        final String result1=client.getLastName();
        Assert.assertEquals(result1, "Bing");

        final Field field2=client.getClass().getDeclaredField("lastName");
        field2.setAccessible(true);
        field2.set(client, "Green");
        final String result2=client.getLastName();
        Assert.assertEquals(result2, "Green");
    }

    public void testGetAddress() throws NoSuchFieldException, IllegalAccessException{
        final Field field=client.getClass().getDeclaredField("address");
        field.setAccessible(true);
        field.set(client, "Street1");
        final String result=client.getAddress();
        Assert.assertEquals(result, "Street1");

        final Field field1=client.getClass().getDeclaredField("address");
        field1.setAccessible(true);
        field1.set(client, "Street2");
        final String result1=client.getAddress();
        Assert.assertEquals(result1, "Street2");

        final Field field2=client.getClass().getDeclaredField("address");
        field2.setAccessible(true);
        field2.set(client, "Street3");
        final String result2=client.getAddress();
        Assert.assertEquals(result2, "Street3");
    }

    public void testGetCity() throws NoSuchFieldException, IllegalAccessException{
        final Field field=client.getClass().getDeclaredField("city");
        field.setAccessible(true);
        field.set(client, "City1");
        final String result=client.getCity();
        Assert.assertEquals(result, "City1");

        final Field field1=client.getClass().getDeclaredField("city");
        field1.setAccessible(true);
        field1.set(client, "City2");
        final String result1=client.getCity();
        Assert.assertEquals(result1, "City2");

        final Field field2=client.getClass().getDeclaredField("city");
        field2.setAccessible(true);
        field2.set(client, "City3");
        final String result2=client.getCity();
        Assert.assertEquals(result2, "City3");
    }

    public void testGetPhoneNumber() throws NoSuchFieldException, IllegalAccessException{
        final Field field=client.getClass().getDeclaredField("phoneNumber");
        field.setAccessible(true);
        field.set(client, "12345");
        final String result=client.getPhoneNumber();
        Assert.assertEquals(result, "12345");

        final Field field1=client.getClass().getDeclaredField("phoneNumber");
        field1.setAccessible(true);
        field1.set(client, "56789");
        final String result1=client.getPhoneNumber();
        Assert.assertEquals(result1, "56789");

        final Field field2=client.getClass().getDeclaredField("phoneNumber");
        field2.setAccessible(true);
        field2.set(client, "98765");
        final String result2=client.getPhoneNumber();
        Assert.assertEquals(result2, "98765");
    }

    public void testEquals() throws NoSuchFieldException, IllegalAccessException {
        Client c1=new Client("Ross", "Geller", "Street1", "123456789", "City1");
        Client c2=new Client("Ross", "Geller", "Street1", "123456789", "City1");
        Client c3=new Client("Monica", "Geller", "Street3", "987654321", "City1");

        assertEquals(true, c1.equals(c2));
        assertEquals(false, c1.equals(c3));
        assertEquals(false, c2.equals(c3));
    }

}
