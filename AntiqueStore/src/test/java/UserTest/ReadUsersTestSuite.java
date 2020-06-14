package UserTest;

import UserTest.ReadUsersTest;
import junit.framework.Test;
import junit.framework.TestSuite;

public class ReadUsersTestSuite {

    public static Test suite(){
        TestSuite suite = new TestSuite("Users");
        suite.addTest(new ReadUsersTest("testJane"));
        suite.addTest(new ReadUsersTest("testJohn"));
        suite.addTest(new ReadUsersTest("testPhoebe"));
        suite.addTest(new ReadUsersTest("testRachel"));
        suite.addTest(new ReadUsersTest("testJoey"));
        suite.addTest(new ReadUsersTest("testMonica"));
        suite.addTest(new ReadUsersTest("testChandler"));
        suite.addTest(new ReadUsersTest("testRoss"));
        return suite;
    }
}
