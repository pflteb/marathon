package ec.com.marathon.employee;

import ec.com.marathon.ejb.Departments;
import ec.com.marathon.ejb.DepartmentsEmployees;
import ec.com.marathon.servicio.DepartmentsService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author esteb
 */
@ViewScoped
@Named
public class DepartmentController implements Serializable {

    //Declaraciones
    @EJB
    private DepartmentsService departmentsService;

    //Variables
    public List<Departments> departmentsList;

    //Metodos
    @PostConstruct
    public void init() {

        try {
            departmentsList = departmentsService.listAll();

        } catch (Exception e) {
        }
    }

    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    }

}
