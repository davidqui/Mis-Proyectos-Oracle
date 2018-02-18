
package co.mil.ejercito.peliculas.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for guardarReservaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="guardarReservaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="confirmacion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "guardarReservaResponse", propOrder = {
    "confirmacion"
})
public class GuardarReservaResponse {

    protected long confirmacion;

    /**
     * Gets the value of the confirmacion property.
     * 
     */
    public long getConfirmacion() {
        return confirmacion;
    }

    /**
     * Sets the value of the confirmacion property.
     * 
     */
    public void setConfirmacion(long value) {
        this.confirmacion = value;
    }

}
