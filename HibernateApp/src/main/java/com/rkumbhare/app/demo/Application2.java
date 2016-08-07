/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.app.domain.entity.EmpAddress;
import com.rkumbhare.app.domain.entity.EmpContact;
import com.rkumbhare.app.domain.entity.Employee;
import com.rkumbhare.app.domain.entity.EmployeeInfo;

public class Application2 {

	/**
	 * get and load method demo
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Employee emp = new Employee();
		Calendar calendar = Calendar.getInstance();
		emp.setDoj(calendar.getTime());
		emp.setDesignation("Software Engineer");
		emp.setLevel("L1");
		
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setFirstname("Sushil");
		employeeInfo.setLastname("P");
		employeeInfo.setGender("Male");
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(1985, 4, 11);
		employeeInfo.setDob(calendar2.getTime());
		employeeInfo.setEmployee(emp);
		
		EmpAddress adds1 = new EmpAddress();
		adds1.setCity("Badlapur");
		adds1.setEmployeeInfo(employeeInfo);
		
		EmpAddress adds2 = new EmpAddress();
		adds2.setCity("Mumbai");
		adds2.setEmployeeInfo(employeeInfo);
		
		employeeInfo.getAddressList().add(adds1);
		employeeInfo.getAddressList().add(adds2);
		
		EmpContact contact1 = new EmpContact();
		contact1.setMobile("998809878");
		contact1.setEmployeeInfo(employeeInfo);
		EmpContact contact2 = new EmpContact();
		contact2.setMobile("890989789");
		contact2.setEmployeeInfo(employeeInfo);
		
		
		employeeInfo.getContactList().add(contact1);
		employeeInfo.getContactList().add(contact2);
		
		
		emp.setEmployeeInfo(employeeInfo);
		
		session.beginTransaction();
		session.save(emp);
		session.getTransaction().commit();
		
		session.close();
		
		
		session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee.getDoj());
		System.out.println(employee.getEmployeeInfo().getDob());
		System.out.println(employee.getEmployeeInfo().getAddressList());
		System.out.println(employee.getEmployeeInfo().getContactList());
		session.close();
		
		employee = null;
		
		session = sessionFactory.openSession();
		employee = (Employee) session.load(Employee.class, 1);
		System.out.println(employee.getDoj());
		System.out.println(employee.getEmployeeInfo().getDob());
		System.out.println(employee.getEmployeeInfo().getAddressList());
		System.out.println(employee.getEmployeeInfo().getContactList());
		session.close();
		
		
		sessionFactory.close();
	}

}
