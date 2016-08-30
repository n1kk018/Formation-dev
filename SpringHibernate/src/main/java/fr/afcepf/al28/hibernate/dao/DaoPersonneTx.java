package fr.afcepf.al28.hibernate.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.hibernate.entity.Personne;

@Service
@Transactional
public class DaoPersonneTx implements IDaoPersonne {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public Personne ajouter(Personne p) {
		try {
			this.sessionFactory.getCurrentSession().save(p);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Integer supprimer(Personne p) {
		Integer id = null;
		try {
			id = p.getId();
			this.sessionFactory.getCurrentSession().delete(p);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personne> rechercheParNom(String nom) {
		List<Personne> list = null;
		try {
			list = this.sessionFactory.getCurrentSession().createQuery(
					"SELECT DISTINCT(p) FROM Personne p "
					+ "LEFT JOIN FETCH p.comptes " //Sans le fetch, la collection n'est pas remplie!!!!
					+ "WHERE p.nom LIKE :name")
					.setParameter("name", "%"+nom+"%")
					.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
