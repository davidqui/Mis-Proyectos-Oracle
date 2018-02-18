

package co.mil.ejc.realstate.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 *Fecha     Sep 28, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "TIPO_VIVIENDAS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoViviendas.findAll", query = "SELECT t FROM TipoViviendas t"),
    @NamedQuery(name = "TipoViviendas.findByIdTVivienda", query = "SELECT t FROM TipoViviendas t WHERE t.idTVivienda = :idTVivienda"),
    @NamedQuery(name = "TipoViviendas.findByDescriV", query = "SELECT t FROM TipoViviendas t WHERE t.descriV = :descriV")})
public class TipoViviendas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_T_VIVIENDA")
    private BigDecimal idTVivienda;
    @Basic(optional = false)
    @Column(name = "DESCRI_V")
    private String descriV;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTVivienda")
    private List<DetalleViviendas> detalleViviendasList;

    public TipoViviendas() {
    }

    public TipoViviendas(BigDecimal idTVivienda) {
        this.idTVivienda = idTVivienda;
    }

    public TipoViviendas(BigDecimal idTVivienda, String descriV) {
        this.idTVivienda = idTVivienda;
        this.descriV = descriV;
    }

    public BigDecimal getIdTVivienda() {
        return idTVivienda;
    }

    public void setIdTVivienda(BigDecimal idTVivienda) {
        this.idTVivienda = idTVivienda;
    }

    public String getDescriV() {
        return descriV;
    }

    public void setDescriV(String descriV) {
        this.descriV = descriV;
    }

    @XmlTransient
    public List<DetalleViviendas> getDetalleViviendasList() {
        return detalleViviendasList;
    }

    public void setDetalleViviendasList(List<DetalleViviendas> detalleViviendasList) {
        this.detalleViviendasList = detalleViviendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTVivienda != null ? idTVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoViviendas)) {
            return false;
        }
        TipoViviendas other = (TipoViviendas) object;
        if ((this.idTVivienda == null && other.idTVivienda != null) || (this.idTVivienda != null && !this.idTVivienda.equals(other.idTVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejc.realstate.entity.TipoViviendas[ idTVivienda=" + idTVivienda + " ]";
    }

}
