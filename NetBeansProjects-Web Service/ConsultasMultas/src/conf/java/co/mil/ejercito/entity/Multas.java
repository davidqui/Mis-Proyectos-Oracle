

package co.mil.ejercito.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 *Fecha     Sep 8, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "MULTAS", catalog = "", schema = "MULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Multas.findAll", query = "SELECT m FROM Multas m"),
    @NamedQuery(name = "Multas.findById", query = "SELECT m FROM Multas m WHERE m.id = :id"),
    @NamedQuery(name = "Multas.findByDescripcion", query = "SELECT m FROM Multas m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "Multas.findByValor", query = "SELECT m FROM Multas m WHERE m.valor = :valor")})
public class Multas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "VALOR")
    private String valor;
    @JoinColumn(name = "ID_CIUDADANO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ciudadano idCiudadano;

    public Multas() {
    }

    public Multas(BigDecimal id) {
        this.id = id;
    }

    public Multas(BigDecimal id, String descripcion, String valor) {
        this.id = id;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
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
        if (!(object instanceof Multas)) {
            return false;
        }
        Multas other = (Multas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.ws.Multas[ id=" + id + " ]";
    }

}
