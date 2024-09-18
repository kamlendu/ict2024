/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;

/**
 *
 * @author root
 */
@Stateful(mappedName = "ejb/MyCart2")
public class ShoppingBean implements ShoppingBeanRemote {
    

    Vector contents;

    @PostConstruct
    private void initialize() {
        contents = new Vector();
        System.out.println("Shopping Bean Created");
    }

    public void addToCart(String[] names, String[] prices, String[] quantities) {
        Vector vtemp = new Vector();
        vtemp.setSize(contents.size());
        vtemp = contents;
        // System.out.println(contents);
        //System.out.println(vtemp);

        int counter = 0;
        if (contents.isEmpty()) {

            for (int k = 0; k < names.length; k++) {
                Hashtable h = new Hashtable();
                h.put("name", names[k]);
                h.put("price", prices[k]);
                h.put("quantity", quantities[k]);
                h.put("total", Double.parseDouble(prices[k]) * Integer.parseInt(quantities[k]));
                contents.add(h);

            }
        } 
        else 
        
            {
            for (int i = 0; i < contents.size(); i++) {
                counter = 0;
                Hashtable temp = (Hashtable) contents.get(i);
                for (int k = 0; k < names.length; k++) {
                       
                    if (temp.get("name").equals(names[k])) {
                        contents.remove(temp);
                        Hashtable h = new Hashtable();
                        h.put("name", names[k]);
                        h.put("price", prices[k]);
                        h.put("quantity", quantities[k]);
                        h.put("total", Double.parseDouble(prices[k]) * Integer.parseInt(quantities[k]));
                        contents.add(h);
                        names[k] = "present";

                    }
                }
                counter = counter + 1;
            }
            for (int num = 0; num < names.length; num++) {
                if (!names[num].equals("present")) {
                    Hashtable h = new Hashtable();
                    h.put("name", names[num]);
                    h.put("price", prices[num]);
                    h.put("quantity", quantities[num]);
                    h.put("total", Double.parseDouble(prices[num]) * Integer.parseInt(quantities[num]));
                    contents.add(h);
                }

            }
        }
    }

    public Vector getContentsOfCart() {

        return contents;
    }

    public void removeFromCart(String[] productNames) {
        int counter = 0;
        Vector vnames;
        Vector vtemp = new Vector();
        vtemp.setSize(contents.size());
        vtemp = contents;
        
        if (!contents.isEmpty()) {
           
            vnames = convertArrayToVector(productNames);
            for (int i = 0; i < contents.size(); i++) {
                Hashtable temp = (Hashtable) contents.get(i);
                if (vnames.contains(temp.get("name"))) {
                    contents.remove(temp);
                }

            }

        }

    }

    public double getGrandTotal() {
        double total = 0;
        Iterator it = contents.iterator();
        while (it.hasNext()) {
            Hashtable h = (Hashtable) it.next();
            Double dbl = (Double) h.get("total");
            total += dbl.doubleValue();
        }

        return total;
    }
    
    private Vector convertArrayToVector(String array[])
    {
        Vector v = new Vector();
            for (int i = 0; i < array.length; i++) {
                v.add(array[i]);
            }
    return v;
    }
}
