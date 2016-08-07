/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.demo;

import java.io.Serializable;
import java.util.Calendar;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.rkumbhare.app.domain.entity.EmpAddress;
import com.rkumbhare.app.domain.entity.EmpContact;
import com.rkumbhare.app.domain.entity.Employee;
import com.rkumbhare.app.domain.entity.EmployeeInfo;

public class Application5 {

	/**
	 * save and persist entity demo
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		
		Employee emp = new Employee();
		Calendar calendar = Calendar.getInstance();
		emp.setDoj(calendar.getTime());
		emp.setDesignation("Software Engineer");
		emp.setLevel("L1");
		
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setFirstname("Mangesh");
		employeeInfo.setLastname("R");
		employeeInfo.setGender("Male");
		Calendar calendar2 = Calendar.getInstance();
		calendar2.set(1987, 7, 12);
		employeeInfo.setDob(calendar2.getTime());
		employeeInfo.setEmployee(emp);
		
		EmpAddress adds1 = new EmpAddress();
		adds1.setCity("Kokan");
		adds1.setEmployeeInfo(employeeInfo);
		
		EmpAddress adds2 = new EmpAddress();
		adds2.setCity("Mumbai");
		adds2.setEmployeeInfo(employeeInfo);
		
		employeeInfo.getAddressList().add(adds1);
		employeeInfo.getAddressList().add(adds2);
		
		EmpContact contact1 = new EmpContact();
		contact1.setMobile("9089786789");
		contact1.setEmployeeInfo(employeeInfo);
		EmpContact contact2 = new EmpContact();
		contact2.setMobile("9403599989");
		contact2.setEmployeeInfo(employeeInfo);
		
		employeeInfo.getContactList().add(contact1);
		employeeInfo.getContactList().add(contact2);
		
		emp.setEmployeeInfo(employeeInfo);
		
		Employee emp2 = null;
		try {
			emp2 = emp.getClone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		Session session = sessionFactory.openSession();
		Serializable key = session.save(emp);
		System.out.println(key);
		session.flush();
		session.close();
		
		session = sessionFactory.openSession();
		session.persist(emp2);
		session.flush();
		session.close();
		
		sessionFactory.close();
	}

}
