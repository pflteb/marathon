import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MyEJB {
    
    @PersistenceContext(unitName = "mthon")
    private EntityManager em;
    
    // Aquí puedes usar el EntityManager (em) para interactuar con la base de datos
    // y realizar operaciones CRUD utilizando JPA.
}
