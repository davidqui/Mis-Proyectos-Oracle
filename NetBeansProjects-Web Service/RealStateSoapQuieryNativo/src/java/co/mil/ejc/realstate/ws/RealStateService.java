/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejc.realstate.ws;


import co.mil.ejc.realstate.entity.DescripcionViviendas;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.Query;

/**
 *
 * @author Nadia Salcedo
 */
@WebService(serviceName = "RealStateWS")
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RealStateService {

    private static final Logger LOG = Logger.getLogger(RealStateService.class.getName());
    @PersistenceContext(unitName = "RealState2PU")
    private EntityManager em;
    
    
    @WebMethod(operationName = "buscarVivienda")
    @WebResult(name = "resultBusqueda")
    public List<DescripcionViviendas> buscarVivienda(@WebParam (name="ID_DESCR_VIVIENDA") BigDecimal idDescrVivienda,
         //   @WebParam (name="CANT_BANOS") BigInteger cantBanos,
            @WebParam (name="CANT_HABITACIONES") BigInteger cantHabitaciones,
            @WebParam (name="PRECIO")BigInteger precio,
            @WebParam (name="PRECIO2")BigInteger precio2)
    { 
        DescripcionViviendas var;
            LOG.log(Level.INFO, "Entrada consultarViviendas");
        List<DescripcionViviendas> lista = new ArrayList();
        try {
            String SQL = "";
            //if (idDescrVivienda.equals("")) {
              //  SQL = "SELECT * FROM DescripcionViviendas";
            //} else {
                //SQL = "SELECT * from DESCRIPCION_VIVIENDAS WHERE CANT_BANOS ='"+cantBanos+"'"
                  //      + " OR CANT_HABITACIONES='" +cantHabitaciones+ "'";
                
                 SQL = "SELECT * "
                         + "from DESCRIPCION_VIVIENDAS DV, "
                         + "DETALLE_VIVIENDAS DEVI, "
                         + "TIPO_VIVIENDAS TV, "
                         + "TIPO_CONTRATOS TC "
                         + "WHERE DV.CANT_HABITACIONES LIKE'%"+cantHabitaciones+"%'"
                         +" AND DEVI.PRECIO BETWEEN '"+precio+ "'" 
                         +"AND '"+precio2+ "'"
                         +" AND DEVI.ID_DESCR_VIVIENDA = DV.ID_DESCR_VIVIENDA"
                         +" AND DEVI.ID_CONTRATO=TC.ID_CONTRATO"
                         +" AND DEVI.ID_T_VIVIENDA=TV.ID_T_VIVIENDA";
                 
            //}
            
            LOG.log(Level.INFO, "Entrada consultarViviendas"+cantHabitaciones);
            LOG.log(Level.INFO, "Entrada consultarViviendas"+precio);
            LOG.log(Level.INFO, "Entrada consultarViviendas"+precio2);
            Query query = em.createNativeQuery(SQL, DescripcionViviendas.class);
            lista = query.getResultList();

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error ", e);
        }
        LOG.log(Level.INFO, "Salida consultarDescripcionViviendas");
        return lista;
    }
    
        
            
    /*public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }*/
    
}
