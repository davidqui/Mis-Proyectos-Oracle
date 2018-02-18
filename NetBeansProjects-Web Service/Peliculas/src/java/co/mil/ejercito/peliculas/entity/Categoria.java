

package co.mil.ejercito.peliculas.entity;

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
 *Fecha     Sep 19, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
@Entity
@Table(name = "CATEGORIA", catalog = "", schema = "PELICULAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCategoryId", query = "SELECT c FROM Categoria c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Categoria.findByCategoryName", query = "SELECT c FROM Categoria c WHERE c.categoryName = :categoryName")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CATEGORY_ID")
    private BigDecimal categoryId;
    @Size(max = 70)
    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<Peliculas> peliculasList;

    public Categoria() {
    }

    public Categoria(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @XmlTransient
    public List<Peliculas> getPeliculasList() {
        return peliculasList;
    }

    public void setPeliculasList(List<Peliculas> peliculasList) {
        this.peliculasList = peliculasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.peliculas.entity.Categoria[ categoryId=" + categoryId + " ]";
    }

}
