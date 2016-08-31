package fr.afcepf.al28.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.entity.Utilisateur;

@Service
@Transactional
public class DaoUtilisateur implements IDaoUtilisateur {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Utilisateur ajouter(Utilisateur u) {
		try {
			this.sessionFactory.getCurrentSession().save(u);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return u;
	}

}
