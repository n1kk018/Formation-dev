package fr.afcepf.al28.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.entity.Operation;

@Service
@Transactional
public class DaoOperation implements IDaoOperation {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public Operation ajouter(Operation o) {
		try {
			this.sessionFactory.getCurrentSession().save(o);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return o;
	}
}
