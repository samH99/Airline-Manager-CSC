/**
 * 
 */
package edu.ncsu.csc316.hub_manager.priority_queue;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;

/**
 * Tests MinHeap
 * 
 * @author someshherath
 *
 */
public class MinHeapTest {

	/**
	 * Tests MinHeap
	 */
	@Test
	public void testInsertAndRemove() {
		Airport a = new Airport("ORH", 42.26729965209961, -71.87570190429688);
		Airport b = new Airport("RDU", 35.877601623535156, -78.7874984741211);

		Airport c = new Airport("SEA", 47.44900131225586, -122.30899810791016);
		Airport d = new Airport("SFO", 37.61899948120117, -122.375);

		FlightLeg f1 = new FlightLeg(a, b);
		FlightLeg f2 = new FlightLeg(a, c);
		FlightLeg f3 = new FlightLeg(a, d);
		FlightLeg f4 = new FlightLeg(b, c);
		FlightLeg f5 = new FlightLeg(b, d);
		FlightLeg f6 = new FlightLeg(c, d);

		MinHeap m = new MinHeap();
		assertEquals(0, m.heap.size());

		m.insert(f1);
		assertEquals(1, m.heap.size());
		assertEquals(f1, m.heap.get(0));
		m.insert(f2);
		assertEquals(2, m.heap.size());
		assertEquals(f2, m.heap.get(1));
		m.insert(f3);
		assertEquals(3, m.heap.size());
		assertEquals(f3, m.heap.get(2));
		m.insert(f4);
		assertEquals(4, m.heap.size());
		assertEquals(f4, m.heap.get(1));
		assertEquals(f2, m.heap.get(3));
		m.insert(f5);
		assertEquals(5, m.heap.size());
		assertEquals(f5, m.heap.get(4));
		m.insert(f6);
		assertEquals(6, m.heap.size());
		assertEquals(f6, m.heap.get(2));
		assertEquals(f3, m.heap.get(5));

		// for (int i = 0; i < m.heap.size(); i++) {
		// System.out.println(m.heap.get(i).distance);
		//
		// }

		m.deleteMin();
		assertEquals(5, m.heap.size());
		assertEquals(f6, m.heap.get(0));

		m.deleteMin();
		assertEquals(4, m.heap.size());
		assertEquals(f4, m.heap.get(0));

		m.deleteMin();
		assertEquals(3, m.heap.size());
		assertEquals(f5, m.heap.get(0));

		m.deleteMin();
		assertEquals(2, m.heap.size());
		assertEquals(f2, m.heap.get(0));

		m.deleteMin();
		assertEquals(1, m.heap.size());
		assertEquals(f3, m.heap.get(0));

		m.deleteMin();
		assertEquals(0, m.heap.size());

	}

}
