package edu.ncsu.csc316.airline_mileage.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests AirlineMileageManager
 * 
 * @author someshherath
 */
public class AirlineMileageManagerTest {

	/**
	 * Tests AirlineMileageManager Constructor
	 */
	@Test
	public void testAirlineMileageManager() {
		AirlineMileageManager a = new AirlineMileageManager("input/valid_airlines_1.txt", "input/valid_customers_1.txt",
				"input/valid_flights_1.txt");

		assertEquals(
				"Erick Mcfarland earned\n    3591 miles with United Airlines (UA)\n    516 miles with Delta Air Lines (DL)\n    319 miles with JetBlue Airways (B6)",
				a.getMiles("Erick", "Mcfarland"));

		assertEquals("Kassandra Stiltner earned\n    5985 miles with United Airlines (UA)",
				a.getMiles("Kassandra", "Stiltner"));

		assertEquals(
				"Erick Mcfarland earned\n    3591 miles with United Airlines (UA)\n    516 miles with Delta Air Lines (DL)\n    319 miles with JetBlue Airways (B6)\n\nKassandra Stiltner earned\n    5985 miles with United Airlines (UA)",
				a.getMileageReport());

	}

}
