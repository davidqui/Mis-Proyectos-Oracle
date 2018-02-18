

package co.gov.policia.entity;

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
 *Fecha     Sep 25, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "ANTECEDENTES", catalog = "", schema = "POLICIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Antecedentes.findAll", query = "SELECT a FROM Antecedentes a"),
    @NamedQuery(name = "Antecedentes.findById", query = "SELECT a FROM Antecedentes a WHERE a.id = :id"),
    @NamedQuery(name = "Antecedentes.findByNombre", query = "SELECT a FROM Antecedentes a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Antecedentes.findByDescripcion", query = "SELECT a FROM Antecedentes a WHERE a.descripcion = :descripcion")})
public class Antecedentes implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 254)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 254)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "CEDULA", referencedColumnName = "CEDULA")
    @ManyToOne(optional = false)
    private Ciudadano cedula;

    public Antecedentes() {
    }

    public Antecedentes(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ciudadano getCedula() {
        return cedula;
    }

    public void setCedula(Ciudadano cedula) {
        this.cedula = cedula;
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
        if (!(object instanceof Antecedentes)) {
            return false;
        }
        Antecedentes other = (Antecedentes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.policia.entity.Antecedentes[ id=" + id + " ]";
    }

}
