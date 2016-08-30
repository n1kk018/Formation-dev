package fr.afcepf.al28.hibernate.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.afcepf.al28.hibernate.entity.Personne;

//@Service
public class DaoPersonne implements IDaoPersonne{
	private SessionFactory sessionFactory;
		
	@Autowired
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public Personne ajouter(Personne p){
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction(); 
			session.save(p);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return p;
	}
	
	@Override
	public Integer supprimer(Personne p){
		Integer id = null;
		Session session = null;
		Transaction tx = null;
		try {
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction(); 
			id = p.getId();
			session.delete(p);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
	
	@Override
	public List<Personne> rechercheParNom (String nom){
		Session session = null;
		List<Personne> list = null;
		try {
			session = this.sessionFactory.openSession();
			list = session.createQuery("SELECT p FROM Personne p WHERE p.nom=:name")
					.setParameter("name", nom)
					.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
}
