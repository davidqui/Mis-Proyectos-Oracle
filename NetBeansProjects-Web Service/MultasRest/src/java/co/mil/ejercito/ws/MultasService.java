/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import co.mil.ejercito.entity.Ciudadano;
import co.mil.ejercito.entity.Multas;
import co.mil.ejercito.modelo.MultasFacadeLocal3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Path(value = "MultasService")
public class MultasService {

    @EJB
    private MultasFacadeLocal3 ejb;

    @GET
    @Path("/multas/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Multa> consultarMultasCiudadano(@PathParam("id") String id) {
        List<Multa> lista = new ArrayList();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MultasRestPU");
        EntityManager em = emf.createEntityManager();
        Ciudadano c = em.find(Ciudadano.class, new BigDecimal(id));
        List<Multas> multas = c.getMultasList();
        for (Multas m : multas) {
            Multa multa = new Multa();
            multa.setId(m.getId());
            multa.setDescripcion(m.getDescripcion());
            multa.setValor(m.getValor());
            lista.add(multa);
        }
        return lista;
    }

    @PUT
    @Path("/multas/{nombre}/{apellido}/{email}/{telefono}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String crearCiudadano(@PathParam("nombre") String nombre, @PathParam("apellido") String apellido, @PathParam("email") String email, @PathParam("telefono") String telefono) {

        boolean respuesta = false;
        try {
            respuesta = ejb.crearCiudadano(nombre, apellido, email, telefono);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "" + respuesta;
    }

    @DELETE
    @Path("/multas/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public String borrarCiudadano(@PathParam("id") String id) {

        boolean respuesta = false;
        try {
            respuesta = ejb.borrarCiudadano(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "" + respuesta;
    }

}
