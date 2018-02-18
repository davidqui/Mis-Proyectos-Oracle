
package co.mil.ejercito.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.mil.ejercito.ws package. 
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

    private final static QName _Concatenar_QNAME = new QName("http://ws.ejercito.mil.co/", "concatenar");
    private final static QName _ConcatenarResponse_QNAME = new QName("http://ws.ejercito.mil.co/", "concatenarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.mil.ejercito.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConcatenarResponse }
     * 
     */
    public ConcatenarResponse createConcatenarResponse() {
        return new ConcatenarResponse();
    }

    /**
     * Create an instance of {@link Concatenar }
     * 
     */
    public Concatenar createConcatenar() {
        return new Concatenar();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Concatenar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "concatenar")
    public JAXBElement<Concatenar> createConcatenar(Concatenar value) {
        return new JAXBElement<Concatenar>(_Concatenar_QNAME, Concatenar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConcatenarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "concatenarResponse")
    public JAXBElement<ConcatenarResponse> createConcatenarResponse(ConcatenarResponse value) {
        return new JAXBElement<ConcatenarResponse>(_ConcatenarResponse_QNAME, ConcatenarResponse.class, null, value);
    }

}
