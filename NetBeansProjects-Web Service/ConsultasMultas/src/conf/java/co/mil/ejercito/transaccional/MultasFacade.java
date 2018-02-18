
package co.mil.ejercito.transaccional;

import co.mil.ejercito.entity.Ciudadano;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class MultasFacade implements MultasFacadeLocal {
    private static final Logger LOG = Logger.getLogger(MultasFacade.class.getName());
    
    @PersistenceContext(unitName = "ConsultasMultasPU")
    private EntityManager em;

    @Override
    public boolean crearCiudadano(String nombre, String apellido, String email, String telefono) {
        LOG.log(Level.INFO, "Entrada del metodo crearCiudadano");
        boolean retorno = true;
        try {
            Ciudadano c = new Ciudadano();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setEmail(email);
            c.setTelefono(telefono);
            em.persist(c);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en el catch : " + e);
            return false;
        }
        LOG.log(Level.INFO, "Salida del metodo crearCiudadano");
        return retorno;
    }
    
    /**
     * METODO PARA BORRAR UN CIUDADANO
     * @param id
     * @return 
     */

    @Override
    public boolean borrarCiudadano(BigDecimal id) {
        boolean retorno = false;
        Ciudadano c = em.find(Ciudadano.class, id);
        if (c != null) {
           retorno = true;
           em.remove(c);
            
        }
        return retorno;
    }

   
}
