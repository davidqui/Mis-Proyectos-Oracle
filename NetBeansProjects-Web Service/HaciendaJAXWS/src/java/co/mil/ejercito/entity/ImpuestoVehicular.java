

package co.mil.ejercito.entity;

import co.mil.ejercito.entity.Ciudadano;
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
 *Fecha     Sep 13, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "IMPUESTO_VEHICULAR", catalog = "", schema = "HACIENDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ImpuestoVehicular.findAll", query = "SELECT i FROM ImpuestoVehicular i"),
    @NamedQuery(name = "ImpuestoVehicular.findById", query = "SELECT i FROM ImpuestoVehicular i WHERE i.id = :id"),
    @NamedQuery(name = "ImpuestoVehicular.findByVigencia", query = "SELECT i FROM ImpuestoVehicular i WHERE i.vigencia = :vigencia"),
    @NamedQuery(name = "ImpuestoVehicular.findByPeriodo", query = "SELECT i FROM ImpuestoVehicular i WHERE i.periodo = :periodo"),
    @NamedQuery(name = "ImpuestoVehicular.findByNumeroTransaccion", query = "SELECT i FROM ImpuestoVehicular i WHERE i.numeroTransaccion = :numeroTransaccion"),
    @NamedQuery(name = "ImpuestoVehicular.findByNumeroFormulario", query = "SELECT i FROM ImpuestoVehicular i WHERE i.numeroFormulario = :numeroFormulario"),
    @NamedQuery(name = "ImpuestoVehicular.findByReferenciaPago", query = "SELECT i FROM ImpuestoVehicular i WHERE i.referenciaPago = :referenciaPago"),
    @NamedQuery(name = "ImpuestoVehicular.findByValor", query = "SELECT i FROM ImpuestoVehicular i WHERE i.valor = :valor")})
public class ImpuestoVehicular implements Serializable {
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

    public ImpuestoVehicular() {
    }

    public ImpuestoVehicular(BigDecimal id) {
        this.id = id;
    }

    public ImpuestoVehicular(BigDecimal id, BigInteger vigencia, String periodo, String numeroTransaccion, String numeroFormulario, BigInteger referenciaPago, BigInteger valor) {
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
        if (!(object instanceof ImpuestoVehicular)) {
            return false;
        }
        ImpuestoVehicular other = (ImpuestoVehicular) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.ws.ImpuestoVehicular[ id=" + id + " ]";
    }

}
