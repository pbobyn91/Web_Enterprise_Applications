package com.mycompany.appuser;

import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application. This is a class that helps with security for the RESTful portion of the code
 * @author Patrick
 */
//@DatabaseIdentityStoreDefinition(
//   dataSourceLookup = "${'java:comp/DefaultDataSource'}",
//   callerQuery = "#{'select password from app.appuser where userid = ?'}",
//   groupsQuery = "select groupname from app.appuser where userid = ?",
//   hashAlgorithm = PasswordHash.class,
//   priority = 10
//)
//@BasicAuthenticationMechanismDefinition
@ApplicationPath("webresources")
public class JAXRSConfiguration extends Application {
    
}
