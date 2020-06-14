package UserTest;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadUsersTest extends TestCase{

    public ReadUsersTest(String s){
        super(s);
    }

    private JSONArray userList;

    protected void setUp() throws IOException, ParseException{
        JSONParser jsonParser = new JSONParser();
        FileReader reader=new FileReader("../AntiqueStore/src/test/resources/users.json");
        Object obj=jsonParser.parse(reader);
        userList = (JSONArray)obj;
    }
    protected void tearDown(){
        userList=null;
    }

    public void testJane()  {
        Object user=userList.get(0);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("jane.doe@gmail.com", email);
        Assert.assertEquals("amFuZTEyMw==", password);
        Assert.assertEquals("Administrator", role);
    }

    public void testJohn()  {
        Object user=userList.get(1);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("john.doe@gmail.com", email);
        Assert.assertEquals("am9objEyMw==", password);
        Assert.assertEquals("Administrator", role);
    }

    public void testPhoebe()  {
        Object user=userList.get(2);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("phoebe.buffay@gmail.com", email);
        Assert.assertEquals("cGhvZWJlMTIz", password);
        Assert.assertEquals("Client", role);
    }

    public void testRachel()  {
        Object user=userList.get(3);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("rachel.green@gmail.com", email);
        Assert.assertEquals("cmFjaGVsMTIz", password);
        Assert.assertEquals("Client", role);
    }

    public void testJoey()  {
        Object user=userList.get(4);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("joey.tribbiani@gmail.com", email);
        Assert.assertEquals("am9leTEyMw==", password);
        Assert.assertEquals("Client", role);
    }

    public void testMonica()  {
        Object user=userList.get(5);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("monica.geller@gmail.com", email);
        Assert.assertEquals("bW9uaWNhMTIz", password);
        Assert.assertEquals("Client", role);
    }

    public void testChandler()  {
        Object user=userList.get(6);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("chandler.bing@gmail.com", email);
        Assert.assertEquals("Y2hhbmRsZXIxMjM=", password);
        Assert.assertEquals("Client", role);
    }

    public void testRoss()  {
        Object user=userList.get(7);
        JSONObject o=(JSONObject)user;
        String email=o.get("mailField").toString();
        String password=o.get("passwordField").toString();
        String role=o.get("roleField").toString();
        Assert.assertEquals("ross.geller@gmail.com", email);
        Assert.assertEquals("cm9zczEyMw==", password);
        Assert.assertEquals("Client", role);
    }
}
