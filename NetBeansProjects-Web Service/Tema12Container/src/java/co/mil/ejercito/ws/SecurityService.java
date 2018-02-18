/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "SecurityService")
 @RolesAllowed(value = {"ejecutivo","gerentes"})//autorizacion
public class SecurityService {

    /**
     * This is a sample web service operation
     */
    
    @WebMethod(operationName = "hello")
   
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
}
