package com.coord.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "basin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basin.findAll", query = "SELECT b FROM Basin b"),
    @NamedQuery(name = "Basin.findById", query = "SELECT b FROM Basin b WHERE b.id = :id"),
    @NamedQuery(name = "Basin.findByName", query = "SELECT b FROM Basin b WHERE b.name = :name")})

public class Basin implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @OneToMany(mappedBy = "idBasin")
    private Collection<Block> blockCollection;

    public Basin() {
    }

    public Basin(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Block> getBlockCollection() {
        return blockCollection;
    }

    public void setBlockCollection(Collection<Block> blockCollection) {
        this.blockCollection = blockCollection;
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
        if (!(object instanceof Basin)) {
            return false;
        }
        Basin other = (Basin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.coord.model.Basin[ id=" + id + " ]";
    }
    
}
