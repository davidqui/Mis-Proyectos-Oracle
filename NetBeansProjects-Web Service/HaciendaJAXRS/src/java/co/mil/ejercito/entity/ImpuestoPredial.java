/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "IMPUESTO_PREDIAL", catalog = "", schema = "HACIENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImpuestoPredial.findAll", query = "SELECT i FROM ImpuestoPredial i"),
    @NamedQuery(name = "ImpuestoPredial.findById", query = "SELECT i FROM ImpuestoPredial i WHERE i.id = :id"),
    @NamedQuery(name = "ImpuestoPredial.findByVigencia", query = "SELECT i FROM ImpuestoPredial i WHERE i.vigencia = :vigencia"),
    @NamedQuery(name = "ImpuestoPredial.findByPeriodo", query = "SELECT i FROM ImpuestoPredial i WHERE i.periodo = :periodo"),
    @NamedQuery(name = "ImpuestoPredial.findByNumeroTransaccion", query = "SELECT i FROM ImpuestoPredial i WHERE i.numeroTransaccion = :numeroTransaccion"),
    @NamedQuery(name = "ImpuestoPredial.findByNumeroFormulario", query = "SELECT i FROM ImpuestoPredial i WHERE i.numeroFormulario = :numeroFormulario"),
    @NamedQuery(name = "ImpuestoPredial.findByReferenciaPago", query = "SELECT i FROM ImpuestoPredial i WHERE i.referenciaPago = :referenciaPago"),
    @NamedQuery(name = "ImpuestoPredial.findByValor", query = "SELECT i FROM ImpuestoPredial i WHERE i.valor = :valor")})
public class ImpuestoPredial implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VIGENCIA")
    private BigInteger vigencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "PERIODO")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "NUMERO_TRANSACCION")
    private String numeroTransaccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "NUMERO_FORMULARIO")
    private String numeroFormulario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCIA_PAGO")
    private BigInteger referenciaPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private BigInteger valor;
    @JoinColumn(name = "ID_CIUDADANO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ciudadano idCiudadano;

    public ImpuestoPredial() {
    }

    public ImpuestoPredial(BigDecimal id) {
        this.id = id;
    }

    public ImpuestoPredial(BigDecimal id, BigInteger vigencia, String periodo, String numeroTransaccion, String numeroFormulario, BigInteger referenciaPago, BigInteger valor) {
        this.id = id;
        this.vigencia = vigencia;
        this.periodo = periodo;
        this.numeroTransaccion = numeroTransaccion;
        this.numeroFormulario = numeroFormulario;
        this.referenciaPago = referenciaPago;
        this.valor = valor;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getVigencia() {
        return vigencia;
    }

    public void setVigencia(BigInteger vigencia) {
        this.vigencia = vigencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getNumeroFormulario() {
        return numeroFormulario;
    }

    public void setNumeroFormulario(String numeroFormulario) {
        this.numeroFormulario = numeroFormulario;
    }

    public BigInteger getReferenciaPago() {
        return referenciaPago;
    }

    public void setReferenciaPago(BigInteger referenciaPago) {
        this.referenciaPago = referenciaPago;
    }

    public BigInteger getValor() {
        return valor;
    }

    public void setValor(BigInteger valor) {
        this.valor = valor;
    }

    public Ciudadano getIdCiudadano() {
        return idCiudadano;
    }

    public void setIdCiudadano(Ciudadano idCiudadano) {
        this.idCiudadano = idCiudadano;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpuestoPredial)) {
            return false;
        }
        ImpuestoPredial other = (ImpuestoPredial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.entity.ImpuestoPredial[ id=" + id + " ]";
    }
    
}
