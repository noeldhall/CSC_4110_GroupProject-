/**
 * 
 */
package guiPkg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import pkg.CustomerOrder;
import pkg.CustomerOrderDataModel;
import pkg.CustomerProfile;
import pkg.InvoiceDataModel;
import pkg.Item;
import pkg.ItemDataModel;
import pkg.Main;
import pkg.OrderItem;
import pkg.OrderObserver;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextArea;

/**
 * @author Noel Hall
 *
 */
public class CustomerOrderItemListGUI extends ItemListGUI implements OrderObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471357721174777103L;
	private CustomerOrder currentCustomerOrder;
	private JTextField txtTotalCost;
	private JTextField txtNeedByDate;
	JTextArea txtrOrderSummary ;
	public CustomerOrderItemListGUI(Vector<Item> data) {
		super(data);
		setName("New Customer Order");

		getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting() && getTable().getSelectedRow()!= -1) {
					String quantity= JOptionPane.showInputDialog(
						        null, 
						        "Enter desired quantity"
						    );
					quantityInputCheck(quantity);
					printOrderSummary();
				}
        }});
		
		
		JButton CancelButton = new JButton("Cancel");
		CancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Cancel order?" , "Cancel", JOptionPane.YES_NO_OPTION) == 0) {
					
				CustomerOrderDataModel.getDatabase().remove(currentCustomerOrder);
				Main.getMenu().clearTabs();
				Main.getMenu().openTab(Main.getSalesCustomerTab());
				}
			}
		});
		
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerOrderDataModel.getDatabase().remove(currentCustomerOrder);
				Main.swapToLogin();
			}
			});
		
		JLabel lblNewByDate = new JLabel("Need by date (mm/dd/yyyy):");
		add(lblNewByDate);
		
		txtNeedByDate = new JTextField();
		add(txtNeedByDate);
		txtNeedByDate.setColumns(10);
		JLabel lblTotalCost= new JLabel("Total cost ($):");
		add(lblTotalCost);
		
		txtTotalCost = new JTextField();
		txtTotalCost.setEditable(false);
		add(txtTotalCost);
		txtTotalCost.setColumns(10);
		
		JLabel lblOrderSummary = new JLabel("Order Summary:");
		add(lblOrderSummary);
		
		 txtrOrderSummary = new JTextArea();
		 txtrOrderSummary.setEnabled(false);
		txtrOrderSummary.setRows(5);
		txtrOrderSummary.setColumns(20);
		add(txtrOrderSummary);
		add(CancelButton);
		
		
		JButton SubmitButton = new JButton("Submit Order");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null,"Submit order?" , "Submit", JOptionPane.YES_NO_OPTION) == 0) {
					if(checkNeedByDate()==true) {
						if(currentCustomerOrder.getOrderItems().size()>0) {
						
							Main.getMenu().clearTabs();
							Main.getMenu().openTab(Main.getSalesCustomerTab());
							currentCustomerOrder.subtractQuantities();
							JOptionPane.showMessageDialog(null, "Customer order submitted.");	
						}
						else {
							JOptionPane.showMessageDialog(null, "Error - Order has to have at least one item");	

						}
					}
				}
			}
		});

		add(SubmitButton);
		add(scrollPane);

	}

	@Override
	public void update(String currentOrderId) {
		currentCustomerOrder=CustomerOrderDataModel.searchCustomerOrderID(currentOrderId);
		txtTotalCost.setText(String.valueOf(currentCustomerOrder.getTotalCost()));
		txtrOrderSummary.setText("");
		txtNeedByDate.setText("");
	}

	
	public OrderItem searchItemInCart(OrderItem oi) {
		for(OrderItem i: currentCustomerOrder.getOrderItems())
		{
			if(i.getItemID().equals(oi.getItemID()))
				return i;
					
		}
		return null;
	}
	
	public void quantityInputCheck(String quantity) {
		if(quantity!=null) {
			if(quantity.matches("^[0-9]*[1-9][0-9]*$")) {
				if(currentCustomerOrder.getOrderItems().size()<5) {
					OrderItem oi = new OrderItem(ItemDataModel.getDatabase().elementAt(getTable().getSelectedRow()),Integer.parseInt(quantity));
					if(oi.getQuantity()<=oi.getBalanceOnHand()) {
						if(searchItemInCart(oi)==null)
							{
								currentCustomerOrder.getOrderItems().add(oi);
		
								currentCustomerOrder.calculateTotalCost();
								//format total cost to 2 decimal places
								txtTotalCost.setText(String.format("%.2f",currentCustomerOrder.getTotalCost()));
							}
						else {
							JOptionPane.showMessageDialog(null, "Error - Item already present in order.");

						}
			
					}
					else {
						JOptionPane.showMessageDialog(null, "Error - Quantity desired exceeds the balance on hand.");

					}
			
				}
				else {
					JOptionPane.showMessageDialog(null, "Error - Limit of 5 items in order reached.");

				}
				}
			else
			{
				JOptionPane.showMessageDialog(null, "Error - Invalid quantity.");

			}
			
		}
	}
	
	public boolean checkNeedByDate() {
		String s=txtNeedByDate.getText().toString();
		if(s.matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$"))
		{
			 DateFormat dF = new SimpleDateFormat("MM/dd/yyyy");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
	            Date needByDate=new Date();
				try {
					needByDate = dF.parse(s);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(needByDate.compareTo(currentCustomerOrder.getOrderDate())>=0)
			{
				currentCustomerOrder.setNeedByDate(needByDate);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(null, "Error - Invalid or past need by date.");
				return false;
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - Invalid or past need by date.");
			return false;
		}
	}
	
	public void expiredCheck() {
		int expiredCount=0;
		Date currentDate=new Date();
		for (Item i:ItemDataModel.getDatabase())
			if(i.getExpires().compareTo(currentDate)==-1)
				expiredCount++;
		if (expiredCount>=2)
			JOptionPane.showMessageDialog(null, "Alert - Over 2 items in the inventory are expired");

	}
	
	public void printOrderSummary() {
		String summary="";
		for(OrderItem oi:currentCustomerOrder.getOrderItems())
			summary+=oi.getQuantity() +" "+oi.getItemName()+", $"+String.format("%.2f",oi.calculateSubtotal())+"\n";
		txtrOrderSummary.setText(summary);
	}
}
          