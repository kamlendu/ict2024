/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.RestClient;
import entity.Category;
import entity.Productmaster;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author root
 */
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
   // @EJB ExamBeanLocal ebl;
    RestClient ebl;
    Response rs;
     Pbkdf2PasswordHashImpl pb; 
    String pname;
    double price;
    int catid;
    int pid;
  
    Productmaster current;
    Collection<Productmaster> products;
    GenericType<Collection<Productmaster>> gproducts;
    Collection<Category> categories;
     GenericType<Collection<Category>> gcats;
    Category category;
    

    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
        ebl = new RestClient();
        products = new ArrayList<>();
        gproducts = new GenericType<Collection<Productmaster>>(){};
        categories = new ArrayList<>();
        gcats = new GenericType<Collection<Category>>(){};
        
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    
   

    
    
    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public Productmaster getCurrent() {
        return current;
    }

    public void setCurrent(Productmaster current) {
        this.current = current;
    }

    public Collection<Productmaster> getProducts() {
        
      
        rs = ebl.getAllProducts(Response.class);
        products = rs.readEntity(gproducts);
        return products;
    }

    public void setProducts(Collection<Productmaster> products) {
        this.products = products;
    }

   
    public String addProduct()
    {
        
        ebl.addProduct(pname, String.valueOf(price), String.valueOf(catid));
        return "index.jsf";
    }
    
    public String updateProduct()
    {
        pname= current.getProductname();
        pid=current.getPid();
        price=current.getPrice();
        catid=current.getCategory().getId();
        
        ebl.updateProduct(String.valueOf(pid), pname, String.valueOf(price), String.valueOf(catid));
        return "index.jsf";
        
    }
    
    public String deleteProduct()
    {
        ebl.deleteProduct(String.valueOf(pid));
        return "index.jsf";
    }

   

    
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Category> getCategories() {
       
      rs=  ebl.getAllCategories(Response.class);
        categories = rs.readEntity(gcats);
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
    
    
    
    
  public String  redirectToAddProduct()
  {
      return "AddProduct.jsf";
  }
  
  public String  redirectToEditProduct()
  {
      return "EditProduct.jsf";
  }
    
}
