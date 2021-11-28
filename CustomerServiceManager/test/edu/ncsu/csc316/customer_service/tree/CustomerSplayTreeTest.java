/**
 * 
 */
package edu.ncsu.csc316.customer_service.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.customer_service.data.HelpTicket;

/**
 * Tests CustomerSplayTree
 * 
 * @author someshherath
 *
 */
public class CustomerSplayTreeTest {

	/**
	 * Tests CustomerSplayTree
	 */
	@Test
	public void test() {
		CustomerSplayTree c = new CustomerSplayTree();

		assertNotNull(c);
		assertNull(c.root);
	}

	/**
	 * Tests rebalanceInsert, rebalanceAccess, rebalanceDelete
	 */
	@Test
	public void testSplay() {
		HelpTicket suzanne = new HelpTicket(5, "Suzanne", "Cmith", "How do I check my mileage balance?",
				"09/03/2017 10:00:00");
		HelpTicket bob = new HelpTicket(2, "Bob", "Baker", "Can I change my flight?", "08/14/2017 06:54:00");
		HelpTicket dob = new HelpTicket(2, "Bob", "Daker", "Can I change my flight?", "08/14/2017 06:54:00");
		HelpTicket eob = new HelpTicket(2, "Bob", "Eaker", "Can I change my flight?", "08/14/2017 06:54:00");

		CustomerSplayTree c = new CustomerSplayTree();

		c.rebalanceInsert(suzanne);
		c.rebalanceInsert(bob);
		c.rebalanceInsert(dob);

		assertEquals(c.root.value.getLast(), "Daker");
		assertEquals(c.root.left.value.getLast(), "Cmith");
		assertEquals(c.root.left.left.value.getLast(), "Baker");

		assertEquals(
				"Priority 2: submitted at 08/14/2017 06:54:00 by Bob Baker, Question: Can I change my flight?\nPriority 5: submitted at 09/03/2017 10:00:00 by Suzanne Cmith, Question: How do I check my mileage balance?\nPriority 2: submitted at 08/14/2017 06:54:00 by Bob Daker, Question: Can I change my flight?",
				c.inOrder());

		c.rebalanceDelete(c.root);
		assertEquals(c.root.value.getLast(), "Cmith");
		assertEquals(c.root.left.value.getLast(), "Baker");
		assertEquals(
				"Priority 2: submitted at 08/14/2017 06:54:00 by Bob Baker, Question: Can I change my flight?\nPriority 5: submitted at 09/03/2017 10:00:00 by Suzanne Cmith, Question: How do I check my mileage balance?",
				c.inOrder());
		
		
		
		c.rebalanceInsert(eob);
		
		//c.rebalanceDelete(c.root.left.left);
		
		System.out.println(c.root.value);
		System.out.println(c.root.left.value);
		System.out.println(c.root.left.left.right.value);
		
		
		assertEquals(
				"Priority 5: submitted at 09/03/2017 10:00:00 by Suzanne Cmith, Question: How do I check my mileage balance?\nPriority 2: submitted at 08/14/2017 06:54:00 by Bob Daker, Question: Can I change my flight?",
				c.inOrder());

	}

}
