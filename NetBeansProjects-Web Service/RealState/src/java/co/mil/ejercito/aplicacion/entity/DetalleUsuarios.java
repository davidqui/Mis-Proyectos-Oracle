

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "DETALLE_USUARIOS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleUsuarios.findAll", query = "SELECT d FROM DetalleUsuarios d"),
    @NamedQuery(name = "DetalleUsuarios.findByIdDetaCliente", query = "SELECT d FROM DetalleUsuarios d WHERE d.idDetaCliente = :idDetaCliente"),
    @NamedQuery(name = "DetalleUsuarios.findByMensaje", query = "SELECT d FROM DetalleUsuarios d WHERE d.mensaje = :mensaje")})
public class DetalleUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DETA_CLIENTE")
    private BigDecimal idDetaCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "MENSAJE")
    private String mensaje;
    @JoinColumns({
        @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER"),
        @JoinColumn(name = "CLI_USER", referencedColumnName = "CLI_USER")})
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public DetalleUsuarios() {
    }

    public DetalleUsuarios(BigDecimal idDetaCliente) {
        this.idDetaCliente = idDetaCliente;
    }

    public DetalleUsuarios(BigDecimal idDetaCliente, String mensaje) {
        this.idDetaCliente = idDetaCliente;
        this.mensaje = mensaje;
    }

    public BigDecimal getIdDetaCliente() {
        return idDetaCliente;
    }

    public void setIdDetaCliente(BigDecimal idDetaCliente) {
        this.idDetaCliente = idDetaCliente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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
        hash += (idDetaCliente != null ? idDetaCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleUsuarios)) {
            return false;
        }
        DetalleUsuarios other = (DetalleUsuarios) object;
        if ((this.idDetaCliente == null && other.idDetaCliente != null) || (this.idDetaCliente != null && !this.idDetaCliente.equals(other.idDetaCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.DetalleUsuarios[ idDetaCliente=" + idDetaCliente + " ]";
    }

}
