package guiPkg;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import pkg.Item;

public class ItemNameRenderer extends JLabel implements ListCellRenderer<Item> {
	/**
	 *  Authored by Nicholas Foster
	 */
	private static final long serialVersionUID = 7222854340057958538L;
	
	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		setText(value.getItemName());
		return this;
	}
}
