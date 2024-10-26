/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;  
import java.util.List;  
import javax.annotation.PostConstruct;
/**
 *
 * @author root
 */
@Named(value = "galleriaBean")
@RequestScoped
public class GalleriaBean {
    private List<String> images;  
  
    @PostConstruct  
    public void init() {  
        images = new ArrayList<String>();  
  
        for(int i=1;i<=12;i++) {  
            images.add("galleria" + i + ".jpg");  
        }  
    }  
  
    public List<String> getImages() {  
        return images;  
    }  
    /** Creates a new instance of GalleriaBean */
    public GalleriaBean() {
    }
}
