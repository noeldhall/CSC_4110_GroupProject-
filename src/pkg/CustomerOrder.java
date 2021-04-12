package pkg;

import java.util.Vector;

public class CustomerOrder {

	public CustomerOrder() {
		
	}
	
	public void subtractQuantities() {
		
	}
	
	public double calculateTotalCost(){
		return totalCost;
	}
	
	private String customerName;
	private int customerOrderid;
	private Vector<OrderItem> orderItems;
	private double totalCost=0;
}
