/*package com.ec.mthonec.ejb;

import com.ec.mthonec.entities.Depemp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DepempEJB {
    
    @PersistenceContext
    private EntityManager em;

    public void createDepemp(Depemp depemp) {
        em.persist(depemp);
    }

    public Depemp getDepempById(Long id) {
        return em.find(Depemp.class, id);
    }

    public void updateDepemp(Depemp depemp) {
        em.merge(depemp);
    }

    public void deleteDepemp(Depemp depemp) {
        em.remove(em.merge(depemp));
    }

    public List<Depemp> getAllDepemps() {
        return em.createQuery("SELECT d FROM Depemp d", Depemp.class).getResultList();
    }
}
*/