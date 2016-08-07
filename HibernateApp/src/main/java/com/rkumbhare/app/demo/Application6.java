/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.app.domain.entity.Employee;

public class Application6 {

	/**
	 * hibernate Query demo
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Query query1 = session.getNamedQuery("employeeAll");
		List<Employee> employeeList = query1.list();
		employeeList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeId());
		});
		
		Query query2 = session.getNamedQuery("employeeById");
		query2.setParameter("id", 1);
		employeeList = query2.list();
		employeeList.stream().forEach(emp -> {
			System.out.println(emp.getDesignation());
		});
		
		Query query3 = session.getNamedQuery("employeeByDoj");
		query3.setParameter("doj", Calendar.getInstance().getTime());
		employeeList = query3.list();
		employeeList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeId());
		});
		
		Query query4 = session.getNamedQuery("employeeByDob");
		Calendar from = Calendar.getInstance();
		from.set(1985, 1, 1);
		Calendar to = Calendar.getInstance();
		to.set(1990, 12, 31);
		query4.setParameter("from", from.getTime());
		query4.setParameter("to", to.getTime());
		employeeList = query4.list();
		employeeList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeId());
		});
		
		session.close();
		sessionFactory.close();
	}

}
