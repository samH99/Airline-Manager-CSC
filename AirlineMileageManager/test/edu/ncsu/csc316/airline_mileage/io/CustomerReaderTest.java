/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Tests CustomerReader
 * 
 * @author someshherath
 *
 */
public class CustomerReaderTest {

	private final String[] validCustomerNames = { "Mcfarland", "Stiltner", "Stiltner", "Mcfarland", "Stiltner",
			"Stiltner", "Mcfarland", "Stiltner", "Mcfarland", "Mcfarland" };

	/**
	 * Tests CustomerReader
	 */
	@Test
	public void testReadValidCustomers() {

		CustomerReader s = new CustomerReader();
		assertNotNull(s);
		try {
			ArrayList<Customer> customers = CustomerReader.readCustomers("input/valid_customers_1.txt");
			assertEquals(10, customers.size());

			for (int i = 0; i < customers.size(); i++) {
				assertEquals(validCustomerNames[i], customers.get(i).getLast());
			}
		} catch (FileNotFoundException e) {
			fail("Unexpected error reading " + "input/valid_customers_1.txt");
		}
	}

}
