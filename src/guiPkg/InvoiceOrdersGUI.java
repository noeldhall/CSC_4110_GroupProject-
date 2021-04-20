package guiPkg;

//Authored by Brett Gloomis

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import pkg.CustomerDataModel;
import pkg.CustomerInvoice;
import pkg.CustomerOrder;
import pkg.InvoiceDataModel;
import pkg.Main;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.Date; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class InvoiceOrdersGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField CustomerNametextField;
	
	/**
	 * Create the panel.
	 */
	public InvoiceOrdersGUI() {
		JLabel lblNewLabel = new JLabel("Customer:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		CustomerNametextField = new JTextField();
		CustomerNametextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CustomerNametextField.setEditable(false);
		CustomerNametextField.setColumns(10);
		final String w = InvoiceDataModel.getDatabase().elementAt(InvoiceMainGUI.table.getSelectedRow()).getCustomerInfo().getCustomerName();
		CustomerNametextField.setText(w);
		
		final Vector<CustomerOrder> co = Main.customerOrderDAO.getOrders(w);
		final JComboBox<CustomerOrder> comboBox = new JComboBox<CustomerOrder>(co);
		JButton NewInvoicebtn = new JButton("Generate Invoice");
		NewInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//populating invoice text fields
				
					if(comboBox.getItemCount() != 0)
					{
						Double total = co.elementAt(comboBox.getSelectedIndex()).calculateTotalCost();
						InvoiceGeneratorGUI invoiceGeneratorPanel = new InvoiceGeneratorGUI();
						String itemsList = co.elementAt(comboBox.getSelectedIndex()).printItems();
						invoiceGeneratorPanel.orderdItemsList.setText(itemsList);
						invoiceGeneratorPanel.OrderNumbertxtField.setText(co.elementAt(comboBox.getSelectedIndex()).getCustomerOrderid());
						DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						String strDate = dateFormat.format(co.elementAt(comboBox.getSelectedIndex()).getOrderDate());
						invoiceGeneratorPanel.OrderDatetxtField.setText(strDate);
						invoiceGeneratorPanel.TotaltxtField.setText("$" + total);
						Date date = new Date();  
					    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
					    String invDate = formatter.format(date);  	
						invoiceGeneratorPanel.InvoiceDatetxtField.setText(invDate);
						
						//populating invoice and adding to newInvoice vector
						if(JOptionPane.showConfirmDialog(null, invoiceGeneratorPanel, "Generate Customer Invoice", JOptionPane.OK_CANCEL_OPTION) == 0)
						{
							CustomerInvoice newInvoice = new CustomerInvoice();
							
							//update customer balance
							CustomerDataModel.getDatabase().get(InvoiceMainGUI.table.getSelectedRow()).getCustomerAccount().setBalance(CustomerDataModel.getDatabase()
									.get(InvoiceMainGUI.table.getSelectedRow()).getCustomerAccount().getBalance() + total);
							
							newInvoice.setCustomerName(w);
							newInvoice.setInvoiceDate(invDate);
							newInvoice.setInvoiceNumber(invoiceGeneratorPanel.invoiceID);
							newInvoice.setInvoiceTotal(total);
							newInvoice.setOrderDate(strDate);
							newInvoice.setOrderedItems(itemsList);
							newInvoice.setOrderNumber(co.elementAt(comboBox.getSelectedIndex()).getCustomerOrderid());
							Main.newInvoice.addCustomerInvoice(newInvoice);
							
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "There are no orders for this customer.");
					}
				}
				
		});
		
		JLabel lblNewLabel_1 = new JLabel("Customer Order Number:");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(NewInvoicebtn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap(178, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(64)
					.addComponent(NewInvoicebtn)
					.addContainerGap(79, Short.MAX_VALUE))
		);
		setLayout(groupLayout);


	}
}
