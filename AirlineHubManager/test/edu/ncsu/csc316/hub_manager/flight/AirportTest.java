/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Airport
 * 
 * @author someshherath
 *
 */
public class AirportTest {

	/**
	 * Tests the Airport constructor and getters
	 */
	@Test
	public void testAirport() {
		Airport a = new Airport("DFW", 32.89680099487305, -97.03800201416016);

		assertEquals("DFW", a.getCode());
		assertEquals("32.89680099487305", a.getLatitude() + "");
		assertEquals("-97.03800201416016", a.getLongitude() + "");

		a = new Airport("MIA", 25.79319953918457, -80.29060363769531);

		assertEquals("MIA", a.getCode());
		assertEquals("25.79319953918457", a.getLatitude() + "");
		assertEquals("-80.29060363769531", a.getLongitude() + "");
	}

}
