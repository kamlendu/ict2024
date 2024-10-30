

package auth;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
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
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable {

    @Inject
    IdentityStoreHandler handler;
    CredentialValidationResult result;
    AuthenticationStatus status;
//   @Inject TokenProvider tokenProvider;
    //@Inject
  //  LoginBean lbean;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext ctx) throws AuthenticationException {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            if (request.getRequestURI().contains("Logout")) {
                request.logout();
                KeepRecord.reset();
                response.sendRedirect("Login.jsf");
                return ctx.doNothing();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

     
        try {
            System.out.println("Name = " + request.getParameter("username"));
            if (request.getParameter("username") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println("In Auth");
//                String username = lbean.getUsername();
//                String password = lbean.getPassword();
//                
                Credential credential = new UsernamePasswordCredential(username, new Password(password));
                result = handler.validate(credential);

                if (result.getStatus() == Status.VALID) {
                    KeepRecord.setErrorStatus("");
                  

                    status = ctx.notifyContainerAboutLogin(result);

                 //   KeepRecord.setUsername(username);
                 //   KeepRecord.setPassword(password);
                    KeepRecord.setPrincipal(result.getCallerPrincipal());
                    KeepRecord.setRoles(result.getCallerGroups());
                    KeepRecord.setCredential(credential);

                    if (result.getCallerGroups().contains("Admin")) {
                        request.getRequestDispatcher("admin/Admin.jsf").forward(request, response);
                    }
                    if (result.getCallerGroups().contains("Supervisor")) {
                        request.getRequestDispatcher("user/User.jsf").forward(request, response);
                    }

                    return status;

                } else {
                    KeepRecord.setErrorStatus("Either Username or Password is wrong !");
                    response.sendRedirect("Login.jsf");

                    //lbean.setStatus(AuthenticationStatus.SEND_FAILURE);
                    return ctx.doNothing();
                    // request.getServletContext().getRequestDispatcher("/Login.jsf").forward(request, response);
                }
            }

            if (KeepRecord.getPrincipal() != null) {
              //  Credential credential1 = new UsernamePasswordCredential(KeepRecord.getUsername(), new Password(KeepRecord.getPassword()));
                result = handler.validate(KeepRecord.getCredential());
              
                
                if(request.getRequestURI().contains("admin") && result.getCallerGroups().contains("Supervisor"))
                {
                    ctx.responseUnauthorized();
                }
               else if(request.getRequestURI().contains("user") && result.getCallerGroups().contains("Admin"))
               {
                  ctx.responseUnauthorized();
               }
                
                ctx.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

       
        return ctx.doNothing();
    }

   
}
