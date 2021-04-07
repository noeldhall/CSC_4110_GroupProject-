package pkg;

import java.util.Date;

public class CustomerProfile implements Comparable<CustomerProfile>, Data{
	String customerId;
	Date lastOrderDate;
	CustomerInfo customerInfo;
	CustomerAccount customerAccount;
	
	@SuppressWarnings("deprecation")
	public CustomerProfile(String[] data) {
			for(int x = 0; x < data.length; x++) {
				customerId = data[0];
				customerInfo = new CustomerInfo(data[1], data[2], data[3],States.valueOf(data[4]), data[5]);
				customerAccount = new CustomerAccount(Double.parseDouble(data[6]), Double.parseDouble(data[7]));
				lastOrderDate = new Date(data[8]);
			}
	}
	

	public CustomerProfile(CustomerProfile customer) {
		this.customerId=customer.getCustomerId();
		this.customerAccount=customer.getCustomerAccount();
		this.customerInfo=customer.getCustomerInfo();
		this.lastOrderDate=customer.getLastOrderDate();
	}
	public CustomerProfile(CustomerInfo customer) {
		customerId = formatID(Database.generateCustomerID());
		this.customerInfo = customer;
		customerAccount = new CustomerAccount();
		lastOrderDate = null;
		
	}
	
	public String toString() {
		String data = "";
		data += customerId + "\t";
		data += customerInfo.toString();
		data += customerAccount.toString();
		data += lastOrderDate.toString() + "\t";
		return data;
	}
	
	private String formatID(int val) {
		String id = Integer.toString(val);
		for(int x = id.length(); x < 6; x++) {
			id = "0" + id;
		}
		return id;
	}
	
	public int compareTo(CustomerProfile o) {
		return this.customerId.compareTo(o.customerId);
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Date getLastOrderDate() {
		return lastOrderDate;
	}
	public void setLastOrderDate(Date lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount = customerAccount;
	}
}