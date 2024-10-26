/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Citytb;
import entity.Districttb;
import entity.Statetb;
import entity.Talukatb;
import entity.Villagetb;
import entity.Wardtb;
import entity.Zonetb;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class LogicBean {
    @PersistenceContext(unitName = "mypu")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

 public Collection<Statetb> getAllStates()
 {
     Collection<Statetb> states = em.createNamedQuery("Statetb.findAll").getResultList();
     return states;
 }

public Collection<Districttb> getDistrictsByState(int stateid)
 {
     Statetb state = em.find(Statetb.class, stateid);
     Collection<Districttb> districts = state.getDistricttbCollection();
     return districts;
 }

public Collection<Citytb> getCitiesByDistrict(int districtid)
 {
      Districttb district = em.find( Districttb.class, districtid);
     Collection<Citytb> cities = district.getCitytbCollection();
  
     return cities;
 }

public Collection<Talukatb> getTalukasByDistrict(int districtid)
 {
       Districttb district = em.find( Districttb.class, districtid);
     Collection<Talukatb> talukas = district.getTalukatbCollection();
     return talukas;
 }

public Collection<Villagetb> getVillagesByTaluka(int talukaid)
 {
     
     Talukatb taluka = em.find( Talukatb.class, talukaid);
     Collection<Villagetb> villages = taluka.getVillagetbCollection();
     return villages;
 }

public Collection<Zonetb> getZonesByCities(int cityid)
 {
     Citytb city = em.find(Citytb.class, cityid);
     Collection<Zonetb> zones = city.getZonetbCollection();
     return zones;
 }

public Collection<Wardtb> getWardsByZones(int zoneid)
 {
     Zonetb zone = em.find(Zonetb.class, zoneid);
     return zone.getWardtbCollection();
 }







}
