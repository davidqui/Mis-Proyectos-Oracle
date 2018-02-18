

package co.mil.ejercito.cliente;

import co.mil.ejercito.wsclient.Empleado;
import java.util.List;

/**
 *
 *Fecha     Sep 8, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class TestEmpleado {
    public static void main(String[] args) {
        List<co.mil.ejercito.wsclient.Empleado> lista =
                consultarEmpleadosDepartamento(Short.parseShort("30"));
        
        for (co.mil.ejercito.wsclient.Empleado emp : lista) {
            System.out.println("Nombre: " + emp.getNombre());
            
            System.out.println("Apellidos: " + emp.getApellido());
            
        }
        
    }

    private static java.util.List<co.mil.ejercito.wsclient.Empleado> consultarEmpleadosDepartamento(java.lang.Short id) {
        co.mil.ejercito.wsclient.EmpleadosService_Service service = new co.mil.ejercito.wsclient.EmpleadosService_Service();
        co.mil.ejercito.wsclient.EmpleadosService port = service.getEmpleadosServicePort();
        return port.consultarEmpleadosDepartamento(id);
    }

}
