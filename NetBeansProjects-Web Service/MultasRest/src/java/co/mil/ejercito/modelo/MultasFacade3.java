/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.modelo;

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
public class MultasFacade3 implements MultasFacadeLocal3 {

    private static final Logger LOG = Logger.getLogger(MultasFacade3.class.getName());

    @PersistenceContext(unitName = "MultasRestPU")
    private EntityManager em;

    public boolean crearCiudadano(String nombre, String apellido, String email, String telefono) {
        LOG.log(Level.INFO, "Entrada crearCiudadano");
        boolean retorno = true;
        try {
            Ciudadano c = new Ciudadano();
            c.setNombre(nombre);
            c.setApellido(apellido);
            c.setEmail(email);
            c.setTelefono(telefono);
            em.persist(c);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
            retorno = false;
        }
        LOG.log(Level.INFO, "Salida crearCiudadano");
        return retorno;
    }

    @Override
    public boolean borrarCiudadano(String id) {
        LOG.log(Level.INFO, "Entrada borrarCiudadano");
        boolean retorno = true;
        try {
            Ciudadano c = em.find(Ciudadano.class, new BigDecimal(id));
            em.remove(c);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error " + e);
            retorno = false;
        }
        LOG.log(Level.INFO, "Salida borrarCiudadano");
        return retorno;
    }
}
