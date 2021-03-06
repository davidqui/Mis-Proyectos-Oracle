
package co.mil.ejercito.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SecurityService", targetNamespace = "http://ws.ejercito.mil.co/", wsdlLocation = "http://192.168.252.72:7001/Tema13/SecurityService?WSDL")
public class SecurityService_Service
    extends Service
{

    private final static URL SECURITYSERVICE_WSDL_LOCATION;
    private final static WebServiceException SECURITYSERVICE_EXCEPTION;
    private final static QName SECURITYSERVICE_QNAME = new QName("http://ws.ejercito.mil.co/", "SecurityService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://192.168.252.72:7001/Tema13/SecurityService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SECURITYSERVICE_WSDL_LOCATION = url;
        SECURITYSERVICE_EXCEPTION = e;
    }

    public SecurityService_Service() {
        super(__getWsdlLocation(), SECURITYSERVICE_QNAME);
    }

    public SecurityService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SECURITYSERVICE_QNAME, features);
    }

    public SecurityService_Service(URL wsdlLocation) {
        super(wsdlLocation, SECURITYSERVICE_QNAME);
    }

    public SecurityService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SECURITYSERVICE_QNAME, features);
    }

    public SecurityService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SecurityService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SecurityService
     */
    @WebEndpoint(name = "SecurityServicePort")
    public SecurityService getSecurityServicePort() {
        return super.getPort(new QName("http://ws.ejercito.mil.co/", "SecurityServicePort"), SecurityService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SecurityService
     */
    @WebEndpoint(name = "SecurityServicePort")
    public SecurityService getSecurityServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.ejercito.mil.co/", "SecurityServicePort"), SecurityService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SECURITYSERVICE_EXCEPTION!= null) {
            throw SECURITYSERVICE_EXCEPTION;
        }
        return SECURITYSERVICE_WSDL_LOCATION;
    }

}
