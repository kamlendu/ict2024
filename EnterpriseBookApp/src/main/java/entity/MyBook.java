/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author root
 */
public class MyBook {
    
    
    String bname;
    String pubName;
    String aName;
    String bTopic;
    String bId;

    public MyBook(String bname, String pubName, String aName, String bTopic) {
        this.bname = bname;
        this.pubName = pubName;
        this.aName = aName;
        this.bTopic = bTopic;
    }

    public MyBook(String bId) {
        this.bId = bId;
    }
    public MyBook() {
        
    
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPubName() {
        return pubName;
    }

    public void setPubName(String pubName) {
        this.pubName = pubName;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getbTopic() {
        return bTopic;
    }

    public void setbTopic(String bTopic) {
        this.bTopic = bTopic;
    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }
    
    
    
    
    
}
