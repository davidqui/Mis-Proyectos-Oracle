/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import co.mil.ejercito.entity.Ciudadano;
import co.mil.ejercito.entity.Multas;
import co.mil.ejercito.transaccional.MultasFacadeLocal;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Administrator
 */
//@WebService(serviceName = "ConsultasService")
@WebService(serviceName = "crearCiudadano")
public class MultasService {
    private static final Logger LOG = Logger.getLogger(ConsultasService.class.getName());
        
    @EJB
    private MultasFacadeLocal ejb;
    
    @WebMethod(operationName = "crearCiudadano")
    @WebResult(name = "retorno")
        public boolean crearCiudadano(String nombre, String apellido, String email, String telefono) {
          LOG.log(Level.INFO, "Entrada crearCiudadano");   
        boolean respuesta = false;
        try {


            respuesta = ejb.crearCiudadano(nombre, apellido, email, telefono);

            

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en el Catch" + e);

        }
        LOG.log(Level.INFO, "Salida crearCiudadano");

        return respuesta;
    }
     @WebMethod(operationName = "borrarCiudadano")
     @WebResult(name = "retorno")
     public boolean borrarCiudadano(BigDecimal id){
         boolean retorno = false;
         retorno = ejb.borrarCiudadano(id);
         return retorno;
     }

   
}
