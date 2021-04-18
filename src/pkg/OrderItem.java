
package pkg;

/**
 * @author Noel Hall
 *
 */
public class OrderItem extends Item{
	private int quantity;
	
	public OrderItem(String[] item,int quantity) {
		super(item);
		this.quantity = quantity;
	}
	
	public OrderItem(Item it, int quantity) {
		super(it);
		setQuantity(quantity);
	}
	
	public double calculateSubtotal() {
		return quantity * sellPrice;
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
	
	@Override
	public String toString()
	{
		String yes = "";
		
		
		yes += super.itemName + "\t" + quantity + "\t$" + super.sellPrice;
		
		return yes;
	}
}
