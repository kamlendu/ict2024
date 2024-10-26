/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author root
 */
@Entity
@Table(name = "wardtb")
@NamedQueries({
    @NamedQuery(name = "Wardtb.findAll", query = "SELECT w FROM Wardtb w"),
    @NamedQuery(name = "Wardtb.findByWardId", query = "SELECT w FROM Wardtb w WHERE w.wardId = :wardId"),
    @NamedQuery(name = "Wardtb.findByWardName", query = "SELECT w FROM Wardtb w WHERE w.wardName = :wardName")})
public class Wardtb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ward_id")
    private Integer wardId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ward_name")
    private String wardName;
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private Zonetb zoneId;

    public Wardtb() {
    }

    public Wardtb(Integer wardId) {
        this.wardId = wardId;
    }

    public Wardtb(Integer wardId, String wardName) {
        this.wardId = wardId;
        this.wardName = wardName;
    }

    public Integer getWardId() {
        return wardId;
    }

    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

    public String getWardName() {
        return wardName;
    }

    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    public Zonetb getZoneId() {
        return zoneId;
    }

    public void setZoneId(Zonetb zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wardId != null ? wardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wardtb)) {
            return false;
        }
        Wardtb other = (Wardtb) object;
        if ((this.wardId == null && other.wardId != null) || (this.wardId != null && !this.wardId.equals(other.wardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Wardtb[ wardId=" + wardId + " ]";
    }
    
}
