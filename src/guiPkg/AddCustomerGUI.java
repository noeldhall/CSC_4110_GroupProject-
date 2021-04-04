package guiPkg;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import pkg.States;

public class AddCustomerGUI extends JPanel {
	private JTextField nameTxtBox;
	private JTextField streetTxtBox;
	private JTextField cityTxtBox;
	private JTextField phoneTxtBox;
	private JLabel customerLbl;
	private JComboBox<States> stateBox;
	
	public AddCustomerGUI() {	
		JLabel nameLbl = new JLabel("Customer Name:");
		JLabel streetLbl = new JLabel("Street Address:");
		JLabel cityLbl = new JLabel("City:");
		JLabel stateLbl = new JLabel("State:");
		JLabel phoneLbl = new JLabel("Phone Number (with dashes):");
		
		//init data
		nameTxtBox = new JTextField();
		nameTxtBox.setColumns(10);
		streetTxtBox = new JTextField();
		streetTxtBox.setColumns(10);		
		cityTxtBox = new JTextField();
		cityTxtBox.setColumns(10);	
		phoneTxtBox = new JTextField();
		phoneTxtBox.setColumns(10);
		customerLbl = new JLabel("Enter Customer Information:");
		customerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		stateBox = new JComboBox<States>();
		stateBox.setModel(new DefaultComboBoxModel<States>(States.values()));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(68)
					.addComponent(customerLbl)
					.addContainerGap(73, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(phoneLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phoneTxtBox, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cityLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cityTxtBox, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(stateLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(streetLbl)
								.addComponent(nameLbl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(nameTxtBox, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
								.addComponent(streetTxtBox, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
					.addGap(103))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(customerLbl)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nameLbl)
						.addComponent(nameTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(streetLbl)
						.addComponent(streetTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityLbl)
						.addComponent(cityTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stateLbl)
						.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(phoneLbl, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(phoneTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	
	public String getName() {
		return nameTxtBox.getText();
	}
	
	public String getStreet() {
		return streetTxtBox.getText();
	}
	
	public String getCity() {
		return cityTxtBox.getText();
	}
	
	public States getState() {
		return (States) stateBox.getSelectedItem();
	}
	public String getPhone() {
		return phoneTxtBox.getText();
	}
	
}
