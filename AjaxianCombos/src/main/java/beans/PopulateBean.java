/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import ejb.LogicBean;
import entity.Citytb;
import entity.Districttb;
import entity.Statetb;
import entity.Talukatb;
import entity.Villagetb;
import entity.Wardtb;
import entity.Zonetb;
import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

/**
 *
 * @author root
 */
@Named(value = "populateBean")
@SessionScoped
public class PopulateBean implements Serializable {
    
    @EJB LogicBean lb;
    
    int stateid;
    int districtid;
    int cityid;
    int talukaid;
    int villageid;
    int zoneid;
    int wardid;
    
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
    Collection<Citytb> cities;
    Collection<Zonetb> zones;
    Collection<Wardtb> wards;

   
    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
    }

    public int getDistrictid() {
        return districtid;
    }

    public void setDistrictid(int districtid) {
        this.districtid = districtid;
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getTalukaid() {
        return talukaid;
    }

    public void setTalukaid(int talukaid) {
        this.talukaid = talukaid;
    }

    public int getVillageid() {
        return villageid;
    }

    public void setVillageid(int villageid) {
        this.villageid = villageid;
    }

    public int getZoneid() {
        return zoneid;
    }

    public void setZoneid(int zoneid) {
        this.zoneid = zoneid;
    }

    public int getWardid() {
        return wardid;
    }

    public void setWardid(int wardid) {
        this.wardid = wardid;
    }

    public Collection<Statetb> getStates() {
        return lb.getAllStates();
    }

    public void setStates(Collection<Statetb> states) {
        this.states = states;
    }

    public Collection<Districttb> getDistricts() {
        if(stateid!=0)
        {
            return lb.getDistrictsByState(stateid);
        }
        return null;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public Collection<Talukatb> getTalukas() {
        if(districtid!=0)
        return lb.getTalukasByDistrict(districtid);
        
        return null;
    }

    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public Collection<Villagetb> getVillages() {
     
        if(talukaid !=0)
        return lb.getVillagesByTaluka(talukaid);
    return null;
    }

    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Collection<Citytb> getCities() {
        
        System.out.println("dist: "+districtid);
     if(districtid!=0){
        return lb.getCitiesByDistrict(districtid);
     }
     return null;
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
      
        if(cityid !=0)
        return lb.getZonesByCities(cityid);
   return null;
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards() {
       
        if(zoneid !=0)
        return lb.getWardsByZones(zoneid);
    return null;
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
    }
    
    
    

    /**
     * Creates a new instance of PopulateBean
     */
    public PopulateBean() {
    }
    
}
