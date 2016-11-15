package fr.afcepf.al28.ria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al28.ria.entities.PetitChien;

@Stateless
public class DaoChienImpl implements IDaoChien {
    @PersistenceContext(unitName="ProjetRIARest")
    private EntityManager em;
    
    @Override
    public List<PetitChien> getAllChiens() {
        return em.createQuery("From PetitChien", PetitChien.class).getResultList();
    }

    @Override
    public PetitChien findById(Integer paramId) {
        return em.find(PetitChien.class, paramId);
    }

    @Override
    public void addChien(PetitChien paramChien) {
        em.persist(paramChien);
    }
    
}
