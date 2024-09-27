/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class DataBean implements DataBeanLocal {
    
    @PersistenceContext(unitName = "mypu")
    EntityManager em;
    

    @Override
    public Collection<BookMaster> getAllBooks() {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findAll").getResultList();
    return books;
    }

    @Override
    public void addBook(String bname, String aname, String pname, String synopsis) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
       BookMaster b = new BookMaster();
       b.setBookName(bname);
       b.setAuthorName(aname);
       b.setPublisherName(pname);
       b.setSynopsis(synopsis);
       
       em.persist(b);
    
    
    }

    @Override
    public void updateBook(Integer bid, String bname, String aname, String pname, String synopsis) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    BookMaster b = em.find(BookMaster.class, bid);
       b.setBookName(bname);
       b.setAuthorName(aname);
       b.setPublisherName(pname);
       b.setSynopsis(synopsis);
       
       em.merge(b);
    
    }

    @Override
    public void removeBook(Integer bid) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     BookMaster b = em.find(BookMaster.class, bid);
    
     em.remove(b);
    
    }

    @Override
    public Collection<BookMaster> findBooksByPublisher(String pname) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    Collection<BookMaster> books = em.createNamedQuery("BookMaster.findByPublisherName")
                                     .setParameter("publisherName", pname)
                                     .getResultList();
    
    return books;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}
