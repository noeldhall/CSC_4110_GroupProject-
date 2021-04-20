package pkg;
/**
 * @author Noel Hall
 *
 */
public class CustomerInfo implements Comparable<CustomerInfo>{
	 String customerName;
	private String streetAddress;
	private String city;
	private States state;
	private String phone;
	
	public CustomerInfo() {
		
	}
	
	public CustomerInfo(String cN, String sA, String c,States s, String p) {
		customerName=cN;
		streetAddress=sA;
		city=c;
		state=s;
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
	
	public int compareTo(CustomerInfo c) {
		return this.customerName.compareTo(c.customerName);
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

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}