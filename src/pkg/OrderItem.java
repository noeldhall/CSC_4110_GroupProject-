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
	
	public OrderItem(String[] item,Date needByDate, Date orderDate,int quantity) {
		super(item);
	}
	
	public double calculateSubtotal() {
		return quantity * unitPrice;
	}
	
	private Date needByDate;
	private Date orderDate;
	private int quantity;
	
	public Date getNeedByDate() {
		return needByDate;
	}

	public void setNeedByDate(Date needByDate) {
		this.needByDate = needByDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
