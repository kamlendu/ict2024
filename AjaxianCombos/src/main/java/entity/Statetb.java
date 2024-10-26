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
@Table(name = "statetb")
@NamedQueries({
    @NamedQuery(name = "Statetb.findAll", query = "SELECT s FROM Statetb s"),
    @NamedQuery(name = "Statetb.findByStateId", query = "SELECT s FROM Statetb s WHERE s.stateId = :stateId"),
    @NamedQuery(name = "Statetb.findByStateName", query = "SELECT s FROM Statetb s WHERE s.stateName = :stateName")})
public class Statetb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "state_id")
    private Integer stateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state_name")
    private String stateName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Citytb> citytbCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateId")
    private Collection<Districttb> districttbCollection;

    public Statetb() {
    }

    public Statetb(Integer stateId) {
        this.stateId = stateId;
    }

    public Statetb(Integer stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Collection<Citytb> getCitytbCollection() {
        return citytbCollection;
    }

    public void setCitytbCollection(Collection<Citytb> citytbCollection) {
        this.citytbCollection = citytbCollection;
    }

    public Collection<Districttb> getDistricttbCollection() {
        return districttbCollection;
    }

    public void setDistricttbCollection(Collection<Districttb> districttbCollection) {
        this.districttbCollection = districttbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateId != null ? stateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statetb)) {
            return false;
        }
        Statetb other = (Statetb) object;
        if ((this.stateId == null && other.stateId != null) || (this.stateId != null && !this.stateId.equals(other.stateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Statetb[ stateId=" + stateId + " ]";
    }
    
}
