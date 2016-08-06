/**
 * @auther Rakesh
 * @time Aug 6, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "User")
@Table(name = "User", schema = "demo")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1)
	@Column(name="user_id", nullable=false)
	private int userId;
	@Column(name="firstname", nullable=false)
	private String firstname;
	@Column(name="lastname", nullable=false)
	private String lastname;
	@Column(name="dob", nullable=false)
	@Temporal(TemporalType.DATE) 
	private Date dob;   
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

}
