/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests FlightLeg
 * 
 * @author someshherath
 *
 */
public class FlightLegTest {

	/**
	 * Tests FlightLeg constructor and getters
	 */
	@Test
	public void testFlightLeg() {
		Airport a = new Airport("ORH", 42.26729965209961, -71.87570190429688);
		Airport b = new Airport("RDU", 35.877601623535156, -78.7874984741211);

		Airport c = new Airport("SEA", 47.44900131225586, -122.30899810791016);
		Airport d = new Airport("SFO", 37.61899948120117, -122.375);

		FlightLeg f1 = new FlightLeg(a, b);
		assertEquals(a, f1.getAirport1());
		assertEquals(b, f1.getAirport2());
		assertEquals("576.4135582245033", f1.getDistance() + "");

		FlightLeg f2 = new FlightLeg(c, d);
		assertEquals(c, f2.getAirport1());
		assertEquals(d, f2.getAirport2());
		assertEquals("679.5807652590674", f2.getDistance() + "");

	}

}
