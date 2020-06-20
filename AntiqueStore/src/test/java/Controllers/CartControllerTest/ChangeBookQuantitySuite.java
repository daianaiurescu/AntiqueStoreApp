package Controllers.CartControllerTest;

import Classes.BookTest;
import Classes.CartTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ChangeBookQuantitySuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("ChangeBookQuantityTest");

        suite.addTest(new CartTest("testGetBooks"));
        suite.addTest(new BookTest("testSetQuantity"));
        return suite;
    }
}
