package DonateFormControllerTest;

import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import org.fis.student.Donation;
import org.fis.student.controllers.donateFormController;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileWriter;
import java.io.IOException;

import static org.fis.student.services.DonationService.readDonationsFromFile;
import static org.junit.Assert.assertEquals;

public class DonateFormControllerTest extends ApplicationTest {
    public static final String TEST_FIRSTNAME = "testFirstName";
    public static final String TEST_LASTNAME = "testLastName";
    public static final String TEST_EMAIL = "testEmail";
    public static final String TEST_PHONE = "testPhone";

    public static final String TEST_TITLE = "testTitle";
    public static final String TEST_AUTHOR = "testAuthor";
    public static final String TEST_PUBLISHINGHOUSE = "testPublishingHouse";
    public static final String TEST_YEAR = "testYear";
    private donateFormController controller;


    private static String fileName = "../AntiqueStore/src/test/resources/donations.json";
    private ObservableList<Donation> donationList;



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
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.append("[]");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        donationList = readDonationsFromFile(fileName);
        controller = new donateFormController();
        controller.userFirstNameField = new TextField();
        controller.userLastNameField = new TextField();
        controller.userEmailField = new TextField();
        controller.userNumberField = new TextField();
        controller.bookTitleField = new TextField();
        controller.authorNameField = new TextField();
        controller.publishingHouseField = new TextField();
        controller.publishingYearField = new TextField();

        controller.userFirstNameField.setText(TEST_FIRSTNAME);
        controller.userLastNameField.setText(TEST_LASTNAME);
        controller.userEmailField.setText(TEST_EMAIL);
        controller.userNumberField.setText(TEST_PHONE);
        controller.bookTitleField.setText(TEST_TITLE);
        controller.authorNameField.setText(TEST_AUTHOR);
        controller.publishingHouseField.setText(TEST_PUBLISHINGHOUSE);
        controller.publishingYearField.setText(TEST_YEAR);
    }

    @Test
    public void testHandleSubmitButtonAction() throws IOException {
/*       controller.handleSubmitButtonAction();
        String message = controller.d.getContentText();

        assertEquals("Donation submitted.", message);*/
    }
}
