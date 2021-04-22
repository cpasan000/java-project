package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;

public class Employee extends Accounts{

	/*
	 * Print All Transactions Chronologically
	 */
	public void printChronoTransactions(ArrayList<Transaction> Transactions) {
		if( Transactions.isEmpty())
			System.out.println("There are no transactions\n");
		else
			for( Transaction t : Transactions)
				t.transPrint();
			
	}
	
	/*
	 * Approve a newly created account
	 * 	*asks for useruniqueID;
	 */
	public void approveAccount( HashMap<String, Customer> Customers) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		String custID;
		System.out.println("Enter Customer ID");
		try {			
			custID = reader.readLine();
			Customer custAccount = Customers.get(custID);
			if( custAccount.Approved == false) {
				custAccount.Approved = true;
				System.out.println("Account has been approved.\n");
			}
			else
				System.out.println("Account has already been approved.\n");
		} catch(NullPointerException | IOException e) {
			System.out.println("Incorrect Input");
		}
	}
	
	/*
	 * delete user account
	 * 	read from console and check if customer is in system.
	 */
	public void deleteCustomer(HashMap<String,Customer> Customers) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		String customerID = null;
		System.out.println("\nEnter Customer ID");
		try {
		customerID = (String)reader.readLine();
		} catch(IOException e) {
			System.out.println("\nInvalid Input for deletion.\n");
		}
		
		if( Customers.get(customerID) != null)
			Customers.remove(customerID);
		else
			System.out.println("Customer is not in system.\n");
	}
}
