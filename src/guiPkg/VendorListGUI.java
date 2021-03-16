package guiPkg;

import java.util.Vector;

import javax.swing.JPanel;
import pkg.VendorProfile;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

public class VendorListGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	private JTable table;
	
	/**
	 * Create the panel.
	 */
	public VendorListGUI(Vector<VendorProfile> data) {
		setName("Supplier");
		VendorTableModel model = new VendorTableModel(data);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		table = new JTable(model);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}

}
