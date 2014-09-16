/**
 * 
 */
package pediacloud.model;

//import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author sinso
 *
 */
public class TestWordClickModel {
	static WordClickModel model = null;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		model = new WordClickModel("Rica","Fri Mar 28 14:23:05 GMT 2014");
		System.out.println("Model created: " + model.toString());
	}

	/**
	 * Test method for {@link pediacloud.model.Model#addStartTime(java.util.Date)}.
	 */
	@Test
	public final void testAddStartTime() {
		model.addStartTime("Fri Mar 28 14:23:05 GMT 2014");
		System.out.println("Start time added: " + model.toString());
	}

	/**
	 * Test method for {@link pediacloud.model.Model#addCoordinates(java.lang.String)}.
	 */
	@Test
	public final void testAddCoordinates() {
		model.addCoordinates("51.5268 N  0.1019 W");
		System.out.println("Coordinates added: " + model.toString());
	}

	/**
	 * Test method for {@link pediacloud.model.Model#addPlace(java.lang.String)}.
	 */
	@Test
	public final void testAddPlace() {
		model.addPlace("Northampton Square");
		System.out.println("Place added: " +model.toString());
	}

	/**
	 * Test method for {@link pediacloud.model.Model#addClickedWord(java.lang.String)}.
	 */
	@Test
	public final void testAddClickedWord() {
		model.addClickedWord("CITY");
		System.out.println("Clicked word added: " + model.toString());
	}
	/**
	 * Test method for {@link pediacloud.model.Model#addWordSize(int)}.
	 */
	@Test
	public final void testAddWordSize() { 
		model.addWordSize(35);
		System.out.println("Word size added: " + model.toString());
	}
	
	/**
	 * Test method for {@link pediacloud.model.Model#addWordColor(int)}.
	 */
	@Test
	public final void testAddColor () { 
		model.addWordColor(-16776961);
		System.out.println("Word color added: " + model.toString());
	}
	
	
	@AfterClass
	public static void tearDownAfterClass () {
		model = null;
	}

}
