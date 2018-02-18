/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mil.ejercito.hosting.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author oracle
 */
@Entity
@Table(name = "EMAIL_FEATURES", catalog = "", schema = "HOSTING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmailFeatures.findAll", query = "SELECT e FROM EmailFeatures e")
    , @NamedQuery(name = "EmailFeatures.findById", query = "SELECT e FROM EmailFeatures e WHERE e.id = :id")
    , @NamedQuery(name = "EmailFeatures.findByFeatures", query = "SELECT e FROM EmailFeatures e WHERE e.features = :features")
    , @NamedQuery(name = "EmailFeatures.findByPlanOne", query = "SELECT e FROM EmailFeatures e WHERE e.planOne = :planOne")
    , @NamedQuery(name = "EmailFeatures.findByPlanTwo", query = "SELECT e FROM EmailFeatures e WHERE e.planTwo = :planTwo")
    , @NamedQuery(name = "EmailFeatures.findByPlanThree", query = "SELECT e FROM EmailFeatures e WHERE e.planThree = :planThree")})
public class EmailFeatures implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FEATURES")
    private String features;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLAN_ONE")
    private String planOne;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLAN_TWO")
    private String planTwo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PLAN_THREE")
    private String planThree;

    public EmailFeatures() {
    }

    public EmailFeatures(BigDecimal id) {
        this.id = id;
    }

    public EmailFeatures(BigDecimal id, String features, String planOne, String planTwo, String planThree) {
        this.id = id;
        this.features = features;
        this.planOne = planOne;
        this.planTwo = planTwo;
        this.planThree = planThree;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getPlanOne() {
        return planOne;
    }

    public void setPlanOne(String planOne) {
        this.planOne = planOne;
    }

    public String getPlanTwo() {
        return planTwo;
    }

    public void setPlanTwo(String planTwo) {
        this.planTwo = planTwo;
    }

    public String getPlanThree() {
        return planThree;
    }

    public void setPlanThree(String planThree) {
        this.planThree = planThree;
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
        if (!(object instanceof EmailFeatures)) {
            return false;
        }
        EmailFeatures other = (EmailFeatures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mil.ejercito.hosting.entity.EmailFeatures[ id=" + id + " ]";
    }
    
}
