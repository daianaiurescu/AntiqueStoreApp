package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.fis.student.Donation;
import org.fis.student.controllers.manageDonationsController;
import org.fis.student.services.DonationService;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ManageDonationsControllerTest extends ApplicationTest {
    private static String fileName = "../AntiqueStore/src/test/resources/donations.json";
    private ObservableList<Donation> donationList = FXCollections.observableArrayList();
    private manageDonationsController controller;

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

        controller = new manageDonationsController();

        controller.tableView1 = new TableView<>();
        controller.titleColumn1 = new TableColumn<>();
        controller.authorColumn1 = new TableColumn<>();
        controller.publishingHouseColumn1 = new TableColumn<>();
        controller.yearColumn1 = new TableColumn<>();
        controller.firstNameColumn1 = new TableColumn<>();
        controller.lastNameColumn1 = new TableColumn<>();
        controller.emailColumn1 = new TableColumn<>();
        controller.phoneColumn1 = new TableColumn<>();
        controller.fileName = fileName;

        donationList = DonationService.readDonationsFromFile(fileName);
        donationList.add(new Donation("testTitle", "testAuthor", "testPublishingHouse",
                "testYear", "testFirstName", "testLastName", "testEmail",
                "testPhone"));
        controller.tableView1.setItems(donationList);
        DonationService.writeDonation(fileName, donationList);
    }

    @Test
    public void initializeTest(){
        controller.initialize();
        assertNotNull(controller.tableView1);
    }

    @Test
    public void resolvedButtonTest() throws IOException, ParseException {
        controller.donationList.add(new Donation("deleteTitle", "deleteAuthor", "deletePublishingHouse",
                "deleteYear", "deleteFirstName", "deleteLastName", "deleteEmail",
                "testPhone"));

        DonationService.writeDonation(fileName, controller.donationList);
        controller.tableView1.getSelectionModel().select(donationList.get(0));
        controller.handleResolvedButtonAction();
        ObservableList<Donation> aux = DonationService.readDonationsFromFile(fileName);

        assertEquals(aux, controller.donationList);

    }
}
