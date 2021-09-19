package demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import models.Book;

public class HibernateHql {
	
	public static void getAllBooks(Session session) {
		List<Book> booksList = new ArrayList<>();
		String mainQuery = " FROM Book";
		Query<Book> query = session.createQuery(mainQuery);
		booksList = query.getResultList();
		System.out.println("booksList size : " + booksList.size());
		booksList.forEach(book -> System.out.println(book.toString()));		
	}

}
