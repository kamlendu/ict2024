/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publish")
@RequestScoped
public class PublishResource {
    
    @EJB PublishBeanLocal pbl;

     /**
     * Creates a new instance of PublishResource
     */
    public PublishResource() {
    }

    /**
     * Retrieves representation of an instance of rest.PublishResource
     * @return an instance of java.lang.String
     */
   
    @POST
    @Path("addcust/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname) {
        pbl.addCustomer(fname, lname);
    }

    @PUT
    @Path("updatecust/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer custId,@PathParam("fname") String fname,@PathParam("lname") String lname) {
   
    pbl.updateCustomer(custId, fname, lname);
    }

    @DELETE
    @Path("remcust/{cid}")
    public void removeCustomer(@PathParam("cid") Integer custId) {
     
    pbl.removeCustomer(custId);
    }

    @GET
    @Produces("application/json")
    public Collection<Customer> getAllCustomers() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      return pbl.getAllCustomers();
    
    }

    @GET
    @Path("getcustbyfirst/{fname}")
    @Produces("application/json")
    public Collection<Customer> getAllCustomersByFirstName(@PathParam("fname") String fname) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    return pbl.getAllCustomersByFirstName(fname);
    
    }

     @GET
    @Path("getcustbylast/{lname}")
    @Produces("application/json")
    public Collection<Customer> getAllCustomersByLastName(@PathParam("lname") String lname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    return pbl.getAllCustomersByLastName(lname);
    
    }

    @GET
    @Path("getcustbyid/{cid}")
    @Produces("application/json")
    public Customer getCustomerById(@PathParam("cid") Integer id) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       return pbl.getCustomerById(id);
    
    }

    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street,@PathParam("city") String city, @PathParam("state") String state, @PathParam("zip") String zip,@PathParam("cid") Integer custId) {
        pbl.addAddressToCustomer(street, city, state, zip, custId);
    
    }

    
   @DELETE
   @Path("remaddress/{cid}/{aid}")
    public void removeAddressFromCustomer(@PathParam("cid") Integer custId, @PathParam("aid") Integer addresId) {
      pbl.removeAddressFromCustomer(custId, addresId);
    }

    @GET
    @Path("getaddofcust/{cid}")
    @Produces("application/json")
    public Collection<Address> getAddressesOfCustomer(@PathParam("cid") Integer custId) {
    
      return pbl.getAddressesOfCustomer(custId);
    
    }

    @GET
    @Path("getcustfromaddress/{aid}")
    @Produces("application/json")
    public Customer getCustomerFromAddress(@PathParam("aid") Integer addressId) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
     
    return pbl.getCustomerFromAddress(addressId);
    }

     @GET
    @Path("getaddressbycity/{city}")
    @Produces("application/json")
    public Collection<Address> getAddressesByCity(@PathParam("city") String city) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      return pbl.getAddressesByCity(city);
    
    }

   
    @POST
    @Path("addsubs/{title}/{type}")
    public void addSubscription(@PathParam("title") String title, @PathParam("type") String type) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       pbl.addSubscription(title, type);
    
    }

    
   

    @DELETE
    @Path("remsubs/{sid}")
    public void removeSubscription(@PathParam("sid") Integer subscriptionId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    pbl.removeSubscription(subscriptionId);
    }

    
    @GET
    @Path("getcustofsubs/{sid}")
    @Produces("application/json")
    public Collection<Customer> getCustomersOfSubscription(@PathParam("sid") Integer subscriptionId) {
     
    return pbl.getCustomersOfSubscription(subscriptionId);
    
    }

    @GET
    @Path("getsubsofcust/{cid}")
    @Produces("application/json")
    public Collection<Subscription> getSubscriptionOfCustomer(@PathParam("cid") Integer custId) {
        
     
    return pbl.getSubscriptionOfCustomer(custId);
    }

    
//    public Collection<Subscription> getSubscriptionByType(String type) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    
//    public Collection<Subscription> getSubscriptionByTitle(String title) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    
    
    @POST
    @Path("addsubstocustomer/{cid}")
    @Consumes("application/json")    
    public void addSubscriptionsToCustomer(@PathParam("cid") Integer custid, Collection<Integer> subids) {
      pbl.addSubscriptionsToCustomer(custid, subids);
    }

    @POST
    @Path("remsubstocustomer/{cid}")
    @Consumes("application/json")    
    public void removeSubscriptionsToCustomer(@PathParam("cid") Integer custid, Collection<Integer> subids) {
       
        pbl.removeSubscriptionsToCustomer(custid, subids);
        
    }
}