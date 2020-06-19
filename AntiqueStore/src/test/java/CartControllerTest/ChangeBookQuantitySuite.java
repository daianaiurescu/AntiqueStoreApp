package CartControllerTest;

import BookClassTest.BookTest;
import CartClassTest.CartTest;
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
