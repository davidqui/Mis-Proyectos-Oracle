/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Administrator
 */
@WebService(name = "PersonaService")
public class PersonaService {

    @WebMethod(operationName = "concatenar")   // para exponer el metodo en web service
    @WebResult(name = "nombreapellido")
    public String concatenar(@WebParam(name = "nombre")String a, @WebParam(name = "apellido")String b) {
        
        return a + b;
    }

}
