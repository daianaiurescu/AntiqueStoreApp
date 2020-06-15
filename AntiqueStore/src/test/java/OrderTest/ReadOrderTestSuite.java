package OrderTest;

import junit.framework.Test;
import junit.framework.TestSuite;


public class ReadOrderTestSuite {


    public static Test suite(){

        TestSuite Ordersuite = new TestSuite("Orders");

        Ordersuite.addTest(new manageOrderTests("testRossOrder"));
        Ordersuite.addTest(new manageOrderTests("testMonicaOrder"));
        Ordersuite.addTest(new manageOrderTests("testRachelOrder"));
        return Ordersuite;
    }

}
