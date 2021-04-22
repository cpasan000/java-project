package bank;
//import java.util.UUID;
//Accounts base class

public class Accounts {
	String firstName;
	String lastName;
	String Pin;
	String ID = "";
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String fName) {
		firstName = fName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lName) {
		lastName = lName;
	}
	
	public String getPassword() {
		return Pin;
	}
	
	public void setPassword(String pWord) {
		Pin = pWord;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String fName, String lName, String pass) {
		ID = fName + lName + pass;
	}
	

}