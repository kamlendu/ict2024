/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import static javax.security.enterprise.identitystore.CredentialValidationResult.Status.VALID;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;

/**
 *
 * @author root
 */

@Named
@RequestScoped
public class UserAuthentication implements HttpAuthenticationMechanism, Serializable {
@Inject IdentityStoreHandler ish;
CredentialValidationResult result;
AuthenticationStatus status;
     
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    try{
        
        if(request.getRequestURI().contains("logout"))
        {
            request.logout();
            KeepRecord.reset();
            response.sendRedirect("index.jsp");
            return ctx.doNothing();
        }
        
        
        
        if(request.getRequestURI().contains("index.jsp") && request.getParameter("username")!=null)
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Credential credential = new UsernamePasswordCredential(username, new Password(password));
            
            result = ish.validate(credential);
            
            if(result.getStatus()== VALID)
            {
                status = ctx.notifyContainerAboutLogin(result);
                
                request.setAttribute("user", result.getCallerPrincipal().getName());
                
                KeepRecord.setUsername(username);
                KeepRecord.setPassword(password);
                
                if(result.getCallerGroups().contains("Admin"))
                {
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                    return status;
                }
               else if(result.getCallerGroups().contains("Supervisor"))
                {
                    request.getRequestDispatcher("/users.jsp").forward(request, response);
                    return status;
                }
                
            }
            else
            {
                request.setAttribute("error", "Either username or password is wrong");
                  request.getRequestDispatcher("/index.jsp").forward(request, response);
                  
                return ctx.doNothing();
            }
            
        
        
        }
        else if (KeepRecord.getUsername()!=null)
        {
            Credential credential = new UsernamePasswordCredential(KeepRecord.getUsername(), new Password(KeepRecord.getPassword()));
            
            result = ish.validate(credential);
           status= ctx.notifyContainerAboutLogin(result);
           return status;
        }
        
    }
    catch(Exception e)
    {
        return ctx.doNothing();
    }
    return ctx.doNothing();
    }
   
    
    
}
