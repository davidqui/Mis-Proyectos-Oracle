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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "ConsultasService")
//@WebService(serviceName = "crearCiudadano")
public class ConsultasService {
    private static final Logger LOG = Logger.getLogger(ConsultasService.class.getName());
    
    @PersistenceContext(unitName = "ConsultasMultasPU")
    private EntityManager em;
    
//    @EJB
//    private MultasFacadeLocal ejb;
    
    @WebMethod(operationName = "consultarCiudadanoMultas")
    @WebResult(name = "ciudadano")
    public List<MultasWs> consultarCiudadanoMultas(@WebParam(name = "id") BigDecimal id) {
       
        List<MultasWs> respuesta = new ArrayList<MultasWs>();

        try {

            Ciudadano ciudadano = em.find(Ciudadano.class, id);
            List<Multas> lista = ciudadano.getMultasList();
            for (Multas e : lista) {
                MultasWs r = new MultasWs();
                r.setId(e.getId());
                r.setDescripcion(e.getDescripcion());
                r.setValor(e.getValor());
                
                respuesta.add(r);
           // respuesta = ejb.crearCiudadano(nombre, apellido, email, telefono);

            

        }
        }catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en el Catch" + e);

        }
        LOG.log(Level.INFO, "Salida crearCiudadano");

        return respuesta;
    }

   
}



