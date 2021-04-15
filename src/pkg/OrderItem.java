/**
 * 
 */
package pkg;

import java.util.Date;

/**
 * @author Noel Hall
 *
 */
public class OrderItem extends Item{
	private int quantity;
	
	public OrderItem(String[] item,int quantity) {
		super(item);
	}
	
	public double calculateSubtotal() {
		return quantity * unitPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) throws IllegalArgumentException {
		if(quantity > 0) {
			this.quantity = quantity;
		}
		else {
			throw new IllegalArgumentException("Quantity of an orderItem must be greater than 0");
		}
	}
}
