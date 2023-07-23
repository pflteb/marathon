package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.EmployeeEJB;
import com.ec.mthonec.entities.Employee;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class EmployeeBean implements Serializable {

    @EJB
    private EmployeeEJB employeeEJB;
    private Employee employee = new Employee();

    public List<Employee> getEmployees() {
        return employeeEJB.getAllEmployees();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void saveEmployee() {
        employeeEJB.createEmployee(employee);
        employee = new Employee(); // Clear the object after saving
    }

    public void updateEmployee() {
        employeeEJB.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeEJB.deleteEmployee(employee);
    }

    // Add additional methods as needed for the CRUD operations
}
