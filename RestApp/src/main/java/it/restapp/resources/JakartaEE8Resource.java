package it.restapp.resources;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @GET
    @Produces("text/html")
    public String sayHello(){
        return "<h2>Hello World of Rest</h2>";
    }
    
    @GET
    @Path("special/{p}")
    @Produces("text/html")
    public String saySpecialHello(@PathParam("p") String person)
    {
        return "<h2>Hello World of Rest to " + person +"</h2>"; 
    }
    
    @PUT
    @Path("names")     
    @Produces("application/json")  
    @Consumes("application/json")        
   public Collection<String> getUnames(Collection<String> pnames)
    {
        Collection<String> unames = new ArrayList<>();
        
        for(String s : pnames)
        {
            unames.add(s.toUpperCase());
        }
        
        return unames;
    }
    
}
