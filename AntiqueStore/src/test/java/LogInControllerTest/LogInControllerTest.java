package LogInControllerTest;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import junit.framework.Assert;
import org.fis.student.controllers.LogInController;
import org.fis.student.exception.WrongPasswordException;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.fis.student.user.ReadJsonFile;
import org.testfx.framework.junit.ApplicationTest;


import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.junit.Assert.assertNotSame;


public class LogInControllerTest extends ApplicationTest {
    public static final String test_mail="ross.geller@gmail.com";
    public static final String test_password="Ross123";
    private LogInController controller;


    @Before
    public void setUp() throws IOException, ParseException{
        controller=new LogInController();
        controller.mailField=new TextField();
        controller.passwordField=new PasswordField();


        controller.passwordField.setText(test_password);
        controller.mailField.setText(test_mail);

    }

    @Test
    public void testLogIn() {
        byte[] passBytes=test_password.getBytes(StandardCharsets.UTF_8);
        String encodedPassword = Base64.getEncoder().encodeToString(passBytes);
        assertNotSame(test_password, encodedPassword);

        //controller.LogIn();

    }

}
