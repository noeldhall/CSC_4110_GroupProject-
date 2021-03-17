package guiPkg;

import java.util.Vector;

import javax.swing.JPanel;

import pkg.PersonalInformation;
import pkg.VendorProfile;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VendorListGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	private JTable table;
	private JTextField searchField;
	
	/**
	 * Create the panel.
	 */
	public VendorListGUI(Vector<VendorProfile> data) {
		//---basic settings---
		setName("Supplier");
		VendorTableModel model = new VendorTableModel(data);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton addVendorBtn = new JButton("New Vendor");
		
		JButton deleteVendorBtn = new JButton("Delete Vendor");
		
		//search field
		searchField = new JTextField();
		searchField.setColumns(10);
		
		//make our table
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setFillsViewportHeight(true);
		
		addVendorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		add(addVendorBtn);
		add(deleteVendorBtn);
		add(searchField);
		add(scrollPane);
	}

}
