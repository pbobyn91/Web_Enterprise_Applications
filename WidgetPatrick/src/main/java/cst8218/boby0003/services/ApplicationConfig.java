/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.boby0003.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pat
 */
//@BasicAuthenticationMechanismDefinition
@ApplicationScoped
@Named
public class ApplicationConfig extends Application{
    
}
