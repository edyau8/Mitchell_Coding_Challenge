package test.finalsubmission;

import finalsubmission.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests CRUD methods in the Vehicle class.
 * 
 * @author Edward Yau
 *
 */
public class VehicleTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
 
	/**
	 * Prepares the output stream captor.
	 */
	@BeforeEach
	public void setup() {
		System.setOut(new PrintStream(outputStreamCaptor));
	}
	
	/**
	 * Closes the output stream captor.
	 */
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	/**
	 * Tests basic functionality for CRUD methods.
	 */
	@Test
	public void testCRUD() {
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
			"id: 1, " + "year: 2020, " + "make: Toyota, " + "model: Prius\n" +
			"id: 2, " + "year: 2021, " + "make: Honda, " + "model: Civic"
		);
	}
	
	/**
	 * Tests invalid year input.
	 */
	@Test
	public void testInvalidYear() {
		Vehicle temp = new Vehicle();
		
		String[] args = {"1949", "Toyota", "Prius"};
		temp.create(args);
		
		assertEquals(
				outputStreamCaptor.toString().trim(),
				"Year must be between 1950 and 2050.");
	}
	
	/**
	 * Tests invalid get input.
	 */
	@Test
	public void testInvalidGet() {
		Vehicle temp = new Vehicle();
		
		String[] args = {"make", "make", "Toyota", "Prius"};
		temp.get(args);
		
		assertEquals(
				outputStreamCaptor.toString().trim(),
				"Invalid arguments for get.");
	}
}
