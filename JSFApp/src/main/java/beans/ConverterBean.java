/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author root
 */
@Named(value = "converterBean")
@RequestScoped
public class ConverterBean {
    
    String somename="ABC-Rahul";

    /**
     * Creates a new instance of ConverterBean
     */
    public ConverterBean() {
    }

    public String getSomename() {
        return somename;
    }

    public void setSomename(String somename) {
        this.somename = somename;
    }
    
}
