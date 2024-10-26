package it.examapp.resources;

import ejb.ExamBeanLocal;
import entity.Category;
import entity.Productmaster;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

    @EJB
    ExamBeanLocal ebl;

    @POST
    @Path("addproduct/{pname}/{price}/{catid}")
   public void addProduct(@PathParam("pname") String pname, @PathParam("price") double price, @PathParam("catid") int catid) {
        ebl.addProduct(pname, price, catid);
    }

    @POST
    @Path("updateproduct/{pid}/{pname}/{price}/{catid}")
    public void updateProduct(@PathParam("pid") int pid, @PathParam("pname") String pname, @PathParam("price") double price, @PathParam("catid") int catid) {
        ebl.updateProduct(pid, pname, price, catid);
    }

    @DELETE
    @Path("deleteproduct/{pid}")
    public void deleteProduct(@PathParam("pid") int pid) {
        ebl.deleteProduct(pid);
    }

    @GET
    @Produces("application/json")
    public Collection<Productmaster> getAllProducts() {
        return ebl.getAllProducts();
    }

    @GET
    @Path("getproductbycatid/{catid}")
    @Produces("application/json")
    public Collection<Productmaster> getProductsByCategory(@PathParam("catid") int catid) {
        return ebl.getProductsByCategory(catid);
    }

    @GET
    @Path("getallcats")
    @Produces("application/json")
    public Collection<Category> getAllCategories() {
        return ebl.getAllCategories();
    }

    @GET
    @Path("getnamebycatid/{catid}")
    @Produces("application/json")
    public Category getNameByCatid(@PathParam("catid") int catid) {
        return ebl.getNameByCatid(catid);
    }

    @GET
    @Path("getnamebycatname/{cname}")
    @Produces("application/json")
    public Category getByCatName(@PathParam("cname") String cname) {
        return ebl.getByCatName(cname);

    }
}
