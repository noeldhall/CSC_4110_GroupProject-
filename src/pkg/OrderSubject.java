/**
 * 
 */
package pkg;

import java.util.Observer;

/**
 * @author Noel Hall
 *
 */
public interface OrderSubject {
    public void attach(InvoiceOrderObserver o);
    public void detach(InvoiceOrderObserver o);
    public void notifyUpdate(String currentOrderId);
    
}
