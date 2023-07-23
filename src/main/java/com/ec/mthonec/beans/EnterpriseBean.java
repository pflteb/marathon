package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.EnterpriseEJB;
import com.ec.mthonec.entities.Enterprise;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import static java.time.LocalDate.now;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class EnterpriseBean implements Serializable {

    //Services
    @EJB
    private EnterpriseEJB enterpriseEJB;

    //Objets
    private Enterprise enterprise;

    //Lists
    private List<Enterprise> listEnterprise;

    //Variables
    private Boolean showNew;
    private Boolean showList;
    private Boolean showUpdate;

    @PostConstruct
    public void init() {

        try {

            //Hide all Panels
            showNew = Boolean.FALSE;
            showList = Boolean.FALSE;
            showUpdate = Boolean.FALSE;

            //Show Panels
            showList = Boolean.TRUE;

            //Get the enterprise list
            listEnterprise = enterpriseEJB.getAllEnterprises();

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }

    }

    public void add() {
        try {

            //Initialize Variables
            Date date = new Date();

            //Show/Hide Panels
            showList = Boolean.FALSE;
            showNew = Boolean.TRUE;

            //Create the new Object
            enterprise = new Enterprise();

            //Set properties
            enterprise.setCreatedDate(date);

        } catch (Exception e) {
            Logger logger = Logger.getLogger(Enterprise.class.getName().getClass().toString());
            System.out.println(logger);
        }
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void saveEnterprise() {
        enterpriseEJB.createEnterprise(enterprise);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "New Enterprise Added"));
        init();
        //PrimeFaces.current().executeScript("PF('dlg').hide();"); // Hide the dialog after saving
        // You can add a success message here using PrimeFaces' RequestContext
        // For example, RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Enterprise saved successfully."));
    }

    public void updateEnterprise() {
        enterpriseEJB.updateEnterprise(enterprise);
        PrimeFaces.current().executeScript("PF('dlg').hide();"); // Hide the dialog after updating
        // You can add a success message here using PrimeFaces' RequestContext
    }

    public void deleteEnterprise(Enterprise enterprise) {
        enterpriseEJB.deleteEnterprise(enterprise);
        // You can add a success message here using PrimeFaces' FacesContext
    }

    public void newEnterprise() {
        enterprise = new Enterprise(); // Clear the object before adding a new enterprise
    }

    public void editEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise; // Set the selected enterprise to edit
    }

    //Get's & Set's
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

}
