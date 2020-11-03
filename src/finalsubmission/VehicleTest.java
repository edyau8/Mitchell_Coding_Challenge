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
	void testCRUD() {
		Vehicle temp = new Vehicle();
		
		String[] args = {};
		temp.delete(args);
		
		String[] args2 = {"2020", "Toyota", "Prius"};
		String[] args3 = {"2019", "Honda", "Civic"};
		temp.create(args2);
		temp.create(args3);
		
		String[] args4 = {"2", "Year", "2021"};
		temp.update(args4);
		
		temp.get(args);
		
		assertEquals(
			outputStreamCaptor.toString().trim(),
			"id: 1\n" +
			"year: 2020\n" +
			"make: Toyota\n" +
			"model: Prius\n\n" +

			"id: 2\n" +
			"year: 2021\n" +
			"make: Honda\n" +
			"model: Civic"
		);
	}
}
