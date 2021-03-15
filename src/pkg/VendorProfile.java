package pkg;

import java.util.Date;

public class VendorProfile implements Comparable<VendorProfile>{
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
	
	public VendorProfile(String vendorID, PersonalInformation personal, Date lastOrderDate, Date discountStartDate) {
		this.vendorID = vendorID;
		this.personal = personal;
		vAccount = new VendorAccount();
		this.lastOrderDate = lastOrderDate;
		this.discountStartDate = discountStartDate;
	}
	
	public String toString() {
		String data = "";
		data += vendorID + "\t";
		data += personal.toString();
		data += vAccount.toString();
		data += lastOrderDate.toString() + "\t";
		data += discountStartDate.toString() + "\t";
		return data;
	}
	
	public int compareTo(VendorProfile o) {
		// default comparison 
		return this.vendorID.compareTo(o.vendorID);
	}
	
	public String getVendorID() {
		return vendorID;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}

	public PersonalInformation getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalInformation personal) {
		this.personal = personal;
	}

	public VendorAccount getvAccount() {
		return vAccount;
	}

	public void setvAccount(VendorAccount vAccount) {
		this.vAccount = vAccount;
	}

	public Date getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}

	public Date getDiscountStartDate() {
		return discountStartDate;
	}

	public void setDiscountStartDate(Date discountStartDate) {
		this.discountStartDate = discountStartDate;
	}

}