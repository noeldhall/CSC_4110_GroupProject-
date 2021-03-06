package guiPkg;

//Authored by Brett Gloomis

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class InvoiceDisplayGUI extends JPanel {
	public JTextField InvoiceDatetxtField;
	public JTextField OrderDatetxtField;
	public JTextField OrderNumbertxtField;
	public JTextField TotaltxtField;
	public JTextField InvoiceIDtxtField;
	public JTextArea ItemsListArea;
	/**
	 * Create the panel.
	 */
	public InvoiceDisplayGUI() {
		
		JLabel lblNewLabel = new JLabel("Invoice Date:");
		
		JLabel lblNewLabel_1 = new JLabel("Order Date:");
		
		JLabel lblNewLabel_2 = new JLabel("Order Number:");
		
		JLabel lblNewLabel_3 = new JLabel("Total Invoice Amount:");
		
		JLabel lblNewLabel_4 = new JLabel("Ordered Items:");
		
		InvoiceDatetxtField = new JTextField();
		InvoiceDatetxtField.setEditable(false);
		InvoiceDatetxtField.setColumns(10);
		
		OrderDatetxtField = new JTextField();
		OrderDatetxtField.setEditable(false);
		OrderDatetxtField.setColumns(10);
		
		OrderNumbertxtField = new JTextField();
		OrderNumbertxtField.setEditable(false);
		OrderNumbertxtField.setColumns(10);
		
		TotaltxtField = new JTextField();
		TotaltxtField.setEditable(false);
		TotaltxtField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_5 = new JLabel("Invoice ID:");
		
		InvoiceIDtxtField = new JTextField();
		InvoiceIDtxtField.setEditable(false);
		InvoiceIDtxtField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(TotaltxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 418, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(InvoiceDatetxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OrderDatetxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(OrderNumbertxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(InvoiceIDtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(InvoiceDatetxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(OrderDatetxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(OrderNumbertxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(InvoiceIDtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(TotaltxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		ItemsListArea = new JTextArea();
		ItemsListArea.setEditable(false);
		scrollPane.setViewportView(ItemsListArea);
		setLayout(groupLayout);

	}
}
