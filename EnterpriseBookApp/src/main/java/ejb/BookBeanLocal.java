/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.*;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local

public interface BookBeanLocal {
   
   void addBook(String bookName,String authorName,String publisherName, String synopsis);
   void updateBook(Integer BookID,String bookName,String authorName,String publisherName, String synopsis);   
   void removeBook(Integer BookID);
   List<BookMaster> getAllBooks();
}
