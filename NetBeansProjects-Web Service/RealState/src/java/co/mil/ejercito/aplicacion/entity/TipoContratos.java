

package co.mil.ejercito.aplicacion.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "TIPO_CONTRATOS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoContratos.findAll", query = "SELECT t FROM TipoContratos t"),
    @NamedQuery(name = "TipoContratos.findByIdContrato", query = "SELECT t FROM TipoContratos t WHERE t.idContrato = :idContrato"),
    @NamedQuery(name = "TipoContratos.findByDescriC", query = "SELECT t FROM TipoContratos t WHERE t.descriC = :descriC")})
public class TipoContratos implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONTRATO")
    private BigDecimal idContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRI_C")
    private String descriC;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idContrato")
    private List<DetalleViviendas> detalleViviendasList;

    public TipoContratos() {
    }

    public TipoContratos(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

    public TipoContratos(BigDecimal idContrato, String descriC) {
        this.idContrato = idContrato;
        this.descriC = descriC;
    }

    public BigDecimal getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(BigDecimal idContrato) {
        this.idContrato = idContrato;
    }

    public String getDescriC() {
        return descriC;
    }

    public void setDescriC(String descriC) {
        this.descriC = descriC;
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
        hash += (idContrato != null ? idContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoContratos)) {
            return false;
        }
        TipoContratos other = (TipoContratos) object;
        if ((this.idContrato == null && other.idContrato != null) || (this.idContrato != null && !this.idContrato.equals(other.idContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.TipoContratos[ idContrato=" + idContrato + " ]";
    }

}
