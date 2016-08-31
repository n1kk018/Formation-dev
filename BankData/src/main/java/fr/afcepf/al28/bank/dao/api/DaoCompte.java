package fr.afcepf.al28.bank.dao.api;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.dao.impl.IDaoCompte;
import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Operation;

@Service
@Transactional
public class DaoCompte implements IDaoCompte {
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	@Override
	public Compte insert(Compte cp) {
		try {
			this.sessionFactory.getCurrentSession().save(cp);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return cp;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Operation> getOperations(Compte cp) {
		List<Operation> list = null;
		try {
			list = this.sessionFactory.getCurrentSession().createQuery("SELECT o FROM Operation o "
					+ "WHERE compte=:cpt")
			.setParameter("cpt", cp)
			.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

}
