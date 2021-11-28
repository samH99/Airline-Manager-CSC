/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

/**
 * Holds information about the Customers
 * 
 * @author someshherath
 */
public class Customer {

	/**
	 * first name of the customer
	 */
	private String first;
	/**
	 * last name of the customer
	 */
	private String last;
	/**
	 * last name of the customer
	 */
	/**
	 * date the customer took the flight
	 */
	private String date;
	/**
	 * iata of the flight
	 */
	private String iata;
	/**
	 * flightNumber of the customer
	 */
	private String flightNumber;
	/**
	 * origin of the flight
	 */
	private String origin;
	/**
	 * destination of the flight
	 */
	private String destination;

	/**
	 * Constructs an Customer with the information given
	 * 
	 * @param first
	 *            first name of the customer
	 * @param last
	 *            last name of the customer
	 * @param date
	 *            date the customer took the flight
	 * @param flight
	 *            flight of the customer
	 * @param origin
	 *            origin of the flight
	 * @param destination
	 *            destination of the flight
	 */
	public Customer(String first, String last, String date, String flight, String origin, String destination) {
		setFirst(first);
		setLast(last);
		this.date = date;
		this.iata = flight.substring(0, 2);
		this.flightNumber = flight.substring(2);
		this.origin = origin;
		this.destination = destination;
	}

	/**
	 * Returns true if this is before c in a sorted list
	 * 
	 * @param c
	 *            the Customer to compare to
	 * @return true if this is before c in a sorted list
	 */
	public boolean isBefore(Customer c) {
		return (this.getLast().compareTo(c.getLast())) < 0;
	}

	/**
	 * Gets the first name of the customer
	 * 
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Sets the first name of the customer
	 * 
	 * @param first
	 *            the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Gets the last name of the customer
	 * 
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Sets the last name of the customer
	 * 
	 * @param last
	 *            the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Gets the date the customer took the flight
	 * 
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Gets the flightNumber of the customer
	 * 
	 * @return the flight
	 */
	public String getFlightNumber() {
		return flightNumber;
	}
	
	/**
	 * Gets the iata of the customer
	 * 
	 * @return the iata
	 */
	public String getIata() {
		return iata;
	}

	/**
	 * Gets the origin of the flight
	 * 
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Gets the destination of the flight
	 * 
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

}