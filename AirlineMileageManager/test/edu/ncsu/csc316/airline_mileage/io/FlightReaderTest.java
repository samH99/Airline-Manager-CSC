/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Tests FlightReader
 * 
 * @author someshherath
 */
public class FlightReaderTest {

	private final String[] validFlightNumbers = { "346", "1233", "1316" };

	/**
	 * Tests FlightReader
	 */
	@Test
	public void testReadValidFlights() {

		FlightReader s = new FlightReader();
		assertNotNull(s);
		try {
			ArrayList<Flight> flights = FlightReader.readFlights("input/valid_flights_1.txt");
			assertEquals(3, flights.size());

			for (int i = 0; i < flights.size(); i++) {
				assertEquals(validFlightNumbers[i], flights.get(i).getFlightNumber());
			}
		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + "input/Valid_Airlines1.txt");
		}
	}

}
