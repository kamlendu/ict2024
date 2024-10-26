/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@Named(value = "editorBean")
@RequestScoped
public class EditorBean {

    /** Creates a new instance of EditorBean */
    public EditorBean() {
    }
    
     private String value;  
  
    public String getValue() {  
        return value;  
    }  
  
    public void setValue(String value) {  
        this.value = value;  
    }  
    
    public void go() throws IOException
    {       
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();  
        HttpServletResponse response =  (HttpServletResponse)context.getResponse();  ///HttpServletResponse is not being found...  
        response.sendRedirect("ViewEditorContent.xhtml"); 
    }
}
