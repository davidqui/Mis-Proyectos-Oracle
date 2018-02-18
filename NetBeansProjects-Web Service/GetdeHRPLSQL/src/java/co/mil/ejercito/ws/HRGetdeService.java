/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Administrator
 */
@WebService(serviceName = "HRGetdeService")
@Stateless
public class HRGetdeService {

    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @PersistenceContext(unitName = "GetdeHRPLSQLPU")      //                            ||
    private EntityManager em;                            //                             ||
    //%%%%%%%%%%%%%%%%%%%%%|    LA ENTITYMANAGER    |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @WebMethod(operationName = "aumentarSalario")
    public void aumentarSalario(BigDecimal idEmpleado, int porcentaje) {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("AJUSTAR_SALARIO").
                registerStoredProcedureParameter("a", BigDecimal.class, ParameterMode.IN).
                setParameter("a", idEmpleado).registerStoredProcedureParameter("b", Integer.class, ParameterMode.IN).
                setParameter("b", porcentaje);
        query.execute();
    }

    @WebMethod(operationName = "consultarEmpleado")
    public String consultarEmpleado(BigDecimal idEmpleado, String nombre) {
        StoredProcedureQuery query
                = em.createStoredProcedureQuery("CONSULTAR_EMPLEADO").
                registerStoredProcedureParameter("ID_EMPLEADO", BigDecimal.class, ParameterMode.IN).
                setParameter("ID_EMPLEADO", idEmpleado).
                registerStoredProcedureParameter("SALIDA", String.class, ParameterMode.OUT).
                setParameter("SALIDA", nombre);
        query.execute();
        return (String)query.getOutputParameterValue("SALIDA");
        
    }
    
}
