

package co.mil.ejercito.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 25, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "RESERVAS", catalog = "", schema = "PELICULAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservas.findAll", query = "SELECT r FROM Reservas r"),
    @NamedQuery(name = "Reservas.findByOrderId", query = "SELECT r FROM Reservas r WHERE r.orderId = :orderId"),
    @NamedQuery(name = "Reservas.findByDescripcion", query = "SELECT r FROM Reservas r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reservas.findByFuncion", query = "SELECT r FROM Reservas r WHERE r.funcion = :funcion"),
    @NamedQuery(name = "Reservas.findByUbicacion", query = "SELECT r FROM Reservas r WHERE r.ubicacion = :ubicacion"),
    @NamedQuery(name = "Reservas.findByConfirmacion", query = "SELECT r FROM Reservas r WHERE r.confirmacion = :confirmacion")})
public class Reservas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDER_ID")
    //PORQUE LA INGENIERIA EN REVERSA NO ASOCIA LA SECUENCIA SE LA INCLUIMOS MANUAL
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%|  AÑADIMOS LA SECUENCIA |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESERVAS_SEQ")          //     |
    @SequenceGenerator(sequenceName = "RESERVAS_SEQ", allocationSize = 1, name = "RESERVAS_SEQ")//  |
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%|  AÑADIMOS LA SECUENCIA |%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    
    private BigDecimal orderId;
    @Size(max = 70)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 254)
    @Column(name = "FUNCION")
    private String funcion;
    @Size(max = 254)
    @Column(name = "UBICACION")
    private String ubicacion;
    @Size(max = 20)
    @Column(name = "CONFIRMACION")
    private String confirmacion;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuarios id;

    public Reservas() {
    }

    public Reservas(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getOrderId() {
        return orderId;
    }

    public void setOrderId(BigDecimal orderId) {
        this.orderId = orderId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public Usuarios getId() {
        return id;
    }

    public void setId(Usuarios id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservas)) {
            return false;
        }
        Reservas other = (Reservas) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.entity.Reservas[ orderId=" + orderId + " ]";
    }

}
