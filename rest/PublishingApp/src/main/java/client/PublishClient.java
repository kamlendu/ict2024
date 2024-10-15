/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:PublishResource [publish]<br>
 * USAGE:
 * <pre>
 *        PublishClient client = new PublishClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author root
 */
public class PublishClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/PublishingApp/resources";

    public PublishClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("publish");
    }

    public void addAddressToCustomer(String street, String city, String state, String zip, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addaddress/{0}/{1}/{2}/{3}/{4}", new Object[]{street, city, state, zip, cid})).request().post(null);
    }

    public void removeSubscription(String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remsubs/{0}", new Object[]{sid})).request().delete();
    }

    public void addSubscription(String title, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addsubs/{0}/{1}", new Object[]{title, type})).request().post(null);
    }

    public void addSubscriptionsToCustomer(Object requestEntity, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addsubstocustomer/{0}", new Object[]{cid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeAddressFromCustomer(String cid, String aid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remaddress/{0}/{1}", new Object[]{cid, aid})).request().delete();
    }

    public <T> T getAllCustomersByFirstName(Class<T> responseType, String fname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcustbyfirst/{0}", new Object[]{fname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCustomer(String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addcust/{0}/{1}", new Object[]{fname, lname})).request().post(null);
    }

    public <T> T getCustomerById(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcustbyid/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCustomers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCustomersByLastName(Class<T> responseType, String lname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcustbylast/{0}", new Object[]{lname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getSubscriptionOfCustomer(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getsubsofcust/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAddressesOfCustomer(Class<T> responseType, String cid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getaddofcust/{0}", new Object[]{cid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCustomersOfSubscription(Class<T> responseType, String sid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcustofsubs/{0}", new Object[]{sid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCustomerFromAddress(Class<T> responseType, String aid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getcustfromaddress/{0}", new Object[]{aid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeSubscriptionsToCustomer(Object requestEntity, String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remsubstocustomer/{0}", new Object[]{cid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateCustomer(String cid, String fname, String lname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatecust/{0}/{1}/{2}", new Object[]{cid, fname, lname})).request().put(null);
    }

    public void removeCustomer(String cid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("remcust/{0}", new Object[]{cid})).request().delete();
    }

    public <T> T getAddressesByCity(Class<T> responseType, String city) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getaddressbycity/{0}", new Object[]{city}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
