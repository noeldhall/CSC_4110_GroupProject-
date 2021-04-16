package pkg;

import java.util.Date;
import java.util.Vector;

public class CustomerOrder implements Data{

	public CustomerOrder() {
		
	}
	
	public CustomerOrder(String[] data) {
		// TODO Auto-generated constructor stub
	}

	public void subtractQuantities() {
		
	}
	
	public CustomerProfile getCustomer() {
		return customer;
	}

	public Date getNeedByDate() {
		return needByDate;
	}

	public void setNeedByDate(Date needByDate) {
		this.needByDate = needByDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getCustomerOrderid() {
		return customerOrderid;
	}

	public void setCustomerOrderid(int customerOrderid) {
		this.customerOrderid = customerOrderid;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setCustomer(CustomerProfile customer) {
		this.customer = customer;
	}

	public double calculateTotalCost(){
		return totalCost;
	}
	
	private Date needByDate;
	private Date orderDate;
	private CustomerProfile customer;
	private int customerOrderid;
	private Vector<OrderItem> orderItems;
	private double totalCost=0;
}
