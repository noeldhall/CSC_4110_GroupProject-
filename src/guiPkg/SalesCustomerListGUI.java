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
import pkg.CustomerOrder;
import pkg.CustomerOrderDataModel;
import pkg.CustomerProfile;
import pkg.Main;
import pkg.InvoiceOrderObserver;
import pkg.OrderSubject;

/**
 * @author Noel Hall
 *
 */
public class SalesCustomerListGUI extends CustomerListGUI implements OrderSubject{
		private static final long serialVersionUID = 8225824411303341872L;
		private InvoiceOrderObserver observer;
	public SalesCustomerListGUI(Vector<CustomerProfile> data) {
		super(data);
		
		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && getTable().getSelectedRow() != -1) {
				
					CustomerProfile cp = CustomerDataModel.getDatabase().elementAt(getTable().getSelectedRow());
					
				
					if(cp != null) {
						
						if(JOptionPane.showConfirmDialog(null,"Create new order for this customer?" , "Customer Profile", JOptionPane.YES_NO_OPTION) == 0) {
							CustomerOrder co=new CustomerOrder(cp);
							CustomerOrderDataModel.getDatabase().add(co);
							notifyUpdate(String.valueOf(co.getCustomerOrderid()));
							Main.getMenu().clearTabs();
							Main.getMenu().openTab(Main.getCustomerOrderItemTab());	
						
							model.fireTableDataChanged();
						
							//table.setSelectedRow();
						}
					}
				}
			}
        });
		
		
		add(scrollPane);

	}

	@Override
	public void attach(InvoiceOrderObserver o) {
		observer=o;
	}

	@Override
	public void detach(InvoiceOrderObserver o) {
		observer=null;
	}

	@Override
	public void notifyUpdate(String currentOrderId) {
		observer.update(currentOrderId);
	}
}
