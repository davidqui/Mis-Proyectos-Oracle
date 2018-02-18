/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import co.mil.ejercito.entity.Ciudadano;
import co.mil.ejercito.entity.ImpuestoPredial;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Path(value = "HaciendaService")
public class HaciendaService {
    private static final Logger LOG = Logger.getLogger(HaciendaService.class.getName());
    

    @GET
    @Path("/nombre/{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public List<Impuesto> consultaImpuestoPredialPorVigencia(@PathParam("cedula") BigDecimal cedula) {
        LOG.log(Level.INFO, "Entrada al metodo consultaImpuestoPredialPorVigencia()");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HaciendaJAXRSPU");
        EntityManager em = emf.createEntityManager();
        List<Impuesto> lista = new ArrayList();
        try{
        Ciudadano c = em.find(Ciudadano.class, cedula);
        List<ImpuestoPredial> iv = c.getImpuestoPredialList();
        for (ImpuestoPredial v : iv) {
            Impuesto imp = new Impuesto();
            imp.setId(v.getId());
            imp.setNumeroFormulario(v.getNumeroFormulario());
            imp.setNumeroTransaccion(v.getNumeroTransaccion());
            imp.setPeriodo(v.getPeriodo());
            imp.setReferenciaPago(v.getReferenciaPago());
            imp.setValor(v.getValor());
            imp.setVigencia(v.getVigencia());
            lista.add(imp);
        }
        } catch (Exception e) {
          LOG.log(Level.SEVERE, "Error en el Catch :" + e);  
        }
        LOG.log(Level.INFO, "Salida del metodo consultaImpuestoPredialPorVigencia()");
        return lista;

    }
}
