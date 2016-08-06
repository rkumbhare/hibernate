/**
 * @auther Rakesh
 * @time Aug 5, 2016
 */

package com.rkumbhare.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.domain.entity.Person;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person p = new Person();
		p.setFirstname("Rakesh");
		p.setLastname("kumbhare");

		session.save(p);

		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
