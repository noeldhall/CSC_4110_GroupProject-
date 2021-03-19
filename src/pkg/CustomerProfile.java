package pkg;

import java.util.Date;

public class CustomerProfile{
	String customerId;
	Date lastOrderDate;
	CustomerInfo customerInfo;
	CustomerAccount customerAccount;
	
	@SuppressWarnings("deprecation")
	public CustomerProfile(String[] data) {
			for(int x = 0; x < data.length; x++) {
				customerId = data[0];
				customerInfo = new CustomerInfo(data[1], data[2], data[3], data[4]);
				customerAccount = new CustomerAccount(Double.parseDouble(data[5]), Double.parseDouble(data[6]));
				lastOrderDate = new Date(data[7]);
			}
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