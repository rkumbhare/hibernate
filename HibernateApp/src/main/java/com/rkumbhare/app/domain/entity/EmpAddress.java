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

@Entity(name = "EmpAddress")
@Table(name = "emp_address", schema = "demo")
public class EmpAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_address_seq")
	@SequenceGenerator(name = "emp_address_seq", sequenceName = "emp_address_seq", allocationSize = 1)
	@Column(name = "address_id", nullable = false)
	private int addressId;
	@Column(name = "city", nullable = true, length = 20)
	private String city;
	@Column(name = "state", nullable = true, length = 20)
	private String state;
	@Column(name = "country", nullable = true, length = 20)
	private String country;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_info_id")
	private EmployeeInfo employeeInfo;

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

}
