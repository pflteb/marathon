/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.marathon.ejb;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author esteb
 */
@Entity
@Table(name = "enterprises")
@NamedQueries({
    @NamedQuery(name = "Enterprises.findAll", query = "SELECT e FROM Enterprises e"),
    @NamedQuery(name = "Enterprises.findById", query = "SELECT e FROM Enterprises e WHERE e.id = :id"),
    @NamedQuery(name = "Enterprises.findByCreatedBy", query = "SELECT e FROM Enterprises e WHERE e.createdBy = :createdBy"),
    @NamedQuery(name = "Enterprises.findByCreatedDate", query = "SELECT e FROM Enterprises e WHERE e.createdDate = :createdDate"),
    @NamedQuery(name = "Enterprises.findByModifiedBy", query = "SELECT e FROM Enterprises e WHERE e.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Enterprises.findByModifiedDate", query = "SELECT e FROM Enterprises e WHERE e.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "Enterprises.findByStatus", query = "SELECT e FROM Enterprises e WHERE e.status = :status"),
    @NamedQuery(name = "Enterprises.findByAddress", query = "SELECT e FROM Enterprises e WHERE e.address = :address"),
    @NamedQuery(name = "Enterprises.findByName", query = "SELECT e FROM Enterprises e WHERE e.name = :name"),
    @NamedQuery(name = "Enterprises.findByPhone", query = "SELECT e FROM Enterprises e WHERE e.phone = :phone")})
public class Enterprises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Size(max = 50)
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Column(name = "status")
    private Boolean status;
    @Size(max = 100)
    @Column(name = "address")
    private String address;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "phone")
    private String phone;

    public Enterprises() {
    }

    public Enterprises(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
        if (!(object instanceof Enterprises)) {
            return false;
        }
        Enterprises other = (Enterprises) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.marathon.ejb.Enterprises[ id=" + id + " ]";
    }
    
}
