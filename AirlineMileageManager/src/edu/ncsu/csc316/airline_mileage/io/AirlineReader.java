/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Airline;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Reads Airline records from text files
 * 
 * @author someshherath
 */
public class AirlineReader {
	
	/**
	 * Reads airlines from a file and generates a list of valid Airlines
	 * 
	 * @param fileName
	 *            file to read Airlines from
	 * @return a list of Airlines
	 * @throws FileNotFoundException
	 *             if the file cannot be found or read
	 */
	public static ArrayList<Airline> readAirlines(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		ArrayList<Airline> airlines = new ArrayList<Airline>();
		//to skip the line of descriptions
		fileReader.nextLine();
		while (fileReader.hasNextLine()) {
			try {
				Airline airline = readAirline(fileReader.nextLine());
//				boolean duplicate = false;
//				for (int i = 0; i < airlines.size(); i++) {
//					Airline a = airlines.get(i);
//					if (airline.getDescription().equals(a.getDescription())) {
//						// it's a duplicate
//						duplicate = true;
//					}
//				}
//				if (!duplicate) {
					airlines.add(airline);
//				}
			} catch (IllegalArgumentException e) {
				// skip the line
			}
		}
		fileReader.close();
		return airlines;
	}

	/**
	 * Processes each line of the file and then create a Airline or skips that
	 * line if the airline is not valid
	 * 
	 * @param nextLine
	 *            the line the airline is in
	 * @return a if the airline is valid
	 * @throws FileNotFoundException
	 *             if there are any errors
	 */

	private static Airline readAirline(String line) {
		Scanner reader = new Scanner(line);
        reader.useDelimiter(",");
        Airline a = null;
        
        try {
            String description = reader.next();
            String iata = reader.next();
            String callsign = reader.next();
            String country = reader.next();
            
            a = new Airline(description, iata, callsign, country);
            
        } catch (NoSuchElementException e) {
            reader.close();
            throw new IllegalArgumentException();
        }
        
        reader.close();
        return a;
	}

}
