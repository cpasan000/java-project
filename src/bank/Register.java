package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Register {
	
	/*
	 * Asks for registration details
	 */
	public Customer regCustomer( Customer newCustomer) throws IOException {
		String fname = null;
		String lname = null;
		String pass = null;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		try {
		System.out.println("Please input your first name:");
		fname = reader.readLine();
		newCustomer.setFirstName(fname);
		System.out.println("Please input your last name:");
		lname = reader.readLine();
		newCustomer.setLastName(lname);
		System.out.println("Please input your Password:");
		pass = reader.readLine();
		newCustomer.setPassword(pass);
		} catch (NullPointerException e) {
			System.out.println("Incorrect input\n");
		}
		newCustomer.setID(fname, lname, pass);
		return newCustomer;
	}
	
	/*
	 * Asks for Registration details
	 */
	public Employee regEmployee( Employee newEmployee) throws IOException {
		String fname = null;
		String lname = null;
		String pass = null;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		try {
		System.out.println("Please input your first name:");
		fname = reader.readLine();
		newEmployee.setFirstName(fname);
		System.out.println("Please input your last name:");
		lname = reader.readLine();
		newEmployee.setLastName(lname);
		System.out.println("Please input your Password:");
		pass = reader.readLine();
		newEmployee.setPassword(pass);
		} catch (NullPointerException e) {
			System.out.println("Incorrect input\n");
		}
		newEmployee.setID( fname, lname, pass);
		
		return newEmployee;
	}
}
