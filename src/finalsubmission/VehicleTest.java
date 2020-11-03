package finalsubmission;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Tests methods in the Vehicle class.
 * 
 * 
 */

class VehicleTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
 
	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	@Test
	void testGet() {
		Vehicle temp = new Vehicle();
		String[] args = {};
		temp.get(args);
		
		assertEquals(
			outputStreamCaptor.toString().trim(),
			"id: 1\n" +
			"year: 2020\n" +
			"make: toyota\n" +
			"model: prius\n\n" +

			"id: 2\n" +
			"year: 2019\n" +
			"make: honda\n" +
			"model: civic"
		);
	}
	
	@Test
	void testCreate() {
	}
}
