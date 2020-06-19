package DonateFormTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class DonateFormTestSuite {
    public static Test suite(){
        TestSuite suite = new TestSuite("JSON donations");
        suite.addTest(new DonateFormTest("testJohn"));
        suite.addTest(new DonateFormTest("testWalter"));
        suite.addTest(new DonateFormTest("testMary"));
        return suite;
    }
}
