package fr.afcepf.al28.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.entity.Compte;

@Service
@Transactional
public class DaoCompte implements IDaoCompte {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public Compte ajouter(Compte cp) {
		try {
			this.sessionFactory.getCurrentSession().save(cp);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return cp;
	}

}
