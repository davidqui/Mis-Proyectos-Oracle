

package co.mil.ejercito.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 *Fecha     Sep 8, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "CIUDADANO", catalog = "", schema = "MULTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ciudadano.findAll", query = "SELECT c FROM Ciudadano c"),
    @NamedQuery(name = "Ciudadano.findById", query = "SELECT c FROM Ciudadano c WHERE c.id = :id"),
    @NamedQuery(name = "Ciudadano.findByNombre", query = "SELECT c FROM Ciudadano c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Ciudadano.findByApellido", query = "SELECT c FROM Ciudadano c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Ciudadano.findByEmail", query = "SELECT c FROM Ciudadano c WHERE c.email = :email"),
    @NamedQuery(name = "Ciudadano.findByTelefono", query = "SELECT c FROM Ciudadano c WHERE c.telefono = :telefono")})
public class Ciudadano implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIUDADANO_SEQ")
    @SequenceGenerator(sequenceName = "CIUDADANO_SEQUENCE", allocationSize = 1, name = "CIUDADANO_SEQ")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "APELLIDO")
    private String apellido;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "TELEFONO")
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCiudadano")
    private List<Multas> multasList;

    public Ciudadano() {
    }

    public Ciudadano(BigDecimal id) {
        this.id = id;
    }

    public Ciudadano(BigDecimal id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Multas> getMultasList() {
        return multasList;
    }

    public void setMultasList(List<Multas> multasList) {
        this.multasList = multasList;
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
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.ws.Ciudadano[ id=" + id + " ]";
    }

}
