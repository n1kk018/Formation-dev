package fr.afcepf.al28.bank.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.entity.Compte;
import fr.afcepf.al28.bank.entity.Credit;
import fr.afcepf.al28.bank.entity.Debit;
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
	public Operation insert(Operation o) {
		try {
			this.sessionFactory.getCurrentSession().save(o);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public Operation doTransfer(Compte cp, Double amount, Compte dest) {
		Operation debit = null;
		try {
			this.sessionFactory.getCurrentSession().save(new Credit(null, new Date(), amount, "Virement depuis "+cp.getLibelle(), dest));
			debit = new Debit(null,new Date(),amount,"Virement vers "+dest.getLibelle(),cp,dest);
			this.sessionFactory.getCurrentSession().save(debit);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return debit;
	}
}
