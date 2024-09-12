/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface StringBeanLocal {
    
    String getUpper(String s);
     String getLower(String s);
    
}
