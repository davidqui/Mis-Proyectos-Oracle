package co.mil.ejercito.rest;



import co.mil.ejercito.entity.Ciudadano;
import co.mil.ejercito.entity.Multas;
import co.mil.ejercito.transaccional.MultasFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path("ConsultasMultasRest")    //ALIAS EN LA "URL"
public class ConsultasMultasRest {
    private static final Logger LOG = Logger.getLogger(ConsultasMultasRest.class.getName());
    
    @EJB
    private MultasFacadeLocal ejb;
        
    @GET    //consultas
    @Produces(MediaType.APPLICATION_JSON)//arroja un xml
    @Consumes(MediaType.TEXT_PLAIN)     //recibe un xml
    @Path("/name/{id}") 
    
    public List<MultasWs> consultarListaMultas(@PathParam( "id") String id) {
        LOG.log(Level.INFO, "Entrada consultarListaMultas");
        List<MultasWs> respuesta = new ArrayList<MultasWs>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultasMultasRestPU");//se declara el entityManager
        EntityManager em = emf.createEntityManager();
        try {

            Ciudadano ciudadano = em.find(Ciudadano.class, Short.parseShort(id));
            List<Multas> lista = ciudadano.getMultasList();
            for (Multas e : lista) {
                MultasWs r = new MultasWs();
                r.setId(e.getId());
                r.setDescripcion(e.getDescripcion());
                r.setValor(e.getValor());
                
                respuesta.add(r);

            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en el Catch" + e);

        }
        LOG.log(Level.INFO, "Salida consultarListaMultas");

        return respuesta;
    }
}
