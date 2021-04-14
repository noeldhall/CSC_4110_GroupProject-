package pkg;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class ItemDataModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8368348238846303420L;
	static DatabaseII<Item> itemData;
	private final String[] columnNames = new String[] { 
			"itemID", "item Name", "vendorID", "Sell Price", "Item Type",
			"Expiration Date", "Unit Price", "Unit Of Measurement", "Balance On Hand"
	};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { 
			String.class, String.class, String.class, Double.class, ItemCategory.class,
			Date.class, Double.class, String.class, Double.class
	};
	
	public ItemDataModel(Class<Item> dt, String s) {
		itemData = new DatabaseII<Item>(dt, s);
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return itemData.getData().size();
	}
	
	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}
	
	public Item getRow(int rowIndex) {
		return itemData.getData().get(rowIndex);
	}

	@Override
    public String getColumnName(int index) {
        return columnNames[index];
    }
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		//gets the value of a particular cell in our table
		Item item = itemData.getData().get(rowIndex);
		switch(columnIndex) {
			case 0:
				return item.getItemID();
			case 1:
				return item.getItemName();
			case 2:
				return item.getVendorID();
			case 3:
				return item.getSellPrice();
			case 4:
				return item.getItemType();
			case 5:
				return (item.getExpires() != null ? item.getExpires() : new String(""));
			case 6:
				return item.getUnitPrice();
			case 7:
				return item.getUnitOfMeasure();
			case 8:
				return item.getBalanceOnHand();
			default:
				return null;
		}
	}
	
	public static void printItems() {
		//prints a list of vendors from our vector - test purposes only
		for(Item ip : getDatabase()) {
			System.out.println(ip.toString());
		}
	}
	public static Vector<Item> getDatabase() {
		return itemData.getData();
	}
}
