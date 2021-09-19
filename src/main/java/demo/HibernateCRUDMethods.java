package demo;

import org.hibernate.Session;

import models.Book;

public class HibernateCRUDMethods {

	/**
	 * @param session
	 */
	public static void deleteBook(Session session) {
		Book book = getBook(session);
		session.delete(book);
	}

	/**
	 * @param session
	 */
	public static void updateBook(Session session) {
		Book book = getBook(session);
		book.setBookName("Winning");
		session.update(book);
	}

	/**
	 * @param session
	 */
	public static Book getBook(Session session) {
		Book book = session.get(Book.class, 2);
		System.out.println(book.toString());
		return book;
	}

	/**
	 * @param session
	 */
	public static void getBookWithDirtyChecking(Session session) {
		Book book = session.get(Book.class, 2);
		System.out.println(book.toString());
		book.setBookAuthor("R.L Stine");
		System.out.println(book.toString());
	}

	/**
	 * @param session
	 * @return
	 */
	public static Integer saveBook(Session session) {
		Book book = new Book("Hibernate Check save get performed", "Ayush");
		return (Integer) session.save(book);
	}

}
