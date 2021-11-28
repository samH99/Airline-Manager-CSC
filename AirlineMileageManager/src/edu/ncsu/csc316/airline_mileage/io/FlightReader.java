/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Flight;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Reads Flight records from text files
 * 
 * @author someshherath
 */
public class FlightReader {

	/**
	 * Reads Flights from a file and generates a list of valid Flights
	 * 
	 * @param fileName
	 *            file to read Flights from
	 * @return a list of Flights
	 * @throws FileNotFoundException
	 *             if the file cannot be found or read
	 */
	public static ArrayList<Flight> readFlights(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		ArrayList<Flight> flights = new ArrayList<Flight>();
		// to skip the line of descriptions
		fileReader.nextLine();
		while (fileReader.hasNextLine()) {
			try {
				Flight flight = readFlight(fileReader.nextLine());
				flights.add(flight);
			} catch (IllegalArgumentException e) {
				// skip the line
			}
		}
		fileReader.close();
		return flights;
	}

	/**
	 * Processes each line of the file and then create a Flight or skips that
	 * line if the flight is not valid
	 * 
	 * @param nextLine
	 *            the line the flight is in
	 * @return a if the flight is valid
	 * @throws FileNotFoundException
	 *             if there are any errors
	 */

	private static Flight readFlight(String line) {
		Scanner reader = new Scanner(line);
		reader.useDelimiter(",");
		Flight a = null;

		try {
			reader.nextInt();
			reader.nextInt();
			reader.nextInt();
			reader.nextInt();
			String airline = reader.next();
			String flightNumber = reader.next();
			String origin = reader.next();
			String destination = reader.next();
			reader.next();
			reader.next();
			int distance = reader.nextInt();
			reader.next();
			reader.nextInt();

			a = new Flight(airline, flightNumber, origin, destination, distance);

		} catch (NoSuchElementException e) {
			reader.close();
			throw new IllegalArgumentException();
		}

		reader.close();
		return a;
	}

}
