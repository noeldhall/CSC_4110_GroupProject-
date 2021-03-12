package pkg;

import java.util.Date;

public class VendorProfile {
	String vendorID;
	PersonalInformation personal;
	VendorAccount vAccount;
	Date lastOrderDate;
	Date  discountStartDate;
	
	@SuppressWarnings("deprecation")
	public VendorProfile(String[] data) {
			for(int x = 0; x < data.length; x++) {
				vendorID = data[0];
				personal = new PersonalInformation(data[1], data[2], data[3], data[4], data[5]);
				vAccount = new VendorAccount(Double.parseDouble(data[6]), Double.parseDouble(data[7]));
				lastOrderDate = new Date(data[8]);
				discountStartDate = new Date(data[9]);
			}
	}
	
	public VendorProfile(String vendorID, PersonalInformation personal, VendorAccount vAccount, Date lastOrderDate, Date discountStartDate) {
		this.vendorID = vendorID;
		this.personal = personal;
		this.vAccount = vAccount;
		this.lastOrderDate = lastOrderDate;
		this.discountStartDate = discountStartDate;
	}
	
	public String toString() {
		String data = "";
		data += vendorID + "\n";
		data += personal.toString();
		data += vAccount.toString();
		data += lastOrderDate.toString() + "\n";
		data += discountStartDate.toString() + "\n";
		return data;
	}
	
}