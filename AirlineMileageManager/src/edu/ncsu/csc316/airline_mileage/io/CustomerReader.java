/**
 * 
 */
package edu.ncsu.csc316.airline_mileage.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ncsu.csc316.airline_mileage.data.Customer;
import edu.ncsu.csc316.airline_mileage.list.ArrayList;

/**
 * Reads Customer records from text files
 * 
 * @author someshherath
 */
public class CustomerReader {

	/**
	 * Reads Customers from a file and generates a list of valid Customers
	 * 
	 * @param fileName
	 *            file to read Customers from
	 * @return a list of Customers
	 * @throws FileNotFoundException
	 *             if the file cannot be found or read
	 */
	public static ArrayList<Customer> readCustomers(String fileName) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(fileName));
		ArrayList<Customer> customers = new ArrayList<Customer>();
		// to skip the line of descriptions
		fileReader.nextLine();
		while (fileReader.hasNextLine()) {
			try {
				Customer customer = readCustomer(fileReader.nextLine());
				customers.add(customer);
			} catch (IllegalArgumentException e) {
				// skip the line
			}
		}
		fileReader.close();
		return customers;
	}
	
	/**
	 * Processes each line of the file and then create a Customer or skips that
	 * line if the Customer is not valid
	 * 
	 * @param nextLine
	 *            the line the Customer is in
	 * @return a if the Customer is valid
	 * @throws FileNotFoundException
	 *             if there are any errors
	 */

	private static Customer readCustomer(String line) {
		Scanner reader = new Scanner(line);
        reader.useDelimiter(",");
        Customer a = null;
        
        try {
            String first = reader.next();
            String last = reader.next();
            String date = reader.next();
            String flight = reader.next();
            String origin = reader.next();
            String destination = reader.next();
            
            a = new Customer(first, last, date, flight, origin, destination);
            
        } catch (NoSuchElementException e) {
            reader.close();
            throw new IllegalArgumentException();
        }
        
        reader.close();
        return a;
	}

}
