package guiPkg;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;

import pkg.Database;
import pkg.Main;
import pkg.UserProfile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class loginGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField1;
    private JTextField textField2;
    private JButton loginButton;
    private JButton btnNewButton;

    public loginGUI() {
    	//invalidLbl.setEnabled(false);
    	
        $$$setupUI$$$();
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	UserProfile up = Database.login(textField1.getText(), textField2.getText());
            	if( up != null) {
            		Database.currentUser = up;
            		Main.swapToMain(up.getUserRole());
            	}
            	else {
            		JOptionPane.showMessageDialog(null, "Please enter a valid username and password.","Invalid Login",JOptionPane.PLAIN_MESSAGE);
            	}            	
            }
        });
    }
    
    private void $$$setupUI$$$() {
        setBackground(new Color(-16711684));
        
        textField1 = new JTextField();
        
        textField2 = new JTextField();
        
        loginButton = new JButton();
        loginButton.setText("Login");
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-16777216));
        label1.setText("Username:");
        final JLabel label2 = new JLabel();
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setEnabled(true);
        Font label2Font = this.$$$getFont$$$(null, -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-16777216));
        label2.setText("Password:");
        
        btnNewButton = new JButton("Exit");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(199)
        					.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(49))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(200)
        					.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(50))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(150)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        						.addComponent(textField1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(197)
        					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(46))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(200)
        					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGap(49)))
        			.addGap(230))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(label1, GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
        			.addGap(28)
        			.addComponent(label2, GroupLayout.PREFERRED_SIZE, 11, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(textField2, GroupLayout.PREFERRED_SIZE, 17, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
        			.addGap(72)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 20, Short.MAX_VALUE)
        			.addGap(111))
        );
        setLayout(groupLayout);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }


}
