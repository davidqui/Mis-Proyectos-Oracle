

package co.gov.policia.entity;

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
 *Fecha     Sep 25, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "CIUDADANO", catalog = "", schema = "POLICIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findByCedula", query = "SELECT c FROM Ciudadano c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Ciudadano.findByNombre", query = "SELECT c FROM Ciudadano c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ciudadano.findByApellido", query = "SELECT c FROM Ciudadano c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Ciudadano.findByDireccion", query = "SELECT c FROM Ciudadano c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Ciudadano.findByEmail", query = "SELECT c FROM Ciudadano c WHERE c.email = :email")})
public class Ciudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CEDULA")
    private BigDecimal cedula;
    @Size(max = 254)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 254)
    @Column(name = "APELLIDO")
    private String apellido;
    @Size(max = 254)
    @Column(name = "DIRECCION")
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula")
    private List<Antecedentes> antecedentesList;

    public Ciudadano() {
    }

    public Ciudadano(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public BigDecimal getCedula() {
        return cedula;
    }

    public void setCedula(BigDecimal cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Antecedentes> getAntecedentesList() {
        return antecedentesList;
    }

    public void setAntecedentesList(List<Antecedentes> antecedentesList) {
        this.antecedentesList = antecedentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.gov.policia.entity.Ciudadano[ cedula=" + cedula + " ]";
    }

}
