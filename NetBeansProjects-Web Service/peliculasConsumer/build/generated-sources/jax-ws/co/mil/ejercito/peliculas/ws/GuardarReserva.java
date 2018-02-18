
package co.mil.ejercito.peliculas.ws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guardarReserva complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guardarReserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reserva" type="{http://ws.peliculas.ejercito.mil.co/}reservas" minOccurs="0"/>
 *         &lt;element name="idUsuario" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardarReserva", propOrder = {
    "reserva",
    "idUsuario"
})
public class GuardarReserva {

    protected Reservas reserva;
    protected BigDecimal idUsuario;

    /**
     * Gets the value of the reserva property.
     * 
     * @return
     *     possible object is
     *     {@link Reservas }
     *     
     */
    public Reservas getReserva() {
        return reserva;
    }

    /**
     * Sets the value of the reserva property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservas }
     *     
     */
    public void setReserva(Reservas value) {
        this.reserva = value;
    }

    /**
     * Gets the value of the idUsuario property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sets the value of the idUsuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdUsuario(BigDecimal value) {
        this.idUsuario = value;
    }

}
