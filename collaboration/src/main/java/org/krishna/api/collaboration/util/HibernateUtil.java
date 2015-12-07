package org.krishna.api.collaboration.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * DB Utility.
 * 
 * @author anurkris
 *
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		sessionFactory = new Configuration().configure("/org/krishna/api/collaboration/resources/hibernate.cfg.xml")
				.buildSessionFactory();
		return sessionFactory;

	}
}
