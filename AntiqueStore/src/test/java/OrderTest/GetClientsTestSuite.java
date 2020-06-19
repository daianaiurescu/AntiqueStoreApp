package OrderTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class GetClientsTestSuite {

    public static Test suite(){

        TestSuite suite = new TestSuite("GetClients");

        suite.addTest(new manageOrderTests("testClientRossgetter"));
        suite.addTest(new manageOrderTests("testClientMonicagetter"));
        suite.addTest(new manageOrderTests("testClientRachelgetter"));
        return suite;
    }
}
