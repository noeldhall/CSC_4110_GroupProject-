package guiPkg;

//Authored by Brett Gloomis

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import pkg.CustomerProfile;
import pkg.InvoiceDataModel;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class InvoiceOrdersGUI extends JPanel {
	private JTable table;
	private JTextField CustomerNametextField;

	/**
	 * Create the panel.
	 */
	public InvoiceOrdersGUI() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton NewInvoicebtn = new JButton("Generate Invoice");
		NewInvoicebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceGeneratorGUI invoiceGeneratorPanel = new InvoiceGeneratorGUI();
				JOptionPane.showConfirmDialog(null, invoiceGeneratorPanel, "Generate Customer Invoice", JOptionPane.OK_CANCEL_OPTION);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Customer:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		CustomerNametextField = new JTextField();
		CustomerNametextField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CustomerNametextField.setEditable(false);
		CustomerNametextField.setColumns(10);
		String w = InvoiceDataModel.getDatabase().elementAt(InvoiceMainGUI.table.getSelectedRow()).getCustomerInfo().getCustomerName();
		CustomerNametextField.setText(w);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(32)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 384, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(168)
							.addComponent(NewInvoicebtn)))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(CustomerNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addGap(21)
					.addComponent(NewInvoicebtn)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order Number:"
			}
		));
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
