/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.aplicacion.ws;

import co.mil.ejercito.aplicacion.entity.BuscarVivienda;
import co.mil.ejercito.aplicacion.entity.DescripcionViviendas;
import co.mil.ejercito.aplicacion.entity.DetalleViviendas;
import co.mil.ejercito.aplicacion.entity.InformacionEmpresa;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "RealStateService")
@Stateless      //es un "WS" y tambien es "EJB" ...(maneja contexto transaccional)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RealStateService {

    private static final Logger LOG = Logger.getLogger(RealStateService.class.getName());

    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "RealStatePU")      //                            ||
    private EntityManager em;                            //                             ||
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @WebMethod(operationName = "findYourPlace")
    @WebResult(name = "confirmacion")
    public List<DescripcionViviendas> findYourPlace(@WebParam(name = "Place") String keyword,
            @WebParam(name = "CANT_HABITACIONES") BigInteger cantHabitaciones,
            @WebParam (name="PRECIO")String precio,
            @WebParam (name="PRECIO2")String precio2,
            @WebParam (name="CONTRATO")String contrato) {
        LOG.log(Level.INFO, "Entrada al metodo findYourPlace() ");
        List<DescripcionViviendas> lista = new ArrayList();
        try {
            String SQL = " ";//si esta en blanco lanza el *from"  y trae todas las peliculas
            if (keyword.equals("")) {
                SQL = "SELECT * FROM DESCRIPCION_VIVIENDAS";

            } else {
               SQL = "SELECT * "
                         + " from DESCRIPCION_VIVIENDAS DV, "
                         + " DETALLE_VIVIENDAS DEVI, "
                         + " TIPO_CONTRATOS TC "
                         + " WHERE DEVI.PRECIO between'"+precio+"'" 
                         +" AND '"+precio2+"'";
                LOG.log(Level.INFO, "Entre al from ");
                //return lista;
                }

            Query query = em.createNativeQuery(SQL, DescripcionViviendas.class);
            lista = query.getResultList();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo findYourPlace() ");
        return lista;
    }
    
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%| METODO VELASCO   |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @WebMethod(operationName = "buscarVi")
    @WebResult(name = "resultBusqueda")
    public List<BuscarVivienda> buscarVivienda(@WebParam(name = "idDescrVivienda") String idDescrVivienda,
            //   @WebParam (name="CANT_BANOS") BigInteger cantBanos,
            @WebParam(name = "CANT_HABITACIONES") String cantHabitaciones,
            @WebParam(name = "precio") String precio,
            @WebParam(name = "precio2") String precio2,
            @WebParam(name = "CONTRATO") String contrato) {
        
        LOG.log(Level.INFO, "Entrada consultarViviendas");
        List<BuscarVivienda> lista = new ArrayList();
        try {
            String SQL = "";
            if (idDescrVivienda.isEmpty()) {
                SQL = "SELECT * FROM DescripcionViviendas,"
                            + " DETALLE_VIVIENDAS DEVI, "
                            + " TIPO_CONTRATOS TC "
                            + " WHERE DEVI.ID_DESCR_VIVIENDA = DV.ID_DESCR_VIVIENDA"
                            + " AND DEVI.ID_CONTRATO=TC.ID_CONTRATO";
            } else {
                if (precio.equals("") && precio2.equals("")) {
                    
                    SQL = "select 1 AS ID, dv.CANT_BANOS, dv.CANT_HABITACIONES,"
                            + " DV.CANT_PISOS, DV.UBICACION_PISO, DV.GARAJE,"
                            + " DV.GAS, DV.ENERGIA, DV.AGUA, DV.DIRECCION,"
                            + " DV.DESCRIPCION, DV.CIUDAD, DV.DEPARTAMENTO,"
                            + " DV.ANO_CONST, DV.AREA_CONST, DEVI.PRECIO, TC.DESCRI_C"
                            + " from DESCRIPCION_VIVIENDAS DV, "
                            + " DETALLE_VIVIENDAS DEVI, "
                            + " TIPO_CONTRATOS TC "
                            + " WHERE (DEVI.ID_CONTRATO LIKE '%" + contrato.trim() + "%'"
                            + " OR DEVI.PRECIO BETWEEN '" + precio.trim() + "'"
                            + " AND '" + precio2.trim() + "')"
                            + " AND DV.CANT_HABITACIONES LIKE'%" + cantHabitaciones.trim() + "%'"
                            + " AND DEVI.ID_DESCR_VIVIENDA = DV.ID_DESCR_VIVIENDA"
                            + " AND DEVI.ID_CONTRATO=TC.ID_CONTRATO";

                    //}
                    LOG.log(Level.INFO, "ENRANDO AL OR");
                    LOG.log(Level.INFO, "Entrada habitacion" + cantHabitaciones);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + precio);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + precio2);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + contrato);
                    Query query = em.createNativeQuery(SQL, BuscarVivienda.class);
                    lista = query.getResultList();
                } else {
                    SQL = "select 1 AS ID, dv.CANT_BANOS, dv.CANT_HABITACIONES,"
                            + " DV.CANT_PISOS, DV.UBICACION_PISO, DV.GARAJE,"
                            + " DV.GAS, DV.ENERGIA, DV.AGUA, DV.DIRECCION,"
                            + " DV.DESCRIPCION, DV.CIUDAD, DV.DEPARTAMENTO,"
                            + " DV.ANO_CONST, DV.AREA_CONST, DEVI.PRECIO, TC.DESCRI_C"
                            + " from DESCRIPCION_VIVIENDAS DV, "
                            + " DETALLE_VIVIENDAS DEVI, "
                            + " TIPO_CONTRATOS TC "
                            + " WHERE (DEVI.ID_CONTRATO LIKE '%" + contrato.trim() + "%'"
                            + " AND DEVI.PRECIO BETWEEN '" + precio.trim() + "'"
                            + " AND '" + precio2.trim() + "')"
                            + " AND DV.CANT_HABITACIONES LIKE'%" + cantHabitaciones.trim() + "%'"
                            + " AND DEVI.ID_DESCR_VIVIENDA = DV.ID_DESCR_VIVIENDA"
                            + " AND DEVI.ID_CONTRATO=TC.ID_CONTRATO";

                    //}
                    LOG.log(Level.INFO, "ENRANDO AL AND");
                    LOG.log(Level.INFO, "Entrada habitacion" + cantHabitaciones);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + precio);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + precio2);
                    LOG.log(Level.INFO, "Entrada consultarViviendas" + contrato);
                    Query query = em.createNativeQuery(SQL, BuscarVivienda.class);
                    lista = query.getResultList();
                    }
            }
            }catch (Exception e) {
            LOG.log(Level.SEVERE, "Error ", e);
        }
            LOG.log(Level.INFO, "Salida consultarDescripcionViviendas");
            return lista;
        }
    
   //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%| METODO EMPRESA    |%%%%% 

    @WebMethod(operationName = "informacionEmp")
    @WebResult(name = "infEmpresa")
    public InformacionEmpresa informacionEmpresa(@WebParam(name = "nit") String nit) {
        LOG.log(Level.INFO, "Entrada al metodo informacionEmpresa() ");
        
        InformacionEmpresa infEmpresa = new InformacionEmpresa();//crea una pelicula vacia
        try {
//            infEmpresa = em.find(InformacionEmpresa.class, nit);//el "entity" va y busca la pelicula por el ID
           Query query = em.createNamedQuery("InformacionEmpresa.findByNit",InformacionEmpresa.class);//toma el Query de la clase "Categoria"
           query.setParameter("nit", nit);
           infEmpresa = (InformacionEmpresa)query.getSingleResult();

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error  ", e);
        }
        LOG.log(Level.INFO, "Salida del metodo informacionEmpresa() ");

        return infEmpresa;
    }

}
