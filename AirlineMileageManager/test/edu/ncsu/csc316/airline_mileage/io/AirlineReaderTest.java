/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Tests AirlineReader
 * 
 * @author someshherath
 *
 */
public class AirlineReaderTest {

	private final String[] validAirlineIatas = { "UA", "DL", "B6" };

	/**
	 * Tests AirlineReader
	 */
	@Test
	public void testReadValidAirlines() {

		AirlineReader s = new AirlineReader();
		assertNotNull(s);
		try {
			ArrayList<Airline> airlines = AirlineReader.readAirlines("input/valid_airlines_1.txt");
			assertEquals(3, airlines.size());

			for (int i = 0; i < airlines.size(); i++) {
				assertEquals(validAirlineIatas[i], airlines.get(i).getIata());
			}
		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + "input/valid_airlines_1.txt");
		}
	}

}
