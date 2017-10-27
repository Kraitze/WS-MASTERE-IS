package com.ingesup.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import lombok.Data;

@Data
public class HibernateUtilMastere {
	
	private static final SessionFactory sessionFactory;
	
	// Instance the SessionFactory
	static{
		final StandardServiceRegistry registry =
				new StandardServiceRegistryBuilder()
					.configure("hibernate.cfg.xml")
					.build();
		
		Metadata meta = new MetadataSources(registry)
				.getMetadataBuilder().build();
		
		sessionFactory = meta.getSessionFactoryBuilder().build();
	}
	
	// SessionFactory getter 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	// Session getter
	public static final Session getSession() {
		
		// Getting the current session
		Session session = getSessionFactory().getCurrentSession();
		
		// Check if a transaction is already active
		if(!session.getTransaction().isActive())
			session.beginTransaction(); // Start a transaction in case of no active transaction
		
		return session;
		
	}
	
	/**
	 * Function that commit Transaction & close Session
	 */
	public static void cleanHibernateExchange() {
		
		try{
			if(HibernateUtilMastere.getSession().getTransaction().isActive())
				HibernateUtilMastere.getSession().getTransaction().commit();
		} catch (Exception e){
			HibernateUtilMastere.getSession().getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if(HibernateUtilMastere.getSession().isOpen())
				HibernateUtilMastere.getSession().close();
		}
	}

}
