package ec.com.marathon.ejb;

import ec.com.marathon.ejb.Departments;
import ec.com.marathon.ejb.DepartmentsEmployees;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-21T01:43:15")
@StaticMetamodel(Departments.class)
public class Departments_ { 

    public static volatile SingularAttribute<Departments, Date> createdDate;
    public static volatile ListAttribute<Departments, DepartmentsEmployees> departmentsEmployeesList;
    public static volatile SingularAttribute<Departments, String> createdBy;
    public static volatile SingularAttribute<Departments, String> phone;
    public static volatile ListAttribute<Departments, Departments> departmentsList;
    public static volatile SingularAttribute<Departments, Departments> idEnterprise;
    public static volatile SingularAttribute<Departments, Date> modifiedDate;
    public static volatile SingularAttribute<Departments, String> name;
    public static volatile SingularAttribute<Departments, String> description;
    public static volatile SingularAttribute<Departments, String> modifiedBy;
    public static volatile SingularAttribute<Departments, Integer> id;
    public static volatile SingularAttribute<Departments, Boolean> status;

}