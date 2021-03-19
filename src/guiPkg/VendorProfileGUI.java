package guiPkg;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import pkg.States;
import pkg.VendorProfile;

public class VendorProfileGUI extends JPanel {
	private VendorProfile profile;
	private JTextField nameTxtBox;
	private JTextField streetTxtBox;
	private JTextField idTxtBox;
	private JTextField orderDateTxtBox;
	private JTextField balanceTxtBox;
	private JTextField lastPaidTxtBox;
	private JTextField seasonalDateTxtBox;
	private JTextField cityTxtBox;
	private JComboBox<States> stateBox;
	
	public VendorProfileGUI() {
		JLabel nameLbl = new JLabel("Full Vendor Name:");
		JLabel streetLbl = new JLabel("Street Address:");
		JLabel vendorID = new JLabel("Vendor ID:");
		JLabel discountDateLbl = new JLabel("Seasonal Discount Start Date:");
		JLabel balanceLbl = new JLabel("Account Balance:");
		JLabel lastPaidLbl = new JLabel("Last Paid Amount:");
		JLabel orderDateLbl = new JLabel("Last Order Date:");
		JLabel cityLbl = new JLabel("City:");
		
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
		
		JLabel stateGUI = new JLabel("State:");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(vendorID)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(idTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(discountDateLbl))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(seasonalDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(nameLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameTxtBox, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(streetLbl)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(streetTxtBox, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(balanceLbl)
										.addComponent(lastPaidLbl))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lastPaidTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(balanceTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(137))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(orderDateLbl)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(orderDateTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(111))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(cityLbl)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cityTxtBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(stateGUI)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
						.addComponent(stateBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(stateGUI))
					.addGap(13)
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
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	public void setFields(VendorProfile profile) {
		this.profile = profile;
		idTxtBox.setText(profile.getVendorID());
		nameTxtBox.setText(profile.getPersonal().getFullName());
		streetTxtBox.setText(profile.getPersonal().getStreetAddress());
		cityTxtBox.setText(profile.getPersonal().getCity());
		stateBox.setSelectedItem(States.valueOf(profile.getPersonal().getState()));
		balanceTxtBox.setText(Double.toString(profile.getvAccount().getBalance()));
		lastPaidTxtBox.setText(Double.toString(profile.getvAccount().getLastPaidAmount()));
		orderDateTxtBox.setText(profile.getLastOrderDate().toString());
		seasonalDateTxtBox.setText(profile.getDiscountStartDate().toString());
	}
	
	public VendorProfile getProfile() {
		return this.profile;
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
