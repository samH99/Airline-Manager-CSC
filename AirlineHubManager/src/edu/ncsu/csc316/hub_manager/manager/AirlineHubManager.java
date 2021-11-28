/**
 * 
 */
package edu.ncsu.csc316.hub_manager.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.hub_manager.disjoint_set.UpTree;
import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.flight.FlightLeg;
import edu.ncsu.csc316.hub_manager.io.AirportReader;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;
import edu.ncsu.csc316.hub_manager.priority_queue.MinHeap;

/**
 * Manages the Airline Hubs
 * 
 * @author someshherath
 *
 */
public class AirlineHubManager {

	/**
	 * List of Airports
	 */
	MultiPurposeList<Airport> airportList;
	/**
	 * heap of FlightLegs
	 */
	MinHeap legList;

	/**
	 * minimum List of FlightLegs
	 */
	MultiPurposeList<FlightLeg> minList;

	/**
	 * List of hubs
	 */
	MultiPurposeList<Airport> hubs;

	/**
	 * Constructs a new AirlineHubManager
	 * 
	 * @param pathToFile
	 *            the path to the file that contains the airports
	 */
	public AirlineHubManager(String pathToFile) {
		airportList = new MultiPurposeList<Airport>();
		try {
			airportList = AirportReader.readAirports(pathToFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

		int s = airportList.size();
		legList = new MinHeap();

		for (int i = 0; i < s; i++) {
			for (int c = i + 1; c < s; c++) {
				legList.insert(new FlightLeg(airportList.get(i), airportList.get(c)));
			}
		}

		minList = new MultiPurposeList<FlightLeg>();
		if (legList.heap.size() != 0) {
			makeMST();
		}
	}

	/**
	 * Makes the MST
	 *
	 * Used pseudo-code from lecture slides on kruskal's algorithm
	 *
	 */
	private void makeMST() {
		FlightLeg f;
		Airport t;
		Airport a1;
		Airport a2;

		while (true) {
			f = legList.deleteMin();

			a1 = f.airport1;
			a2 = f.airport2;
			t = UpTree.union(a1, a2);

			if (t != null) {
				minList.add(f);
			}

			if (t != null && t.count == (airportList.size() - 1))
				break;
		}

	}

	/**
	 * Returns a string representation of the list of Flights contained in the
	 * minimum spanning set of flights that connect all airports. The returned
	 * string is in the following format, where the flights are sorted in
	 * increasing order by distance. If multiple flights have the same distance,
	 * order by airport code in ascending alphabetical order. - Distance should
	 * be displayed to 1 decimal place - Each flight line is indented by 3
	 * spaces
	 * 
	 * FlightList[ Flight[airport1=ORH, airport2=RDU, distance=576.4],
	 * Flight[airport1=SEA, airport2=SFO, distance=679.6], Flight[airport1=MIA,
	 * airport2=RDU, distance=702.8], Flight[airport1=DFW, airport2=RDU,
	 * distance=1059.7], Flight[airport1=DFW, airport2=SFO, distance=1462.3] ]
	 * 
	 * @return a string representation of the minimum spanning set of flights
	 */
	public String getMinimumFlights() {

		String r = "FlightList[";
		int s = minList.size();

		if (s == 0) {
			r += "\n      No flights connect the provided airports.";
		}

		for (int i = 0; i < s - 1; i++) {
			int m = i;
			for (int c = i + 1; c < s; c++) {
				if (minList.get(c).getDistance() < minList.get(m).getDistance()) {
					m = c;
				} else if (minList.get(c).getDistance() > minList.get(m).getDistance()) {
					m = i;
				} else if (0 > minList.get(c).getAirport1().getCode()
						.compareTo(minList.get(i).getAirport1().getCode())) {
					m = c;
				} else if (0 < minList.get(c).getAirport1().getCode()
						.compareTo(minList.get(i).getAirport1().getCode())) {
					m = i;

				} else if (0 > minList.get(c).getAirport2().getCode()
						.compareTo(minList.get(i).getAirport2().getCode())) {
					m = c;
				} else if (0 < minList.get(c).getAirport2().getCode()
						.compareTo(minList.get(i).getAirport2().getCode())) {
					m = i;
				}

				FlightLeg temp = minList.get(m);
				minList.set(m, minList.get(i));
				minList.set(i, temp);
			}
		}
		int i;
		for (i = 0; i < minList.size() - 1; i++) {
			r += "\n   Flight[airport1=" + minList.get(i).getAirport1().getCode() + ", airport2="
					+ minList.get(i).getAirport2().getCode() + ", distance="
					+ String.format("%.1f", minList.get(i).getDistance()) + "],";
		}

		if (minList.size() > 0) {
			r += "\n   Flight[airport1=" + minList.get(i).getAirport1().getCode() + ", airport2="
					+ minList.get(i).getAirport2().getCode() + ", distance="
					+ String.format("%.1f", minList.get(i).getDistance()) + "]";
		}

		r += "\n]";
		return r;

	}

	/**
	 * Returns the list of possible airport hubs (airports with at least 3
	 * connecting flights in the minimum spanning set of flights). The list
	 * should be output in the following format, where the airports are listed
	 * in descending order by number of connecting flights. If multiple airports
	 * have the same number of connecting flights, order the airports
	 * alphabetically by airport code. - Each airport line is indented by 3
	 * spaces
	 * 
	 * HubReport[ RDU has 3 connections. ]
	 * 
	 * @return the string representation of the list of possible airport hubs
	 */
	public String getPossibleHubs() {
		hubs = new MultiPurposeList<Airport>();

		String r = "HubReport[";

		for (int i = 0; i < airportList.size(); i++) {
			if (airportList.get(i).connections >= 3) {
				hubs.add(airportList.get(i));
			}
		}

		if (hubs.size() == 0) {
			r += "\n   No airports have at least 3 connecting flights.";
		}

		for (int i = 0; i < hubs.size() - 1; i++) {
			int m = i;
			for (int c = i + 1; c < hubs.size(); c++) {
				if (hubs.get(c).connections > hubs.get(i).connections) {
					m = c;
				} else if (hubs.get(c).connections < hubs.get(i).connections) {
					m = i;

				} else if (0 < hubs.get(c).getCode().compareTo(hubs.get(i).getCode())) {
					m = i;
				} else if (0 > hubs.get(c).getCode().compareTo(hubs.get(i).getCode())) {
					m = c;
				}

				Airport temp = hubs.get(m);
				hubs.set(m, hubs.get(i));
				hubs.set(i, temp);
			}
		}

		for (int i = 0; i < hubs.size(); i++) {
			r += "\n   " + hubs.get(i).getCode() + " has " + hubs.get(i).connections + " connections.";
		}

		r += "\n]";
		return r;
	}
}
