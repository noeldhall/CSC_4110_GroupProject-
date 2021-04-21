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
    public void attach(OrderObserver o);
    public void detach(OrderObserver o);
    public void notifyUpdate(String currentOrderId);
    
}
