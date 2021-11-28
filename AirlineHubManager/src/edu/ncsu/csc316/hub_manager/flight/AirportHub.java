/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

/**
 * Holds information about an AirportHub
 * 
 * @author someshherath
 *
 */
public class AirportHub {

	/**
	 * Airport Code
	 */
	private String code;

	/**
	 * Number of connections a Hub has
	 */
	private int connections;

	/**
	 * Creates an AirportHub using the fields
	 * 
	 * @param code
	 *            Airport code
	 * @param connections
	 *            the number of connections the hub has
	 */
	public AirportHub(String code, int connections) {
		this.code = code;
		this.connections = connections;
	}

	/**
	 * returns the Airport code
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * returns the number of connections the hub has
	 * 
	 * @return the connections
	 */
	public int getConnections() {
		return connections;
	}

}
