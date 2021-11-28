package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests Customer
 * 
 * @author someshherath
 *
 */
public class CustomerTest {

	/**
	 * Tests Customer
	 */
	@Test
	public void test() {
		Customer c = new Customer("Erick", "Mcfarland", "12/20/2015", "UA346", "ORD", "MIA");

		try {
			assertNotNull(c);
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("Erick", c.getFirst());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("Mcfarland", c.getLast());
		} catch (Exception e) {
			fail();
		}

		Customer d = new Customer("Botanny", "Palm", "11/23/2015", "UA386", "ORD", "MIA");

		assertTrue(c.isBefore(d));
		assertFalse(d.isBefore(c));
		try {
			assertEquals("12/20/2015", c.getDate());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("UA", c.getIata());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("346", c.getFlightNumber());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("ORD", c.getOrigin());
		} catch (Exception e) {
			fail();
		}

		try {
			assertEquals("MIA", c.getDestination());
		} catch (Exception e) {
			fail();
		}
	}

}
