package pediacloud.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSorting {
	ArrayList<WordLine> al = new ArrayList<WordLine>();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

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
	public final void test() {
		String[] p1 = {"BNAVN", "9", "33"};

		WordLine wl = new WordLine(p1);
		al.add(wl);
		
		String[] p2 = {"ANAVN", "6", "44"};
		WordLine wl2 = new WordLine(p2);
		al.add(wl2);
		
		String[] p3 = {"CNAVN", "8", "66"};
		WordLine wl3 = new WordLine(p3);
		al.add(wl3);
		System.out.println("The unsorted list is like this: \n" + al.toString() );

		Arrays.sort(al.toArray());
		System.out.println("The sorted list is like this: \n" + al.toString() );
		
	}

}
