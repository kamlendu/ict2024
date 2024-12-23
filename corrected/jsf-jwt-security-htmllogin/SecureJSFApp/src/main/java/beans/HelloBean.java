/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.SecureClient;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import record.KeepRecord;

/**
 *
 * @author root
 */
@Named(value = "helloBean")
//@RequestScoped
public class HelloBean {
    
    SecureClient cl;
    String secureHello;
    Response response;
    String message="";

    
    public String getMessage() {
        return message;
       
    }

    /**
     * Creates a new instance of HelloBean
     */
    public void setMessage(String message) {    
        this.message = message;
    }

    public HelloBean() {
    }

    public String getSecureHello() {
        try{
         cl = new SecureClient(KeepRecord.getToken());
         
         message="";
        return cl.sayHello();
        }
        catch(Exception e)
        {
            message="You are Forbidden to access";
        }
        return null;
     }

    public void setSecureHello(String secureHello) {
        this.secureHello = secureHello;
    }
  
}
