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
@Stateless(mappedName = "ejb/calculate")
public class CalculateBean implements CalculateBeanRemote {

    @Override
    public int add(int x, int y) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return x+y;
    }

    @Override
    public int subtract(int x, int y) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       return x-y;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
