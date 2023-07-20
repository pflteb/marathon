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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departments_employees")
@NamedQueries({
    @NamedQuery(name = "DepartmentsEmployees.findAll", query = "SELECT d FROM DepartmentsEmployees d"),
    @NamedQuery(name = "DepartmentsEmployees.findById", query = "SELECT d FROM DepartmentsEmployees d WHERE d.id = :id"),
    @NamedQuery(name = "DepartmentsEmployees.findByCreatedBy", query = "SELECT d FROM DepartmentsEmployees d WHERE d.createdBy = :createdBy"),
    @NamedQuery(name = "DepartmentsEmployees.findByCreatedDate", query = "SELECT d FROM DepartmentsEmployees d WHERE d.createdDate = :createdDate"),
    @NamedQuery(name = "DepartmentsEmployees.findByModifiedBy", query = "SELECT d FROM DepartmentsEmployees d WHERE d.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "DepartmentsEmployees.findByModifiedDate", query = "SELECT d FROM DepartmentsEmployees d WHERE d.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "DepartmentsEmployees.findByStatus", query = "SELECT d FROM DepartmentsEmployees d WHERE d.status = :status"),
    @NamedQuery(name = "DepartmentsEmployees.findByIdEmployee", query = "SELECT d FROM DepartmentsEmployees d WHERE d.idEmployee = :idEmployee")})
public class DepartmentsEmployees implements Serializable {

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
    @Column(name = "id_employee")
    private Integer idEmployee;
    @JoinColumn(name = "id_department", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departments idDepartment;

    public DepartmentsEmployees() {
    }

    public DepartmentsEmployees(Integer id) {
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

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Departments getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Departments idDepartment) {
        this.idDepartment = idDepartment;
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
        if (!(object instanceof DepartmentsEmployees)) {
            return false;
        }
        DepartmentsEmployees other = (DepartmentsEmployees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.com.marathon.ejb.DepartmentsEmployees[ id=" + id + " ]";
    }
    
}
