

package co.mil.ejc.realstate.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "DESCRIPCION_VIVIENDAS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescripcionViviendas.findAll", query = "SELECT d FROM DescripcionViviendas d"),
    @NamedQuery(name = "DescripcionViviendas.findByIdDescrVivienda", query = "SELECT d FROM DescripcionViviendas d WHERE d.idDescrVivienda = :idDescrVivienda"),
    @NamedQuery(name = "DescripcionViviendas.findByCantBanos", query = "SELECT d FROM DescripcionViviendas d WHERE d.cantBanos = :cantBanos"),
    @NamedQuery(name = "DescripcionViviendas.findByCantHabitaciones", query = "SELECT d FROM DescripcionViviendas d WHERE d.cantHabitaciones = :cantHabitaciones"),
    @NamedQuery(name = "DescripcionViviendas.findByCantPisos", query = "SELECT d FROM DescripcionViviendas d WHERE d.cantPisos = :cantPisos"),
    @NamedQuery(name = "DescripcionViviendas.findByUbicacionPiso", query = "SELECT d FROM DescripcionViviendas d WHERE d.ubicacionPiso = :ubicacionPiso"),
    @NamedQuery(name = "DescripcionViviendas.findByGaraje", query = "SELECT d FROM DescripcionViviendas d WHERE d.garaje = :garaje"),
    @NamedQuery(name = "DescripcionViviendas.findByGas", query = "SELECT d FROM DescripcionViviendas d WHERE d.gas = :gas"),
    @NamedQuery(name = "DescripcionViviendas.findByEnergia", query = "SELECT d FROM DescripcionViviendas d WHERE d.energia = :energia"),
    @NamedQuery(name = "DescripcionViviendas.findByAgua", query = "SELECT d FROM DescripcionViviendas d WHERE d.agua = :agua"),
    @NamedQuery(name = "DescripcionViviendas.findByDireccion", query = "SELECT d FROM DescripcionViviendas d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "DescripcionViviendas.findByDescripcion", query = "SELECT d FROM DescripcionViviendas d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DescripcionViviendas.findByCiudad", query = "SELECT d FROM DescripcionViviendas d WHERE d.ciudad = :ciudad"),
    @NamedQuery(name = "DescripcionViviendas.findByDepartamento", query = "SELECT d FROM DescripcionViviendas d WHERE d.departamento = :departamento"),
    @NamedQuery(name = "DescripcionViviendas.findByAnoConst", query = "SELECT d FROM DescripcionViviendas d WHERE d.anoConst = :anoConst"),
    @NamedQuery(name = "DescripcionViviendas.findByAreaConst", query = "SELECT d FROM DescripcionViviendas d WHERE d.areaConst = :areaConst")})
public class DescripcionViviendas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DESCR_VIVIENDA")
    private BigDecimal idDescrVivienda;
    @Column(name = "CANT_BANOS")
    private BigInteger cantBanos;
    @Column(name = "CANT_HABITACIONES")
    private BigInteger cantHabitaciones;
    @Column(name = "CANT_PISOS")
    private BigInteger cantPisos;
    @Column(name = "UBICACION_PISO")
    private String ubicacionPiso;
    @Column(name = "GARAJE")
    private String garaje;
    @Column(name = "GAS")
    private String gas;
    @Column(name = "ENERGIA")
    private String energia;
    @Column(name = "AGUA")
    private String agua;
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CIUDAD")
    private String ciudad;
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Column(name = "ANO_CONST")
    private String anoConst;
    @Column(name = "AREA_CONST")
    private String areaConst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDescrVivienda")
    private List<DetalleViviendas> detalleViviendasList;

    public DescripcionViviendas() {
    }

    public DescripcionViviendas(BigDecimal idDescrVivienda) {
        this.idDescrVivienda = idDescrVivienda;
    }

    public BigDecimal getIdDescrVivienda() {
        return idDescrVivienda;
    }

    public void setIdDescrVivienda(BigDecimal idDescrVivienda) {
        this.idDescrVivienda = idDescrVivienda;
    }

    public BigInteger getCantBanos() {
        return cantBanos;
    }

    public void setCantBanos(BigInteger cantBanos) {
        this.cantBanos = cantBanos;
    }

    public BigInteger getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(BigInteger cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }

    public BigInteger getCantPisos() {
        return cantPisos;
    }

    public void setCantPisos(BigInteger cantPisos) {
        this.cantPisos = cantPisos;
    }

    public String getUbicacionPiso() {
        return ubicacionPiso;
    }

    public void setUbicacionPiso(String ubicacionPiso) {
        this.ubicacionPiso = ubicacionPiso;
    }

    public String getGaraje() {
        return garaje;
    }

    public void setGaraje(String garaje) {
        this.garaje = garaje;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getEnergia() {
        return energia;
    }

    public void setEnergia(String energia) {
        this.energia = energia;
    }

    public String getAgua() {
        return agua;
    }

    public void setAgua(String agua) {
        this.agua = agua;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAnoConst() {
        return anoConst;
    }

    public void setAnoConst(String anoConst) {
        this.anoConst = anoConst;
    }

    public String getAreaConst() {
        return areaConst;
    }

    public void setAreaConst(String areaConst) {
        this.areaConst = areaConst;
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
        hash += (idDescrVivienda != null ? idDescrVivienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescripcionViviendas)) {
            return false;
        }
        DescripcionViviendas other = (DescripcionViviendas) object;
        if ((this.idDescrVivienda == null && other.idDescrVivienda != null) || (this.idDescrVivienda != null && !this.idDescrVivienda.equals(other.idDescrVivienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejc.realstate.entity.DescripcionViviendas[ idDescrVivienda=" + idDescrVivienda + " ]";
    }

}
