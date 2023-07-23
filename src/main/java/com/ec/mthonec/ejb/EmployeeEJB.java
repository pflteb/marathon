package com.ec.mthonec.ejb;

import com.ec.mthonec.entities.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeEJB {
    
    @PersistenceContext
    private EntityManager em;

    public void createEmployee(Employee employee) {
        em.persist(employee);
    }

    public Employee getEmployeeById(Long id) {
        return em.find(Employee.class, id);
    }

    public void updateEmployee(Employee employee) {
        em.merge(employee);
    }

    public void deleteEmployee(Employee employee) {
        em.remove(em.merge(employee));
    }

    public List<Employee> getAllEmployees() {
        return em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    // Add additional methods as needed for the CRUD operations
}
