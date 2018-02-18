

package co.mil.ejercito.aplicacion.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "INFORMACION_EMPRESA", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformacionEmpresa.findAll", query = "SELECT i FROM InformacionEmpresa i"),
    @NamedQuery(name = "InformacionEmpresa.findByNit", query = "SELECT i FROM InformacionEmpresa i WHERE i.nit = :nit"),
    @NamedQuery(name = "InformacionEmpresa.findByDireEmp", query = "SELECT i FROM InformacionEmpresa i WHERE i.direEmp = :direEmp"),
    @NamedQuery(name = "InformacionEmpresa.findByTelEmp", query = "SELECT i FROM InformacionEmpresa i WHERE i.telEmp = :telEmp"),
    @NamedQuery(name = "InformacionEmpresa.findByCelular", query = "SELECT i FROM InformacionEmpresa i WHERE i.celular = :celular"),
    @NamedQuery(name = "InformacionEmpresa.findByEmal", query = "SELECT i FROM InformacionEmpresa i WHERE i.emal = :emal"),
    @NamedQuery(name = "InformacionEmpresa.findByFax", query = "SELECT i FROM InformacionEmpresa i WHERE i.fax = :fax"),
    @NamedQuery(name = "InformacionEmpresa.findByUrl", query = "SELECT i FROM InformacionEmpresa i WHERE i.url = :url"),
    @NamedQuery(name = "InformacionEmpresa.findByAbout", query = "SELECT i FROM InformacionEmpresa i WHERE i.about = :about"),
    @NamedQuery(name = "InformacionEmpresa.findByRequest", query = "SELECT i FROM InformacionEmpresa i WHERE i.request = :request")})
public class InformacionEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NIT")
    private String nit;
    @Size(max = 50)
    @Column(name = "DIRE_EMP")
    private String direEmp;
    @Size(max = 20)
    @Column(name = "TEL_EMP")
    private String telEmp;
    @Size(max = 15)
    @Column(name = "CELULAR")
    private String celular;
    @Size(max = 15)
    @Column(name = "EMAL")
    private String emal;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "FAX")
    private String fax;
    @Size(max = 100)
    @Column(name = "URL")
    private String url;
    @Size(max = 400)
    @Column(name = "ABOUT")
    private String about;
    @Size(max = 400)
    @Column(name = "REQUEST")
    private String request;

    public InformacionEmpresa() {
    }

    public InformacionEmpresa(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireEmp() {
        return direEmp;
    }

    public void setDireEmp(String direEmp) {
        this.direEmp = direEmp;
    }

    public String getTelEmp() {
        return telEmp;
    }

    public void setTelEmp(String telEmp) {
        this.telEmp = telEmp;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmal() {
        return emal;
    }

    public void setEmal(String emal) {
        this.emal = emal;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformacionEmpresa)) {
            return false;
        }
        InformacionEmpresa other = (InformacionEmpresa) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.InformacionEmpresa[ nit=" + nit + " ]";
    }

}
