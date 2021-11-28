/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Airline
 * 
 * @author someshherath
 *
 */
public class AirlineTest {

	/**
	 * Tests Airline
	 */
	@Test
	public void test() {
		Airline a = null;
		try {
			a = new Airline("United Airlines", "UA", "UNITED", "United States");
			assertNotNull(a);
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("United Airlines", a.getDescription());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("UA", a.getIata());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("UNITED", a.getCallsign());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("United States", a.getCountry());
		} catch (Exception e) {
			fail();
		}

		try {
			a = new Airline("Delta Air Lines", "DL", "DELTA", "United States");
			assertNotNull(a);
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("Delta Air Lines", a.getDescription());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("DL", a.getIata());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("DELTA", a.getCallsign());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("United States", a.getCountry());
		} catch (Exception e) {
			fail();
		}

	}

}
