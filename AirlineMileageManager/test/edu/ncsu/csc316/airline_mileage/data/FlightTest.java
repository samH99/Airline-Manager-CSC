/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Flight
 * 
 * @author someshherath
 */
public class FlightTest {

	/**
	 * Tests Flight
	 */
	@Test
	public void test() {
		Flight f = null;
		f = new Flight("UA", "346", "ORD", "MIA", 1197);

		
		assertEquals("UA", f.getAirline());
		assertEquals("346", f.getFlightNumber());
		assertEquals("ORD", f.getOrigin());
		assertEquals("MIA", f.getDestination());
		assertEquals(1197, f.getDistance());
	}

}
