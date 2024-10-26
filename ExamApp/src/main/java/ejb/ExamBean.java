/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Category;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class ExamBean implements ExamBeanLocal {
    
     @PersistenceContext(unitName = "mypu")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addProduct(String pname, double price, int catid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       Category c = (Category) em.find(Category.class,catid);
       Collection<Productmaster> products = c.getProductmasterCollection();
       Productmaster p = new Productmaster();
       p.setProductname(pname);
       p.setPrice(price);
       p.setCategory(c);
       products.add(p);
       
       c.setProductmasterCollection(products);
       
       em.persist(p);
       em.merge(c);
       
    
    }

    @Override
    public void updateProduct(int pid, String pname, double price, int category) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   
       Category c = (Category) em.find(Category.class,category);
       Collection<Productmaster> products = c.getProductmasterCollection();
       Productmaster p = (Productmaster) em.find(Productmaster.class, pid);
      if(products.contains(p))
      {   
       products.remove(p);
      }
       p.setProductname(pname);
       p.setPrice(price);
       p.setCategory(c);
      
       products.add(p);
       
       c.setProductmasterCollection(products);
       
       em.merge(p);
       em.merge(c);
       
    
    
    }

    @Override
    public void deleteProduct(int pid) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Productmaster p = (Productmaster) em.find(Productmaster.class, pid);
    
    em.remove(p);
    
    }

    @Override
    public Collection<Productmaster> getAllProducts() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       return em.createNamedQuery("Productmaster.findAll").getResultList();
    
    }

    @Override
    public Collection<Productmaster> getProductsByCategory(int catid) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Category c = (Category) em.find(Category.class,catid);
    
     return c.getProductmasterCollection();
    
    }

    @Override
    public Collection<Category> getAllCategories() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public Category getNameByCatid(int catid) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     return (Category)em.find(Category.class, catid);
    }

    @Override
    public Category getByCatName(String name) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       Collection<Category> cats =  em.createNamedQuery("Category.findByName")
               .setParameter("name", name)
               .getResultList();
       
       for(Category c : cats)
       {
           return c;
       }
    
       return null;
    }



}
