/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import com.rkumbhare.app.domain.entity.Employee;
import com.rkumbhare.app.domain.entity.EmployeeInfo;

public class Application7 {

	/**
	 * Criteria demo
	 * http://howtodoinjava.com/hibernate/hibernate-criteria-queries-tutorial-
	 * and-examples/
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria1 = session.createCriteria(Employee.class);
		criteria1.add(Restrictions.eq("employeeId", 1));
		List<Employee> empList = criteria1.list();
		empList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeInfo().getFirstname());
		});

		Calendar from = Calendar.getInstance();
		from.set(1985, 1, 1);
		Calendar to = Calendar.getInstance();
		to.set(1990, 12, 31);
		Criteria empCriteria = session.createCriteria(Employee.class);
		Criteria empInfoCriteria = empCriteria.createCriteria("employeeInfo");
		empInfoCriteria.add(Restrictions.between("dob", from.getTime(), to.getTime()));
		empList = empCriteria.list();
		empList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeInfo().getFirstname());
		});

		empCriteria = session.createCriteria(Employee.class);
		empInfoCriteria = empCriteria.createCriteria("employeeInfo");
		empInfoCriteria.add(Restrictions.like("firstname", "R%"));
		empList = empCriteria.list();
		empList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeInfo().getFirstname());
		});

		empCriteria = session.createCriteria(Employee.class);
		empInfoCriteria = empCriteria.createCriteria("employeeInfo");
		Criteria addsCriteria = empInfoCriteria.createCriteria("addressList");
		empInfoCriteria.add(Restrictions.between("dob", from.getTime(), to.getTime()));
		addsCriteria.add(Restrictions.in("city", new String[]{"Nagpur"}));
		empList = empCriteria.list();
		empList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeInfo().getFirstname());
		});

		
		empCriteria = session.createCriteria(Employee.class);
		empInfoCriteria = empCriteria.createCriteria("employeeInfo");
		addsCriteria = empInfoCriteria.createCriteria("addressList");
		empInfoCriteria.add(Restrictions.in("gender", new String[]{"Male"}));
		addsCriteria.add(Restrictions.in("city", new String[]{"Nagpur", "UP"}));
		empList = empCriteria.list();
		empList.stream().forEach(emp -> {
			System.out.println(emp.getEmployeeInfo().getFirstname());
		});
		
		session.close();
		sessionFactory.close();
	}

}
