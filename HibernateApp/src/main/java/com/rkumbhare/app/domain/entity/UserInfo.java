/**
 * @auther Rakesh
 * @time Aug 6, 2016
 */

package com.rkumbhare.app.domain.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "UserInfo")
@Table(name = "user_info", schema = "demo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq")
	@SequenceGenerator(name = "user_info_seq", sequenceName = "user_info_seq", allocationSize = 1)
	@Column(name = "user_info_id", nullable = false)
	private int userInfoId;
	@Column(name = "firstname", nullable = false, length = 50)
	private String firstname;
	@Column(name = "lastname", nullable = true, length = 50)
	private String lastname;
	@Column(name = "dob", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "home_city")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state")),
			@AttributeOverride(name = "country", column = @Column(name = "home_country"))})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "city", column = @Column(name = "office_city")),
			@AttributeOverride(name = "state", column = @Column(name = "office_state")),
			@AttributeOverride(name = "country", column = @Column(name = "office_country"))})
	private Address officeAddress;
	
	@ElementCollection
	@JoinTable(name="user_contact", schema="demo", joinColumns=@JoinColumn(name="user_id"))
	private List<Contact> contactList = new LinkedList<Contact>();

	public List<Contact> getContactList() {
		return contactList;
	}
	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
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

}
