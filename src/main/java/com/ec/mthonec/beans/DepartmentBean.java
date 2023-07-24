package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.DepartmentEJB;
import com.ec.mthonec.ejb.EnterpriseEJB;
import com.ec.mthonec.entities.Department;
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
public class DepartmentBean implements Serializable {

    @EJB
    private DepartmentEJB departmentEJB;
    @EJB
    private EnterpriseEJB enterpriseEJB;

    //Objets
    private Department objDepartment;

    //Lists
    private List<Department> listDepartments;
    private List<SelectItem> listStatus;
    private List<Enterprise> listEnterprise;

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

            //Show Panels
            showList = Boolean.TRUE;

            //Initialize variables
            listStatus = new ArrayList<SelectItem>();
            listStatus.add(new SelectItem("true", "Active"));
            listStatus.add(new SelectItem("false", "Inactive"));

            //Get the department list
            listDepartments = departmentEJB.getAllDepartmentsJoinEnterprise();

            //Get the enterpriselist
            listEnterprise = enterpriseEJB.getAllEnterprises();

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Department.class.getName().getClass().toString());
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
            objDepartment = new Department();

            //Set properties
            objDepartment.setCreatedDate(date);
            objDepartment.setCreatedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Department.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Select a record
     *
     * @param department
     */
    public void select(Department department) {

        try {

            //Initialize Variables
            Date date = new Date();
            status = "UPDATE";

            //Show/Hide Panels
            showList = Boolean.FALSE;
            showNew = Boolean.TRUE;

            objDepartment = departmentEJB.getDepartmentById(department.getId());

            objDepartment.setModifiedDate(date);
            objDepartment.setModifiedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Department.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Save/Update a record
     *
     */
    public void saveDepartment() {
        try {

            switch (status) {
                case "CREATE":
                    departmentEJB.createDepartment(objDepartment);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "New Employee Added"));
                    init();
                    break;
                case "UPDATE":
                    departmentEJB.updateDepartment(objDepartment);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Employee Updated"));
                    init();
                    break;
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    public void updateDepartment() {
        departmentEJB.updateDepartment(objDepartment);
    }

    public void deleteDepartment(Department department) {
        departmentEJB.deleteDepartment(department);
    }

    public List<Department> getDepartments() {
        return departmentEJB.getAllDepartments();
    }

    public Department getObjDepartment() {
        return objDepartment;
    }

    public void setObjDepartment(Department objDepartment) {
        this.objDepartment = objDepartment;
    }

    public List<Department> getListDepartments() {
        return listDepartments;
    }

    public void setListDepartments(List<Department> listDepartments) {
        this.listDepartments = listDepartments;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Enterprise> getListEnterprise() {
        return listEnterprise;
    }

    public void setListEnterprise(List<Enterprise> listEnterprise) {
        this.listEnterprise = listEnterprise;
    }

}
