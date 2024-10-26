/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ManagedBean;

/**
 *
 * @author Bhungalia
 */
public class bookInfo {

    int id;
    String bookName;
    String authorName;
    String publisherName;

    bookInfo(){}
    bookInfo(int id, String bookName,String authorName,String publisherName){
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.publisherName = publisherName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
