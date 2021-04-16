/**
 * 
 */
package guiPkg;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Date;
import java.util.Vector;

import pkg.CustomerDataModel;
import pkg.CustomerInfo;
import pkg.CustomerProfile;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 */
public class OwnerCustomerListGUI extends CustomerListGUI {
	private static final long serialVersionUID = 7727161324173086580L;
	//private JTable table;
	//private JTextField searchField;
	//private TableRowSorter<CustomerDataModel> sorter;
	
	public OwnerCustomerListGUI(Vector<CustomerProfile> data) {
		super(data);

		//---basic settings---
		setName("Customers");
		
		//VARIABLE DECLARATION AND INITIALIZATION
	//	final CustomerDataModel model = Main.customerDAO;
		//JScrollPane scrollPane = new JScrollPane();
		JButton addCustomerBtn = new JButton("New Customer");
		JButton deleteCustomerBtn = new JButton("Delete Customer");
	//	sorter = new TableRowSorter<CustomerDataModel>(model);
	//	table = new JTable(model);
		
		//setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//search field
		//searchField = new JTextField();
		//searchField.setColumns(10);
		
		//make table
//		table.setAutoCreateRowSorter(true);
//		scrollPane.setViewportView(table);
//		table.setBorder(new EmptyBorder(5, 5, 5, 5));
//		table.setFillsViewportHeight(true);
//		table.setRowSorter(sorter);
		addCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerGUI makeCustomerPanel = new AddCustomerGUI();
				if(JOptionPane.showConfirmDialog(null, makeCustomerPanel, "Create Customer", JOptionPane.OK_CANCEL_OPTION) == 0) {
					if(CustomerDataModel.searchCustomerName(makeCustomerPanel.getName())!=null)
					{
						JOptionPane.showMessageDialog(null, "Error - Customer profile already exists.");
					}
					else if(makeCustomerPanel.getName().length()==0||makeCustomerPanel.getCity().length()==0||makeCustomerPanel.getStreet().length()==0||makeCustomerPanel.getCity().length()==0) {
						JOptionPane.showMessageDialog(null, "Error - Empty fields in Customer Profile creation.");
						}
					else if(makeCustomerPanel.getPhone().matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")==false)
					{
						JOptionPane.showMessageDialog(null, "Error - Invalid Phone number.");
					}
					else 
						model.addRow(new CustomerProfile(new CustomerInfo(makeCustomerPanel.getName(), makeCustomerPanel.getStreet(), makeCustomerPanel.getCity(), makeCustomerPanel.getState(), makeCustomerPanel.getPhone())));
					
					}
			}
		});
		
		deleteCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeRow(getTable().getSelectedRow());
			}
		});
		
        
        getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && getTable().getSelectedRow() != -1) {
				//	System.out.println((String)table.getValueAt(table.getSelectedRow(), 0));
					CustomerProfile cp = CustomerDataModel.getDatabase().elementAt(getTable().getSelectedRow());
					SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
					String currentOrderDate=null;
					if (cp.getLastOrderDate()!=null)
 					 currentOrderDate=dateFormat.format(cp.getLastOrderDate());
					if(cp != null) {
						CustomerProfileGUI profile = new CustomerProfileGUI();
						
						profile.setFields(cp);
						if(JOptionPane.showConfirmDialog(null, profile, "Customer Profile", JOptionPane.OK_CANCEL_OPTION) == 0) {
							String lastOrderDate=profile.getOrderDateTxtBox().getText().toString();
							try {
								if (checkUpdateInputs(profile.getProfile(),lastOrderDate,currentOrderDate)==true) {
								cp =new CustomerProfile( profile.getProfile());

								model.fireTableDataChanged();
								profile.setFields(cp);
								}
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							//table.setSelectedRow();
						}
					}
				}
			}
        });
		

		
		add(addCustomerBtn);
		add(deleteCustomerBtn);
	//	add(searchField);
		add(scrollPane);
	}
	

	

	
	private boolean checkUpdateInputs(CustomerProfile c,String s,String s2) throws ParseException {

		if (c.getCustomerInfo().getCustomerName().length()==0|| c.getCustomerInfo().getStreetAddress().length()==0||c.getCustomerInfo().getCity().length()==0||c.getCustomerInfo().getPhone().length()==0) {
			JOptionPane.showMessageDialog(null, "Error - Empty fields in Customer Profile update.");
			return false;
		}
		else if((Double.toString(c.getCustomerAccount().getBalance())!=null)&&(Double.toString(c.getCustomerAccount().getBalance()).matches("^[0-9]*\\.?[0-9]*$"))==false) {
			JOptionPane.showMessageDialog(null, "Error - Empty or invalid balance in Customer Profile update.");
			return false;
		}
		else if((Double.toString(c.getCustomerAccount().getLastPaidAmount()).matches("^[0-9]*\\.?[0-9]*$"))==false&&c.getCustomerAccount().getLastPaidAmount()!=0) {
			JOptionPane.showMessageDialog(null, "Error - Empty or invalid last paid amount in Customer Profile update.");
			return false;
		}
		if(s.length()!=0) {
		if(s.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
	        DateFormat dF = new SimpleDateFormat("MM/dd/yyyy");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
            Date newOrderDate = dF.parse(s);
            Date presentOrderDate;
            if(s2!=null&&s2!="") {
             presentOrderDate=dF.parse(s2);
            }
            else {
            	presentOrderDate=new Date();
            }
            Date currentDate=new Date();
            SimpleDateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
				String currentDateString=dateFormat.format(currentDate);
				currentDate=dF.parse(currentDateString);
            if(newOrderDate.compareTo(currentDate)!=0&&newOrderDate.compareTo(presentOrderDate)!=0)
            {
    			JOptionPane.showMessageDialog(null, "Error - Past or invalid last order date in Customer Profile update, must be in \"mm/dd/yyyy\" format.");
    			return false;
            }
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - Past or invalid last order date in Customer Profile update, must be in \"mm/dd/yyyy\" format.");
			return false;
		}

		}
		return true;
	}
}
