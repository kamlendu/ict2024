/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBean;

import java.io.Serializable;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
//import misc.Utils;

/**
 *
 * @author Kamlendu Pandey
 */
@SessionScoped
@Named("BookMasterBean")
public class BookMasterBean implements Serializable {

    String query = null;
    int id;
    String bookName;
    String authorName;
    String publisherName;
  
    List allBookInfo;
    BookMaster currentBook;
    @PersistenceContext
    EntityManager em;

    public BookMaster getCurrentBook() {
        return currentBook;
    }

    public void setCurrentBook(BookMaster currentBook) {
        this.currentBook = currentBook;
    }
    @Resource
    UserTransaction utrans;

    public void setAllBookInfo(ArrayList<BookMaster> allBookInfo) {
        this.allBookInfo = allBookInfo;
    }

   

    //ArrayList allBookInfo = new ArrayList();
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookMasterBean() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public List getAllBookInfo() {
        try {


            allBookInfo = new ArrayList();
            /////////////////
            allBookInfo =  em.createNamedQuery("BookMaster.findAll").getResultList();

            
            }



         catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }
        System.out.println(allBookInfo.toString());
        return allBookInfo;
    }

    public String addBook() {

        try {

            BookMaster bmaster = new BookMaster(bookName, authorName, publisherName);
            utrans.begin();
            em.persist(bmaster);
            utrans.commit();
            em.merge(bmaster);

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e.toString());
        }

        System.out.println("Add Book Called");
        return "AllBooks";
    }

    public String redirectToEditBookDetail() {

        return "EditBookDetail";
    }

    public String editBookDetail() {

        try {
            bookName = currentBook.getBookName();
            authorName = currentBook.getAuthorName();
            publisherName = currentBook.getPublisherName();
            id = currentBook.getBookID();

            utrans.begin();
            BookMaster bmaster = (BookMaster) em.find(BookMaster.class, id);
            bmaster.setAuthorName(authorName);
            bmaster.setBookName(bookName);
            bmaster.setPublisherName(publisherName);
            em.merge(bmaster);
            utrans.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }
        bookName = "";
        authorName = "";
        publisherName = "";

        return "AllBooks";
    }

    public String redirectToAddBookDetail() {

        return "index";
    }

    public String deleteBookDetail() {
        try {

            utrans.begin();
            BookMaster bmaster = (BookMaster) em.find(BookMaster.class, id);
            em.remove(bmaster);
            utrans.commit();


        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.toString());
        }

        return "AllBooks";
    }
}
