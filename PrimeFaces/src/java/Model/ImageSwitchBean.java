/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
@Named(value = "imageSwitchBean")
@RequestScoped
public class ImageSwitchBean {

    private List<String> images;

    public ImageSwitchBean() {
        images = new ArrayList<String>();
        images.add("galleria1.jpg");
        images.add("galleria2.jpg");
        images.add("galleria3.jpg");
        images.add("galleria4.jpg");
    }

    public List<String> getImages() {
        return images;
    }

   
}
