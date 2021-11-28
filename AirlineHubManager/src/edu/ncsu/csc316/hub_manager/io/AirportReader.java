/**
 * 
 */
package edu.ncsu.csc316.hub_manager.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.hub_manager.flight.Airport;
import edu.ncsu.csc316.hub_manager.list.MultiPurposeList;

/**
 * Reads Airports from text files
 * 
 * @author someshherath
 *
 */
public class AirportReader {
	
	/**
	 * Reads Airports from a file and generates a list of valid airports
	 * 
	 * @param fileName
	 *            file to read airports from
	 * @return a list of airports
	 * @throws FileNotFoundException
	 *             if the file cannot be found or read
	 */
	public static MultiPurposeList<Airport> readAirports(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		MultiPurposeList<Airport> airports = new MultiPurposeList<Airport>();
		// to skip the line of descriptions
		fileReader.nextLine();
		while (fileReader.hasNextLine()) {
			try {
				Airport airport = readAirport(fileReader.nextLine());
				airports.add(airport);
			} catch (IllegalArgumentException e) {
				// skip the line
			}
		}
		fileReader.close();
		return airports;
	}
	
	/**
	 * Processes each line of the file and then create a Airport or skips that
	 * line if the Airport is not valid
	 * 
	 * @param nextLine
	 *            the line the Airport is in
	 * @return a if the Airport is valid
	 * @throws FileNotFoundException
	 *             if there are any errors
	 */

	private static Airport readAirport(String line) {
		Scanner reader = new Scanner(line);
        reader.useDelimiter(",");
        Airport a = null;
        
        try {
            String code = reader.next();
            double latitude = Double.parseDouble(reader.next());
            double longitude = Double.parseDouble(reader.next());
            
            a = new Airport(code, latitude, longitude);
            
        } catch (NoSuchElementException e) {
            reader.close();
            throw new IllegalArgumentException();
        }
        
        reader.close();
        return a;
	}

}
