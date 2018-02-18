
package co.mil.ejercito.wsl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.mil.ejercito.wsl package. 
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

    private final static QName _ConsultaImpuestoVehicular_QNAME = new QName("http://ws.ejercito.mil.co/", "consultaImpuestoVehicular");
    private final static QName _ConsultaImpuestoVehicularResponse_QNAME = new QName("http://ws.ejercito.mil.co/", "consultaImpuestoVehicularResponse");
    private final static QName _Impuesto_QNAME = new QName("http://ws.ejercito.mil.co/", "impuesto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.mil.ejercito.wsl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Impuesto }
     * 
     */
    public Impuesto createImpuesto() {
        return new Impuesto();
    }

    /**
     * Create an instance of {@link ConsultaImpuestoVehicular }
     * 
     */
    public ConsultaImpuestoVehicular createConsultaImpuestoVehicular() {
        return new ConsultaImpuestoVehicular();
    }

    /**
     * Create an instance of {@link ConsultaImpuestoVehicularResponse }
     * 
     */
    public ConsultaImpuestoVehicularResponse createConsultaImpuestoVehicularResponse() {
        return new ConsultaImpuestoVehicularResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaImpuestoVehicular }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultaImpuestoVehicular")
    public JAXBElement<ConsultaImpuestoVehicular> createConsultaImpuestoVehicular(ConsultaImpuestoVehicular value) {
        return new JAXBElement<ConsultaImpuestoVehicular>(_ConsultaImpuestoVehicular_QNAME, ConsultaImpuestoVehicular.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultaImpuestoVehicularResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultaImpuestoVehicularResponse")
    public JAXBElement<ConsultaImpuestoVehicularResponse> createConsultaImpuestoVehicularResponse(ConsultaImpuestoVehicularResponse value) {
        return new JAXBElement<ConsultaImpuestoVehicularResponse>(_ConsultaImpuestoVehicularResponse_QNAME, ConsultaImpuestoVehicularResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Impuesto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "impuesto")
    public JAXBElement<Impuesto> createImpuesto(Impuesto value) {
        return new JAXBElement<Impuesto>(_Impuesto_QNAME, Impuesto.class, null, value);
    }

}
