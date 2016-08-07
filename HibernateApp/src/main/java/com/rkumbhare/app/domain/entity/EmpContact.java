/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "EmpContact")
@Table(name = "emp_contact", schema = "demo")
public class EmpContact {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_contact_seq")
	@SequenceGenerator(name = "emp_contact_seq", sequenceName = "emp_contact_seq", allocationSize = 1)
	@Column(name = "contact_id", nullable = false)
	private int contactId;
	private String phone;
	private String mobile;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_info_id")
	private EmployeeInfo employeeInfo;

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
