/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DataBeanLocal {
    
    Collection<BookMaster> getAllBooks();
    void addBook(String bname, String aname, String pname, String synopsis);
    void updateBook(Integer bid, String bname, String aname, String pname, String synopsis);
    void removeBook(Integer bid);
    Collection<BookMaster> findBooksByPublisher(String pname);
}
