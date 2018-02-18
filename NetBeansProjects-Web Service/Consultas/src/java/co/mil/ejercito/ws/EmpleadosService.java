/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import co.mil.ejercito.entity.Departments;
import co.mil.ejercito.entity.Employees;
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
@WebService(serviceName = "EmpleadosService")
public class EmpleadosService {

    private static final Logger LOG = Logger.getLogger(EmpleadosService.class.getName());

    @PersistenceContext(unitName = "ConsultasPU")
    private EntityManager em;

    @WebMethod(operationName = "consultarEmpleadosDepartamento")
    @WebResult(name = "empleados")
    public List<Empleado> consultarEmpleadosDepartamento(@WebParam(name = "id") Short id) {
        LOG.log(Level.INFO, "Entrada consultarEmpleadosDepartamento");
        List<Empleado> respuesta = new ArrayList<Empleado>();
        try {

            Departments departamento = em.find(Departments.class, id);
            List<Employees> lista = departamento.getEmployeesList();
            for (Employees e : lista) {
                Empleado r = new Empleado();
                r.setId(e.getEmployeeId());;
                r.setNombre(e.getFirstName());
                r.setApellido(e.getLastName());
                r.setEmail(e.getEmail());
                r.setNumeroTel(e.getPhoneNumber());
                respuesta.add(r);

            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Error en el Catch" + e);

        }
        LOG.log(Level.INFO, "Salida consultarEmpleadosDepartamento");

        return respuesta;
    }
}
