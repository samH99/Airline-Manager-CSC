package edu.ncsu.csc316.hub_manager.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Tests AirportReader
 * 
 * @author someshherath
 *
 */
public class AirportReaderTest {

	/**
	 * Tests AirportReader
	 */
	@Test
	public void testReadValidAirports() {
		// for 100% coverage
		AirportReader s = new AirportReader();

		assertNotNull(s);
		String str = "";
		try {
			MultiPurposeList<Airport> airports = AirportReader.readAirports("input/valid_airports_1.txt");
			assertEquals(6, airports.size());

			for (int i = 0; i < airports.size(); i++) {
				str += (airports.get(i).getCode() + "," + airports.get(i).getLatitude() + ","
						+ airports.get(i).getLongitude()) + "\n";
			}
		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + "input/valid_airports_1.txt");
		}

		assertEquals(
				"DFW,32.89680099487305,-97.03800201416016\nMIA,25.79319953918457,-80.29060363769531\nORH,42.26729965209961,-71.87570190429688\nRDU,35.877601623535156,-78.7874984741211\nSEA,47.44900131225586,-122.30899810791016\nSFO,37.61899948120117,-122.375\n",
				str);
	}

}
