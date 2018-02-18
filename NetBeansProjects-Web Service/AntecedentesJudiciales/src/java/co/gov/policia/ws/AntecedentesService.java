/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.gov.policia.ws;

import co.gov.policia.entity.Antecedentes;
import co.gov.policia.entity.Ciudadano;
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

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "AntecedentesService")
public class AntecedentesService {

    private static final Logger LOG = Logger.getLogger(AntecedentesService.class.getName());

    @PersistenceContext(unitName = "AntecedentesJudicialesPU")
    private EntityManager em;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarAntecedentesJudiciales")
    @WebResult(name = "listaAntecedentes")
    public List<Resultado> consultarAntecedentesJudiciales(@WebParam(name = "cedula") BigDecimal cedula) {
        LOG.log(Level.INFO, "Entrada consultarAntecedentesJudiciales");
        List<Resultado> antecedentes = new ArrayList();
        try {
            Ciudadano ciudadano = em.find(Ciudadano.class, cedula);
            List<Antecedentes> lista = ciudadano.getAntecedentesList();
            //List<Antecedentes> lista = ciudadano.getNombre();
            for (Antecedentes a : lista) {
                Resultado r = new Resultado();
                r.setId(a.getId());
                r.setNombre(a.getNombre());
                r.setDescritcion(a.getDescripcion());
                antecedentes.add(r);
            }
        } catch (Exception e) {
            LOG.log(Level.OFF, "Error",e);
        }
        LOG.log(Level.INFO, "Salida consultarAntecedentesJudiciales");
        return antecedentes;
    }
}
