/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author root
 */
@Named(value = "eventBean")
@RequestScoped
public class EventBean {
    
    String person;
    Collection<String> names;
    String msg1;
    String msg2;

    /**
     * Creates a new instance of EventBean
     */
    public EventBean() {
        
        names = new ArrayList<>();
        names.add("Prakash");
        names.add("Sunil");
        names.add("Seema");
        
    }

    
    public void changeEvent(ValueChangeEvent event)
    {
        msg1 = "The new value is :"+ event.getNewValue();
    }
    
    public void handle(ActionEvent event)
    {
        msg2 = "The button has been clicked !";
    }
    
    
    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public Collection<String> getNames() {
        return names;
    }

    public void setNames(Collection<String> names) {
        this.names = names;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }
    
    
    
}
