/**
 * 
 */
package pkg;

import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author Noel Hall
 *
 */
public class CustomerOrderDataModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3302157226851315559L;
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
	
 public Vector<CustomerOrder> getOrders(String customerName){
	//	declare a return vector here
		Vector<CustomerOrder> cov=new Vector<CustomerOrder>();
		//for each customer in datamodel
		for(CustomerOrder co: getDatabase()) {
		//if(customerid == customerid
		if(co.getCustomer().getCustomerInfo().getCustomerName().equals(customerName))
			cov.add(co);
		//	add to return vector

		}
//	return the vector
		return cov;
	}
 
 	public static Vector<CustomerOrder> getDatabase(){
 		return customerOrderData.getData();
 	}

}
