package demo;

// author : Ayush Jaipuriar 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

	/**
	 * @param session
	 */
	private static void getBook(Session session) {
		Book book = session.get(Book.class, 2);
		System.out.println(book.toString());
	}

	/**
	 * @param session
	 * @return
	 */
	private static Integer saveBook(Session session) {
		Book book = new Book("Hibernate Check save get performed", "Ayush");		
		return (Integer) session.save(book);		
	}

}
