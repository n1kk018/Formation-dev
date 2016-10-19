package fr.afcepf.al28.jeeapp.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al28.jeeapp.entity.Devise;
import fr.afcepf.al28.jeeapp.entity.Pays;


@Stateless
public class DaoDeviseJpa implements IDaoDevise {
	@PersistenceContext(unitName="jeeapp-entity")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#updateDevise(fr.afcepf.al28.jeeapp.entity.Devise)
	 */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED) par défaut
	public void updateDevise(Devise d){
		em.merge(d);
		//Transaction auto en jboss
		/*try {
			em.getTransaction().begin();
			em.merge(d);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}*/
	}
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#deleteDevise(fr.afcepf.al28.jeeapp.entity.Devise)
	 */
	@Override
	public void deleteDevise(Devise d){
		em.remove(d);
	}
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#createDevise(fr.afcepf.al28.jeeapp.entity.Devise)
	 */
	@Override
	public String createDevise(Devise d){
		em.persist(d);
		return d.getCodeDevise();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#getDeviseByCode(java.lang.String)
	 */
	@Override
	public Devise getDeviseByCode(String code) {
	    Devise d = em.find(Devise.class, code);
	    //em.detach(d);
		return d;
	}
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#getDeviseByName(java.lang.String)
	 */
	@Override
	public Devise getDeviseByName(String nom){
		return em.createQuery("SELECT d FROM Devise d WHERE d.monnaie=:nom",Devise.class)
			.setParameter("nom",nom)
			.getSingleResult();
	}
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaoDevise#getAllDevises()
	 */
	@Override
	public List<Devise> getAllDevises() {
		return em.createNamedQuery("devise.findAll", Devise.class).getResultList();
	}
	
	@Override
	public List<Pays> getListePaysPartageantDevise(String codeDevise) {
		/*return em.createQuery("SELECT p FROM Pays p JOIN p.devise d WHERE d.codeDevise = :code", Pays.class)
				.setParameter("code", codeDevise)
				.getResultList();*/
		Devise d = em.find(Devise.class, codeDevise);
		
		d.getPays().size();
		//mais en mieux
		//return em.createQuery("SELECT DISTINCT d FROM Devise d JOIN FETCH d.pays p", Pays.class)
		//.getResultList();
		
		return d.getPays();
		
	}
}
