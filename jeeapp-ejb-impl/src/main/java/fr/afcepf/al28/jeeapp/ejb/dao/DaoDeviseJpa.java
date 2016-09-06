package fr.afcepf.al28.jeeapp.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.afcepf.al28.jeeapp.entity.Devise;

@Stateless
public class DaoDeviseJpa implements IDaoDevise {
	@PersistenceContext(unitName="jeeapp-entity")
	EntityManager em;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaodevise#getDeviseByCode(java.lang.String)
	 */
	@Override
	public Devise getDeviseByCode(String codeDevise){
		return em.find(Devise.class, codeDevise);
	}
	/* (non-Javadoc)
	 * @see fr.afcepf.al28.jeeapp.ejb.dao.IDaodevise#getAllDeviseByCode()
	 */
	@Override
	public List<Devise> getAllDevise(){
		return em.createQuery("SELECT d FROM Devise d",Devise.class).getResultList();
	}
}
