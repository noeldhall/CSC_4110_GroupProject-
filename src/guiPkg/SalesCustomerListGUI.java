/**
 * 
 */
package guiPkg;

import java.util.Vector;

import pkg.CustomerProfile;

/**
 * @author Noel Hall
 *
 */
public class SalesCustomerListGUI extends CustomerListGUI {
	public SalesCustomerListGUI(Vector<CustomerProfile> data) {
		super(data);
		add(scrollPane);

	}
}
