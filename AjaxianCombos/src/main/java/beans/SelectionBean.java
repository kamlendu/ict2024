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
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author root
 */
@Named(value = "selectionBean")
@SessionScoped
public class SelectionBean implements Serializable {
    
    long serialVersionUID = 1L;
 @EJB LogicBean lb;
    
    int stateid;
    int districtid;
    int cityid;
    int talukaid;
    int villageid;
    int zoneid;
    int wardid;
    
    Collection<Integer> stateids;
    Collection<Integer> districtids;
    Collection<Integer> cityids;
    Collection<Integer> zoneids;
    Collection<Integer> wardids;
    Collection<Integer> talukaids;
    Collection<Integer> villageids;
    
    
    
    
    Collection<Statetb> states;
    Collection<Districttb> districts;
    Collection<Talukatb> talukas;
    Collection<Villagetb> villages;
    Collection<Citytb> cities;
    Collection<Zonetb> zones;
    Collection<Wardtb> wards;

   public String show()
   {
       return "show.jsf";
   }

    public Collection<Integer> getStateids() {
        return stateids;
    }

    public void setStateids(Collection<Integer> stateids) {
        this.stateids = stateids;
    }

    public Collection<Integer> getDistrictids() {
        return districtids;
    }

    public void setDistrictids(Collection<Integer> districtids) {
        this.districtids = districtids;
    }

    public Collection<Integer> getCityids() {
        return cityids;
    }

    public void setCityids(Collection<Integer> cityids) {
        this.cityids = cityids;
    }

    public Collection<Integer> getZoneids() {
        return zoneids;
    }

    public void setZoneids(Collection<Integer> zoneids) {
        this.zoneids = zoneids;
    }

    public Collection<Integer> getWardids() {
        return wardids;
    }

    public void setWardids(Collection<Integer> wardids) {
        this.wardids = wardids;
    }

    public Collection<Integer> getTalukaids() {
        return talukaids;
    }

    public void setTalukaids(Collection<Integer> talukaids) {
        this.talukaids = talukaids;
    }

    public Collection<Integer> getVillageids() {
        return villageids;
    }

    public void setVillageids(Collection<Integer> villageids) {
        this.villageids = villageids;
    }

   

    
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

    public void deselectState()
    {
        populateDistricts();
        populateCities();
        populateTalukas();
        
    }
    
    
    public void populateDistricts() {
        if(stateids!=null)
       {
           districts.clear();
       for(Integer stateid : stateids)
       {
           
            System.out.println("stateid : "+stateid);
       if(stateid!=0)
        {
       
            districts.addAll(lb.getDistrictsByState(stateid));
            
        }        
       }
      
       }
        
    }
    
    public Collection<Districttb> getDistricts()
    {
        return districts;
    }

    public void setDistricts(Collection<Districttb> districts) {
        this.districts = districts;
    }

    public void populateTalukas() {
       
        if(districtids!=null)
       {
           talukas.clear();
       for(Integer districtid : districtids)
       {
       if(districtid!=0)
        {                       
           talukas.addAll(lb.getTalukasByDistrict(districtid));
           
        }
       }
        
       }
    }

     public Collection<Talukatb> getTalukas()
     {
         return talukas;
     }
    
    public void setTalukas(Collection<Talukatb> talukas) {
        this.talukas = talukas;
    }

    public void populateVillages() {
     if(talukaids!=null)
       {
           villages.clear();
        for(Integer talukaid: talukaids)
        {
        if(talukaid !=0)
        villages.addAll(lb.getVillagesByTaluka(talukaid));
       
        }
        
       }
        
    }

    public Collection<Villagetb> getVillages()
    {
        return villages;
    }
    
    
    public void setVillages(Collection<Villagetb> villages) {
        this.villages = villages;
    }

    public Collection<Citytb> getCities() {
        return cities;
    }
        
    
    public void populateCities()
      {  
           if(districtids!=null)
       {
           cities.clear();
        for(Integer districtid : districtids)
       {
       if(districtid!=0)
        {
            
            
           cities.addAll(lb.getCitiesByDistrict(districtid));
           
        }
       }
       }
    }

    public void setCities(Collection<Citytb> cities) {
        this.cities = cities;
    }

    public Collection<Zonetb> getZones() {
        return zones;
    }
    
    public void populateZones() {
      
         if(cities!=null)
       {
           zones.clear();
        for(Integer cityid : cityids)
        {
        if(cityid !=0)
        zones.addAll(lb.getZonesByCities(cityid));
        }
        }
   
    }

    public void setZones(Collection<Zonetb> zones) {
        this.zones = zones;
    }

    public Collection<Wardtb> getWards()
    {
        return wards;
    }
    
    public void populateWards() {
        if(zones!=null)
       {
           zones.clear();
        for(Integer zoneid: zoneids)
       {
        if(zoneid !=0)
        wards.addAll(lb.getWardsByZones(zoneid));
       }
       }
    
    }

    public void setWards(Collection<Wardtb> wards) {
        this.wards = wards;
    }
    
    /**
     * Creates a new instance of SelectionBean
     */
    public SelectionBean() {
        
    states = new ArrayList<>();
    districts = new ArrayList<>();;
    talukas = new ArrayList<>();;
    villages = new ArrayList<>();;
    cities = new ArrayList<>();;
    zones = new ArrayList<>();;
    wards = new ArrayList<>();;
    }
    
}
