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
	public static UserProfile currentUser;
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
	
	public static void printVendors() {
		//prints a list of vendors from our vector - test purposes only
		for(VendorProfile vp : vendors) {
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

	public static void printUsers() {
		//prints a list of users from our vector - test purposes only
		for(UserProfile vp : users) {
			System.out.println(vp.toString());
		}
	}
	
	public static UserProfile login(String username, String password) {
		boolean loginFlag = false;
		
		for(UserProfile up : users) {
			//attempt to find the user for login process
			loginFlag = up.login(username, password);
			if(loginFlag == true) {
				//if the login is ever successful, we can just break, we found our user.
				return up;
			}		
		}
		return null;
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
	
	public static int generateVendorID() {
		int uniInt = 1;
		for(VendorProfile vp: vendors) {
			if(uniInt == Integer.parseInt(vp.getVendorID())) {
				uniInt++;
			}
			else {
				return uniInt;
			}
		}
		return 0;
	}
	
	public static int generateCustomerID() {
		int uniInt = generateVendorID()+1;
		
		for (CustomerProfile cp:customers)
		{
			if(uniInt==Integer.parseInt(cp.getCustomerId())) {
				uniInt++;
			}
			else 
				return uniInt;
		}
		return 0;
	}
	
	public static VendorProfile searchVendorID(String id) {
		for(VendorProfile vp : vendors) {
			if(vp.vendorID.equals(id)) {
				return vp;
			}
		}
		return null;
	}
	
	public static VendorProfile searchVendorName(String name) {
		for(VendorProfile vp : vendors) {
			if(vp.personal.fullName.trim().equalsIgnoreCase(name)) {
				return vp;
			}
		}
		return null;
	}
	
	public static boolean insertVendor(VendorProfile p) {
		if(Database.searchVendorName(p.getPersonal().getFullName()) == null) {
			vendors.add(p);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Integrity Constraint Violation - Duplicate Vendor Name - row rejected", "insert Error", JOptionPane.OK_OPTION);
			return false;
		}
	}

	public static boolean deleteVendor(VendorProfile p) {
		//find and delete a vendor profile based on a passed in vendor profile
		if(p.getvAccount().getBalance() == 0) {
			for(VendorProfile profile: vendors) {
				if(p.compareTo(profile) == 0) {
					if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a vendor will also delete all purchase orders associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
						vendors.remove(profile);
						return true;
					}
					else {
						break;
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - Account has a remaining balance. Cannot delete if non-zero.", "Deletion Error", JOptionPane.OK_OPTION);
		}
		return false;
	}

	public static boolean searchIDMatch(String ID) {
		for(UserProfile vp : users) {
			if(vp.userID.equals(ID)) {
				return true;
			}
		}
		return false;
	}
	
	public static CustomerProfile searchCustomerID(String id) {
		for(CustomerProfile cp : customers) {
			if(cp.customerId.equals(id)) {
				return cp;
			}
		}
		return null;
	}
	
	public static CustomerProfile searchCustomerName(String name) {
		for(CustomerProfile cp : customers) {
			if(cp.customerInfo.customerName.trim().equalsIgnoreCase(name)) {
				return cp;
			}
		}
		return null;
	}
	
	public static boolean insertCustomer(CustomerProfile p) {
		if(Database.searchVendorName(p.getCustomerInfo().getCustomerName()) == null) {
			customers.add(p);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Integrity Constraint Violation - Duplicate Customer Name - row rejected", "insert Error", JOptionPane.OK_OPTION);
			return false;
		}
	}
	
	public static boolean deleteCustomer(CustomerProfile p) {
		//find and delete a vendor profile based on a passed in vendor profile
		if(p.getCustomerAccount().getBalance() == 0) {
			for(CustomerProfile profile: customers) {
				if(p.compareTo(profile) == 0) {
					if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a customer will also delete all invoices associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
						customers.remove(profile);
						return true;
					}
					else {
						break;
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - Account has a remaining balance. Cannot delete if non-zero.", "Deletion Error", JOptionPane.OK_OPTION);
		}
		return false;
	}
}
