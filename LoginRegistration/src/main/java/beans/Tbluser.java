/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author root
 */
@Entity
@Table(name = "tbluser", catalog = "test", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"EmailAddress"}),
    @UniqueConstraint(columnNames = {"Username"})})
@NamedQueries({
    @NamedQuery(name = "Tbluser.findAll", query = "SELECT t FROM Tbluser t"),
    @NamedQuery(name = "Tbluser.findByUserId", query = "SELECT t FROM Tbluser t WHERE t.userId = :userId"),
    @NamedQuery(name = "Tbluser.findByUsername", query = "SELECT t FROM Tbluser t WHERE t.username = :username"),
    @NamedQuery(name = "Tbluser.findByPassword", query = "SELECT t FROM Tbluser t WHERE t.password = :password"),
    @NamedQuery(name = "Tbluser.findByEmailAddress", query = "SELECT t FROM Tbluser t WHERE t.emailAddress = :emailAddress"),
    @NamedQuery(name = "Tbluser.findByContactNo", query = "SELECT t FROM Tbluser t WHERE t.contactNo = :contactNo"),
    @NamedQuery(name = "Tbluser.findByResidentialAddress", query = "SELECT t FROM Tbluser t WHERE t.residentialAddress = :residentialAddress")})
public class Tbluser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserId", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Username", nullable = false, length = 50)
    private String username;
    @Basic(optional = false)
    @Column(name = "Password", nullable = false, length = 50)
    private String password;
    @Basic(optional = false)
    @Column(name = "EmailAddress", nullable = false, length = 256)
    private String emailAddress;
    @Basic(optional = false)
    @Column(name = "ContactNo", nullable = false, length = 10)
    private String contactNo;
    @Basic(optional = false)
    @Column(name = "ResidentialAddress", nullable = false, length = 512)
    private String residentialAddress;

    public Tbluser() {
    }

    public Tbluser(Integer userId) {
        this.userId = userId;
    }

    public Tbluser( String username, String password, String emailAddress, String contactNo, String residentialAddress) {
        //this.userId = userId;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.contactNo = contactNo;
        this.residentialAddress = residentialAddress;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbluser)) {
            return false;
        }
        Tbluser other = (Tbluser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Tbluser[userId=" + userId + "]";
    }

}
