/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Set;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import static javax.security.enterprise.AuthenticationStatus.SEND_FAILURE;
import static javax.security.enterprise.AuthenticationStatus.SUCCESS;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;


/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {
    @Inject SecurityContext ctx;
    
    private String username;
    private String password;
    private Set<String> roles;
    private String errorstatus;
    private AuthenticationStatus status;

   

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SecurityContext getCtx() {
        return ctx;
    }

    public void setCtx(SecurityContext ctx) {
        this.ctx = ctx;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getErrorStatus() {
        return errorstatus;
    }

    public void setErrorStatus(String status) {
        this.errorstatus = status;
    }

    public String login()
    {
        try{
       FacesContext context = FacesContext.getCurrentInstance();
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
         HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
     status=   ctx.authenticate(request, response, withParams().credential(credential));

   // AuthenticationStatus mystatus = AuthenticationStatus.;
     
       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
           context.responseComplete();
       } 
     
     if(status.equals(SUCCESS))
        {
        if(roles.contains("Admin"))
            return "/admin/Admin";
       else if(roles.contains("Supervisor"))
            return "/user/User";
       
        }
     else
     {
          errorstatus= "User Name or Password may be wrong";
          return "/admin/Admin";
     }
       
        }
        catch(Exception e)
        {
             errorstatus= "User Name or Password may be wrong";
            e.printStackTrace();
        }
        return "";
    }
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        
       // errorstatus="";
    }
    
    public String logout()
    {
        try{
       HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       request.logout();
       KeepRecord.reset();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "/Login.jsf";
    }
    
}
