
package jwtrest;

//import com.okta.jwt.AccessTokenVerifier;
import fish.payara.security.openid.api.OpenIdContext;
 import static jwtrest.Constants.AUTHORIZATION_HEADER;
import static jwtrest.Constants.BEARER;
import static jwtrest.Constants.REMEMBERME_VALIDITY_SECONDS;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.inject.Named;
import javax.json.JsonObject;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.authentication.mechanism.http.RememberMe;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RememberMe(
       cookieMaxAgeSeconds = REMEMBERME_VALIDITY_SECONDS,
       isRememberMeExpression = "self.isRememberMe(httpMessageContext)"
)
//@Specializes
 @Alternative
//@Vetoed
@RequestScoped
@Named
public class JWTAuthenticationMechanism implements HttpAuthenticationMechanism, Serializable {

    private static final Logger LOGGER = Logger.getLogger(JWTAuthenticationMechanism.class.getName());
    // private AccessTokenVerifier jwtVerifier;
    /**
     * Access to the
     * IdentityStore(AuthenticationIdentityStore,AuthorizationIdentityStore) is
     * abstracted by the IdentityStoreHandler to allow for multiple identity
     * stores to logically act as a single IdentityStore
     */
    @Inject
   private IdentityStoreHandler identityStoreHandler;

    @Inject
    private TokenProvider tokenProvider;
     @Inject OpenIdContext openidContext;
     String accessToken;
     String subject;
     Set<String> groups;
    String token;
    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) {

        LOGGER.log(Level.INFO, "validateRequest: {0}", request.getRequestURI());
        // Get the (caller) name and password from the request
        // NOTE: This is for the smallest possible example only. In practice
        // putting the password in a request query parameter is highly insecure
       // identityStoreHandler.validate(crdntl);
        String token = extractToken(context);
         JsonObject json =openidContext.getClaimsJson(); 
        System.out.println(" Name : "+ json.getString("given_name"));
        subject = json.getString("given_name");
         groups = new HashSet<String>();
        groups.add("Admin");
        groups.add("Supervisor");
        
        
        
        if (token == null) {
//            LOGGER.log(Level.INFO, "credentials : {0}, {1}", new String[]{name, password});
               System.out.println("JWTAuthenticationMechanism - Creating tokenhttp://localhost:8080/RestPublishApp-war/");
                AuthenticationStatus status= createOAuthToken(subject,groups, context);
             
                String authorizationHeader = context.getResponse().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String mytoken = authorizationHeader.substring(BEARER.length(), authorizationHeader.length());
            
                
               request.getSession().setAttribute("token",mytoken);
        }
                      return status;
            }
            // if the authentication failed, we return the unauthorized status in the http response
            //return context.responseUnauthorized();
         else if (token != null) {
            // validation of the jwt credential
       
            return validateToken(token, context);
        } else if (context.isProtected()) {
            // A protected resource is a resource for which a constraint has been defined.
            // if there are no credentials and the resource is protected, we response with unauthorized status
            return context.responseUnauthorized();
        }
        // there are no credentials AND the resource is not protected, 
        // SO Instructs the container to "do nothing"
        return context.doNothing();
    }

    /**
     * To validate the JWT token e.g Signature check, JWT claims
     * check(expiration) etc
     *
     * @param token The JWT access tokens
     * @param context
     * @return the AuthenticationStatus to notify the container
     */
    private AuthenticationStatus validateToken(String token, HttpMessageContext context) {
        try {
            if (tokenProvider.validateToken(token)) {
//                JWTCredential credential = tokenProvider.getCredential(token);
//            System.out.println("JWTAuthenticationMechanism-Token Validated");
                return context.notifyContainerAboutLogin(subject, groups);
            
            }
            // if token invalid, response with unauthorized status
            return context.responseUnauthorized();
        } catch (ExpiredJwtException eje) {
            LOGGER.log(Level.INFO, "Security exception for user {0} - {1}", new String[]{eje.getClaims().getSubject(), eje.getMessage()});
            return context.responseUnauthorized();
        }
    }

   
     private AuthenticationStatus createOAuthToken(String subject,Set<String> groups, HttpMessageContext context) {
        if (!isRememberMe(context)) {
            // if (true) {
            String jwt = tokenProvider.createToken(subject, groups, false);
          
            context.getResponse().addHeader(AUTHORIZATION_HEADER, BEARER + jwt);
           
            System.out.println("iToken="+jwt);
        }
        System.out.println("JWTAuthenticationMechanism - Token Created");
        return context.notifyContainerAboutLogin(subject, groups);
    }
    
    
    /**
     * To extract the JWT from Authorization HTTP header
     *
     * @param context
     * @return The JWT access tokens
     */
    private String extractToken(HttpMessageContext context) {
        String authorizationHeader = context.getRequest().getHeader(AUTHORIZATION_HEADER);
        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER)) {
            String token = authorizationHeader.substring(BEARER.length(), authorizationHeader.length());
     System.out.println("JWTAuthenticationMechanism - Extract Tokens");
            return token;
        }
        return null;
    }

    /**
     * this function invoked using RememberMe.isRememberMeExpression EL
     * expression
     *
     * @param context
     * @return The remember me flag
     */
    public Boolean isRememberMe(HttpMessageContext context) {
        return Boolean.valueOf(context.getRequest().getParameter("rememberme"));
    }

}
