package bank;

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.util.*;

public class Bank {
	HashMap<String, Employee> Employees = new HashMap<String, Employee>();
	HashMap<String, Customer> Customers = new HashMap<String,Customer>();
	ArrayList<Transaction> Transactions = new ArrayList<Transaction>();
	
	/*
	 * Set a new customer in system after registration
	 */
	public void setNewCustomer() throws IOException {
		Customer newCustomer = new Customer();
		Register newReg = new Register();
		newReg.regCustomer(newCustomer);
		Customers.put(newCustomer.getID(), newCustomer);
	}
	
	/*
	 * Set a new employee in system after registration
	 */
	public void setNewEmployee() throws IOException {
		Employee newEmployee= new Employee();
		Register newReg = new Register();
		newReg.regEmployee(newEmployee);
		Employees.put(newEmployee.getID(), newEmployee);
	}
	
	/*
	 * Display bank menu
	 * 	+read from console and execute either Login or Registration Actions
	 */
	public void Display() throws IOException {
		int opt = 0;
		int quit = 5;
		String ID = "";
		Login user = new Login();
		
		System.out.println("------------------");
		System.out.println("Welcome to the Bank");
		System.out.println("------------------");
		
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		do {
			System.out.println("\nPlease select one of the following options");
			System.out.println("1. Current Customer\n"
					         + "2. Current Employee\n"
					         + "3. New Customer\n"
					         + "4. New Employee\n"
					         + "5. Quit\n");
			try {
				opt = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("The input you selected is incorrect. Please type correct input\n");
			}
			switch(opt) {
			case 1: 
				System.out.println("You are a Current Customer\n");
				ID = user.getID();
				Customer verifiedCustomer = Customers.get(ID);
				if( verifiedCustomer != null)
					if( verifiedCustomer.Approved)
						user.customerMenu(Customers, Customers.get(ID), Transactions);
					else
						System.out.println("You have not been approved.\n");
				else 
					System.out.println("Account is not in the system.\nPlease create a new one");
				break;
			case 2:
				System.out.println("You are a Current Employee\n");
				ID = user.getID();
				Employee verifiedEmployee = Employees.get(ID);
				System.out.println("After user.get: " + ID);
				if( verifiedEmployee != null)
					user.employeeMenu(Customers, Employees.get(ID), Transactions);
				else {
					System.out.println("Account is not in the system.\nPlease create a new one");
				}
				break;
			case 3:
				System.out.println("You are a New Customer\n");
				setNewCustomer();
				break;
			case 4:
				System.out.println("You are a New Employee\n");
				setNewEmployee();
				break;
			case 5:
				System.out.println("Quit Program\n");
				break;
			}
		} while ( quit != opt);

	}

	
}