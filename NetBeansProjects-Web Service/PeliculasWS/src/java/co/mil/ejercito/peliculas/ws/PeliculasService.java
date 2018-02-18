/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.peliculas.ws;

import co.mil.ejercito.peliculas.entity.Reservas;
import co.mil.ejercito.peliculas.entity.Usuarios;
import co.mil.ejercito.qr.GetdeGeneradorQR;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
//PARA QUE EL WEB SERVICE SEA TAMBIEN EJB
@WebService(serviceName = "PeliculasService")
@Stateless      //es un "WS" y tambien es "EJB" ...(maneja contexto transaccional)
@TransactionManagement(TransactionManagementType.CONTAINER)//latransaccionabilidad es automatica
public class PeliculasService {
    private static final Logger LOG = Logger.getLogger(PeliculasService.class.getName());
    
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "PeliculasWSPU")      //                            ||
    private EntityManager em;                           //                             ||
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

       
    @WebMethod(operationName = "guardarReserva")
    @WebResult(name = "confirmacion")
    public long guardarReserva(@WebParam(name = "reserva")Reservas reserva,
            @WebParam(name = "idUsuario")BigDecimal idUsuario) {
        LOG.log(Level.INFO, "Entrada al metodo guardarReserva ");
        long resultado = 0L;
        try {
            Usuarios usuario = em.find(Usuarios.class, idUsuario);//el "entity" va y busca la pelicula por el ID
            reserva.setId(usuario);
            
            resultado = System.currentTimeMillis();//generador del Tiket  "numero de milis desde 1970
            reserva.setConfirmacion(String.valueOf(resultado));//para que quede el registro en la base de datos
            em.persist(reserva);
            GetdeGeneradorQR.generarQR(String.valueOf(resultado));//le agregamos esta linea para el QR
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo guardarReserva ");
        return resultado;
        
    }
}
