package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.DepartmentEJB;
import com.ec.mthonec.entities.Department;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class DepartmentBean implements Serializable {

    @EJB
    private DepartmentEJB departmentEJB;
    private Department department = new Department();

    public List<Department> getDepartments() {
        return departmentEJB.getAllDepartments();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void saveDepartment() {
        departmentEJB.createDepartment(department);
        department = new Department(); // Clear the object after saving
    }

    public void updateDepartment() {
        departmentEJB.updateDepartment(department);
    }

    public void deleteDepartment(Department department) {
        departmentEJB.deleteDepartment(department);
    }

    // Add additional methods as needed for the CRUD operations
}
