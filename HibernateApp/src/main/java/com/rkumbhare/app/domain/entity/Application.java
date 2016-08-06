/**
 * @auther Rakesh
 * @time Aug 6, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.Calendar;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class Application {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setUsername("rakesh");
		user.setPassword("rakesh");
		
		UserInfo userInfo = new UserInfo();
		userInfo.setFirstname("rakesh");
		userInfo.setLastname("k");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1989, Calendar.JULY, 20);
		userInfo.setDob(calendar.getTime());
		
		Address homeAddress = new Address();
		homeAddress.setCity("Nagpur");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Mumbai");
		
		userInfo.setHomeAddress(homeAddress);
		userInfo.setOfficeAddress(officeAddress);
		
		userInfo.getContactList().add(new Contact(null, "38093489"));
		userInfo.getContactList().add(new Contact(null, "99884774"));
		
		user.setUserInfo(userInfo);
		
		
		
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		
	}

}
