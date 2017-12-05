package utbm.ia54.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import junit.framework.Test;
import junit.framework.TestSuite;
import utbm.ia54.ant2dgrid.objects.Vector2i;
import utbm.ia54.test.objects.CellTest;
import utbm.ia54.test.objects.Vetor2iTest;

@RunWith(Suite.class)
@SuiteClasses({ CellTest.class, Vetor2iTest.class })
public class AllTests {
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All Tests");
		
		suite.addTest(new TestSuite(CellTest.class));
		suite.addTest(new TestSuite(Vector2i.class));
		
		return suite;
	}
}
