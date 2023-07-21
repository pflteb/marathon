package ec.com.marathon.ejb;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-07-20T19:00:23")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, Date> createdDate;
    public static volatile SingularAttribute<Employees, String> createdBy;
    public static volatile SingularAttribute<Employees, String> surname;
    public static volatile SingularAttribute<Employees, Date> modifiedDate;
    public static volatile SingularAttribute<Employees, String> name;
    public static volatile SingularAttribute<Employees, String> modifiedBy;
    public static volatile SingularAttribute<Employees, Long> id;
    public static volatile SingularAttribute<Employees, String> position;
    public static volatile SingularAttribute<Employees, String> age;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, Boolean> status;

}