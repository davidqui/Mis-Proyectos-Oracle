/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "ErrorService")
public class ErrorService {
    private static final Logger LOG = Logger.getLogger(ErrorService.class.getName());
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        LOG.log(Level.INFO, "Entrada al metodo Hello");
        try {
            int a = 5;
            int b = 0;
            int c = a / b;
            //return "Hello " + txt + " !";
        } catch (Exception e) {
          LOG.log(Level.SEVERE, "Error en el Catch :" + e);  
        }
        LOG.log(Level.INFO, "Salida del metodo Hello");
        return "Hello " + txt + " !";
    }
}
