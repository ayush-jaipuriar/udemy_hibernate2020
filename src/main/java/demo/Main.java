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
	private static void deleteBook(Session session) {
		Book book = getBook(session);
		session.delete(book);
	}

	/**
	 * @param session
	 */
	private static void updateBook(Session session) {
		Book book = getBook(session);
		book.setBookName("Winning");
		session.update(book);
	}

	/**
	 * @param session
	 */
	private static Book getBook(Session session) {
		Book book = session.get(Book.class, 2);
		System.out.println(book.toString());
		return book;
	}

	/**
	 * @param session
	 */
	private static void getBookWithDirtyChecking(Session session) {
		Book book = session.get(Book.class, 2);
		System.out.println(book.toString());
		book.setBookAuthor("R.L Stine");
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
