/**
 * 
 */
package edu.ncsu.csc316.hub_manager.flight;

/**
 * Contains two Airport objects and the distance between them
 * 
 * @author someshherath
 *
 */
public class FlightLeg {

	private static final double R = 3961.0;

	/**
	 * Airport 1
	 */
	public Airport airport1;

	/**
	 * Airport 2
	 */
	public Airport airport2;

	/**
	 * the distance between the two Airports
	 */
	public double distance;

	/**
	 * Constructs the Flight legend using the two airports given
	 * 
	 * @param airport1
	 *            Airport 1
	 * @param airport2
	 *            Airport 2
	 */
	public FlightLeg(Airport airport1, Airport airport2) {
		this.airport1 = airport1;
		this.airport2 = airport2;
		distance = getDistance(airport1.getLatitude(), airport1.getLongitude(), airport2.getLatitude(),
				airport2.getLongitude());
	}

	/**
	 * calculates the distance between the two airports
	 */
	private static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
		// Convert degrees lat/lon to radians
		double lat1 = Math.toRadians(latitude1);
		double lat2 = Math.toRadians(latitude2);
		double lon1 = Math.toRadians(longitude1);
		double lon2 = Math.toRadians(longitude2);

		// Apply Haversine formula
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		double d = R * c;
		return d;
	}

	/**
	 * returns Airport 1
	 * 
	 * @return the airport1
	 */
	public Airport getAirport1() {
		return airport1;
	}

	/**
	 * returns Airport 2
	 * 
	 * @return the airport2
	 */
	public Airport getAirport2() {
		return airport2;
	}

	/**
	 * returns the distance between the two airports
	 * 
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}

}
