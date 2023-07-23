/*
package com.ec.mthonec.beans;

import com.ec.mthonec.ejb.DepempEJB;
import com.ec.mthonec.entities.Depemp;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class DepempBean implements Serializable {

    @EJB
    private DepempEJB depempEJB;
    private Depemp depemp = new Depemp();

    public List<Depemp> getDepempList() {
        return depemp.getAllDepemp();
    }

    public Depemp getDepemp() {
        return depemp;
    }

    public void setDepemp(Depemp depemp) {
        this.depemp = depemp;
    }

    public void saveDepemp() {
        depempEJB.createDepemp(depemp);
        depemp = new Depemp(); // Clear the object after saving
    }

    public void updateDepemp() {
        depempEJB.updateDepemp(depemp);
    }

    public void deleteDepemp(Depemp depemp) {
        depempEJB.deleteDepemp(depemp);
    }

    // Add additional methods as needed for the CRUD operations
}
*/