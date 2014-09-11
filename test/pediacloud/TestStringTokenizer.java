package pediacloud;

import static org.junit.Assert.*;

import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestStringTokenizer {

	static String testString = null;
	static StringTokenizer st = null;
 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testString = "STARTED: Fri Mar 28 14:23:05 GMT 2014";
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testString = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testFirstToken() {
		 st = new StringTokenizer(testString,":");
		String token = st.nextToken();
		System.out.println("1. token = " + token);
		if (!token.equals("STARTED")){
			fail("Didn't create right token."); 
		} else 
			assertTrue(token.equals("STARTED"));
	}
		

	/* It is a problem to use the same token to split the rest of the line */
	@Test
	public final void testNextToken() {
		st = new StringTokenizer(testString,":");
		String token = st.nextToken();
		String secondToken = st.nextToken();
		System.out.println("1. token = " + token);
		System.out.println("2. token = " + secondToken);
		if (!secondToken.startsWith(" Fri")){
			fail("Didn't get right token."); 
		} 
	}	
	
	@Test
	public final void theSolution () {
		st = new StringTokenizer (testString, ":");
		String token = st.nextToken();
		if (token.equals("STARTED")) {
			// Remove this token and keep the reminder
			String remaining = testString.replace("STARTED: ", "");
			System.out.println(remaining);
		}
	}
}
