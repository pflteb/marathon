package ec.com.marathon.employee;

import ec.com.marathon.ejb.DepartmentsEmployees;
import java.io.Serializable;
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
public class EmployeeController implements Serializable {

    //Declaraciones
    @EJB
    private DepartmentsEmployees departmentsEmployees;

    //Variables
    public Integer edad;
    
    //Metodos
    @PostConstruct
    public void init() {

        //Carga la lista de empleados
        //Cargar los datos del usuario
    }
    
    public void guadar(){
        
    }

    //Gets y Sets

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
}
