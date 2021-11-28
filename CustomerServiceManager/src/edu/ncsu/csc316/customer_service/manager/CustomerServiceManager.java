/**
 * 
 */
package edu.ncsu.csc316.customer_service.manager;

/**
 * Manages the Customers and the HelpTickets
 * 
 * @author someshherath
 */
public class CustomerServiceManager {

	/**
	 * Constructs a CustomerServiceManager
	 * 
	 * @param pathToHelpTicketsFile
	 *            - path to the help ticket information file
	 */
	public CustomerServiceManager(String pathToHelpTicketsFile) {
		// TODO: add your implementation here
	}

	/**
	 * Outputs the customer's place in line in the help queue, along with the
	 * help ticket information in the format (with 2nd line indentation of 4
	 * spaces and NO newline at the end):
	 *
	 * Bob Baker is number 3 in the queue: Priority 2 submmited on 08/14/2017 at
	 * 06:54:00: Can I change my flight?
	 * 
	 * @param firstName
	 *            - the customer's first name
	 * @param lastName
	 *            - the customer's last name
	 * @return the customer's place in line and help ticket information
	 */
	public String getPlaceInLine(String firstName, String lastName) {
		return null;
		// TODO: add your implementation
	}

	/**
	 * Retrieves the complete help ticket queue, sorted in order that the
	 * customers will be served. Higher priority is served first, and (if
	 * priorities are the same) the help ticket with the earlier submission
	 * timestamp is serviced first.
	 * 
	 * The help queue is returned in the following format (with indentation of 4
	 * spaces and NO newline at the very end):
	 *
	 * Priority 8: submitted at 11/11/2017 23:45:00 by John Smith, Question: How
	 * much does it cost to change flights on the same day? Priority 5:
	 * submitted at 09/03/2017 10:00:00 by Suzanne Smith, Question: How do I
	 * check my mileage balance? Priority 2: submitted at 10/14/2017 06:54:00 by
	 * Bob Baker, Question: Can I change my flight?
	 * 
	 * @return the help ticket queue listed in the order customers will be
	 *         serviced
	 */
	public String getHelpTicketQueue() {
		return null;
		// TODO: add your implementation
	}

	/**
	 * Removes the customer from the help ticket software (for example, if the
	 * customer finds the answer to their question while waiting, they may
	 * cancel their help ticket instead of waiting to be serviced)
	 *
	 * @param firstName
	 *            - the customer's first named
	 * @param lastName
	 *            - the customer's last name
	 */
	public void removeCustomerFromQueue(String firstName, String lastName) {
		// TODO: add your implementation
	}

}
