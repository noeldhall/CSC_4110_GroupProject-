/**
 * 
 */
package guiPkg;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Vector;

import pkg.Database;
import pkg.Main;
import pkg.CustomerInfo;
import pkg.CustomerProfile;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 *
 */
public class CustomerListGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086580L;
	private JTable table;
	private JTextField searchField;
	private TableRowSorter<CustomerTableModel> sorter;
	
	public CustomerListGUI(Vector<CustomerProfile> data) {
		//---basic settings---
		setName("Customer");
		
		//VARIABLE DECLARATION AND INITIALIZATION
		final CustomerTableModel model = new CustomerTableModel(data);
		JScrollPane scrollPane = new JScrollPane();
		JButton addCustomerBtn = new JButton("New Customer");
		JButton deleteCustomerBtn = new JButton("Delete Customer");
		sorter = new TableRowSorter<CustomerTableModel>(model);
		table = new JTable(model);
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//search field
		searchField = new JTextField();
		searchField.setColumns(10);
		
		//make table
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		addCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerGUI makeCustomerPanel = new AddCustomerGUI();
				if(JOptionPane.showConfirmDialog(null, makeCustomerPanel, "Create Customer", JOptionPane.OK_CANCEL_OPTION) == 0) {
					if(Database.searchCustomerName(makeCustomerPanel.getName())!=null)
					{
						JOptionPane.showMessageDialog(null, "Customer profile already exists.");
					}
					else {
					model.addRow(new CustomerProfile(new CustomerInfo(makeCustomerPanel.getName(), makeCustomerPanel.getStreet(), makeCustomerPanel.getCity(), makeCustomerPanel.getState(), makeCustomerPanel.getPhone())));
					}
					}
			}
		});
		
		deleteCustomerBtn.addActionListener(new ActionListener() {
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
					CustomerProfile cp = Database.searchCustomerName(((String)table.getValueAt(table.getSelectedRow(), 0)).trim());
					if(cp != null) {
						CustomerProfileGUI profile = new CustomerProfileGUI();
						profile.setFields(cp);
						if(JOptionPane.showConfirmDialog(null, profile, "Customer Profile", JOptionPane.OK_CANCEL_OPTION) == 0) {
							cp = profile.getProfile();
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
		
		add(addCustomerBtn);
		add(deleteCustomerBtn);
		add(searchField);
		add(scrollPane);
	}
	
	private void newFilter() {
	    RowFilter<CustomerTableModel, Object> rf = null;
	    //If current expression doesn't parse, don't update.
	    try {
	        rf = RowFilter.regexFilter("(?i).*" + searchField.getText() +".*", 0);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);
	}
}
