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
	static DatabaseII<CustomerOrder> customerOrderData;
	private final String[] columnNames = new String[] { 
			"Order Id","Customer Name","Need By Date","Order Date"
	};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { 
			String.class, String.class, Date.class,Date.class
	};
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
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
			return customerOrder.getNeedByDate();
		case 3:
			return customerOrder.getOrderDate();
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
