package edu.ncsu.csc316.airline_mileage.data;

/**
 * Holds information about the Airlines
 * 
 * @author someshherath
 */
public class Airline {

	/**
	 * Description of the Airline
	 */
	private String description;
	/**
	 * Iata Code of the Airline
	 */
	private String iata;
	/**
	 * Call sign of the Airline
	 */
	private String callsign;
	/**
	 * Country of the Airline
	 */
	private String country;

	private int miles = 0;

	/**
	 * Constructs an Airline with the information given
	 * 
	 * @param description
	 *            Description of the Airline
	 * @param iata
	 *            Iata Code of the Airline
	 * @param callsign
	 *            Call sign of the Airline
	 * @param country
	 *            Country of the Airline
	 */
	public Airline(String description, String iata, String callsign, String country) {
		setDescription(description);
		setIata(iata);
		setCallsign(callsign);
		setCountry(country);
	}

	/**
	 * Returns true if this is before c in a sorted list
	 * 
	 * @param c
	 *            the Airline to compare to
	 * @return true if this is before c in a sorted list
	 */
	public boolean isBefore(Airline c) {
		return (this.getIata().compareTo(c.getIata())) < 0;
	}

	/**
	 * Returns true if this is before c in miles in a sorted list
	 * 
	 * @param c
	 *            the Airline to compare to
	 * @return true if this is before c in miles in a sorted list
	 */
	public boolean isBeforeMiles(Airline c) {
		return !(this.getMiles() < c.getMiles());
	}

	/**
	 * Adds to the miles of the Airline
	 * 
	 * @param m
	 *            the miles to be added
	 */
	public void addMiles(int m) {
		miles += m;
	}

	/**
	 * Returns the miles
	 * 
	 * @return the miles
	 */
	public int getMiles() {
		return miles;
	}

	/**
	 * Returns the description
	 * 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description
	 * 
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the iata
	 * 
	 * @return the iata
	 */
	public String getIata() {
		return iata;
	}

	/**
	 * Sets the iata
	 * 
	 * @param iata
	 *            the iata to set
	 */
	public void setIata(String iata) {
		this.iata = iata;
	}

	/**
	 * Returns the callsign
	 * 
	 * @return the callsign
	 */
	public String getCallsign() {
		return callsign;
	}

	/**
	 * Sets the callsign
	 * 
	 * @param callsign
	 *            the callsign to set
	 */
	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	/**
	 * Returns the country
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country
	 * 
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
}
