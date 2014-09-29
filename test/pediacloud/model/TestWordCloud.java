package pediacloud.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestWordCloud {
	WordCloud wc;

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
	public final void testGetCollectionSize() {
		WordCloud wc = new WordCloud();
		wc.add("dream1 21 43");
		wc.add("dream2 5 43");
		wc.add("dream3 34 43");
		wc.add("dream4 32 43");
		wc.add("dream5 1 45");
		wc.add("dream6 66 43");
		wc.add("dream7 55 43");
		wc.add("dream8 45 43");
		wc.add("dream9 15 43");
		wc.toString();
		assertTrue(wc.size() == 9);
		wc.clear();
	}
	@Test
	public final void testGetWordSize() {
		WordCloud wc = new WordCloud();
		wc.add("dream1 21 43");
		wc.add("dream2 5 43");
		wc.add("dream3 34 43");
		wc.add("dream4 32 43");
		wc.add("dream5 1 45");
		wc.add("dream6 66 43");
		wc.add("dream7 55 43");
		wc.add("dream8 45 43");
		wc.add("dream9 15 43");
		wc.toString();
		assertTrue(wc.getWordSize("dream3") == 34);
		assertTrue(wc.getWordSize("dream5") == 1);

	}

	@Test
	public final void testGetColor() {
		WordCloud wc = new WordCloud();
		wc.add("dream1 21 43");
		wc.add("dream2 5 43");
		wc.add("dream3 34 43");
		wc.add("dream4 32 43");
		wc.add("dream5 1 45");
		wc.add("dream6 66 43");
		wc.add("dream7 55 43");
		wc.add("dream8 45 43");
		wc.add("dream9 15 43");
		wc.toString();
		System.out.println("Dream5 = " + wc.getColor("dream5"));
		assertTrue(wc.getColor("dream5") == 45);
		assertFalse(wc.getColor("dream3") != 43);
	}

	@Test
	public final void testGetRank() {
		WordCloud wc = new WordCloud();
		wc.add("dream1 21 43");
		wc.add("dream2 5 43");
		wc.add("dream3 34 43");
		wc.add("dream4 32 43");
		wc.add("dream5 1 45");
		wc.add("dream6 66 43");
		wc.add("dream7 55 43");
		wc.add("dream8 45 43");
		wc.add("dream9 15 43");
		wc.toString();
		assertTrue(wc.getRank("dream6") == 1);
		assertTrue(wc.getRank("dream5") == 9);
	}

	@Test
	public final void testSize() {
		WordCloud wc = new WordCloud();
		wc.add("dream1 21 43");
		wc.add("dream2 5 43");
		wc.add("dream3 34 43");
		wc.add("dream4 32 43");
		wc.add("dream5 1 45");
		wc.add("dream6 66 43");
		wc.add("dream7 55 43");
		wc.add("dream8 45 43");
		wc.add("dream9 15 43");
		wc.toString();
		assertTrue(wc.getWordSize("dream8") == 45);
	}

}
