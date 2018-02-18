

package co.mil.ejercito.aplicacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "CONSULTA_VIVIENDAS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConsultaViviendas.findAll", query = "SELECT c FROM ConsultaViviendas c"),
    @NamedQuery(name = "ConsultaViviendas.findByIdConsulta", query = "SELECT c FROM ConsultaViviendas c WHERE c.idConsulta = :idConsulta")})
public class ConsultaViviendas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONSULTA")
    private BigDecimal idConsulta;
    @JoinColumn(name = "ID_DETA_VIVIENDA", referencedColumnName = "ID_DETA_VIVIENDA")
    @ManyToOne(optional = false)
    private DetalleViviendas idDetaVivienda;
    @JoinColumns({
        @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER"),
        @JoinColumn(name = "CLI_USER", referencedColumnName = "CLI_USER")})
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public ConsultaViviendas() {
    }

    public ConsultaViviendas(BigDecimal idConsulta) {
        this.idConsulta = idConsulta;
    }

    public BigDecimal getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(BigDecimal idConsulta) {
        this.idConsulta = idConsulta;
    }

    public DetalleViviendas getIdDetaVivienda() {
        return idDetaVivienda;
    }

    public void setIdDetaVivienda(DetalleViviendas idDetaVivienda) {
        this.idDetaVivienda = idDetaVivienda;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConsultaViviendas)) {
            return false;
        }
        ConsultaViviendas other = (ConsultaViviendas) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.ConsultaViviendas[ idConsulta=" + idConsulta + " ]";
    }

}
