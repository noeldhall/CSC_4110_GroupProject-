package guiPkg;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import pkg.CustomerProfile;
import pkg.Main;
import pkg.CustomerDataModel;
import pkg.CustomerInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@SuppressWarnings("serial")
public class CustomerSearchGUI extends JPanel {

	public CustomerSearchGUI() {
		setName("Customer Search");
		JLabel customerLbl = new JLabel("Customer Profile:");
		customerLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton addCustomerBtn = new JButton("New Customer");
		JButton deleteCustomerBtn = new JButton("Delete Customer");
		JButton searchIDBtn = new JButton("Search by ID");
		JButton searchNameBtn = new JButton("Search by Name");
		final CustomerProfileGUI subPanel = new CustomerProfileGUI();
		
		JButton btnNewButton = new JButton("Log out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(customerLbl, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(subPanel, 0, 0, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addCustomerBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(deleteCustomerBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(searchNameBtn, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
										.addComponent(searchIDBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCustomerBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteCustomerBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchIDBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(customerLbl, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchNameBtn))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(subPanel, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		addCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerGUI makeCustomerPanel = new AddCustomerGUI();
				if(JOptionPane.showConfirmDialog(null, makeCustomerPanel, "Create Customer", JOptionPane.OK_CANCEL_OPTION) == 0) {
					CustomerProfile cp = new CustomerProfile(new CustomerInfo(makeCustomerPanel.getName(), makeCustomerPanel.getStreet(), makeCustomerPanel.getCity(), makeCustomerPanel.getState(), makeCustomerPanel.getPhone()));
						CustomerDataModel.insertCustomer(cp);
					subPanel.setFields(cp);
				}
			}
		});
		
		deleteCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(subPanel.getProfile() != null) {
					CustomerDataModel.deleteCustomer(subPanel.getProfile());
				}
				else {
					JOptionPane.showMessageDialog(null, "Error - Must have a profile selected to delete. Please note only customers with a balance of $0.00 are eligible for deletion.", "Deletion Error", JOptionPane.OK_OPTION);
				}
			}
		});
		
		searchIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Please Input a Customer ID to search for:");
				CustomerProfile cp = CustomerDataModel.searchCustomerID(id);
				if(cp != null) {
					subPanel.setFields(cp);
				}
				else {
					JOptionPane.showMessageDialog(null, "No Customer found with id: " + id, "No Customer Found", JOptionPane.OK_OPTION);
				}
			}
		});
		
		searchNameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "Please Input a Customer Name to search for:");
				CustomerProfile vp = CustomerDataModel.searchCustomerName(name);
				if(vp != null) {
					subPanel.setFields(vp);
				}
				else {
					JOptionPane.showMessageDialog(null, "No Customer found with name: " + name, "No Customer Found", JOptionPane.OK_OPTION);
				}
			}
		});
		
	}
}
