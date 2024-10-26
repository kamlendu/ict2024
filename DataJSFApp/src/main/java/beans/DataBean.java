/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import client.BookClient;
import entity.BookMaster;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "dataBean")
@RequestScoped
public class DataBean {
    
    BookClient bc;
    Response rs;
    Collection<BookMaster> books;
    GenericType<Collection<BookMaster>> gbooks;

    /**
     * Creates a new instance of DataBean
     */
    public DataBean() {
        
        bc = new BookClient();
        books = new ArrayList<>();
        gbooks = new GenericType<Collection<BookMaster>>(){};
        
        
    }

    public Collection<BookMaster> getBooks() {
       
        rs = bc.getAllBooks(Response.class);
        books = rs.readEntity(gbooks);
        return books;
    }

    public void setBooks(Collection<BookMaster> books) {
        this.books = books;
    }
    
    
}
