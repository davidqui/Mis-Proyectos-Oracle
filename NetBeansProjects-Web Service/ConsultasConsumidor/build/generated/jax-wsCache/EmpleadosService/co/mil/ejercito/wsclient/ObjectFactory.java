
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

    private final static QName _ConsultarEmpleadosDepartamentoResponse_QNAME = new QName("http://ws.ejercito.mil.co/", "consultarEmpleadosDepartamentoResponse");
    private final static QName _ConsultarEmpleadosDepartamento_QNAME = new QName("http://ws.ejercito.mil.co/", "consultarEmpleadosDepartamento");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.mil.ejercito.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarEmpleadosDepartamento }
     * 
     */
    public ConsultarEmpleadosDepartamento createConsultarEmpleadosDepartamento() {
        return new ConsultarEmpleadosDepartamento();
    }

    /**
     * Create an instance of {@link ConsultarEmpleadosDepartamentoResponse }
     * 
     */
    public ConsultarEmpleadosDepartamentoResponse createConsultarEmpleadosDepartamentoResponse() {
        return new ConsultarEmpleadosDepartamentoResponse();
    }

    /**
     * Create an instance of {@link Empleado }
     * 
     */
    public Empleado createEmpleado() {
        return new Empleado();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEmpleadosDepartamentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultarEmpleadosDepartamentoResponse")
    public JAXBElement<ConsultarEmpleadosDepartamentoResponse> createConsultarEmpleadosDepartamentoResponse(ConsultarEmpleadosDepartamentoResponse value) {
        return new JAXBElement<ConsultarEmpleadosDepartamentoResponse>(_ConsultarEmpleadosDepartamentoResponse_QNAME, ConsultarEmpleadosDepartamentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarEmpleadosDepartamento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ejercito.mil.co/", name = "consultarEmpleadosDepartamento")
    public JAXBElement<ConsultarEmpleadosDepartamento> createConsultarEmpleadosDepartamento(ConsultarEmpleadosDepartamento value) {
        return new JAXBElement<ConsultarEmpleadosDepartamento>(_ConsultarEmpleadosDepartamento_QNAME, ConsultarEmpleadosDepartamento.class, null, value);
    }

}
