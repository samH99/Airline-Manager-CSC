/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests AirportHub
 * 
 * @author someshherath
 *
 */
public class AirportHubTest {

	/**
	 * Tests the AirportHub constructor and getters
	 */
	@Test
	public void testAirportHub() {
		AirportHub a = new AirportHub("DFW", 3);

		assertEquals("DFW", a.getCode());
		assertEquals(3, a.getConnections());

		a = new AirportHub("MIA", 2);

		assertEquals("MIA", a.getCode());
		assertEquals(2, a.getConnections());
	}

}
