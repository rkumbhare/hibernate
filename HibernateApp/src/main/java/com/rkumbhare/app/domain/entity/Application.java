/**
 * @auther Rakesh
 * @time Aug 6, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setFirstname("Rakesh");
		user.setLastname("kumhbhare");
		user.setDob(new Date(1989, 07, 20));
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
	}

}
