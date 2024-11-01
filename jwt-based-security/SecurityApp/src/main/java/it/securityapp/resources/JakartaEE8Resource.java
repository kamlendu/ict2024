package it.securityapp.resources;

import ejb.HelloBeanLocal;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@DeclareRoles({"Admin","Supervisor"})
@Path("rest")
public class JakartaEE8Resource {
    @EJB HelloBeanLocal hbl;
    
    @RolesAllowed("Admin")
    @GET
    @Produces("text/html")
    public String sayHello(){
       return "<h3>"+hbl.sayHello() + " and From  Rest !! </h3>" ;
    }
}
