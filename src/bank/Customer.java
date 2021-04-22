package bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Customer extends Accounts{
	int Money;
	Boolean Approved;
	ArrayList<Transaction> CustTransactions = new ArrayList<Transaction>();
	
	Customer(){
		Money = 0;
		Approved = false;
	}
	
	public int getMoney() {
		return Money;
	}
	
	public void getMoney(int money) {
		Money = money;
	}
	
	/*
	 * Deposit reads amount input for deposit
	 * *If deposit is less than zero, it refuses deposit
	 */
	public void Deposit( ArrayList<Transaction> Transactions) {
		int depositAmount = 0;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("\nPlease enter a deposit amount.");
		try {
			depositAmount = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a numerical input.\n");
		} catch (IOException e) {
			System.out.println("This is a IO exception: \n");
		}
		if(depositAmount <= 0)
			System.out.println("You have entered a value less than or equal to zero.\n");
		else {
			Money += depositAmount;
			System.out.println("Money deposited\n");
			Transaction newTrans = new Transaction((String)(firstName + " " + lastName), TypeOfTrans.DEPOSIT, depositAmount);
			Transactions.add(newTrans);
			CustTransactions.add(newTrans);
		}
	}
	
	/*
	 * *Withdraw reads amount to be taken.
	 * *if withdraw amount is less the account balance, refuses withdrawal
	 */
	public void Withdraw(ArrayList<Transaction> Transactions) {
		int withdrawAmount = 0;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("\nPlease enter a withdrawal amount.");
		try {
			withdrawAmount = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			System.out.println("Please enter a numerical input.\n");
		} catch (IOException e) {
			System.out.println("This is a IO exception: \n");
		}
		if(withdrawAmount > Money) {
			System.out.println("You have entered a value less than the amount of money in your account:\t$"
								+ Money + "\n");
		}
		else {
			Money -= withdrawAmount;
			System.out.println("Money withdrawn\n");
			Transaction newTrans = new Transaction((String)(firstName + " " + lastName), TypeOfTrans.WITHDRAWAL, withdrawAmount);
			Transactions.add(newTrans);
			CustTransactions.add(newTrans);
		}
	}
	
	/*
	 * *Transfer asks for transfer amount and account ID where the amount will be transfered.
	 * *If transfer amount is less than account user account balance and greater than zero.
	 * 		+it transfers money
	 * Otherwise makes quits.
	 */
	public void transfer(HashMap<String, Customer> transferAccounts, Customer currCustomer, ArrayList<Transaction> Transactions) {
		int transferAmount = 0;
		String transferID = null;
		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
		System.out.println("Enter amount to be transfered:\n");
		try {
			transferAmount = Integer.parseInt(reader.readLine());
			transferID = (String)reader.readLine();
		} catch (NumberFormatException | IOException e) {
			System.out.println("Error in input. Please try apgain.\n");
		}
		Customer transferAccount = transferAccounts.get(transferID);
		if(transferAccount != null)
			if( transferAmount < Money && transferAmount > 0) {
				transferAccount.Money += transferAmount;
				currCustomer.Money -= transferAmount;
				System.out.println("Money transfered\n");
				Transaction newTrans = new Transaction((String)(firstName + " " + lastName), TypeOfTrans.TRANSFER, transferAmount);
				Transactions.add(newTrans);
				CustTransactions.add(newTrans);
			} else {
				System.out.println("Tranfer not possible.\n");
			}
		else
			System.out.println("Transfer Account is not is system.\n");				
	}
	
	/*
	 * Print Customer details
	 */
	public void print() {
		System.out.println( "Customer ID:\t" + ID);
		System.out.println( "Name:\t" + firstName + " " + lastName);
		System.out.println( "Account Amount:\t$" + Money);
		if(Approved)
			System.out.println("Account is approved.");
		else
			System.out.println("Account is not approved.");
	}
	
	/*
	 * Print current customer transactions
	 */
	public void printCustTrans() {
		System.out.println("Customer: " + firstName + "  " + lastName + ". Here are your transactions.\n");
		if( CustTransactions.isEmpty())
			System.out.println("There are no transactions\n");
		else
			for( Transaction t : CustTransactions)
				t.transPrint();
	}
}
 