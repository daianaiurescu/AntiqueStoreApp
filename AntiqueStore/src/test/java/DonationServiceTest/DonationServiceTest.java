package DonationServiceTest;

import javafx.collections.ObservableList;
import org.fis.student.Donation;
import org.fis.student.controllers.manageDonationsController;
import org.fis.student.services.DonationService;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.fis.student.services.DonationService.readDonationsFromFile;
import static org.fis.student.services.DonationService.writeDonation;
import static org.junit.Assert.*;

public class DonationServiceTest {
    private ObservableList<Donation> donationList;
    private static String fileName = "../AntiqueStore/src/test/resources/donations.json";

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
    }

    @Test
    public void testLoadDonationsFromFile() throws IOException, ParseException {
        donationList = readDonationsFromFile(fileName);
        assertNotNull(DonationService.donations);
        assertEquals(0, DonationService.donations.size());
    }

    @Test
    public void testAddOneDonation() throws Exception {
        donationList = readDonationsFromFile(fileName);
        donationList.add(new Donation("testTitle1", "testAuthor1", "testPublishing1",
                "testYear1", "testFirstName1", "testLastName1",
                "testEmail1", "testPhone1"));
        writeDonation(fileName, donationList);
        assertNotNull(DonationService.donations);
        assertEquals(1, DonationService.donations.size());
    }

    @Test
    public void testAddTwoDonations() throws Exception {
        donationList = readDonationsFromFile(fileName);
        donationList.add(new Donation("testTitle1", "testAuthor1", "testPublishing1",
                "testYear1", "testFirstName1", "testLastName1",
                "testEmail1", "testPhone1"));
        donationList.add(new Donation("testTitle2", "testAuthor2", "testPublishing2",
                "testYear2", "testFirstName2", "testLastName2",
                "testEmail2", "testPhone2"));
        writeDonation(fileName, donationList);
        assertNotNull(DonationService.donations);
        assertEquals(2, DonationService.donations.size());
    }

}