package guiPkg;

//Authored by Brett Gloomis

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import pkg.CustomerInvoice;
import pkg.InvoiceDataModel;
import pkg.Main;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InvoiceInvoicesGUI extends JPanel {
	private JTextField CustomertxtField;

	/**
	 * Create the panel.
	 */
	public InvoiceInvoicesGUI() {
		
		JLabel lblNewLabel = new JLabel("Customer:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		CustomertxtField = new JTextField();
		CustomertxtField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CustomertxtField.setEditable(false);
		CustomertxtField.setColumns(10);
		String w = InvoiceDataModel.getDatabase().elementAt(InvoiceMainGUI.table.getSelectedRow()).getCustomerInfo().getCustomerName();
		CustomertxtField.setText(w);
		

		
		Vector<CustomerInvoice> ci = Main.newInvoice.getCustomerInvoice(w);
		JComboBox<CustomerInvoice> comboBox = new JComboBox<CustomerInvoice>(ci);
		

		
		JButton ViewInvoicebtn = new JButton("View Invoice");
		ViewInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getItemCount() != 0)
				{
					InvoiceDisplayGUI invoiceDisplayPanel = new InvoiceDisplayGUI();
					
					invoiceDisplayPanel.InvoiceDatetxtField.setText(ci.elementAt(comboBox.getSelectedIndex()).getInvoiceDate());
					invoiceDisplayPanel.InvoiceIDtxtField.setText(Integer.toString(ci.elementAt(comboBox.getSelectedIndex()).getInvoiceNumber()));
					invoiceDisplayPanel.ItemsListArea.setText(ci.elementAt(comboBox.getSelectedIndex()).getOrderedItems());
					invoiceDisplayPanel.OrderDatetxtField.setText(ci.elementAt(comboBox.getSelectedIndex()).getOrderDate());
					invoiceDisplayPanel.OrderNumbertxtField.setText(ci.elementAt(comboBox.getSelectedIndex()).getOrderNumber());
					invoiceDisplayPanel.TotaltxtField.setText("$" + Double.toString(ci.elementAt(comboBox.getSelectedIndex()).getInvoiceTotal()));
					JOptionPane.showConfirmDialog(null, invoiceDisplayPanel, "Customer Invoice Display", JOptionPane.DEFAULT_OPTION);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "There are no invoices for this customer.");
				}
				
			}
		});		
		JLabel lblNewLabel_1 = new JLabel("Customer Invoice Number");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(CustomertxtField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(ViewInvoicebtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustomertxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(84)
					.addComponent(ViewInvoicebtn)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
