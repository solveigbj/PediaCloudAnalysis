package pediacloud;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWordSplit {
	static TestSplit ts = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ts = new TestSplit();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSplit() {
		if(ts.split()) {
			fail("Not correct parsing");
		}
	}
	@Test
	public final void testNumberOfArguments() {
		if (ts.testNumberOfArguments()){
			fail();
		}
	
	}

}
