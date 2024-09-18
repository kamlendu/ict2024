/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class BookMaster implements Serializable {
    private static final long serialVersionUID = 1L;
   
    private String bookName;
    private String authorName;
    private String publisherName;
    private String synopsis;
    private Integer bookID;

    public BookMaster() {
    }

    public BookMaster(Integer bookID) {
        this.bookID = bookID;
    }
public BookMaster(String bookName,String authorName,String publisherName, String synopsis) {
       // this.bookID = bookID;
        this.authorName=authorName;
        this.bookName=bookName;
        this.publisherName=publisherName;
        this.synopsis=synopsis;        
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

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

   
}
