package guiPkg;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import pkg.Database;
import pkg.Roles;
import pkg.UserProfile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerGUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField UserIDtxtField;
	private JTextField textField_1;
	private JTextField txtPassReset;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ManagerGUI() {

		setName("Manager");
		setBackground(Color.CYAN);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 190, 212, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{26, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Enter User ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		UserIDtxtField = new JTextField();
		GridBagConstraints gbc_UserIDtxtField = new GridBagConstraints();
		gbc_UserIDtxtField.fill = GridBagConstraints.BOTH;
		gbc_UserIDtxtField.insets = new Insets(0, 0, 5, 5);
		gbc_UserIDtxtField.gridx = 2;
		gbc_UserIDtxtField.gridy = 0;
		add(UserIDtxtField, gbc_UserIDtxtField);
		UserIDtxtField.setColumns(10);
		
		btnNewButton = new JButton("Display User List");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserTableGUI UserTab = new UserTableGUI(Database.users);
				JOptionPane.showMessageDialog(null, UserTab,"User Data Table",JOptionPane.PLAIN_MESSAGE);
			}
		});

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search User");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 3;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnCreateProfile = new JButton("Create User Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = JOptionPane.showInputDialog(null, "Enter first name:");
				String lastName = JOptionPane.showInputDialog(null, "Enter last name:");
				String userID = JOptionPane.showInputDialog(null, "Enter user ID:");
				String password = JOptionPane.showInputDialog(null, "Enter password:");
				Object[] possibleValues = Roles.values();
				Object selectedValue = JOptionPane.showInputDialog(null, "Assign a role:", "Input", JOptionPane.INFORMATION_MESSAGE, null, 
						possibleValues, possibleValues[0]);
				
				Database.users.add(new UserProfile(lastName, firstName, userID, password, (Roles) selectedValue));
			}
		});
		GridBagConstraints gbc_btnCreateProfile = new GridBagConstraints();
		gbc_btnCreateProfile.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateProfile.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateProfile.gridx = 1;
		gbc_btnCreateProfile.gridy = 4;
		add(btnCreateProfile, gbc_btnCreateProfile);
		
		JButton btnNewButton_3 = new JButton("Update User Profile");
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 5;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JComboBox roleComboBox = new JComboBox();
		roleComboBox.setModel(new DefaultComboBoxModel(Roles.values()));
		GridBagConstraints gbc_roleComboBox = new GridBagConstraints();
		gbc_roleComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_roleComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_roleComboBox.gridx = 2;
		gbc_roleComboBox.gridy = 6;
		add(roleComboBox, gbc_roleComboBox);
		
		JButton btnNewButton_5 = new JButton("Reset Password");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				if(Database.findUser(UserIDtxtField.getText()).createPassword(txtPassReset.getText()))
					JOptionPane.showMessageDialog(null, "User password has been reset!");
			}
		});
		
		JButton btnAssignRole = new JButton("Assign User Role");
		btnAssignRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Database.findUser(UserIDtxtField.getText()).changeRole(roleComboBox.getSelectedItem()))
					JOptionPane.showMessageDialog(null, "User role assigned!");
			}
		});
		GridBagConstraints gbc_btnAssignRole = new GridBagConstraints();
		gbc_btnAssignRole.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAssignRole.insets = new Insets(0, 0, 5, 5);
		gbc_btnAssignRole.gridx = 1;
		gbc_btnAssignRole.gridy = 6;
		add(btnAssignRole, gbc_btnAssignRole);
		
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 1;
		gbc_btnNewButton_5.gridy = 7;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		txtPassReset = new JTextField();
		GridBagConstraints gbc_txtPassReset = new GridBagConstraints();
		gbc_txtPassReset.insets = new Insets(0, 0, 5, 5);
		gbc_txtPassReset.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPassReset.gridx = 2;
		gbc_txtPassReset.gridy = 7;
		add(txtPassReset, gbc_txtPassReset);
		txtPassReset.setColumns(10);
		
		JButton btnDeleteUser = new JButton("Delete User Profile");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Database.findUser(UserIDtxtField.getText()).deleteProfile())
					JOptionPane.showMessageDialog(null, "User profile has been deleted.");
				
			}
		});
		
		
		GridBagConstraints gbc_btnDeleteUser = new GridBagConstraints();
		gbc_btnDeleteUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDeleteUser.insets = new Insets(0, 0, 5, 5);
		gbc_btnDeleteUser.gridx = 1;
		gbc_btnDeleteUser.gridy = 8;
		add(btnDeleteUser, gbc_btnDeleteUser);

	}
}
