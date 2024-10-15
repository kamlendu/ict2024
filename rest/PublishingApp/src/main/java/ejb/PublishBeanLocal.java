/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {
    
    //===  customer
    
    void addCustomer(String fname, String lname);
    void updateCustomer(Integer custId, String fname, String lname);
    void removeCustomer(Integer custId);
    Collection<Customer> getAllCustomers();
    Collection<Customer> getAllCustomersByFirstName(String fname);
    Collection<Customer> getAllCustomersByLastName(String lname);
    Customer getCustomerById(Integer id);
    
    //=== Address
    
    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);
    void updateAddressToCustomer(Integer addressId, String street, String city, String state, String zip, Integer custId);
    void removeAddressFromCustomer(Integer custId, Integer addresId);
    Collection<Address> getAddressesOfCustomer(Integer custId);
    Customer getCustomerFromAddress(Integer addressId);
    Collection<Address> getAddressesByCity(String city);
    Collection<Address> getAddressesByState(String state);
    Collection<Address> getAddressesByZip(String zip);
    
    //=== Subscription
    
    void addSubscription(String title, String type);
    void updateSubscription(Integer subscriptionId, String title, String type);
    void removeSubscription(Integer subscriptionId);
    Collection<Customer> getCustomersOfSubscription(Integer subscriptionId);
    Collection<Subscription> getSubscriptionOfCustomer(Integer custId);
    Collection<Subscription> getSubscriptionByType(String type);
    Collection<Subscription> getSubscriptionByTitle(String title);  
    void addSubscriptionsToCustomer(Integer custid, Collection<Integer> subids);
    void removeSubscriptionsToCustomer(Integer custid, Collection<Integer> subids);
    
    
    
    
    
    
    
    
    
}
