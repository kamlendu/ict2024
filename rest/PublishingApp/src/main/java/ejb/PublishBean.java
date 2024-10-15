/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    @PersistenceContext(unitName = "pubpu")
    EntityManager em;

    @Override
    public void addCustomer(String fname, String lname) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer c = new Customer();
        c.setFirstName(fname);
        c.setLastName(lname);
        em.persist(c);
    
    }

    @Override
    public void updateCustomer(Integer custId, String fname, String lname) {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Customer c = (Customer) em.find(Customer.class, custId);
        c.setFirstName(fname);
        c.setLastName(lname);
        
        em.merge(c);
    
    }

    @Override
    public void removeCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
          Customer c = (Customer) em.find(Customer.class, custId);
          em.remove(c);
    
    }

    @Override
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      return em.createNamedQuery("Customer.findAll").getResultList();
    
    }

    @Override
    public Collection<Customer> getAllCustomersByFirstName(String fname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", fname)
            .getResultList();
    
    }

    @Override
    public Collection<Customer> getAllCustomersByLastName(String lname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return em.createNamedQuery("Customer.findByFirstName")
            .setParameter("lastName", lname)
            .getResultList();
    
    }

    @Override
    public Customer getCustomerById(Integer id) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, id);
       return c;
    
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      Customer c = (Customer) em.find(Customer.class, custId);
       Collection<Address> addresses = c.getAddressCollection();
       Address a = new Address();
       a.setStreet(street);
       a.setCity(city);
       a.setState(state);
       a.setZip(zip);
       a.setCustomer(c);
       
       addresses.add(a);
       c.setAddressCollection(addresses);
       
       em.persist(a);
       em.merge(c);
    
    }

    @Override
    public void updateAddressToCustomer(Integer addressId, String street, String city, String state, String zip, Integer custId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAddressFromCustomer(Integer custId, Integer addresId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, custId);
      Address a = (Address) em.find(Address.class, addresId);
       
      Collection<Address> addresses = c.getAddressCollection();
      
      if(addresses.contains(a))
      {
          addresses.remove(a);
          c.setAddressCollection(addresses);
          em.remove(a);
          em.merge(c);
      }
      
      
    
    
    
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      Customer c = (Customer) em.find(Customer.class, custId);
       
      return c.getAddressCollection();
    
    }

    @Override
    public Customer getCustomerFromAddress(Integer addressId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Address a = (Address) em.find(Address.class, addressId);
     
    return a.getCustomer();
    }

    @Override
    public Collection<Address> getAddressesByCity(String city) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      return em.createNamedQuery("Address.findByCity")
               .setParameter("city", city)
                .getResultList();
    
    }

    @Override
    public Collection<Address> getAddressesByState(String state) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Address> getAddressesByZip(String zip) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscription(String title, String type) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Subscription s = new Subscription();
        s.setTitle(title);
        s.setType(type);
        em.persist(s);
    
    }

    @Override
    public void updateSubscription(Integer subscriptionId, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeSubscription(Integer subscriptionId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = (Subscription) em.find(Subscription.class, subscriptionId);
    em.remove(s);
    }

    @Override
    public Collection<Customer> getCustomersOfSubscription(Integer subscriptionId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    Subscription s = (Subscription) em.find(Subscription.class, subscriptionId);
  
    return s.getCustomerCollection();
    
    }

    @Override
    public Collection<Subscription> getSubscriptionOfCustomer(Integer custId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     Customer c = (Customer) em.find(Customer.class, custId);
     
    return c.getSubscriptionCollection();
    }

    @Override
    public Collection<Subscription> getSubscriptionByType(String type) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Subscription> getSubscriptionByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addSubscriptionsToCustomer(Integer custid, Collection<Integer> subids) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     
      Customer c = (Customer) em.find(Customer.class, custid);
     Collection<Subscription> subs = c.getSubscriptionCollection();
     
     for(Integer sid : subids)
     {
          Subscription s = (Subscription) em.find(Subscription.class, sid);
          Collection<Customer> custs = s.getCustomerCollection();
          
          if(!custs.contains(c))
          {
              
              custs.add(c);
              subs.add(s);
              
              c.setSubscriptionCollection(subs);
              s.setCustomerCollection(custs);
              
              em.merge(c);
              
              
          }
     
     
     }
     
    
    
    
    }

    @Override
    public void removeSubscriptionsToCustomer(Integer custid, Collection<Integer> subids) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Customer c = (Customer) em.find(Customer.class, custid);
     Collection<Subscription> subs = c.getSubscriptionCollection();
     
     for(Integer sid : subids)
     {
          Subscription s = (Subscription) em.find(Subscription.class, sid);
          Collection<Customer> custs = s.getCustomerCollection();
          
          if(custs.contains(c))
          {
              
              custs.remove(c);
              subs.remove(s);
              
              c.setSubscriptionCollection(subs);
              s.setCustomerCollection(custs);
              
              em.merge(c);
              
              
          }
     
    
    }
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
