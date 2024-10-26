/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/FacesComponent.java to edit this template
 */
package component;

import java.io.IOException;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author root
 */
@FacesComponent(createTag = true, tagName = "lower")
public class CustomComponent extends UIComponentBase {
    
    @Override
    public String getFamily() {
        return "component";
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    
        String val = (String)getAttributes().get("value");
         if(val!=null){
        ResponseWriter responseWriter = context.getResponseWriter();
        responseWriter.write(val.toLowerCase());
         }
    }
    
    
    
}
