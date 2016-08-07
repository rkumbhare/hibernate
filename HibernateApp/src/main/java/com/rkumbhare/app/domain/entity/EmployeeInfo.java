/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "EmployeeInfo")
@Table(name = "employee_info", schema = "demo")
public class EmployeeInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_info_seq")
	@SequenceGenerator(name = "employee_info_seq", sequenceName = "employee_info_seq", allocationSize = 1)
	@Column(name = "employee_info_id", nullable = false)
	private int employeeInfoId;
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;
	@Column(name = "lastname", nullable = false, length = 50)
	private String lastname;
	@Column(name = "gender", nullable = false, length = 20)
	private String gender;
	@Column(name = "dob", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "emp_id")
	private Employee employee;
	@OneToMany(mappedBy = "employeeInfo", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<EmpAddress> addressList = new ArrayList<EmpAddress>();
	@OneToMany(mappedBy="employeeInfo", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<EmpContact> contactList = new ArrayList<EmpContact>();

	public List<EmpContact> getContactList() {
		return contactList;
	}
	public void setContactList(List<EmpContact> contactList) {
		this.contactList = contactList;
	}
	public List<EmpAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<EmpAddress> addressList) {
		this.addressList = addressList;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getEmployeeInfoId() {
		return employeeInfoId;
	}
	public void setEmployeeInfoId(int employeeInfoId) {
		this.employeeInfoId = employeeInfoId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
