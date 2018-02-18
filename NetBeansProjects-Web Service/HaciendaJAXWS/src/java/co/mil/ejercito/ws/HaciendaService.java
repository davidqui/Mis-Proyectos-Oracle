/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;


import co.mil.ejercito.entity.Ciudadano;
import co.mil.ejercito.entity.ImpuestoVehicular;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import weblogic.jws.Policies;
import weblogic.jws.Policy;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "HaciendaService")
@Policies({@Policy(uri="../UsernameToken.xml")})
public class HaciendaService {
    private static final Logger LOG = Logger.getLogger(HaciendaService.class.getName());
    
    @PersistenceContext(unitName = "HaciendaJAXWSPU")
    private EntityManager em;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultaImpuestoVehicular")
    @WebResult(name = "Impuesto")
    public List<Impuesto> consultaImpuestoVehicularPorVigencia(@WebParam(name = "cedula") BigDecimal cedula) {
        LOG.log(Level.INFO, "Entrada al metodo consultaImpuestoVehicularPorVigencia()");
        List<Impuesto> lista = new ArrayList();
        try{
        Ciudadano c = em.find(Ciudadano.class, cedula);
        List<ImpuestoVehicular> iv = c.getImpuestoVehicularList();
        for (ImpuestoVehicular v : iv) {
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
        LOG.log(Level.INFO, "Salida del metodo consultaImpuestoVehicularPorVigencia()");
        return lista;
    }
}
