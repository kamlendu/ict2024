package it.jsfapp.resources;

import ejb.DataBean;
import entity.BookMaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    @EJB DataBean db;
   
    
    
    @GET   
    @Produces("application/json")
    public Collection<BookMaster> getBooks()
    {
        return db.getAllBooks();
    }
}
