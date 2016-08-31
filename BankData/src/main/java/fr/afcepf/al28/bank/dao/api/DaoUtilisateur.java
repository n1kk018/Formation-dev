package fr.afcepf.al28.bank.dao.api;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al28.bank.dao.impl.IDaoUtilisateur;
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
	public Utilisateur insert(Utilisateur u) {
		try {
			this.sessionFactory.getCurrentSession().save(u);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Utilisateur getByLogin(String login) {
		Utilisateur u = null;
		try {
			List<Utilisateur> list = this.sessionFactory.getCurrentSession()
			.createQuery("SELECT u FROM Utilisateur u WHERE u.email = :login")
			.setParameter("login", login).list();
			if(list.size()>0){
				u = list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return u;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Utilisateur getByLoginAndMdp(String login, String mdp) {
		Utilisateur u = null;
		try {
			List<Utilisateur> list = this.sessionFactory.getCurrentSession()
			.createQuery("SELECT u FROM Utilisateur u "
					+ "LEFT JOIN FETCH u.comptes "
					+ "WHERE u.email = :login AND u.mdp = :mdp")
			.setParameter("login", login)
			.setParameter("mdp", mdp).list();
			if(list.size()>0){
				u = list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return u;
	}

}
