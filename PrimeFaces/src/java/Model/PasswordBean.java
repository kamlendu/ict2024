/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author root
 */
@Named(value = "passwordBean")
@RequestScoped
public class PasswordBean {
    
    private String password1;  
    private String password2;  
    private String password3;  
    private String password4;  
    private String password5;  
  
    public String getPassword1() {  
        return password1;  
    }  
  
    public void setPassword1(String password1) {  
        this.password1 = password1;  
    }  
  
    public String getPassword2() {  
        return password2;  
    }  
  
    public void setPassword2(String password2) {  
        this.password2 = password2;  
    }  
  
    public String getPassword3() {  
        return password3;  
    }  
  
    public void setPassword3(String password3) {  
        this.password3 = password3;  
    }  
      
    public String getPassword4() {  
        return password4;  
    }  
  
    public void setPassword4(String password4) {  
        this.password4 = password4;  
    }  
  
    public String getPassword5() {  
        return password5;  
    }  
  
    public void setPassword5(String password5) {  
        this.password5 = password5;  
    }  
    /** Creates a new instance of PasswordBean */
    public PasswordBean() {
    }
}
