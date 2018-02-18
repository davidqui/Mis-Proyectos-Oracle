

package co.mil.ejercito.aplicacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 *Fecha     Sep 27, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Embeddable
public class UsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private BigInteger idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLI_USER")
    private BigInteger cliUser;

    public UsuariosPK() {
    }

    public UsuariosPK(BigInteger idUser, BigInteger cliUser) {
        this.idUser = idUser;
        this.cliUser = cliUser;
    }

    public BigInteger getIdUser() {
        return idUser;
    }

    public void setIdUser(BigInteger idUser) {
        this.idUser = idUser;
    }

    public BigInteger getCliUser() {
        return cliUser;
    }

    public void setCliUser(BigInteger cliUser) {
        this.cliUser = cliUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        hash += (cliUser != null ? cliUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosPK)) {
            return false;
        }
        UsuariosPK other = (UsuariosPK) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        if ((this.cliUser == null && other.cliUser != null) || (this.cliUser != null && !this.cliUser.equals(other.cliUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.aplicacion.entity.UsuariosPK[ idUser=" + idUser + ", cliUser=" + cliUser + " ]";
    }

}
