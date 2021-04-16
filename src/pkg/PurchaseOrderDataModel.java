package pkg;

import java.util.Date;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class PurchaseOrderDataModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4481018938412618294L;
	static DatabaseII<PurchaseOrder> purchaseOrderData;
	private final String[] columnNames = new String[] { "itemID", "Vendor Name", "Need by Date", "Item 1",
														"Item 2", "Item 3", "Item 4" , "Item 5"};
	private final Class[] columnClass = new Class[] { Integer.class, String.class, Date.class, String.class,
														String.class, String.class, String.class, String.class};

	public PurchaseOrderDataModel(Class<PurchaseOrder> dt, String s) {
		//initialize our database object
		purchaseOrderData = new DatabaseII<PurchaseOrder>(dt,s);
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return purchaseOrderData.getData().size();
	}
	
	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}
	
	public PurchaseOrder getRow(int rowIndex) {
		//get an individual purchase order via row selection
		return purchaseOrderData.getData().get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//explains to our model how to fill our table
		PurchaseOrder po = getRow(rowIndex);
		switch(columnIndex) {
		case 0: // id
			return po.getOrderId();
		case 1: // vendor name
			return po.getVendor().getPersonal().getFullName();
		case 2: //need by date
			return po.getNeedByDate();
		case 3: //item 1
			OrderItem item1 = po.getItem(0);
			return item1 != null ? item1.getItemName() : new String("");
		case 4: //item 2
			OrderItem item2 = po.getItem(1);
			return item2 != null ? item2.getItemName() : new String("");
		case 5: //item 3
			OrderItem item3 = po.getItem(2);
			return item3 != null ? item3.getItemName() : new String("");
		case 6: //item 4
			OrderItem item4 = po.getItem(3);
			return item4 != null ? item4.getItemName() : new String("");
		case 7: //item 5
			OrderItem item5 = po.getItem(4);
			return item5 != null ? item5.getItemName() : new String("");
		default:
			return null;
		}
	}
	
	public static int generateID() {
		//generates a unique purchaseOrderID by picking the next sequential number in order.
		int uniInt = purchaseOrderData.getData().lastElement().getOrderId() + 1;
		return uniInt;
	}
	
	public Vector<PurchaseOrder> searchByVendor(String vendorID){
		//collect all purchase orders for a given vendor and return them in a container.
		Vector<PurchaseOrder> returnVec = new Vector<PurchaseOrder>();
		for(PurchaseOrder po : purchaseOrderData.getData()) {
			if(po.getVendor().getVendorID().equals(vendorID)) {
				returnVec.add(po);
			}
		}
		return returnVec;
	}
}
