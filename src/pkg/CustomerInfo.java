package pkg;

public class CustomerInfo{
	 private String customerName;
	private String streetAddress;
	private String city;
	private String state;
	private String phone;
	
	public CustomerInfo(String cN, String sA, String c, String p) {
		customerName=cN;
		streetAddress=sA;
		city=c;
		phone=p;
	}
	
	public String toString() {
		return customerName +"\n"+streetAddress+"\n"+city+"\n"+phone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}