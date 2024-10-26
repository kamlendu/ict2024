/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.RestClient;
import ejb.ExamBeanLocal;
import entity.Category;
import entity.Productmaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "reportBean")
@RequestScoped
public class ReportBean {
    //@EJB ExamBeanLocal ebl;
RestClient ebl;
    Response rs;
    int catid;
   Collection<Productmaster> products;
    GenericType<Collection<Productmaster>> gproducts;
    Collection<Category> categories;
     GenericType<Collection<Category>> gcats;    /**
     * Creates a new instance of ReportBean
     */
    public ReportBean() {
        ebl = new RestClient();
        products = new ArrayList<>();
        gproducts = new GenericType<Collection<Productmaster>>(){};
        categories = new ArrayList<>();
        gcats = new GenericType<Collection<Category>>(){};
        
    }

    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }

    public Collection<Productmaster> getProducts() {
       
        rs = ebl.getProductsByCategory(Response.class, String.valueOf(catid));
        products = rs.readEntity(gproducts);
        //products = ebl.getProductsByCategory(catid);
        
        return products;
    }

    public void setProducts(Collection<Productmaster> products) {
        this.products = products;
    }

    public Collection<Category> getCategories() {
       rs=  ebl.getAllCategories(Response.class);
        categories = rs.readEntity(gcats);
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }
    
    public String displayReport()
    {
        return "DisplayReport.jsf";
    }
    
}
