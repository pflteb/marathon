package com.ec.mthonec.ejb;

import com.ec.mthonec.entities.Department;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

@Stateless
public class DepartmentEJB {

    @PersistenceContext
    private EntityManager em;

    public void createDepartment(Department department) {
        em.persist(department);
    }

    public Department getDepartmentById(Long id) {
        return em.find(Department.class, id);
    }

    public void updateDepartment(Department department) {
        em.merge(department);
    }

    public void deleteDepartment(Department department) {
        em.remove(em.merge(department));
    }

    public List<Department> getAllDepartments() {
        return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }

    public List<Department> getAllDepartmentsJoinEnterprise() {
        String jpaQl = "SELECT d.`name`, d.phone, d.`status`, d.description, e.`name` FROM departments d JOIN enterprises e ON d.id_enterprise = e.id";
        return em.createNativeQuery(jpaQl, Department.class).getResultList();
    }

    // Add additional methods as needed for the CRUD operations
}
