/**
 * 
 */
package edu.ncsu.csc316.hub_manager.manager;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests AirlineHubManager
 * 
 * @author someshherath
 *
 */
public class AirlineHubManagerTest {

	/**
	 * Tests AirlineHubManager
	 */
	@Test
	public void test() {
		AirlineHubManager a = new AirlineHubManager("input/valid_airports_1.txt");

		assertEquals("HubReport[\n   RDU has 3 connections.\n]", a.getPossibleHubs());

		assertEquals(
				"FlightList[\n   Flight[airport1=ORH, airport2=RDU, distance=576.4],\n   Flight[airport1=SEA, airport2=SFO, distance=679.6],\n   Flight[airport1=MIA, airport2=RDU, distance=702.8],\n   Flight[airport1=DFW, airport2=RDU, distance=1059.7],\n   Flight[airport1=DFW, airport2=SFO, distance=1462.3]\n]",
				a.getMinimumFlights());

		AirlineHubManager b = new AirlineHubManager("input/invalid_airports_1.txt");

		assertEquals("HubReport[\n   No airports have at least 3 connecting flights.\n]", b.getPossibleHubs());

		assertEquals("FlightList[\n      No flights connect the provided airports.\n]", b.getMinimumFlights());

		AirlineHubManager c = new AirlineHubManager("input/valid_airports_2.txt");

		assertEquals("HubReport[\n   DFW has 3 connections.\n   RDU has 3 connections.\n   SFO has 3 connections.\n]",
				c.getPossibleHubs());
		assertEquals(
				"FlightList[\n   Flight[airport1=DFW, airport2=DFV, distance=0.0],\n   Flight[airport1=MIA, airport2=MIU, distance=0.0],\n   Flight[airport1=ORH, airport2=ORT, distance=0.0],\n   Flight[airport1=RDU, airport2=RDI, distance=0.0],\n   Flight[airport1=SEA, airport2=SEL, distance=0.0],\n   Flight[airport1=SFO, airport2=SFI, distance=0.0],\n   Flight[airport1=ORH, airport2=RDU, distance=576.4],\n   Flight[airport1=SEA, airport2=SFO, distance=679.6],\n   Flight[airport1=MIA, airport2=RDU, distance=702.8],\n   Flight[airport1=DFW, airport2=RDI, distance=1059.7],\n   Flight[airport1=DFW, airport2=SFO, distance=1462.3]\n]",
				c.getMinimumFlights());

		// AirlineHubManager d = new
		// AirlineHubManager("input/valid_airports_3.txt");
		// System.out.println(d.getPossibleHubs());
	}

}
