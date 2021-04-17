package pkg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class CustomerOrder implements Data{
	private Date needByDate;
	private Date orderDate;
	private CustomerProfile customer;
	private int customerOrderId;
	private Vector<OrderItem> orderItems=new Vector<OrderItem>();
	private double totalCost=0;
	public CustomerOrder() {
		
	}
	
	public Vector<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Vector<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public CustomerOrder(String[] data) throws ParseException {
		customerOrderId=Integer.parseInt(data[0]);
		customer=CustomerDataModel.searchCustomerName(data[1]);
		DateFormat dF = new SimpleDateFormat("MM/dd/yyyy");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
         orderDate = dF.parse(data[2]);
         needByDate=dF.parse(data[3]);
         
         String itemString;
         for(int i=4;i<=12;i+=2 )
         {
        	 itemString=data[i];
        	 if(!itemString.equals("null"))
        	 {
        		 Item item=ItemDataModel.searchItemID(data[i]);
        		 if (item!=null)
        		 {
        			 orderItems.add(new OrderItem(item,Integer.parseInt(data[i+1])));
        			 
        		 }
        	 }
        	 
         }
         
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
		return customerOrderId;
	}

	public void setCustomerOrderid(int customerOrderid) {
		this.customerOrderId = customerOrderid;
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
		totalCost=0;
		for(OrderItem oi:orderItems)
		totalCost+=	oi.calculateSubtotal();
			return totalCost;
	}
	
	public String printItems()
	{
		String yes = "";
		
		yes += "Item Name:\tQuantity:\tSell Price:\n";
		
		for(OrderItem items : orderItems)
		{
			yes += items.toString() + "\n";
		}
		return yes;
	} 
	
	public String toString()
	{
		return Integer.toString(customerOrderId);
		
	}
}
