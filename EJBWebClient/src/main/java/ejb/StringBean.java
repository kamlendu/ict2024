/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class StringBean implements StringBeanLocal {

    @Override
    public String getUpper(String s) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      return s.toUpperCase();
    
    }

    @Override
    public String getLower(String s) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return s.toLowerCase();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
