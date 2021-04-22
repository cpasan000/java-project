package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Login {
	
	/*
	 * Output employee menu
	 * 	+Call on options and read from console
	 */
	public void employeeMenu( HashMap<String, Customer> Customers, Employee currEmployee, ArrayList<Transaction> Transactions) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		int opt = 0;
		int quitProgram = 4;
		
		do {
			System.out.println("\nPlease imput an option selected from below.\n"
								+ "1. View a log of all transactions\n"
								+ "2. Approve a Customer Account\n"
								+ "3. Delete Customer account\n"
								+ "4. Quit\n");
			try {
				opt = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Input selected is incorrect. Please type correct input.\n");
				opt = 0;
			}
			switch(opt) {
			case 1:
				System.out.println("View All Transactions\n");
				currEmployee.printChronoTransactions(Transactions);
				break;
			case 2:
				System.out.println("Approve Customer Account");
				currEmployee.approveAccount(Customers);
				break;
			case 3:
				System.out.println("Delete Customer account");
				currEmployee.deleteCustomer(Customers);
				break;
			case 4:
				System.out.println("quit\n");
			}					
		} while( opt != quitProgram);
	}
	
	/*
	 * Output customerMenu
	 * 	*call on options and read from console
	 */
	public void customerMenu( HashMap<String, Customer> Customers, Customer currCustomer, ArrayList<Transaction> Transactions) throws IOException {
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		int opt = 0;
		int quitProgram = 6;
		
		do {
			System.out.println("\nPlease imput an option selected from below.\n"
								+ "1. View Account Details\n"
								+ "2. View Transactions\n"
								+ "3. Deposit Money\n"
								+ "4. Withdraw Money\n"
								+ "5. Transfer Money\n"
								+ "6. Quit\n");
			try {
				opt = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Input selected is incorrect. Please type correct input.\n");
				opt = 0;
			}
			switch(opt) {
			case 1:
				System.out.println("View Account Details\n");
				currCustomer.print();
				break;
			case 2:
				System.out.println("View Transactions\n");
				currCustomer.printCustTrans();
				break;
			case 3:
				System.out.println("Deposit Money\n");
				currCustomer.Deposit(Transactions);
				break;
			case 4:
				System.out.println("Withdraw Money\n");
				currCustomer.Withdraw(Transactions);
				break;
			case 5:
				System.out.println("Transfer Money\n");
				currCustomer.transfer(Customers, currCustomer, Transactions);
				break;
			case 6:
				System.out.println("Quit\n");
			}					
		} while( opt != quitProgram);
	}
	
	/*
	 * Gets user Id for login
	 */
	public String getID() {
		String fName = "";
		String lName = "";
		String pass = "";
		String userID;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		try {
			System.out.println("Enter first name:");
			fName = (String)reader.readLine();
			System.out.println("Enter last name:");
			lName = (String)reader.readLine();
			System.out.println("Enter password:");
			pass = (String)reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		userID = (String)(fName + lName + pass);
		return userID;
	}
}