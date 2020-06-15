package OrderTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class OrderedBooksTestSuite {
    public static Test suite(){

        TestSuite suite = new TestSuite("OrderedBooks");

        suite.addTest(new manageOrderTests("testOrderedBooksRoss"));
        suite.addTest(new manageOrderTests("testOrderedBooksMonica"));
        suite.addTest(new manageOrderTests("testOrderedBooksRachel"));
        return suite;
    }
}
