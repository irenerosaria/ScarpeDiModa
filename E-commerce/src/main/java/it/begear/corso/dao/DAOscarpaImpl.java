package it.begear.corso.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import it.begear.corso.entity.Employee;
import it.begear.corso.entity.Scarpa;

public class DAOscarpaImpl implements DAOscarpa {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(Scarpa a) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(a);
		tx.commit();
		session.close();
		System.out.println("Create successful!");
	}

	@Override
	public List<Scarpa> read() {
		Session session = this.sessionFactory.openSession();
		List<Scarpa> anList = session.createQuery("from Scarpa").list();
		session.close();
		return anList;
	}

	@Override
	public void update(Scarpa a, int id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Scarpa shoe = (Scarpa) session.load(Scarpa.class, a.getId());
		shoe.setId(a.getId());
		shoe.setGender(a.getGender());
		shoe.setDescrizione(a.getDescrizione());
		shoe.setColor(a.getColor());
		shoe.setNumero(a.getNumero());
		shoe.setBrand(a.getBrand());
		shoe.setCosto(a.getCosto());
		session.getTransaction().commit();
		session.close();
		System.out.println("Update successful!");
		
	}

	@Override
	public void delete(Integer id) {
		Session session = getSessionFactory().openSession();
		session.beginTransaction();
		Scarpa scarpa = findByID(id);
		session.delete(scarpa);
		session.getTransaction().commit();
		session.close();
		System.out.println("Delete successful!");
	}
	
	@Override
	public Scarpa findByID(Integer id) {
		Session session = getSessionFactory().openSession();
		Scarpa scarpa = (Scarpa) session.load(Scarpa.class, id);
		session.close();
		System.out.println("Scarpa trovata!");
		return scarpa;
	}
	
	@Override
	public Scarpa findByCode(String code) {                        // new                  
		Session session = getSessionFactory().openSession();
		Scarpa scarpa = null;
		List<Scarpa> scarpaList = read();      
    	for(Scarpa sc : scarpaList) {
    		if(scarpa.getCode().equals(code)) {
    			scarpa = sc;
    			break;
    		}
    	}
		return scarpa;
	}

}
