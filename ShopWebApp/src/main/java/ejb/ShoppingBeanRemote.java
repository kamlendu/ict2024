/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.Vector;
import javax.ejb.Remote;


/**
 *
 * @author root
 */
@Remote
public interface ShoppingBeanRemote {

   void addToCart(String[] names, String[] prices, String[] quantity);
   void removeFromCart(String[] productNames);
   Vector getContentsOfCart();
   double getGrandTotal();
   //void initialize();
}
