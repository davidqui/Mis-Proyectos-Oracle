/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "LoginService")
public class LoginService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "SUMA")
    public long sumar(@WebParam(name = "a")int a,@WebParam(name = "b") int b){
        return (long) (a+b);
    }
}
