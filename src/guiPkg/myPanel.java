package guiPkg;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class myPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	
	myPanel(){
		 setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
	        setBackground(new Color(-14232015));
	        final JLabel label1 = new JLabel();
	        label1.setForeground(new Color(-16777216));
	        label1.setText("Main Menu");
	        add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
	}
}
