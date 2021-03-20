package guiPkg;

import java.util.Vector;

import javax.swing.JPanel;

import pkg.Database;
import pkg.Main;
import pkg.PersonalInformation;
import pkg.VendorProfile;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VendorListGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	private JTable table;
	private JTextField searchField;
	private TableRowSorter<VendorTableModel> sorter;
	
	/**
	 * Create the panel.
	 */
	public VendorListGUI(Vector<VendorProfile> data) {
		//---basic settings---
		setName("Supplier");
		
		//VARIABLE DECLARATION AND INITIALIZATION
		final VendorTableModel model = new VendorTableModel(data);
		JScrollPane scrollPane = new JScrollPane();
		JButton addVendorBtn = new JButton("New Vendor");
		JButton deleteVendorBtn = new JButton("Delete Vendor");
		sorter = new TableRowSorter<VendorTableModel>(model);
		table = new JTable(model);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//search field
		searchField = new JTextField();
		searchField.setColumns(10);
		
		//make our table
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		addVendorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVendorGUI makeVendorPanel = new AddVendorGUI();
				if(JOptionPane.showConfirmDialog(null, makeVendorPanel, "Create Vendor", JOptionPane.OK_CANCEL_OPTION) == 0) {
					model.addRow(new VendorProfile(new PersonalInformation(makeVendorPanel.getName(), makeVendorPanel.getStreet(), makeVendorPanel.getCity(), makeVendorPanel.getState(), makeVendorPanel.getPhone())));
				}
			}
		});
		
		deleteVendorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table.getSelectedRow());
			}
		});
		
        searchField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						newFilter();
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						newFilter();
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
						newFilter();
					}
        });
        
		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				table.clearSelection();
				searchField.setText("");
			}
		});
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
					System.out.println((String)table.getValueAt(table.getSelectedRow(), 0));
					VendorProfile vp = Database.searchVendorName(((String)table.getValueAt(table.getSelectedRow(), 0)).trim());
					if(vp != null) {
						VendorProfileGUI profile = new VendorProfileGUI();
						profile.setFields(vp);
						if(JOptionPane.showConfirmDialog(null, profile, "Vendor Profile", JOptionPane.OK_CANCEL_OPTION) == 0) {
							//TODO object not updating for some reason, need to fix.
							vp = profile.getProfile();
							model.fireTableDataChanged();
						}
					}
				}
			}
        });
		
		JButton Logoutbtn = new JButton("Log out");
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		add(Logoutbtn);
		
		add(addVendorBtn);
		add(deleteVendorBtn);
		add(searchField);
		add(scrollPane);
	}
	
	private void newFilter() {
	    RowFilter<VendorTableModel, Object> rf = null;
	    //If current expression doesn't parse, don't update.
	    try {
	        rf = RowFilter.regexFilter("(?i).*" + searchField.getText() +".*", 0);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);
	}

}
