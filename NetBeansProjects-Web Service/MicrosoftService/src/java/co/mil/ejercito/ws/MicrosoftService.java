

package co.mil.ejercito.ws;

import javax.jws.WebService;

/**
 *
 *Fecha     Sep 12, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@WebService(serviceName = "CalculatorService", portName = "ICalculator", endpointInterface = "org.example.ICalculator", targetNamespace = "http://Example.org", wsdlLocation = "WEB-INF/wsdl/MicrosoftService/Microsoft.wsdl")
public class MicrosoftService {

    public java.lang.Integer add(java.lang.Integer a, java.lang.Integer b) {
        return a + b;
    }

    public java.lang.Integer subtract(java.lang.Integer a, java.lang.Integer b) {
        //TODO implement this method
        return a - b;
    }

}
