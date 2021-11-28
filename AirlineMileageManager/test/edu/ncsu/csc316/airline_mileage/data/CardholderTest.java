/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * tests Cardholder
 * @author someshherath
 *
 */
public class CardholderTest {

	/**
	 * tests Cardholder
	 */
	@Test
	public void test() {
		Cardholder c = new Cardholder(null, null, new ArrayList<Airline>());
		assertNotNull(c);
	}

}
