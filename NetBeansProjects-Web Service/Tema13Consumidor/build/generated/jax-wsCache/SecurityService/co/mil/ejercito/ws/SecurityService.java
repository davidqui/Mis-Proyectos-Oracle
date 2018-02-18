
package co.mil.ejercito.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SecurityService", targetNamespace = "http://ws.ejercito.mil.co/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SecurityService {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://ws.ejercito.mil.co/", className = "co.mil.ejercito.ws.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://ws.ejercito.mil.co/", className = "co.mil.ejercito.ws.HelloResponse")
    @Action(input = "http://ws.ejercito.mil.co/SecurityService/helloRequest", output = "http://ws.ejercito.mil.co/SecurityService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
