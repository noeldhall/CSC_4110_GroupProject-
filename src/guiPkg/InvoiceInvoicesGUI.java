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

import pkg.InvoiceDataModel;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvoiceInvoicesGUI extends JPanel {
	private JTextField CustomertxtField;
	private JTable table;

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
		JScrollPane scrollPane = new JScrollPane();
		
		JButton ViewInvoicebtn = new JButton("View Invoice");
		ViewInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceDisplayGUI invoiceDisplayPanel = new InvoiceDisplayGUI();
				JOptionPane.showConfirmDialog(null, invoiceDisplayPanel, "Customer Invoice Display", JOptionPane.DEFAULT_OPTION);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CustomertxtField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(179)
							.addComponent(ViewInvoicebtn)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustomertxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ViewInvoicebtn)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}

}
