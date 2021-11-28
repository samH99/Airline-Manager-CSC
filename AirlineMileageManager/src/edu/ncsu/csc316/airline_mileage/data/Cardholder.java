/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Holds information about individual cardholders
 * 
 * @author someshherath
 *
 */
public class Cardholder {
	/**
	 * first name of the customer
	 */
	private String first;
	/**
	 * last name of the customer
	 */
	private String last;

	/**
	 * List of airlines
	 */
	private ArrayList<Airline> airlines = new ArrayList<Airline>();

	/**
	 * Constructs Cardholder with information given
	 * 
	 * @param first
	 *            first name of Cardholder
	 * @param last
	 *            last name of Cardholder
	 * @param airlines
	 *            List of airlines
	 */
	public Cardholder(String first, String last, ArrayList<Airline> a) {
		this.first = first;
		this.last = last;
		for (Airline air : a) {
			airlines.add(new Airline(air.getDescription(), air.getIata(), air.getCallsign(), air.getCountry()));
		}
	}

	/**
	 * gets first name
	 * 
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * gets last name
	 * 
	 * @return the last
	 */
	public String getLast() {
		return last;
	}

	/**
	 * returns the List of airlines
	 * 
	 * @return the airlines
	 */
	public ArrayList<Airline> getAirlines() {
		return airlines;
	}

}
