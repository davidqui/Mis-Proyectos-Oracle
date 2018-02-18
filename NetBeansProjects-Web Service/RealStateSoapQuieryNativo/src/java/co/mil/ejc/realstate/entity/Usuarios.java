

package co.mil.ejc.realstate.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "USUARIOS", catalog = "", schema = "REALDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByIdUser", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.idUser = :idUser"),
    @NamedQuery(name = "Usuarios.findByCliUser", query = "SELECT u FROM Usuarios u WHERE u.usuariosPK.cliUser = :cliUser"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByDirU", query = "SELECT u FROM Usuarios u WHERE u.dirU = :dirU"),
    @NamedQuery(name = "Usuarios.findByTeleU", query = "SELECT u FROM Usuarios u WHERE u.teleU = :teleU"),
    @NamedQuery(name = "Usuarios.findByCelU", query = "SELECT u FROM Usuarios u WHERE u.celU = :celU"),
    @NamedQuery(name = "Usuarios.findByCorreoU", query = "SELECT u FROM Usuarios u WHERE u.correoU = :correoU"),
    @NamedQuery(name = "Usuarios.findByPais", query = "SELECT u FROM Usuarios u WHERE u.pais = :pais"),
    @NamedQuery(name = "Usuarios.findByPassU", query = "SELECT u FROM Usuarios u WHERE u.passU = :passU")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuariosPK usuariosPK;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Basic(optional = false)
    @Column(name = "DIR_U")
    private String dirU;
    @Basic(optional = false)
    @Column(name = "TELE_U")
    private String teleU;
    @Basic(optional = false)
    @Column(name = "CEL_U")
    private String celU;
    @Basic(optional = false)
    @Column(name = "CORREO_U")
    private String correoU;
    @Basic(optional = false)
    @Column(name = "PAIS")
    private String pais;
    @Basic(optional = false)
    @Column(name = "PASS_U")
    private String passU;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<DetalleUsuarios> detalleUsuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<ConsultaViviendas> consultaViviendasList;

    public Usuarios() {
    }

    public Usuarios(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public Usuarios(UsuariosPK usuariosPK, String nombres, String apellidos, String dirU, String teleU, String celU, String correoU, String pais, String passU) {
        this.usuariosPK = usuariosPK;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dirU = dirU;
        this.teleU = teleU;
        this.celU = celU;
        this.correoU = correoU;
        this.pais = pais;
        this.passU = passU;
    }

    public Usuarios(BigInteger idUser, BigInteger cliUser) {
        this.usuariosPK = new UsuariosPK(idUser, cliUser);
    }

    public UsuariosPK getUsuariosPK() {
        return usuariosPK;
    }

    public void setUsuariosPK(UsuariosPK usuariosPK) {
        this.usuariosPK = usuariosPK;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirU() {
        return dirU;
    }

    public void setDirU(String dirU) {
        this.dirU = dirU;
    }

    public String getTeleU() {
        return teleU;
    }

    public void setTeleU(String teleU) {
        this.teleU = teleU;
    }

    public String getCelU() {
        return celU;
    }

    public void setCelU(String celU) {
        this.celU = celU;
    }

    public String getCorreoU() {
        return correoU;
    }

    public void setCorreoU(String correoU) {
        this.correoU = correoU;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPassU() {
        return passU;
    }

    public void setPassU(String passU) {
        this.passU = passU;
    }

    @XmlTransient
    public List<DetalleUsuarios> getDetalleUsuariosList() {
        return detalleUsuariosList;
    }

    public void setDetalleUsuariosList(List<DetalleUsuarios> detalleUsuariosList) {
        this.detalleUsuariosList = detalleUsuariosList;
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
        hash += (usuariosPK != null ? usuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuariosPK == null && other.usuariosPK != null) || (this.usuariosPK != null && !this.usuariosPK.equals(other.usuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejc.realstate.entity.Usuarios[ usuariosPK=" + usuariosPK + " ]";
    }

}
