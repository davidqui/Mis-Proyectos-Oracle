//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 11:20:11 AM COT 
//


package co.mil.ejercito;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sueldoBasico" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="valorPrima" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="descuento" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sueldoBasico",
    "valorPrima",
    "descuento"
})
@XmlRootElement(name = "Nomina")
public class Nomina {

    protected double sueldoBasico;
    protected double valorPrima;
    protected double descuento;

    /**
     * Gets the value of the sueldoBasico property.
     * 
     */
    public double getSueldoBasico() {
        return sueldoBasico;
    }

    /**
     * Sets the value of the sueldoBasico property.
     * 
     */
    public void setSueldoBasico(double value) {
        this.sueldoBasico = value;
    }

    /**
     * Gets the value of the valorPrima property.
     * 
     */
    public double getValorPrima() {
        return valorPrima;
    }

    /**
     * Sets the value of the valorPrima property.
     * 
     */
    public void setValorPrima(double value) {
        this.valorPrima = value;
    }

    /**
     * Gets the value of the descuento property.
     * 
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Sets the value of the descuento property.
     * 
     */
    public void setDescuento(double value) {
        this.descuento = value;
    }

}
