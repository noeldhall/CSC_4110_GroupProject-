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
