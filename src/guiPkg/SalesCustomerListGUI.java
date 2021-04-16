/**
 * 
 */
package guiPkg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pkg.CustomerDataModel;
import pkg.CustomerProfile;
import pkg.Main;

/**
 * @author Noel Hall
 *
 */
public class SalesCustomerListGUI extends CustomerListGUI {
	public SalesCustomerListGUI(Vector<CustomerProfile> data) {
		super(data);
		
		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && getTable().getSelectedRow() != -1) {
				//	System.out.println((String)table.getValueAt(table.getSelectedRow(), 0));
					CustomerProfile cp = CustomerDataModel.getDatabase().elementAt(getTable().getSelectedRow());
					SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
					String currentOrderDate=null;
					if (cp.getLastOrderDate()!=null)
 					 currentOrderDate=dateFormat.format(cp.getLastOrderDate());
					if(cp != null) {
						CustomerProfileGUI profile = new CustomerProfileGUI();
						
						profile.setFields(cp);
						if(JOptionPane.showConfirmDialog(null,"Create new order for this customer?" , "Customer Profile", JOptionPane.YES_NO_OPTION) == 0) {
							System.out.println("\n Yes sir, right away sir");
							Main.getMenu().openTab(Main.customerOrderItemTab);	
							model.fireTableDataChanged();
						
							//table.setSelectedRow();
						}
					}
				}
			}
        });
		
		
		add(scrollPane);

	}
}
