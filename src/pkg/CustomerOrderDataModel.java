/**
 * 
 */
package pkg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author Noel Hall
 *
 */
public class CustomerOrderDataModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 3302157226851315559L;	
	
	
	private static List<OrdersObserver> observers = new ArrayList<OrdersObserver>();
	private static int state = 0;

	static DatabaseII<CustomerOrder> customerOrderData;
	private final String[] columnNames = new String[] { 
			"Order Id","Customer Name","Order Date","Need By Date"
	};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { 
			String.class, String.class, Date.class,Date.class
	};
	
	public CustomerOrderDataModel(Class<CustomerOrder> dt,String s) {
		customerOrderData=new DatabaseII<CustomerOrder>(dt,s);
	}
	@Override
	public int getRowCount() {
		return customerOrderData.getData().size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CustomerOrder customerOrder=customerOrderData.getData().get(rowIndex);
		switch(columnIndex)
		{
		case 0:
			return customerOrder.getCustomerOrderid();
		case 1:
			return customerOrder.getCustomer().getCustomerInfo().getCustomerName();
		case 2: 
			return customerOrder.getOrderDate();
		case 3:
			return customerOrder.getNeedByDate();
		default:
			return null;
			
		}
	}
	
	public static CustomerOrder searchCustomerOrderID(String id) {
		for(CustomerOrder co : customerOrderData.getData()) {
			if(co.getCustomerOrderId()==id) {
				return co;
			}
		}
		return null;
	}
	
	
 public Vector<CustomerOrder> getOrders(String customerName){
		Vector<CustomerOrder> cov=new Vector<CustomerOrder>();
		boolean set = true;
		for(CustomerOrder co: getDatabase()) {
		if(co.getCustomer().getCustomerInfo().getCustomerName().equals(customerName))
		{
			cov.add(co);
			if (getDatabase().size() > 2 && set)
			{
				set = false;
				CustomerOrderDataModel.setState(1);
			}
		}
		
		}
		return cov;
	}
 
 	public static Vector<CustomerOrder> getDatabase(){
 		return customerOrderData.getData();
 	}
 	
 	public static int generateCustomerID() {
		int uniInt = 1;
		
		for (CustomerOrder co:customerOrderData.getData())
		{
			if(uniInt==Integer.parseInt(co.getCustomerOrderId())) {
				uniInt++;
			}
			
		}
		return uniInt;
	}
 	
	//observer for Customer Invoice Feature - By Brett Gloomis
	public int getState() {
		return state;
	}
	public static void setState(int state) {
		CustomerOrderDataModel.state += state;
		notifyAllObservers();
	}	
	public static void attach(OrdersObserver observer){
		observers.add(observer);		
	}

	public static void notifyAllObservers(){
		for (OrdersObserver observer : observers) {
			observer.update();
			}
	}
}
