
package co.mil.ejercito.peliculas.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.mil.ejercito.peliculas.ws package. 
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

    private final static QName _Usuarios_QNAME = new QName("http://ws.peliculas.ejercito.mil.co/", "usuarios");
    private final static QName _GuardarReserva_QNAME = new QName("http://ws.peliculas.ejercito.mil.co/", "guardarReserva");
    private final static QName _Reservas_QNAME = new QName("http://ws.peliculas.ejercito.mil.co/", "reservas");
    private final static QName _GuardarReservaResponse_QNAME = new QName("http://ws.peliculas.ejercito.mil.co/", "guardarReservaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.mil.ejercito.peliculas.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GuardarReservaResponse }
     * 
     */
    public GuardarReservaResponse createGuardarReservaResponse() {
        return new GuardarReservaResponse();
    }

    /**
     * Create an instance of {@link GuardarReserva }
     * 
     */
    public GuardarReserva createGuardarReserva() {
        return new GuardarReserva();
    }

    /**
     * Create an instance of {@link Reservas }
     * 
     */
    public Reservas createReservas() {
        return new Reservas();
    }

    /**
     * Create an instance of {@link Usuarios }
     * 
     */
    public Usuarios createUsuarios() {
        return new Usuarios();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Usuarios }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.peliculas.ejercito.mil.co/", name = "usuarios")
    public JAXBElement<Usuarios> createUsuarios(Usuarios value) {
        return new JAXBElement<Usuarios>(_Usuarios_QNAME, Usuarios.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.peliculas.ejercito.mil.co/", name = "guardarReserva")
    public JAXBElement<GuardarReserva> createGuardarReserva(GuardarReserva value) {
        return new JAXBElement<GuardarReserva>(_GuardarReserva_QNAME, GuardarReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reservas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.peliculas.ejercito.mil.co/", name = "reservas")
    public JAXBElement<Reservas> createReservas(Reservas value) {
        return new JAXBElement<Reservas>(_Reservas_QNAME, Reservas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardarReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.peliculas.ejercito.mil.co/", name = "guardarReservaResponse")
    public JAXBElement<GuardarReservaResponse> createGuardarReservaResponse(GuardarReservaResponse value) {
        return new JAXBElement<GuardarReservaResponse>(_GuardarReservaResponse_QNAME, GuardarReservaResponse.class, null, value);
    }

}
