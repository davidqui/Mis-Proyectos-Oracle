

package co.mil.ejc.realstate.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 28, 2017
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
    @Column(name = "NIT")
    private String nit;
    @Column(name = "DIRE_EMP")
    private String direEmp;
    @Column(name = "TEL_EMP")
    private String telEmp;
    @Column(name = "CELULAR")
    private String celular;
    @Column(name = "EMAL")
    private String emal;
    @Column(name = "FAX")
    private String fax;
    @Column(name = "URL")
    private String url;
    @Column(name = "ABOUT")
    private String about;
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
        return "co.mil.ejc.realstate.entity.InformacionEmpresa[ nit=" + nit + " ]";
    }

}
