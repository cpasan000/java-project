package bank;

import java.util.UUID;


enum TypeOfTrans {
	DEPOSIT, WITHDRAWAL, TRANSFER;
}

public class Transaction /*implements Comparable<Transaction>*/{
	UUID transID;
	String accountID;
	String user;
	TypeOfTrans transType = null;
	private Integer transAmount;
	
	Transaction( String transUser, TypeOfTrans tType, Integer tAmount){
		transID = UUID.randomUUID();
		accountID = transUser;
		transType = tType;
		transAmount = tAmount;
	}

	public Integer getAmount() {
		return transAmount;
	}
	
	/*
	 * Prints transaction details
	 */
	public void transPrint() {
		System.out.println("Transaction ID: " + transID + "\n" 
						 + "Account User: " + accountID + "\n" 
						 + "Transaction: " + transType + "\n" 
						 + "Transaction Amount: $" + getAmount() + "\n");
	}
/*
	@Override
    public String toString() {
        return "Transaction[transAmount=" + transAmount + "]";
    }
	
	@Override
    public int compareTo(Transaction o) {
        return this.getAmount().compareTo(o.getAmount());
    }
    */
}
