/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

/**
 * Holds information about an Airport
 * 
 * @author someshherath
 *
 */
public class Airport {

	/** parent Airport */
	public Airport parent;

	/**
	 * Airport Code
	 */
	private String code;

	/**
	 * the Airport's latitude
	 */
	private double latitude;

	/**
	 * the Airport's longitude
	 */
	private double longitude;

	/**
	 * number of connections an airport has
	 */
	public int connections = 0;
	
	/**
	 * number of children an airport has
	 */
	public int count = 0;

	/**
	 * constructs an Airport using the fields given
	 * 
	 * @param code
	 *            the code of the Airport
	 * @param latitude
	 *            the latitude of the Airport
	 * @param longitude
	 *            the longitude of the Airport
	 */
	public Airport(String code, double latitude, double longitude) {
		this.code = code;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * returns the code of the Airport
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * returns the latitude of the Airport
	 * 
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * returns the longitude of the Airport
	 * 
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

}
