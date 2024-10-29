package it.mysecurityapp;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@DeclareRoles({"Admin","Supervisor"})
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    
}
