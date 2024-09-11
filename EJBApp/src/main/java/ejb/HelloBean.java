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
public class HelloBean implements HelloBeanLocal {

    @Override
    public String sayHello(String user) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     return "Hello World of EJB to "+ user+ " !!";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}
