
package co.mil.ejercito.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.mil.ejercito.wsclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarCiudadanoMultasResponse_QNAME = new QName("http://ws.ejercito.mil.co/", "consultarCiudadanoMultasResponse");
    private final static QName _ConsultarCiudadanoMultas_QNAME = new QName("http://ws.ejercito.mil.co/", "consultarCiudadanoMultas");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.mil.ejercito.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarCiudadanoMultas }
     * 
     */
    public ConsultarCiudadanoMultas createConsultarCiudadanoMultas() {
        return new ConsultarCiudadanoMultas();
    }

    /**
     * Create an instance of {@link ConsultarCiudadanoMultasResponse }
     * 
     */
    public ConsultarCiudadanoMultasResponse createConsultarCiudadanoMultasResponse() {
        return new ConsultarCiudadanoMultasResponse();
    }

    /**
     * Create an instance of {@link MultasWs }
     * 
     */
    public MultasWs createMultasWs() {
        return new MultasWs();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCiudadanoMultasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultarCiudadanoMultasResponse")
    public JAXBElement<ConsultarCiudadanoMultasResponse> createConsultarCiudadanoMultasResponse(ConsultarCiudadanoMultasResponse value) {
        return new JAXBElement<ConsultarCiudadanoMultasResponse>(_ConsultarCiudadanoMultasResponse_QNAME, ConsultarCiudadanoMultasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarCiudadanoMultas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultarCiudadanoMultas")
    public JAXBElement<ConsultarCiudadanoMultas> createConsultarCiudadanoMultas(ConsultarCiudadanoMultas value) {
        return new JAXBElement<ConsultarCiudadanoMultas>(_ConsultarCiudadanoMultas_QNAME, ConsultarCiudadanoMultas.class, null, value);
    }

}
