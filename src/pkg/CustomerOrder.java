package pkg;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
/**
 * @author Noel Hall
 *
 */
public class CustomerOrder implements Data{
	private Date needByDate;
	private Date orderDate;
	private CustomerProfile customer;
	private String customerOrderId;
	private Vector<OrderItem> orderItems=new Vector<OrderItem>();
	private double totalCost=0;

	public CustomerOrder(CustomerProfile cp) {
		customer=cp;
		customerOrderId= String.format("%06d", CustomerOrderDataModel.generateCustomerID());

		 orderDate=new Date();
	        DateFormat dF = new SimpleDateFormat("MM/dd/yyyy");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
			String currentDateString=dateFormat.format(orderDate);
			try {
				orderDate=dF.parse(currentDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}
	
	public Vector<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Vector<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public CustomerOrder(String[] data) throws ParseException {
		setCustomerOrderId(data[0]);
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
		for (OrderItem oi: orderItems)
		{
				for(Item i:ItemDataModel.getDatabase())
				{
					if(oi.getItemID().equals(i.getItemID()))
						i.setBalanceOnHand(i.getBalanceOnHand()-oi.getQuantity());
				}
		}
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

	public String getCustomerOrderid() {
		return getCustomerOrderId();
	}

	public void setCustomerOrderid(String customerOrderid) {
		this.setCustomerOrderId(customerOrderid);
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
		return customerOrderId;
		
	}

	public String getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	

}
