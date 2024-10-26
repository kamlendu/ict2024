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
@Table(name = "zonetb")
@NamedQueries({
    @NamedQuery(name = "Zonetb.findAll", query = "SELECT z FROM Zonetb z"),
    @NamedQuery(name = "Zonetb.findByZoneId", query = "SELECT z FROM Zonetb z WHERE z.zoneId = :zoneId"),
    @NamedQuery(name = "Zonetb.findByZoneName", query = "SELECT z FROM Zonetb z WHERE z.zoneName = :zoneName")})
public class Zonetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "zone_id")
    private Integer zoneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "zone_name")
    private String zoneName;
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    @ManyToOne(optional = false)
    private Citytb cityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneId")
    private Collection<Wardtb> wardtbCollection;

    public Zonetb() {
    }

    public Zonetb(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Zonetb(Integer zoneId, String zoneName) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Citytb getCityId() {
        return cityId;
    }

    public void setCityId(Citytb cityId) {
        this.cityId = cityId;
    }

    public Collection<Wardtb> getWardtbCollection() {
        return wardtbCollection;
    }

    public void setWardtbCollection(Collection<Wardtb> wardtbCollection) {
        this.wardtbCollection = wardtbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zoneId != null ? zoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zonetb)) {
            return false;
        }
        Zonetb other = (Zonetb) object;
        if ((this.zoneId == null && other.zoneId != null) || (this.zoneId != null && !this.zoneId.equals(other.zoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Zonetb[ zoneId=" + zoneId + " ]";
    }
    
}
