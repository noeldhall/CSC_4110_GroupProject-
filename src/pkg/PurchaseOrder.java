package pkg;

import java.util.Date;
import java.util.Vector;

public class PurchaseOrder {
	Vector<OrderItem> items;
	int orderId;
	Date needByDate;
	int quantity;
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public VendorProfile getVendor() {
		return vendor;
	}
	
	//------------SETS-------------
	public void setItem(OrderItem item) {
		items.add(item);
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setNeedByDate(Date needByDate) {
		this.needByDate = needByDate;
	}
	
	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity > 0) {
			this.quantity = quantity;
		}
		else {
			throw new IllegalArgumentException("Quantity of an orderItem must be greater than 0");
		}
	}
	
	public void setVendor(VendorProfile vendor) {
		this.vendor = vendor;
	}
	
}
