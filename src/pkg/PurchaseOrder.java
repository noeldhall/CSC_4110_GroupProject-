package pkg;

import java.util.Date;
import java.util.Vector;

public class PurchaseOrder implements Data {
	int orderId;
	VendorProfile vendor;
	Date needByDate;
	Vector<OrderItem> items;
	
	public void update()
	{
		
	}
	
	
	
	PurchaseOrder(String[] data){
		items = new Vector<OrderItem>();
		setOrderId(Integer.parseInt(data[0]));
		setVendor(VendorDataModel.searchVendorID(data[1]));
		setNeedByDate(new Date(data[2]));
		for(int x = 3; x < data.length; x+=2) {
			if(!data[x].equals("null")) {
				items.add(new OrderItem(ItemDataModel.searchItemID(data[x]), Integer.parseInt(data[x+1])));
			}
			else {
				break;
			}
		}
	}
	
	public PurchaseOrder(){
		//this default constructor will be used with PurchaseOrderGUI to construct a new purchase order
		orderId = PurchaseOrderDataModel.generateID();
		items = new Vector<OrderItem>();
		
	}
	
	public PurchaseOrder(VendorProfile vp, Date nbd, Vector<OrderItem> items) {
		orderId = PurchaseOrderDataModel.generateID();
		setVendor(vp);
		setNeedByDate(nbd);
		this.items = items;
	}
	
	//------------GETS-------------
	public int getOrderId() {
		return orderId;
	}
	
	public OrderItem getItem(int index) {
		if(index <= items.size() && index > -1) {
			return items.elementAt(index);
		}
		return null;
	}
	
	public Vector<OrderItem> getItemsVec(){
		return items;
	}
	
	public Date getNeedByDate() {
		return needByDate;
	}
	
	public int getItemCount() {
		//returns the number of items in the order
		return items.size();
	}
	
	public VendorProfile getVendor() {
		return vendor;
	}
	
	//------------SETS-------------
	public void addItem(Item it, int quant) throws IllegalArgumentException {
		if(getItemCount() < 5) {
			if(it.getExpires().after(new Date())) {
				items.add(new OrderItem(it, quant));
			}
			else {
				throw new IllegalArgumentException("The Item you are trying to order is expired.");
			}
		}
		else {
			throw new IllegalArgumentException("maximum of five items on an order!");
		}
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public void setNeedByDate(Date needByDate) throws IllegalArgumentException {
		if(needByDate.after(new Date())) {
			this.needByDate = needByDate;
		}
		else {
			throw new IllegalArgumentException("Need By Date has already passed.");
		}
	}
	
	public void setNeedByDate(String s) throws IllegalArgumentException {
		if(!s.matches("[0-9][0-9]\\/[0-9][0-9]\\/[0-9][0-9][0-9][0-9]")) {
			throw new IllegalArgumentException("NeedByDate must be in a valid format [MM/DD/YYYY]");
		}
		Date d = new Date(s);
		if(!d.after(new Date())) {
			throw new IllegalArgumentException("the given Need by date has already passed");
		}
		this.needByDate = d;
		
	}
	
	public void setVendor(VendorProfile vendor) {
		this.vendor = vendor;
	}
	
	//----------utility functions------------
	public void removeItem(int val) throws IllegalArgumentException {
		if(val <= getItemCount()) {
			items.remove(val);
		}
		else {
			throw new IllegalArgumentException("Item out of order range");
		}
	}
	
	public double calcTotal() {
		double total = 0.00;
		for(OrderItem item : items) {
			total += item.calculateSubtotal();
		}
		return total;
	}
	
	@Override
	public String toString() {
		return "PO#" + Integer.toString(orderId);
	}

	public void updateVendorAccount() {
		vendor.vAccount.balance -= calcTotal();
		
	}
	
	
}
