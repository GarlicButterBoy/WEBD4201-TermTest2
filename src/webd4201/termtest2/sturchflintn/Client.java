package webd4201.termtest2.sturchflintn;

import java.sql.*;

public class Client
{
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String firstName;
	private String lastName;
 	private String emailAddress;
 	private String phoneNumber;
 	
	public Client(String firstName, String lastName, String emailAddress, String phoneNumber)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
		setPhoneNumber(phoneNumber);
   	}

	public String toString()
	{
		String clientDetails = "webd4201.termtest2.sturchflintn.Client Info:\n\tName: " + getFirstName() + " " + getLastName() +
				"\n\tPhone Number: " + getPhoneNumber() + "\n\tEmail Address: " + getEmailAddress();
		return clientDetails;
	}
	public static void initialize(Connection c)
	{
		ClientDA.initialize(c);
	}
	public static void terminate()
	{
		ClientDA.terminate();
	}
	

}
