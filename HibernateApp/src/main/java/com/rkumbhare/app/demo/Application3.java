/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.app.domain.entity.Employee;

public class Application3 {

	/**
	 * Merge entities demo
	 * merge(e) -> merge specified entity with current persistent entity
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Employee e1 = (Employee) session.get(Employee.class, 3);
		e1.setDesignation("Lead Software Engineer");
		e1.setLevel("L2");
		session.close();

		session = sessionFactory.openSession();
		session.beginTransaction();
		Employee e11 = (Employee) session.get(Employee.class, 3);
		session.merge(e1);
		session.getTransaction().commit();

		sessionFactory.close();
	}

}
