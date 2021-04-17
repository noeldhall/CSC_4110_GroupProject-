package guiPkg;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import pkg.PurchaseOrder;
import pkg.PurchaseOrderDataModel;
import pkg.VendorDataModel;
import pkg.VendorProfile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

public class PurchaserGUI extends JPanel {
	/**
	 * Author: Nicholas Foster
	 */
	private static final long serialVersionUID = 3360425635918542473L;
	private JTextField searchTxt;
	private VendorProfile currentVendor;
	
	public PurchaserGUI() {
		DefaultListModel<PurchaseOrder> model = new DefaultListModel<PurchaseOrder>();
		setName("Purchaser");
		searchTxt = new JTextField();
		searchTxt.setColumns(10);
		JButton searchBtn = new JButton("Search Orders");
		JList<PurchaseOrder> orderList = new JList<PurchaseOrder>();
		JLabel vendorLbl = new JLabel("Vendor Name:");
		JButton orderBtn = new JButton("New Purchase Order");
		
		//button functionality
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentVendor != null) {
					PurchaseOrderGUI newOrder = new PurchaseOrderGUI(currentVendor);
					if(JOptionPane.showConfirmDialog(null, newOrder, "New Purchase Order", JOptionPane.OK_CANCEL_OPTION) == 0 ){
						try {
							PurchaseOrder po = newOrder.createPurchaseOrder();
							model.addElement(po);
							PurchaseOrderDataModel.addPurchaseOrder(po);
						}
						catch(IllegalArgumentException err) {
							JOptionPane.showMessageDialog(null, err.getMessage(), "Data error", JOptionPane.OK_OPTION);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please Search for a vendor first", "Warning", JOptionPane.OK_OPTION);
				}
			}
			
		});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentVendor = VendorDataModel.searchVendorName(searchTxt.getText());
				if(currentVendor != null) {
					model.removeAllElements();
					model.addAll(PurchaseOrderDataModel.searchByVendor(currentVendor.getPersonal().getFullName().trim()));
					orderList.setModel(model);
				}
				else {
					JOptionPane.showMessageDialog(null, "Vendor " + searchTxt.getText() + " Not Found.", "Failed to find", JOptionPane.CANCEL_OPTION);
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(vendorLbl)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBtn, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
						.addComponent(orderList, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addComponent(orderBtn, Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(vendorLbl)
						.addComponent(searchBtn))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(orderList, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(orderBtn)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
