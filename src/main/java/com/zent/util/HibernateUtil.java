package com.zent.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final Log log = LogFactory.getLog(HibernateUtil.class);
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public static Session getSession() {
		Session session = threadLocal.get();
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
			threadLocal.remove();
		}
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure(
						"hibernate.cfg.xml").buildSessionFactory();
			}
			session = sessionFactory.openSession();
			threadLocal.set(session);
		}

		return session;
	}

	public static void closeSession() {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}

}
