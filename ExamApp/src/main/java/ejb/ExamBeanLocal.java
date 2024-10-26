/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface ExamBeanLocal {
   
    void addProduct(String pname, double price, int catid);
    void updateProduct(int pid, String pname, double price, int category);
    void deleteProduct(int pid);
    Collection<Productmaster> getAllProducts();
    Collection<Productmaster> getProductsByCategory(int catid);
    Collection<Category> getAllCategories();
    Category getNameByCatid(int catid);
    Category getByCatName(String name);
    
}
