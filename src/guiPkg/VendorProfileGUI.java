package guiPkg;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

import java.util.Date;

import javax.swing.DefaultComboBoxModel;

import pkg.PersonalInformation;
import pkg.States;
import pkg.VendorAccount;
import pkg.VendorProfile;

//Authored by Nicholas Foster

public class VendorProfileGUI extends JPanel {
	private JTextField nameTxtBox;
	private JTextField streetTxtBox;
	private JTextField idTxtBox;
	private JTextField orderDateTxtBox;
	private JTextField balanceTxtBox;
	private JTextField lastPaidTxtBox;
	private JTextField seasonalDateTxtBox;
	private JTextField cityTxtBox;
	private JComboBox<States> stateBox;
	private JTextField phoneTxtBox;
	
	public VendorProfileGUI() {
		JLabel nameLbl = new JLabel("Full Vendor Name:");
		JLabel streetLbl = new JLabel("Street Address:");
		JLabel vendorID = new JLabel("Vendor ID:");
		JLabel discountDateLbl = new JLabel("Seasonal Discount Start Date:");
		JLabel balanceLbl = new JLabel("Account Balance:");
		JLabel lastPaidLbl = new JLabel("Last Paid Amount:");
		JLabel orderDateLbl = new JLabel("Last Order Date:");
		JLabel cityLbl = new JLabel("City:");
		JLabel stateGUI = new JLabel("State:");
		JLabel phoneLbl = new JLabel("Phone Number:");
		
		nameTxtBox = new JTextField();
		nameTxtBox.setColumns(10);
		
		
		streetTxtBox = new JTextField();
		streetTxtBox.setColumns(10);
		
		
		idTxtBox = new JTextField();
		idTxtBox.setColumns(10);
		idTxtBox.setEditable(false);
		
		orderDateTxtBox = new JTextField();
		orderDateTxtBox.setColumns(10);
		
		stateBox = new JComboBox<States>();
		stateBox.setModel(new DefaultComboBoxModel<States>(States.values()));
		
		balanceTxtBox = new JTextField();
		balanceTxtBox.setColumns(10);
		
		lastPaidTxtBox = new JTextField();
		lastPaidTxtBox.setColumns(10);
		
		seasonalDateTxtBox = new JTextField();
		seasonalDateTxtBox.setColumns(10);
		
		cityTxtBox = new JTextField();
		cityTxtBox.setColumns(10);
		
		phoneTxtBox = new JTextField();
		phoneTxtBox.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(vendorID)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nameLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTxtBox, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(streetLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(streetTxtBox, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
							.addGap(111))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(discountDateLbl)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(seasonalDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(orderDateLbl)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(orderDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(phoneLbl)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(phoneTxtBox))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(balanceLbl)
												.addComponent(lastPaidLbl))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lastPaidTxtBox)
												.addComponent(balanceTxtBox)))))
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addComponent(cityLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cityTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(stateGUI)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(125))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(vendorID)
								.addComponent(idTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(nameLbl)
								.addComponent(nameTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(streetLbl)
								.addComponent(streetTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cityLbl)
						.addComponent(cityTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stateGUI)
						.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(phoneLbl)
						.addComponent(phoneTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(balanceLbl)
						.addComponent(balanceTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastPaidLbl)
						.addComponent(lastPaidTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(orderDateLbl)
						.addComponent(orderDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(seasonalDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(discountDateLbl))
					.addContainerGap())
		);
		
		setLayout(groupLayout);
	}
	
	public void setFields(VendorProfile profile) {
		idTxtBox.setText(profile.getVendorID());
		nameTxtBox.setText(profile.getPersonal().getFullName());
		streetTxtBox.setText(profile.getPersonal().getStreetAddress());
		cityTxtBox.setText(profile.getPersonal().getCity());
		stateBox.setSelectedItem(States.valueOf(profile.getPersonal().getState()));
		phoneTxtBox.setText(profile.getPersonal().getPhone());
		balanceTxtBox.setText(Double.toString(profile.getvAccount().getBalance()));
		lastPaidTxtBox.setText(Double.toString(profile.getvAccount().getLastPaidAmount()));
		orderDateTxtBox.setText(profile.getLastOrderDate().toString());
		seasonalDateTxtBox.setText(profile.getDiscountStartDate().toString());
	}
	
	public VendorProfile getProfile() {
		VendorProfile vp = new VendorProfile();
		vp.setvAccount(new VendorAccount(Double.parseDouble(balanceTxtBox.getText()), Double.parseDouble(lastPaidTxtBox.getText())));
		vp.setPersonal(new PersonalInformation(nameTxtBox.getText(), streetTxtBox.getText(), cityTxtBox.getText(), (States) stateBox.getSelectedItem(), phoneTxtBox.getText()));
		vp.setDiscountStartDate(new Date(seasonalDateTxtBox.getText()));
		vp.setLastOrderDate(new Date(orderDateTxtBox.getText()));
		return vp;
	}
	
	//generic get/sets used to populate and modify
	public JTextField getNameTxtBox() {
		return nameTxtBox;
	}
	public void setNameTxtBox(JTextField nameTxtBox) {
		this.nameTxtBox = nameTxtBox;
	}
	public JTextField getStreetTxtBox() {
		return streetTxtBox;
	}
	public void setStreetTxtBox(JTextField streetTxtBox) {
		this.streetTxtBox = streetTxtBox;
	}
	public JTextField getIdTxtBox() {
		return idTxtBox;
	}
	public void setIdTxtBox(JTextField idTxtBox) {
		this.idTxtBox = idTxtBox;
	}
	public JTextField getOrderDateTxtBox() {
		return orderDateTxtBox;
	}
	public void setOrderDateTxtBox(JTextField orderDateTxtBox) {
		this.orderDateTxtBox = orderDateTxtBox;
	}
	public JTextField getBalanceTxtBox() {
		return balanceTxtBox;
	}
	public void setBalanceTxtBox(JTextField balanceTxtBox) {
		this.balanceTxtBox = balanceTxtBox;
	}
	public JTextField getLastPaidTxtBox() {
		return lastPaidTxtBox;
	}
	public void setLastPaidTxtBox(JTextField lastPaidTxtBox) {
		this.lastPaidTxtBox = lastPaidTxtBox;
	}
	public JTextField getSeasonalDateTxtBox() {
		return seasonalDateTxtBox;
	}
	public void setSeasonalDateTxtBox(JTextField seasonalDateTxtBox) {
		this.seasonalDateTxtBox = seasonalDateTxtBox;
	}
	public JTextField getCityTxtBox() {
		return cityTxtBox;
	}
	public void setCityTxtBox(JTextField cityTxtBox) {
		this.cityTxtBox = cityTxtBox;
	}
}
