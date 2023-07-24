package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.EmployeeEJB;
import com.ec.mthonec.entities.Employee;
import com.ec.mthonec.entities.Enterprise;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

@Named
@SessionScoped
public class EmployeeBean implements Serializable {

    @EJB
    private EmployeeEJB employeeEJB;

    //Objets
    private Employee objEmployee;

    //Lists
    private List<Employee> listEmployee;
    private List<SelectItem> listStatus;

    //Variables
    private Boolean showNew;
    private Boolean showList;
    private Boolean showUpdate;
    private Boolean statusEmployee;
    private String status;

    @PostConstruct
    public void init() {

        try {

            //Hide all Panels
            showNew = Boolean.FALSE;
            showList = Boolean.FALSE;
            showUpdate = Boolean.FALSE;

            //Initialize variables
            listStatus = new ArrayList<SelectItem>();
            listStatus.add(new SelectItem("true", "Active"));
            listStatus.add(new SelectItem("false", "Inactive"));

            //Show Panels
            showList = Boolean.TRUE;

            //Get the enterprise list
            listEmployee = employeeEJB.getAllEmployees();

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }

    }

    /**
     * Create a new record
     *
     */
    public void add() {
        try {

            //Initialize Variables
            Date date = new Date();
            status = "CREATE";

            //Show/Hide Panels
            showList = Boolean.FALSE;
            showNew = Boolean.TRUE;

            //Create the new Object
            objEmployee = new Employee();

            //Set properties
            objEmployee.setCreatedDate(date);
            objEmployee.setCreatedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Select a record
     *
     * @param employee
     */
    public void select(Employee employee) {

        try {

            //Initialize Variables
            Date date = new Date();
            status = "UPDATE";

            //Show/Hide Panels
            showList = Boolean.FALSE;
            showNew = Boolean.TRUE;

            objEmployee = employeeEJB.getEmployeeById(employee.getId());

            objEmployee.setModifiedDate(date);
            objEmployee.setModifiedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Save/Update a record
     *
     */
    public void saveEmployee() {
        try {

            switch (status) {
                case "CREATE":
                    employeeEJB.createEmployee(objEmployee);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "New Employee Added"));
                    init();
                    break;
                case "UPDATE":
                    employeeEJB.updateEmployee(objEmployee);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Employee Updated"));
                    init();
                    break;
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    public List<Employee> getEmployees() {
        return employeeEJB.getAllEmployees();
    }

    public Employee getObjEmployee() {
        return objEmployee;
    }

    public void setObjEmployee(Employee objEmployee) {
        this.objEmployee = objEmployee;
    }

    public void updateEmployee() {
        employeeEJB.updateEmployee(objEmployee);
    }

    public void deleteEmployee(Employee employee) {
        employeeEJB.deleteEmployee(employee);
    }

    public List<Employee> getListEmployee() {
        return listEmployee;
    }

    public void setListEmployee(List<Employee> listEmployee) {
        this.listEmployee = listEmployee;
    }

    public Boolean getShowNew() {
        return showNew;
    }

    public void setShowNew(Boolean showNew) {
        this.showNew = showNew;
    }

    public Boolean getShowList() {
        return showList;
    }

    public void setShowList(Boolean showList) {
        this.showList = showList;
    }

    public Boolean getShowUpdate() {
        return showUpdate;
    }

    public void setShowUpdate(Boolean showUpdate) {
        this.showUpdate = showUpdate;
    }

    public List<SelectItem> getListStatus() {
        return listStatus;
    }

    public void setListStatus(List<SelectItem> listStatus) {
        this.listStatus = listStatus;
    }

    public Boolean getStatusEmployee() {
        return statusEmployee;
    }

    public void setStatusEmployee(Boolean statusEmployee) {
        this.statusEmployee = statusEmployee;
    }

}
