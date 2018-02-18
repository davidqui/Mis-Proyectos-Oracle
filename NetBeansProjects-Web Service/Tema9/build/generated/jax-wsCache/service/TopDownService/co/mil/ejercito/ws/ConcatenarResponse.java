
package co.mil.ejercito.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for concatenarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="concatenarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreapellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "concatenarResponse", propOrder = {
    "nombreapellido"
})
public class ConcatenarResponse {

    protected String nombreapellido;

    /**
     * Gets the value of the nombreapellido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreapellido() {
        return nombreapellido;
    }

    /**
     * Sets the value of the nombreapellido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreapellido(String value) {
        this.nombreapellido = value;
    }

}
