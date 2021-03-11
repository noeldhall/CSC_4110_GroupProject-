package pkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

public class Database {
	Vector<VendorProfile> vendors;
	private String vendorData;
	private String userData;
	private String customerData;
	
	Database(){
		vendorData = "data\\Feature3_dummyData.txt";
		userData = "data\\Login_and_Logout_User_Data.txt";
		customerData = "data\\Customer Profiles Data.txt";
		vendors = new Vector<VendorProfile>();
		loadVendorData(vendorData);
	}
	
	private void loadVendorData(String s) {
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
		for(VendorProfile vp : vendors) {
			System.out.println(vp.toString());
		}
	}
}
