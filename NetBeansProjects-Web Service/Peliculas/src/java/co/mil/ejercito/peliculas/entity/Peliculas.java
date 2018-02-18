

package co.mil.ejercito.peliculas.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 *Fecha     Sep 19, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "PELICULAS", catalog = "", schema = "PELICULAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peliculas.findAll", query = "SELECT p FROM Peliculas p"),
    @NamedQuery(name = "Peliculas.findByPeliculaId", query = "SELECT p FROM Peliculas p WHERE p.peliculaId = :peliculaId"),
    @NamedQuery(name = "Peliculas.findByTitulo", query = "SELECT p FROM Peliculas p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Peliculas.findByDescripcion", query = "SELECT p FROM Peliculas p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Peliculas.findByPrecio", query = "SELECT p FROM Peliculas p WHERE p.precio = :precio")})
public class Peliculas implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PELICULA_ID")
    private BigDecimal peliculaId;
    @Size(max = 70)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 254)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "PRECIO")
    private Double precio;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(optional = false)
    private Categoria categoryId;

    public Peliculas() {
    }

    public Peliculas(BigDecimal peliculaId) {
        this.peliculaId = peliculaId;
    }

    public BigDecimal getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(BigDecimal peliculaId) {
        this.peliculaId = peliculaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Categoria getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Categoria categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (peliculaId != null ? peliculaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peliculas)) {
            return false;
        }
        Peliculas other = (Peliculas) object;
        if ((this.peliculaId == null && other.peliculaId != null) || (this.peliculaId != null && !this.peliculaId.equals(other.peliculaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.peliculas.entity.Peliculas[ peliculaId=" + peliculaId + " ]";
    }

}
