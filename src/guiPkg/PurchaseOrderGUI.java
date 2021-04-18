package guiPkg;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import pkg.Item;
import pkg.ItemDataModel;
import pkg.OrderItem;
import pkg.PurchaseOrder;
import pkg.VendorProfile;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class PurchaseOrderGUI extends JPanel{
	/**
	 * authored by Nicholas Foster
	 */
	private static final long serialVersionUID = -5647187456393468684L;
	private JTextField quantityTxt;
	private JTextField needByTxt;
	PurchaseOrder orderObj;
	public PurchaseOrderGUI(VendorProfile vp) {
		orderObj = new PurchaseOrder();
		orderObj.setVendor(vp);
		
		JLabel itemLbl = new JLabel("Item:");
		JLabel quantityLbl = new JLabel("Quantity:");
		JLabel needByLbl = new JLabel("Need By Date:");
		JButton addToOrderBtn = new JButton("Add Item to Order");
		JButton removeItemBtn = new JButton("Remove Selected Item");
		JScrollPane scrollPane = new JScrollPane();
		JComboBox<Item> itemBox = new JComboBox<Item>();
		JList<OrderItem> orderItemList = new JList<OrderItem>();
		DefaultComboBoxModel<Item> itemModel = new DefaultComboBoxModel<Item>(ItemDataModel.searchVendorItemsByID(vp.getVendorID()));
		DefaultListModel<OrderItem> orderModel = new DefaultListModel<OrderItem>();
		
		//component settings
		quantityTxt = new JTextField();
		quantityTxt.setColumns(10);
		
		needByTxt = new JTextField();
		needByTxt.setColumns(10);
	
		itemBox.setRenderer(new ItemNameRenderer());
		itemBox.setModel(itemModel);
		
		orderModel.addAll(orderObj.getItemsVec());
		orderItemList.setModel(orderModel);
		
		//Button Functionality
		addToOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Format the add so its not ugly
				try {
					orderModel.addElement(new OrderItem(itemModel.getElementAt(itemBox.getSelectedIndex()), Integer.parseInt(quantityTxt.getText())));
					orderObj.addItem(itemModel.getElementAt(itemBox.getSelectedIndex()), Integer.parseInt(quantityTxt.getText()));
				}
				catch(NumberFormatException err) {
					JOptionPane.showMessageDialog(null, "Must set quantity to a non-zero positive value", "Data error", JOptionPane.OK_OPTION);
				}
				catch(IllegalArgumentException err) {
					JOptionPane.showMessageDialog(null, err.getMessage(), "Data error", JOptionPane.OK_OPTION);
				}
			}
		});
		
		removeItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderModel.removeElementAt(orderItemList.getSelectedIndex());
				}
				catch(ArrayIndexOutOfBoundsException err) {
					//we catch this error so if no element is select, simply nothing happens. No reason to have a popup for this.
				}
			}
		});
		
		//Group Layout Modifiers -autogenerated by Windowbuilder-
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(needByLbl)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(needByTxt, 127, 127, 127)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(removeItemBtn))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(quantityLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(quantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
							.addComponent(addToOrderBtn))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(itemLbl)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(itemBox, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(orderItemList, 0, 359, Short.MAX_VALUE)))
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(itemLbl)
								.addComponent(itemBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(quantityLbl)
								.addComponent(quantityTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(addToOrderBtn))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(orderItemList, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(removeItemBtn)
						.addComponent(needByTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(needByLbl))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public PurchaseOrder createPurchaseOrder() throws IllegalArgumentException {
		//attempt to return the constructed orderObj
		//vendor set in constructor
		orderObj.setNeedByDate(needByTxt.getText());
		if(orderObj.getItemCount() == 0) {
			throw new IllegalArgumentException("Must have at least 1 and at most 5 item types in an order");
		}
		return orderObj;
	}
}
