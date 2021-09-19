package demo;

// author : Ayush Jaipuriar 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		tx.commit();
		session.close();
		HibernateUtil.closeSessionFactory(sessionFactory);
	}

}
