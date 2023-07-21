package ec.com.marathon.ejb;

import ec.com.marathon.ejb.Departments;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-20T19:00:23")
@StaticMetamodel(DepartmentsEmployees.class)
public class DepartmentsEmployees_ { 

    public static volatile SingularAttribute<DepartmentsEmployees, Integer> idEmployee;
    public static volatile SingularAttribute<DepartmentsEmployees, Date> createdDate;
    public static volatile SingularAttribute<DepartmentsEmployees, String> createdBy;
    public static volatile SingularAttribute<DepartmentsEmployees, Date> modifiedDate;
    public static volatile SingularAttribute<DepartmentsEmployees, String> modifiedBy;
    public static volatile SingularAttribute<DepartmentsEmployees, Integer> id;
    public static volatile SingularAttribute<DepartmentsEmployees, Boolean> status;
    public static volatile SingularAttribute<DepartmentsEmployees, Departments> idDepartment;

}