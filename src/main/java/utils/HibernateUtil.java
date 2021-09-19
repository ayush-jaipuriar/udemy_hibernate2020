package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory
	 * @return session factory object
	 */
	public static SessionFactory getSessionFactory() {		
		try {
	            Configuration configuration = new Configuration();
	            configuration.configure();

	            /*return configuration
	                    .buildSessionFactory(new StandardServiceRegistryBuilder()
	                            .applySettings(configuration.getProperties())
	                            .build());  -- does not work while using hibernate.cfg.xml, but works with hibernate.properties*/

	            sessionFactory = configuration
	                    .buildSessionFactory(); 
	        } catch (Exception e) {
	            e.printStackTrace();	            
	        }
		return sessionFactory;
	}
	
	/**
	 * @param sessionFactory
	 */
	public static void closeSessionFactory(SessionFactory sessionFactory) {
		sessionFactory.close();
	}
	 

}
