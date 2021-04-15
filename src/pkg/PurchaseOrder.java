package pkg;

import java.util.Date;
import java.util.Vector;

public class PurchaseOrder {
	Vector<OrderItem> items;
	int orderId;
	Date needByDate;
	VendorProfile vendor;

	//------------GETS-------------
	public int getOrderId() {
		return orderId;
	}
	
	public Item getItem(int val) {
		return items.elementAt(val);
	}
	
	public Date getNeedByDate() {
		return needByDate;
	}
	
	public int getItemCount() {
		//returns the number of items in the order
		return items.size();
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public VendorProfile getVendor() {
		return vendor;
	}
	
	//------------SETS-------------
	public void addItem(OrderItem item) throws IllegalArgumentException {
		if(getItemCount() < 5) {
			items.add(item);
		}
		else {
			throw new IllegalArgumentException("maximum of five items on an order!");
		}
	}
	
	public void removeItem(int val) throws IllegalArgumentException {
		if(val <= getItemCount()) {
			items.remove(val);
		}
		else {
			throws new IllegalArgumentException("Item out of order range");
		}
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setNeedByDate(Date needByDate) {
		this.needByDate = needByDate;
	}
	
	public void setVendor(VendorProfile vendor) {
		this.vendor = vendor;
	}
	
	//----------utility functions------------
	public double calcTotal() {
		double total = 0.00;
		for(OrderItem item : items) {
			total += item.calculateSubtotal();
		}
		return total;
	}
}
