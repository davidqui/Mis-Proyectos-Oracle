
package co.mil.ejercito.wsclient;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultarCiudadanoMultasResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultarCiudadanoMultasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ciudadano" type="{http://ws.ejercito.mil.co/}multasWs" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultarCiudadanoMultasResponse", propOrder = {
    "ciudadano"
})
public class ConsultarCiudadanoMultasResponse {

    protected List<MultasWs> ciudadano;

    /**
     * Gets the value of the ciudadano property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ciudadano property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCiudadano().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MultasWs }
     * 
     * 
     */
    public List<MultasWs> getCiudadano() {
        if (ciudadano == null) {
            ciudadano = new ArrayList<MultasWs>();
        }
        return this.ciudadano;
    }

}
