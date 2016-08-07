/**
 * @auther Rakesh
 * @time Aug 7, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({@NamedQuery(name = "employeeAll", query = "from Employee ORDER BY employeeId"),
		@NamedQuery(name = "employeeById", query = "from Employee WHERE employeeId=:id"),
		@NamedQuery(name="employeeByDoj", query="FROM Employee WHERE doj=:doj ORDER BY employeeId"),
		@NamedQuery(name="employeeByDob", query="FROM Employee WHERE employeeInfo.dob between :from and :to ORDER BY employeeId")
})
@Entity(name = "Employee")
@Table(name = "employee", schema = "demo")
public class Employee implements Cloneable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
	@Column(name = "emp_id", nullable = false)
	private int employeeId;
	@Column(name = "doj", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date doj;
	@Column(name = "designation", nullable = false, length = 50)
	private String designation;
	@Column(name = "level", nullable = true, length = 10)
	private String level;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private EmployeeInfo employeeInfo;

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public Employee getClone() throws CloneNotSupportedException {
		return (Employee) clone();
	}

}
