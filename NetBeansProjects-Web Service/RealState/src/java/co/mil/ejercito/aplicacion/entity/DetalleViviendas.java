

package co.mil.ejercito.aplicacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "DETALLE_VIVIENDAS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleViviendas.findAll", query = "SELECT d FROM DetalleViviendas d"),
    @NamedQuery(name = "DetalleViviendas.findByIdDetaVivienda", query = "SELECT d FROM DetalleViviendas d WHERE d.idDetaVivienda = :idDetaVivienda"),
    @NamedQuery(name = "DetalleViviendas.findByPrecio", query = "SELECT d FROM DetalleViviendas d WHERE d.precio = :precio")})
public class DetalleViviendas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETA_VIVIENDA")
    private BigDecimal idDetaVivienda;
    @Column(name = "PRECIO")
    private BigInteger precio;
    @JoinColumn(name = "ID_DESCR_VIVIENDA", referencedColumnName = "ID_DESCR_VIVIENDA")
    @ManyToOne(optional = false)
    private DescripcionViviendas idDescrVivienda;
    @JoinColumn(name = "ID_CONTRATO", referencedColumnName = "ID_CONTRATO")
    @ManyToOne(optional = false)
    private TipoContratos idContrato;
    @JoinColumn(name = "ID_T_VIVIENDA", referencedColumnName = "ID_T_VIVIENDA")
    @ManyToOne(optional = false)
    private TipoViviendas idTVivienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetaVivienda")
    private List<ConsultaViviendas> consultaViviendasList;

    public DetalleViviendas() {
    }

    public DetalleViviendas(BigDecimal idDetaVivienda) {
        this.idDetaVivienda = idDetaVivienda;
    }

    public BigDecimal getIdDetaVivienda() {
        return idDetaVivienda;
    }

    public void setIdDetaVivienda(BigDecimal idDetaVivienda) {
        this.idDetaVivienda = idDetaVivienda;
    }

    public BigInteger getPrecio() {
        return precio;
    }

    public void setPrecio(BigInteger precio) {
        this.precio = precio;
    }

    public DescripcionViviendas getIdDescrVivienda() {
        return idDescrVivienda;
    }

    public void setIdDescrVivienda(DescripcionViviendas idDescrVivienda) {
        this.idDescrVivienda = idDescrVivienda;
    }

    public TipoContratos getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(TipoContratos idContrato) {
        this.idContrato = idContrato;
    }

    public TipoViviendas getIdTVivienda() {
        return idTVivienda;
    }

    public void setIdTVivienda(TipoViviendas idTVivienda) {
        this.idTVivienda = idTVivienda;
    }

    @XmlTransient
    public List<ConsultaViviendas> getConsultaViviendasList() {
        return consultaViviendasList;
    }

    public void setConsultaViviendasList(List<ConsultaViviendas> consultaViviendasList) {
        this.consultaViviendasList = consultaViviendasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetaVivienda != null ? idDetaVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleViviendas)) {
            return false;
        }
        DetalleViviendas other = (DetalleViviendas) object;
        if ((this.idDetaVivienda == null && other.idDetaVivienda != null) || (this.idDetaVivienda != null && !this.idDetaVivienda.equals(other.idDetaVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.DetalleViviendas[ idDetaVivienda=" + idDetaVivienda + " ]";
    }

}
