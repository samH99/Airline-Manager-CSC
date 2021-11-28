/**
 * 
 */
package edu.ncsu.csc316.customer_service.data;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests HelpTicket
 * 
 * @author someshherath
 */
public class HelpTicketTest {

	/**
	 * Tests HelpTicket
	 */
	@Test
	public void test() {
		HelpTicket suzanne = new HelpTicket(5, "Suzanne", "Smith", "How do I check my mileage balance?",
				"09/03/2017 10:00:00");
		HelpTicket bob = new HelpTicket(2, "Bob", "Baker", "Can I change my flight?", "08/14/2017 06:54:00");
		assertNotNull(suzanne);

		assertEquals(5, suzanne.getPriority());
		assertEquals("Suzanne", suzanne.getFirst());
		assertEquals("Smith", suzanne.getLast());
		assertEquals("How do I check my mileage balance?", suzanne.getQuestion());

		assertTrue(suzanne.compareByPlaceInLine(bob) > 0);
		assertTrue(bob.compareByPlaceInLine(suzanne) < 0);

		HelpTicket A = new HelpTicket(2, "A", "B", "", "08/14/2017 06:54:00");
		HelpTicket B = new HelpTicket(2, "A", "B", "", "08/14/2017 06:54:00");
		HelpTicket C = new HelpTicket(2, "A", "B", "", "08/14/2018 06:54:00");
		HelpTicket D = new HelpTicket(2, "A", "B", "", "11/14/2017 06:54:00");
		HelpTicket E = new HelpTicket(2, "A", "B", "", "08/20/2017 06:54:00");
		HelpTicket F = new HelpTicket(2, "A", "B", "", "08/14/2017 11:54:00");
		HelpTicket G = new HelpTicket(2, "A", "B", "", "08/14/2017 06:59:00");
		HelpTicket H = new HelpTicket(2, "A", "B", "", "08/14/2017 06:54:45");

		assertEquals(0, A.compareByPlaceInLine(B));

		assertTrue(A.compareByPlaceInLine(C) > 0);
		assertTrue(C.compareByPlaceInLine(A) < 0);

		assertTrue(A.compareByPlaceInLine(D) > 0);
		assertTrue(D.compareByPlaceInLine(A) < 0);

		assertTrue(A.compareByPlaceInLine(E) > 0);
		assertTrue(E.compareByPlaceInLine(A) < 0);

		assertTrue(A.compareByPlaceInLine(F) > 0);
		assertTrue(F.compareByPlaceInLine(A) < 0);

		assertTrue(A.compareByPlaceInLine(G) > 0);
		assertTrue(G.compareByPlaceInLine(A) < 0);

		assertTrue(A.compareByPlaceInLine(H) > 0);
		assertTrue(H.compareByPlaceInLine(A) < 0);
	}

}
