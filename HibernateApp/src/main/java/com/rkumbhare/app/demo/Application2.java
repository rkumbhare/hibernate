/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.app.domain.entity.Employee;

public class Application2 {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee emp = new Employee();
		Calendar calendar = Calendar.getInstance();
		emp.setDoj(calendar.getTime());
		emp.setDesignation("Software Engineer");
		emp.setLevel("L3");
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		
		session.close();
		sessionFactory.close();
	}

}
