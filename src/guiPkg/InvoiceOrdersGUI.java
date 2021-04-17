package guiPkg;

//Authored by Brett Gloomis

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import pkg.CustomerOrder;
import pkg.CustomerOrderDataModel;
import pkg.CustomerProfile;
import pkg.InvoiceDataModel;
import pkg.Main;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InvoiceOrdersGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField CustomerNametextField;

	/**
	 * Create the panel.
	 */
	public InvoiceOrdersGUI() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		

		
		JLabel lblNewLabel = new JLabel("Customer:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		CustomerNametextField = new JTextField();
		CustomerNametextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CustomerNametextField.setEditable(false);
		CustomerNametextField.setColumns(10);
		String w = InvoiceDataModel.getDatabase().elementAt(InvoiceMainGUI.table.getSelectedRow()).getCustomerInfo().getCustomerName();
		CustomerNametextField.setText(w);
		
		Vector<CustomerOrder> co = Main.customerOrderDAO.getOrders(w);
		JComboBox<CustomerOrder> comboBox = new JComboBox<CustomerOrder>(co);
		
		JButton NewInvoicebtn = new JButton("Generate Invoice");
		NewInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceGeneratorGUI invoiceGeneratorPanel = new InvoiceGeneratorGUI();
				invoiceGeneratorPanel.orderdItemsList.setText(co.elementAt(comboBox.getSelectedIndex()).printItems());
				JOptionPane.showConfirmDialog(null, invoiceGeneratorPanel, "Generate Customer Invoice", JOptionPane.OK_CANCEL_OPTION);
				//CustomerOrder.printItems();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(lblNewLabel)
							.addGap(5)
							.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(NewInvoicebtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(133)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(NewInvoicebtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(105)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		setLayout(groupLayout);


	}
}
