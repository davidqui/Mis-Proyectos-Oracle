

package co.mil.ejercito.rs;

import co.mil.ejercito.entity.Reservas;
import co.mil.ejercito.entity.Usuarios;
import co.mil.ejercito.qr.GetdeGeneradorQR;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 *Fecha     Sep 25, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Path("ReservasRestService")
@Stateless //Es un "Rest" y es un "EJB" tambien a la vez
public class ReservasRestService {
    private static final Logger LOG = Logger.getLogger(ReservasRestService.class.getName());
    
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "PeliculasRestPU")      //                            ||
    private EntityManager em;                           //                             ||
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/guardarReserva/{descripcion}/{funcion}/{ubicacion}/{id}")
    public String guardarReserva(@PathParam("descripcion")String descripcion,
            @PathParam("funcion")String funcion, 
            @PathParam("ubicacion")String ubicacion,
            @PathParam("id")String id){
      LOG.log(Level.INFO, "Entrada al metodo guardarReserva ");
      String resultado = "15EBEA440AE";
      
        try {
            Reservas reserva = new Reservas();
            reserva.setDescripcion(descripcion);
            reserva.setFuncion(funcion);
            reserva.setUbicacion(ubicacion);
            Usuarios usuario = em.find(Usuarios.class, new BigDecimal(id));
            reserva.setId(usuario);
            Long confirmacion = System.currentTimeMillis();
            reserva.setConfirmacion(String.valueOf(confirmacion));
            em.persist(reserva);
            resultado = confirmacion.toString();
            GetdeGeneradorQR.generarQR(resultado);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
      
      LOG.log(Level.INFO, "Salida del metodo guardarReserva ");
      return resultado;
        
    }
    

}
