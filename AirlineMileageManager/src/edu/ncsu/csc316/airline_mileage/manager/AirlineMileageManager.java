/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.manager;

import java.io.FileNotFoundException;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.data.Cardholder;
import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.io.AirlineReader;
import edu.ncsu.csc316.airline_mileage.io.CustomerReader;
import edu.ncsu.csc316.airline_mileage.io.FlightReader;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Keeps information about Airline Mileage of customers
 * 
 * @author someshherath
 */
public class AirlineMileageManager {

	/**
	 * List of Airlines
	 */
	private ArrayList<Airline> airlineList;
	/**
	 * List of Customers
	 */
	private ArrayList<Customer> customerList;
	/**
	 * List of Flights
	 */
	private ArrayList<Flight> flightList;
	/**
	 * List of Cardholders
	 */
	private ArrayList<Cardholder> cardholderList = new ArrayList<Cardholder>();

	/**
	 * Constructs an AirlineMileageManager
	 * 
	 * @param pathToAirlineFile
	 *            - path to the airline information file
	 * @param pathToCustomerFile
	 *            - path to the customer information file
	 * @param pathToFlightFile
	 *            - path to the flight information file
	 */
	public AirlineMileageManager(String pathToAirlineFile, String pathToCustomerFile, String pathToFlightFile) {
		try {
			airlineList = AirlineReader.readAirlines(pathToAirlineFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

		try {
			customerList = CustomerReader.readCustomers(pathToCustomerFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

		try {
			flightList = FlightReader.readFlights(pathToFlightFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
		}

		airlineList = airlineSort(airlineList);
		customerList = customerSort(customerList);
		flightList = flightSort(flightList);

		int cardholderIdx = 0;
		for (int i = 0; i < customerList.size(); i++) {

			if (!cardholderList.isEmpty()) {

				if (cardholderList.get(cardholderIdx).getLast().equals(customerList.get(i).getLast())
						&& cardholderList.get(cardholderIdx).getFirst().equals(customerList.get(i).getFirst())) {

					ArrayList<Flight> r = new ArrayList<Flight>();
					r = flightSearch(r, customerList.get(i).getIata(),
							customerList.get(i).getFlightNumber(), customerList.get(i).getOrigin(),
							customerList.get(i).getDestination(), 0, flightList.size() - 1);

					for (Flight f : r) {
						if (f.getAirline().equals(customerList.get(i).getIata())
								&& f.getFlightNumber().equals(customerList.get(i).getFlightNumber())
								&& f.getOrigin().equals(customerList.get(i).getOrigin())
								&& f.getDestination().equals(customerList.get(i).getDestination())) {

							airlineSearch(cardholderList.get(cardholderIdx).getAirlines(), f.getAirline(), 0,
									cardholderList.get(cardholderIdx).getAirlines().size() - 1)
											.addMiles(f.getDistance());

						}
					}

				} else {
					cardholderList.add(
							new Cardholder(customerList.get(i).getFirst(), customerList.get(i).getLast(), airlineList));
					cardholderIdx++;

					ArrayList<Flight> r = new ArrayList<Flight>();

					r = flightSearch(r, customerList.get(i).getIata(),
							customerList.get(i).getFlightNumber(), customerList.get(i).getOrigin(),
							customerList.get(i).getDestination(), 0, flightList.size() - 1);

					for (Flight f : r) {
						if (f.getAirline().equals(customerList.get(i).getIata())
								&& f.getFlightNumber().equals(customerList.get(i).getFlightNumber())
								&& f.getOrigin().equals(customerList.get(i).getOrigin())
								&& f.getDestination().equals(customerList.get(i).getDestination())) {

							airlineSearch(cardholderList.get(cardholderIdx).getAirlines(), f.getAirline(), 0,
									cardholderList.get(cardholderIdx).getAirlines().size() - 1)
											.addMiles(f.getDistance());
						}
					}

				}
			} else {
				cardholderList.add(
						new Cardholder(customerList.get(i).getFirst(), customerList.get(i).getLast(), airlineList));
				ArrayList<Flight> r = new ArrayList<Flight>();

				r = flightSearch(r, customerList.get(i).getIata(), customerList.get(i).getFlightNumber(),
						customerList.get(i).getOrigin(), customerList.get(i).getDestination(), 0,
						flightList.size() - 1);

				for (Flight f : r) {
					if (f.getAirline().equals(customerList.get(i).getIata())
							&& f.getFlightNumber().equals(customerList.get(i).getFlightNumber())
							&& f.getOrigin().equals(customerList.get(i).getOrigin())
							&& f.getDestination().equals(customerList.get(i).getDestination())) {

						airlineSearch(cardholderList.get(cardholderIdx).getAirlines(), f.getAirline(), 0,
								cardholderList.get(cardholderIdx).getAirlines().size() - 1).addMiles(f.getDistance());
					}
				}

			}

		}

	}

	/**
	 * Produces the mileage report for all cardholders as a String, sorted
	 * alphabetically by cardholder last name.
	 * 
	 * @return the mileage report for all customers
	 */
	public String getMileageReport() {
		String r = getMiles(cardholderList.get(0).getFirst(), cardholderList.get(0).getLast());
		for (int i = 1; i < cardholderList.size(); i++) {
			Cardholder c = cardholderList.get(i);
			r += "\n\n" + getMiles(c.getFirst(), c.getLast());
		}

		return r;
	}

	/**
	 * Retrieves the frequent flier mileage for the specified cardholder with
	 * the given first name and last name. Miles are listed in descending order
	 * by distance
	 * 
	 * @param firstName
	 *            - the cardholder's first name
	 * @param lastName
	 *            - the cardholder's last name
	 * @return the frequent flier mileage information for the cardholder
	 */
	public String getMiles(String firstName, String lastName) {
		Cardholder c = cardholderSearch(cardholderList, firstName, lastName, 0, cardholderList.size());
		ArrayList<Airline> miles = airlineSortMiles(c.getAirlines());

		String r = firstName + " " + lastName + " earned";
		for (Airline a : miles) {
			int m = a.getMiles();
			if (m > 0) {
				r += "\n    " + m + " miles with " + a.getDescription() + " (" + a.getIata() + ")";
			}
		}

		return r;
	}

	/**
	 * Sorts an ArrayList of Customers using MergeSort
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param list
	 *            an ArrayList of Customers
	 * @return an ArrayList of Customers sorted using MergeSort
	 */
	private ArrayList<Customer> customerSort(ArrayList<Customer> list) {
		ArrayList<Customer> leftList = new ArrayList<Customer>();
		ArrayList<Customer> rightList = new ArrayList<Customer>();
		int centerIdx;

		if (list.size() == 1) {
			return list;
		} else {
			centerIdx = list.size() / 2;
			for (int i = 0; i < centerIdx; i++) {
				leftList.add(list.get(i));
			}
			for (int i = centerIdx; i < list.size(); i++) {
				rightList.add(list.get(i));
			}
			leftList = customerSort(leftList);
			rightList = customerSort(rightList);
			customerMerge(leftList, rightList, list);
		}
		return list;
	}

	/**
	 * Helper for mergeSort that combines the leftList and rightList
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param leftList
	 *            the left halve of the list
	 * @param rightList
	 *            the right halve of the list
	 * @param list
	 *            the full list
	 */
	private void customerMerge(ArrayList<Customer> leftList, ArrayList<Customer> rightList, ArrayList<Customer> list) {
		int leftListIndex = 0;
		int rightListIndex = 0;
		int listIndex = 0;

		while (leftListIndex < leftList.size() && rightListIndex < rightList.size()) {
			if (leftList.get(leftListIndex).isBefore(rightList.get(rightListIndex))) {
				list.set(listIndex, leftList.get(leftListIndex));
				leftListIndex++;
			} else {
				list.set(listIndex, rightList.get(rightListIndex));
				rightListIndex++;
			}
			listIndex++;
		}

		ArrayList<Customer> rest;
		int restIndex;
		if (leftListIndex >= leftList.size()) {
			rest = rightList;
			restIndex = rightListIndex;
		} else {
			rest = leftList;
			restIndex = leftListIndex;
		}
		for (int i = restIndex; i < rest.size(); i++) {
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}

	/**
	 * Uses binary search to search an arrayList of Cardholders for a Cardholder
	 * 
	 * @param list
	 *            ArrayList being searched
	 * @param firstName
	 *            the first name of the Cardholder being searched for
	 * @param lastName
	 *            the last name of the Cardholder being searched for
	 * @param low
	 *            the low index
	 * @param high
	 *            the high index
	 * @return the Cardholder being looked for or null if the Cardholder cannot
	 *         be found
	 */
	private Cardholder cardholderSearch(ArrayList<Cardholder> list, String firstName, String lastName, int low,
			int high) {

		if (low > high) {
			return null;
		} else {
			int mid = (low + high) / 2;
			if (list.get(mid).getLast().equals(lastName) && list.get(mid).getFirst().equals(firstName)) {
				return list.get(mid);
			} else if (list.get(mid).getLast().compareTo(lastName) > 0) {
				return cardholderSearch(list, firstName, lastName, low, mid - 1);
			} else {
				return cardholderSearch(list, firstName, lastName, mid + 1, high);
			}
		}

	}

	/**
	 * Sorts an ArrayList of Airlines using MergeSort by miles
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param list
	 *            an ArrayList of Airlines
	 * @return an ArrayList of Airlines sorted using MergeSort by miles
	 */
	private ArrayList<Airline> airlineSortMiles(ArrayList<Airline> list) {
		ArrayList<Airline> leftList = new ArrayList<Airline>();
		ArrayList<Airline> rightList = new ArrayList<Airline>();
		int centerIdx;

		if (list.size() == 1) {
			return list;
		} else {
			centerIdx = list.size() / 2;
			for (int i = 0; i < centerIdx; i++) {
				leftList.add(list.get(i));
			}
			for (int i = centerIdx; i < list.size(); i++) {
				rightList.add(list.get(i));
			}
			leftList = airlineSortMiles(leftList);
			rightList = airlineSortMiles(rightList);

			airlineMergeMiles(leftList, rightList, list);
		}
		return list;
	}

	/**
	 * Helper for mergeSort that combines the leftList and rightList
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param leftList
	 *            the left halve of the list
	 * @param rightList
	 *            the right halve of the list
	 * @param list
	 *            the full list
	 */
	private void airlineMergeMiles(ArrayList<Airline> leftList, ArrayList<Airline> rightList, ArrayList<Airline> list) {
		int leftListIndex = 0;
		int rightListIndex = 0;
		int listIndex = 0;

		while (leftListIndex < leftList.size() && rightListIndex < rightList.size()) {
			if (leftList.get(leftListIndex).isBeforeMiles(rightList.get(rightListIndex))) {
				list.set(listIndex, leftList.get(leftListIndex));
				leftListIndex++;
			} else {
				list.set(listIndex, rightList.get(rightListIndex));
				rightListIndex++;
			}
			listIndex++;
		}

		ArrayList<Airline> rest;
		int restIndex;
		if (leftListIndex >= leftList.size()) {
			rest = rightList;
			restIndex = rightListIndex;
		} else {
			rest = leftList;
			restIndex = leftListIndex;
		}

		for (int i = restIndex; i < rest.size(); i++) {
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}

	/**
	 * Sorts an ArrayList of Airlines using MergeSort
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param list
	 *            an ArrayList of Airlines
	 * @return an ArrayList of Airlines sorted using MergeSort
	 */
	private ArrayList<Airline> airlineSort(ArrayList<Airline> list) {
		ArrayList<Airline> leftList = new ArrayList<Airline>();
		ArrayList<Airline> rightList = new ArrayList<Airline>();
		int centerIdx;

		if (list.size() == 1) {
			return list;
		} else {
			centerIdx = list.size() / 2;
			for (int i = 0; i < centerIdx; i++) {
				leftList.add(list.get(i));
			}
			for (int i = centerIdx; i < list.size(); i++) {
				rightList.add(list.get(i));
			}
			leftList = airlineSort(leftList);
			rightList = airlineSort(rightList);

			airlineMerge(leftList, rightList, list);
		}
		return list;
	}

	/**
	 * Helper for mergeSort that combines the leftList and rightList
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param leftList
	 *            the left halve of the list
	 * @param rightList
	 *            the right halve of the list
	 * @param list
	 *            the full list
	 */
	private void airlineMerge(ArrayList<Airline> leftList, ArrayList<Airline> rightList, ArrayList<Airline> list) {
		int leftListIndex = 0;
		int rightListIndex = 0;
		int listIndex = 0;

		while (leftListIndex < leftList.size() && rightListIndex < rightList.size()) {
			if (leftList.get(leftListIndex).isBefore(rightList.get(rightListIndex))) {
				list.set(listIndex, leftList.get(leftListIndex));
				leftListIndex++;
			} else {
				list.set(listIndex, rightList.get(rightListIndex));
				rightListIndex++;
			}
			listIndex++;
		}

		ArrayList<Airline> rest;
		int restIndex;
		if (leftListIndex >= leftList.size()) {
			rest = rightList;
			restIndex = rightListIndex;
		} else {
			rest = leftList;
			restIndex = leftListIndex;
		}

		for (int i = restIndex; i < rest.size(); i++) {
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}

	/**
	 * Uses binary search to search an arrayList of Airlines for a Airline
	 * 
	 * @param list
	 *            ArrayList being searched
	 * @param iata
	 *            the iata of the Airline being searched for
	 * @param low
	 *            the low index
	 * @param high
	 *            the high index
	 * @return the Airline being looked for or null if the Airline cannot be
	 *         found
	 */
	private Airline airlineSearch(ArrayList<Airline> list, String iata, int low, int high) {

		if (low > high) {
			return null;
		} else {
			int mid = (low + high) / 2;
			if (list.get(mid).getIata().equals(iata)) {
				return list.get(mid);
			} else if (list.get(mid).getIata().compareTo(iata) > 0) {
				return airlineSearch(list, iata, low, mid - 1);
			} else {
				return airlineSearch(list, iata, mid + 1, high);
			}
		}

	}

	/**
	 * Sorts an ArrayList of Flights using MergeSort
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param list
	 *            an ArrayList of Flights
	 * @return an ArrayList of Flights sorted using MergeSort
	 */
	private ArrayList<Flight> flightSort(ArrayList<Flight> list) {
		ArrayList<Flight> leftList = new ArrayList<Flight>();
		ArrayList<Flight> rightList = new ArrayList<Flight>();
		int centerIdx;

		if (list.size() == 1) {
			return list;
		} else {
			centerIdx = list.size() / 2;
			for (int i = 0; i < centerIdx; i++) {
				leftList.add(list.get(i));
			}
			for (int i = centerIdx; i < list.size(); i++) {
				rightList.add(list.get(i));
			}

			leftList = flightSort(leftList);
			rightList = flightSort(rightList);

			flightMerge(leftList, rightList, list);
		}
		return list;
	}

	/**
	 * Helper for mergeSort that combines the leftList and rightList
	 * 
	 * References:
	 * http://www.codexpedia.com/java/java-merge-sort-implementation/ - I drew
	 * ideas from this code to write my MergeSort code
	 * 
	 * @param leftList
	 *            the left halve of the list
	 * @param rightList
	 *            the right halve of the list
	 * @param list
	 *            the full list
	 */
	private void flightMerge(ArrayList<Flight> leftList, ArrayList<Flight> rightList, ArrayList<Flight> list) {
		int leftListIndex = 0;
		int rightListIndex = 0;
		int listIndex = 0;

		while (leftListIndex < leftList.size() && rightListIndex < rightList.size()) {
			if (leftList.get(leftListIndex).isBefore(rightList.get(rightListIndex))) {
				list.set(listIndex, leftList.get(leftListIndex));
				leftListIndex++;
			} else {
				list.set(listIndex, rightList.get(rightListIndex));
				rightListIndex++;
			}
			listIndex++;
		}

		ArrayList<Flight> rest;
		int restIndex;
		if (leftListIndex >= leftList.size()) {
			rest = rightList;
			restIndex = rightListIndex;
		} else {
			rest = leftList;
			restIndex = leftListIndex;
		}

		for (int i = restIndex; i < rest.size(); i++) {
			list.set(listIndex, rest.get(i));
			listIndex++;
		}
	}

	/**
	 * Uses binary search to search an arrayList of Flights for a Flight
	 * 
	 * @param flightList
	 *            ArrayList being searched
	 * @param airline
	 *            the airline of the Flight being searched for
	 * @param flightNumber
	 *            the flightNumber of the Flight being searched for
	 * @param origin
	 *            the origin of the Flight being searched for
	 * @param destination
	 *            the destination of the Flight being searched for
	 * @param low
	 *            the low index
	 * @param high
	 *            the high index
	 * @return the Flight being looked for or null if the Flight cannot be found
	 */
	private ArrayList<Flight> flightSearch(ArrayList<Flight> r, String airline,
			String flightNumber, String origin, String destination, int low, int high) {

		if (low > high) {
			return null;
		} else {
			int mid = (low + high) / 2;
			if (flightList.get(mid).getAirline().equals(airline) && flightList.get(mid).getFlightNumber().equals(flightNumber)
					&& flightList.get(mid).getOrigin().equals(origin) && flightList.get(mid).getDestination().equals(destination)) {
				r.add(flightList.get(mid));
				return r;
			} else if (flightList.get(mid).getAirline().compareTo(airline) == 0) {
				int i = mid;
				while (flightList.get(i).getAirline().compareTo(airline) == 0) {
					r.add(flightList.get(i));
					i--;
				}
				i = mid + 1;
				while (flightList.get(i).getAirline().compareTo(airline) == 0) {
					r.add(flightList.get(i));
					i++;
				}
				return r;
			} else if (flightList.get(mid).getAirline().compareTo(airline) > 0) {
				return flightSearch(r, airline, flightNumber, origin, destination, low, mid - 1);
			} else {
				return flightSearch(r, airline, flightNumber, origin, destination, mid + 1, high);
			}
		}

	}

}
