package pkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Database {
	public static Vector<VendorProfile> vendors;
	public static Vector<UserProfile> users;
	public static Vector<CustomerProfile> customers;
	private String vendorData;
	private String userData;
	private String customerData;
	
	Database(){
		vendorData = "data\\Feature3_dummyData.txt";
		userData = "data\\Login_and_Logout_User_Data.txt";
		customerData = "data\\Customer Profiles Data.txt";
		vendors = new Vector<VendorProfile>();
		users = new Vector<UserProfile>();
		customers=new Vector<CustomerProfile>();
		loadVendorData(vendorData);
		loadUserData(userData);
		loadCustomerData(customerData);
	}
	
	private void loadVendorData(String s) {
		//reads data in from our Vendor data file (txt files) and fills our Vectors with that data
		DataReader reader = new DataReader(s);
		try {
			Vector<String[]> tempData = reader.readFile();
			for(String[] d : tempData){
				vendors.add(new VendorProfile(d));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("fileNotFound - " + s);
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException in Database");
			System.out.println(e.getMessage());
		}
	}
	
	public void printVendors() {
		//prints a list of vendors from our vector - test purposes only
		for(VendorProfile vp : vendors) {
			System.out.println(vp.toString());
		}
	}

	private void loadUserData(String s) {
		//reads data in from our User data file (txt files) and fills our Vectors with that data
		DataReader reader = new DataReader(s);
		try {
			Vector<String[]> tempData = reader.readFile();
			for(String[] d : tempData){
				users.add(new UserProfile(d));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("fileNotFound - " + s);
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException in Database");
			System.out.println(e.getMessage());
		}
	}

	public void printUsers() {
		//prints a list of users from our vector - test purposes only
		for(UserProfile vp : users) {
			System.out.println(vp.toString());
		}
	}
	
	private void loadCustomerData(String s) {
		DataReader reader = new DataReader(s);
		try {
			Vector<String[]> tempData = reader.readFile();
			for(String[] d : tempData){
				customers.add(new CustomerProfile(d));
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("fileNotFound - " + s);
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println("IOException in Database");
			System.out.println(e.getMessage());
		}
	}
	
	public void printCustomers() {
		//prints a list of customers from our vector - test purposes only
		for(CustomerProfile vp : customers) {
			System.out.println(vp.toString());
		}
	}
	
	
	public static boolean login(String username, String password) {
		boolean loginFlag = false;
		
		for(UserProfile up : users) {
			//attempt to find the user for login process
			loginFlag = up.login(username, password);
			if(loginFlag == true) {
				//if the login is ever successful, we can just break, we found our user.
				break;
			}		
		}
		return loginFlag;
	}
		
	public static UserProfile findUser(String userID) {
		Iterator<UserProfile> userIndex = Database.users.iterator();
			
		while(userIndex.hasNext())
		{	
			UserProfile jeff = userIndex.next();
			if(jeff.getUserID().equals(userID))
			{
				return jeff;
			}				
		}		
		JOptionPane.showMessageDialog(null, "User profile not found.");			//TODO fix this error		
		return null;		
	}
	
	public static UserProfile deleteUser(String userID) {
		Iterator<UserProfile> userIndex = Database.users.iterator();
			
		while(userIndex.hasNext())
		{	
			UserProfile jeff = userIndex.next();
			if(jeff.getUserID().equals(userID))
			{
				userIndex.remove();
				return jeff;
			}			
		}
		return null;			
	}
}
