

package co.mil.ejercito.totDown;

import javax.jws.WebService;

/**
 *
 *Fecha     Sep 12, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@WebService(serviceName = "PersonaServiceService", portName = "PersonaServicePort", endpointInterface = "co.mil.ejercito.ws.PersonaService", targetNamespace = "http://ws.ejercito.mil.co/", wsdlLocation = "WEB-INF/wsdl/TopDownService/PersonaServiceService.wsdl")
public class TopDownService {

    public java.lang.String concatenar(java.lang.String nombre, java.lang.String apellido) {
       return nombre + apellido;
    }

}
