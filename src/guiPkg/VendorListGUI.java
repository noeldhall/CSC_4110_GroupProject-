package guiPkg;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;

import pkg.VendorProfile;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class VendorListGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	private JTable vendorTable;

	/**
	 * Create the panel.
	 */
	public VendorListGUI(Vector<VendorProfile> data) {
		VendorTableModel model = new VendorTableModel(data);
		
		ScrollPane scrollPane = new ScrollPane();
		add(scrollPane);
		
		vendorTable = new JTable(model);
		vendorTable.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GRAY));
		vendorTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(vendorTable);

	}

}
