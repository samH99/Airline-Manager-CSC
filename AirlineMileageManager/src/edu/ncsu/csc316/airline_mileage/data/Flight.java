/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.data;

/**
 * Holds information about the Flights
 * 
 * @author someshherath
 */
public class Flight {

	/**
	 * airline of the flight
	 */
	private String airline;
	/**
	 * flight number of the flight
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
	 * distance of the flight
	 */
	private int distance;

	/**
	 * Constructs a Flight with the information given
	 * 
	 * @param airline
	 *            airline of the flight
	 * @param flightNumber
	 *            flight number of the flight
	 * @param origin
	 *            origin of the flight
	 * @param destination
	 *            destination of the flight
	 * @param distance
	 *            distance of the flight
	 */
	public Flight(String airline, String flightNumber, String origin, String destination, int distance) {
		setAirline(airline);
		setFlightNumber(flightNumber);
		setOrigin(origin);
		setDestination(destination);

		setDistance(distance);
	}

	/**
	 * Returns true if this is before c in a sorted list
	 * 
	 * @param c
	 *            the Flight to compare to
	 * @return true if this is before c in a sorted list
	 */
	public boolean isBefore(Flight c) {
		return (this.getAirline().compareTo(c.getAirline())) < 0;
	}

	/**
	 * Returns the airline
	 * 
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}

	/**
	 * Sets the airline
	 * 
	 * @param airline
	 *            the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}

	/**
	 * Returns the flightNumber
	 * 
	 * @return the flightNumber
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Sets the flightNumber
	 * 
	 * @param flightNumber
	 *            the flightNumber to set
	 */
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	/**
	 * Returns the origin
	 * 
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Sets the origin
	 * 
	 * @param origin
	 *            the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Returns the destination
	 * 
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Sets the destination
	 * 
	 * @param destination
	 *            the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Returns the distance
	 * 
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * Sets the distance
	 * 
	 * @param distance
	 *            the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
