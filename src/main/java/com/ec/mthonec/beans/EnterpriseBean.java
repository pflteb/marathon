package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.EnterpriseEJB;
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
import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class EnterpriseBean implements Serializable {

    //Services
    @EJB
    private EnterpriseEJB enterpriseEJB;

    //Objets
    private Enterprise objEnterprise;

    //Lists
    private List<Enterprise> listEnterprise;
    private List<SelectItem> listStatus;

    //Variables
    private Boolean showNew;
    private Boolean showList;
    private Boolean showUpdate;
    private Boolean statusEnterprise;
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
            listEnterprise = enterpriseEJB.getAllEnterprises();

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
            objEnterprise = new Enterprise();

            //Set properties
            objEnterprise.setCreatedDate(date);
            objEnterprise.setCreatedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Select a record
     *
     * @param enterprise
     */
    public void select(Enterprise enterprise) {

        try {

            //Initialize Variables
            Date date = new Date();
            status = "UPDATE";

            //Show/Hide Panels
            showList = Boolean.FALSE;
            showNew = Boolean.TRUE;

            objEnterprise = enterpriseEJB.getEnterpriseById(enterprise.getId());

            objEnterprise.setModifiedDate(date);
            objEnterprise.setModifiedBy("default.user");

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    /**
     * Save/Update a record
     *
     */
    public void saveEnterprise() {
        try {

            switch (status) {
                case "CREATE":
                    enterpriseEJB.createEnterprise(objEnterprise);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "New Employee Added"));
                    init();
                    break;
                case "UPDATE":
                    enterpriseEJB.updateEnterprise(objEnterprise);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Employee Updated"));
                    init();
                    break;
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    public void updateEnterprise() {
        enterpriseEJB.updateEnterprise(objEnterprise);
        PrimeFaces.current().executeScript("PF('dlg').hide();"); // Hide the dialog after updating
        // You can add a success message here using PrimeFaces' RequestContext
    }

    public void deleteEnterprise(Enterprise enterprise) {
        enterpriseEJB.deleteEnterprise(enterprise);
        // You can add a success message here using PrimeFaces' FacesContext
    }

    public void newEnterprise() {
        objEnterprise = new Enterprise(); // Clear the object before adding a new enterprise
    }

    public void editEnterprise(Enterprise enterprise) {
        this.objEnterprise = enterprise; // Set the selected enterprise to edit
    }

    public Enterprise getObjEnterprise() {
        return objEnterprise;
    }

    //Get's & Set's
    public void setObjEnterprise(Enterprise objEnterprise) {
        this.objEnterprise = objEnterprise;
    }

    public List<Enterprise> getListEnterprise() {
        return listEnterprise;
    }

    public void setListEnterprise(List<Enterprise> listEnterprise) {
        this.listEnterprise = listEnterprise;
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

    public Boolean getStatusEnterprise() {
        return statusEnterprise;
    }

    public void setStatusEnterprise(Boolean statusEnterprise) {
        this.statusEnterprise = statusEnterprise;
    }

}
