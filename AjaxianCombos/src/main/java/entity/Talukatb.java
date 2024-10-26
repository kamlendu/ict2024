/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "talukatb")
@NamedQueries({
    @NamedQuery(name = "Talukatb.findAll", query = "SELECT t FROM Talukatb t"),
    @NamedQuery(name = "Talukatb.findByTalukaId", query = "SELECT t FROM Talukatb t WHERE t.talukaId = :talukaId"),
    @NamedQuery(name = "Talukatb.findByTalukaName", query = "SELECT t FROM Talukatb t WHERE t.talukaName = :talukaName")})
public class Talukatb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "taluka_id")
    private Integer talukaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "taluka_name")
    private String talukaName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "talukaId")
    private Collection<Villagetb> villagetbCollection;
    @JoinColumn(name = "district_id", referencedColumnName = "district_id")
    @ManyToOne(optional = false)
    private Districttb districtId;

    public Talukatb() {
    }

    public Talukatb(Integer talukaId) {
        this.talukaId = talukaId;
    }

    public Talukatb(Integer talukaId, String talukaName) {
        this.talukaId = talukaId;
        this.talukaName = talukaName;
    }

    public Integer getTalukaId() {
        return talukaId;
    }

    public void setTalukaId(Integer talukaId) {
        this.talukaId = talukaId;
    }

    public String getTalukaName() {
        return talukaName;
    }

    public void setTalukaName(String talukaName) {
        this.talukaName = talukaName;
    }

    public Collection<Villagetb> getVillagetbCollection() {
        return villagetbCollection;
    }

    public void setVillagetbCollection(Collection<Villagetb> villagetbCollection) {
        this.villagetbCollection = villagetbCollection;
    }

    public Districttb getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Districttb districtId) {
        this.districtId = districtId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talukaId != null ? talukaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talukatb)) {
            return false;
        }
        Talukatb other = (Talukatb) object;
        if ((this.talukaId == null && other.talukaId != null) || (this.talukaId != null && !this.talukaId.equals(other.talukaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Talukatb[ talukaId=" + talukaId + " ]";
    }
    
}
