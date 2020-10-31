package edyausubmission;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
 * Tests methods in the Vehicle class.
 * 
 * 
 */

class VehicleTest {

	@Test
	void testGetMethods() {
		Vehicle v = new Vehicle();
		v.create(2020, "Toyota", "Prius");
		assertEquals(0, v.vehicles.get(0).getId());
		assertEquals(2020, v.vehicles.get(0).getYear());
		assertEquals("Toyota", v.vehicles.get(0).getMake());
		assertEquals("Prius", v.vehicles.get(0).getModel());
	}
	
	@Test
	void testSetMethods() {
		Vehicle v = new Vehicle();
		v.create(2020, "Toyota", "Prius");
		v.vehicles.get(0).setId(2);
		v.vehicles.get(0).setYear(2019);
		v.vehicles.get(0).setMake("Honda");
		v.vehicles.get(0).setModel("Civic");
		assertEquals(2, v.vehicles.get(0).getId());
		assertEquals(2019, v.vehicles.get(0).getYear());
		assertEquals("Honda", v.vehicles.get(0).getMake());
		assertEquals("Civic", v.vehicles.get(0).getModel());
	}
	
	@Test
	void testInvalidYear() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			Vehicle v = new Vehicle();
			v.create(1949, "Toyota", "Prius");
		});
		Exception exception2 = assertThrows(ArithmeticException.class, () -> {
			Vehicle v = new Vehicle();
			v.create(2020, "Toyota", "Prius");
			v.vehicles.get(0).setYear(1949);
		});
		assertEquals("Vehicle year must be between 1950 and 2050", exception.getMessage());
		assertEquals("Vehicle year must be between 1950 and 2050", exception2.getMessage());		
	}
	
	@Test
	void testId() {
		Vehicle v = new Vehicle();
		v.create(2020, "Toyota", "Prius");
		v.create(2019, "Honda", "Civic");
		assertEquals(v.vehicles.get(0).getId(), 0);
		assertEquals(v.vehicles.get(1).getId(), 1);
	}
}
