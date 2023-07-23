package com.ec.mthonec.ejb;

import com.ec.mthonec.entities.Enterprise;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EnterpriseEJB {
    
    @PersistenceContext
    private EntityManager em;

    public void createEnterprise(Enterprise enterprise) {
        em.persist(enterprise);
    }

    public Enterprise getEnterpriseById(Long id) {
        return em.find(Enterprise.class, id);
    }

    public void updateEnterprise(Enterprise enterprise) {
        em.merge(enterprise);
    }

    public void deleteEnterprise(Enterprise enterprise) {
        em.remove(em.merge(enterprise));
    }

    public List<Enterprise> getAllEnterprises() {
        return em.createQuery("SELECT e FROM Enterprise e", Enterprise.class).getResultList();
    }

    // Add additional methods as needed for the CRUD operations
}
