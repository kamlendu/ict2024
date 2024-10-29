package it.mysecurityapp.resources;

import ejb.SecureBean;
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
    @EJB SecureBean sb;
    
    @RolesAllowed("Admin")
    @GET
    @Produces("text/html")
    public String saySecureRest(){
        return sb.saySecureHello()+ " also returred by Secure REST !!!" ;
    }
}
