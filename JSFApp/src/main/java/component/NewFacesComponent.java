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
@FacesComponent(createTag = true, tagName = "upper", namespace = "http://example.com/tags")
public class NewFacesComponent extends UIComponentBase {
    
    @Override
    public String getFamily() {
        return "component";
    }
    
    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        String value = (String) getAttributes().get("value");
        if (value != null) {
            ResponseWriter responseWriter = context.getResponseWriter();
            responseWriter.write(value.toUpperCase());
        }
    }
    
}
