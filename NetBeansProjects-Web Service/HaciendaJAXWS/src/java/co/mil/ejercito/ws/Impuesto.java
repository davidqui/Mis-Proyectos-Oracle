/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.ws;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public  class Impuesto implements Serializable {

    private BigDecimal id;
    private BigInteger vigencia;
    private String periodo;
    private String numeroTransaccion;
    private String numeroFormulario;
    private BigInteger referenciaPago;
    private BigInteger valor;

    /**
     * @return the id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return the vigencia
     */
    public BigInteger getVigencia() {
        return vigencia;
    }

    /**
     * @param vigencia the vigencia to set
     */
    public void setVigencia(BigInteger vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * @return the periodo
     */
    public String getPeriodo() {
        return periodo;
    }

    //public  Impuesto(){}
    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the numeroTransaccion
     */
    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    /**
     * @param numeroTransaccion the numeroTransaccion to set
     */
    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    /**
     * @return the numeroFormulario
     */
    public String getNumeroFormulario() {
        return numeroFormulario;
    }

    /**
     * @param numeroFormulario the numeroFormulario to set
     */
    public void setNumeroFormulario(String numeroFormulario) {
        this.numeroFormulario = numeroFormulario;
    }

    /**
     * @return the referenciaPago
     */
    public BigInteger getReferenciaPago() {
        return referenciaPago;
    }

    /**
     * @param referenciaPago the referenciaPago to set
     */
    public void setReferenciaPago(BigInteger referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    /**
     * @return the valor
     */
    public BigInteger getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigInteger valor) {
        this.valor = valor;
    }
    
    

}
